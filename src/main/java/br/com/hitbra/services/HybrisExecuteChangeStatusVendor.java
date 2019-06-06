package br.com.hitbra.services;

import br.com.hitbra.dao.DataStore;
import br.com.hitbra.dao.MongoDataStore;
import br.com.hitbra.model.VendorModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.log4j.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.apache.log4j.Logger.getLogger;

public class HybrisExecuteChangeStatusVendor extends HybrisConsumer implements VendorCommand
{
	private static final Logger LOG = getLogger( HybrisExecuteChangeStatusVendor.class.getName( ) );

	public HybrisExecuteChangeStatusVendor( )
	{
		super.getToken( ) ;
	}

	public void execute( VendorModel vendor )
	{
		String vendorAsString = null ;
		try
		{
			LOG.info( " :: HybrisExecuteChangeStatusVendor.execute() starting ::" );
			System.out.println( " :: HybrisExecuteChangeStatusVendor.execute() starting ::" );

			// uri information
			final UriComponents uri = UriComponentsBuilder.fromUriString( BASEURL )
					.path( URICREATEVENDOR ).build( ).encode( );

			// SSL security
			SSLContextBuilder sslcontext = new SSLContextBuilder( );
			sslcontext.loadTrustMaterial( null, new TrustSelfSignedStrategy( ) );
			CloseableHttpClient httpClient = HttpClients.custom( )
					.setSSLContext( sslcontext.build( ) )
					.setSSLHostnameVerifier( NoopHostnameVerifier.INSTANCE ).build( );
			HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory( );
			requestFactory.setHttpClient( httpClient );

			// body information
			ObjectMapper objectMapper = new ObjectMapper( );
			vendorAsString = objectMapper.writeValueAsString( vendor );

			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;
			System.out.println( "  HYBRIS - REST API  :: HybrisExecuteChangeStatusVendor.execute() body :: " + uri.toString() + " - "  + vendorAsString );
			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;

			// send Rest
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> result = restTemplate
					.exchange( uri.toString( ), HttpMethod.PUT, getRequest( vendorAsString ), String.class );

			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;
			System.out.println( "  STATUS: << OK >>  HybrisExecuteChangeStatusVendor.execute()" + vendorAsString ) ;
			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;

			System.out.println( "##########################  :: HybrisExecuteChangeStatusVendor.execute() OK ::" + vendorAsString );
			LOG.debug( "##########################  :: HybrisExecuteChangeStatusVendor.execute() OK ::" + vendorAsString );
		}
		catch (HttpClientErrorException e)
		{
			LOG.error( " :: HybrisExecuteChangeStatusVendor.execute() :: HttpClientErrorException :: " + e.getStatusCode( ) + " :: " + e.getResponseBodyAsString( ) );
			LOG.error( "Error :: HybrisExecuteChangeStatusVendor :: HybrisExecuteChangeStatusOffer.execute() ", e ) ;
			System.out.println( " :: HybrisExecuteChangeStatusVendor.execute() :: HttpClientErrorException :: " + e.getStatusCode( ) + " :: " + e.getResponseBodyAsString( ) );

			DataStore store = null;
			try
			{
				store = MongoDataStore.getInstanceError( );
				store.storeRawEventError( "{ \"error\": \"" + e.getMessage() + " - ChangeStatus Vendor\", \"vendorId\":\""
						+ vendor.getCode() + "\",\"message\":"+ e.getResponseBodyAsString( )
						+ ", \"vendor\":" + vendorAsString + "}") ;
			}
			catch (Exception exception)
			{
				LOG.error( "Error HybrisExecuteChangeStatusVendor.exception() ", exception );
				exception.printStackTrace( );
			}

		}
		catch (Exception e)
		{
			LOG.error( " Error :: Exception :: HybrisExecuteChangeStatusVendor.execute() ", e );
			System.out.println( " ################ HybrisExecuteChangeStatusVendor.execute() :: HttpClientErrorException :: " + e.getMessage( ) );
		}
	}
}
