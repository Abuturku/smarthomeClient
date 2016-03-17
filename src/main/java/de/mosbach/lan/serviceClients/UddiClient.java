package de.mosbach.lan.serviceClients;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.xml.registry.BulkResponse;
import javax.xml.registry.BusinessQueryManager;
import javax.xml.registry.Connection;
import javax.xml.registry.ConnectionFactory;
import javax.xml.registry.JAXRException;
import javax.xml.registry.infomodel.InternationalString;
import javax.xml.registry.infomodel.LocalizedString;
import javax.xml.registry.infomodel.Organization;
import javax.xml.registry.infomodel.Service;
import javax.xml.registry.infomodel.ServiceBinding;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

public final class UddiClient
{
	private static final String JUDDI_VERSION = "3.0";

	private static final String JUDDI_SERVICES_URL = "http://10.50.12.187:9765/juddiv3/services/";

	private static final String JUDDI_INQUIRY_URL = JUDDI_SERVICES_URL + "inquiry";
	private static final String JUDDI_PUBLISH_URL = JUDDI_SERVICES_URL + "publish";
	private static final String JUDDI_SECURITY_URL = JUDDI_SERVICES_URL + "security";

	private static Connection getConnection() throws JAXRException
	{
		System.setProperty("javax.xml.registry.ConnectionFactoryClass",
				"org.apache.ws.scout.registry.ConnectionFactoryImpl");

		final ConnectionFactory connectionFactory = ConnectionFactory.newInstance();

		final Properties uddiProperties = new Properties();
		uddiProperties.put("javax.xml.registry.queryManagerURL", JUDDI_INQUIRY_URL);
		uddiProperties.put("javax.xml.registry.lifeCycleManagerURL", JUDDI_PUBLISH_URL);
		uddiProperties.put("javax.xml.registry.securityManagerURL", JUDDI_SECURITY_URL);
		uddiProperties.put("scout.proxy.uddiVersion", JUDDI_VERSION);
		uddiProperties.put("scout.juddi.client.config.file", "META-INF/jaxr-uddi.xml");

		connectionFactory.setProperties(uddiProperties);

		final Connection uddiConnection = connectionFactory.createConnection();

		final PasswordAuthentication passwdAuth = new PasswordAuthentication("inf14", "inf14".toCharArray());
		final Set<PasswordAuthentication> passwdAuthSet = new HashSet<PasswordAuthentication>();
		passwdAuthSet.add(passwdAuth);
		uddiConnection.setCredentials(passwdAuthSet);
		return uddiConnection;
	}

	public static Multimap<String, Service> getAllServices() throws JAXRException
	{
		final Connection connection = getConnection();
		final Multimap<String, Service> servicesMap = ArrayListMultimap.create();

		try
		{
			final BusinessQueryManager uddiQueryManager = connection.getRegistryService().getBusinessQueryManager();
			final Collection<Organization> organizations = getOrganizations("%", uddiQueryManager);

			for (final Organization orga : organizations)
			{
				final String organizationName = getLocalString(orga.getName());

				@SuppressWarnings("unchecked")
				final Collection<Service> services = orga.getServices();
				for (final Service service : services)
				{
					servicesMap.put(organizationName, service);
				}
			}
		}
		finally
		{
			if (connection != null)
			{
				connection.close();
			}
		}

		return servicesMap;
	}

	/**
	 * Tries to find a service matching the given organization name and service
	 * name.
	 *
	 * @param organizationName
	 *          use '%' as wildcard
	 * @param serviceName
	 *          use '%' as wildcard
	 * @param majorVersion
	 *          use negative number to ignore version
	 * @param minorVersion
	 *          use negative number to ignore version
	 * @return collection of services
	 * @throws JAXRException
	 */
	public static Collection<Service> getServices(final String organizationName, final String serviceName,
			final int majorVersion, final int minorVersion) throws JAXRException
	{
		final Connection connection = getConnection();
		final Collection<Service> matchingServices = Lists.newArrayList();

		try
		{
			final BusinessQueryManager uddiQueryManager = connection.getRegistryService().getBusinessQueryManager();
			final Collection<Organization> organizations = getOrganizations(organizationName, uddiQueryManager);

			final List<String> serviceNamePatterns = new ArrayList<String>();
			serviceNamePatterns.add(serviceName);

			for (final Organization orga : organizations)
			{
				final BulkResponse servicesResponse = uddiQueryManager.findServices(orga.getKey(), null, serviceNamePatterns,
						null, null);

				@SuppressWarnings("unchecked")
				final Collection<Service> services = servicesResponse.getCollection();

				// TODO specify version in findServices invocation
				for(final Service service : services)
				{
					// unsupported feature, leads to UnsupportedCapabilityException :-(
					// if (((majorVersion < 0) || (service.getMajorVersion() ==
					// majorVersion))
					// && ((minorVersion < 0) || (service.getMinorVersion() ==
					// minorVersion)))
					{
						matchingServices.add(service);
					}
				}
			}
		}
		finally
		{
			if (connection != null)
			{
				connection.close();
			}
		}

		return matchingServices;
	}

	private static Collection<Organization> getOrganizations(String organizationName,
			final BusinessQueryManager uddiQueryManager) throws JAXRException
	{
		final List<String> namePatterns = new ArrayList<String>();
		namePatterns.add(organizationName);
		final BulkResponse organizationResponse = uddiQueryManager.findOrganizations(null, namePatterns, null, null, null,
				null);

		@SuppressWarnings("unchecked")
		final Collection<Organization> organizations = organizationResponse.getCollection();
		return organizations;
	}

	/**
	 * Returns the first localized String found for a given
	 * {@link InternationalString}.
	 *
	 * @param internationalString
	 * @return String value of the first {@link LocalizedString}
	 * @throws JAXRException
	 */
	public static String getLocalString(InternationalString internationalString) throws JAXRException
	{
		if (internationalString != null)
		{
			@SuppressWarnings("unchecked")
			final Collection<LocalizedString> localizedStrings = internationalString.getLocalizedStrings();
			return localizedStrings.iterator().next().getValue();
		}
		else
		{
			return "null";
		}
	}

	public static String getFirstServiceBinding(Service service) throws JAXRException
	{
		@SuppressWarnings("unchecked")
		final Collection<ServiceBinding> bindings = service.getServiceBindings();

		if (!bindings.isEmpty())
		{
			final ServiceBinding firstBinding = bindings.iterator().next();
			return firstBinding.getAccessURI();
		}

		return "null";
	}
}
