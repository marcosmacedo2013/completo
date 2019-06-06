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
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.apache.log4j.Logger.getLogger;

public class HybrisExecuteCreateUpdateVendor extends HybrisConsumer implements VendorCommand
{
	private static final Logger LOG = getLogger( HybrisExecuteCreateUpdateVendor.class.getName( ) );

	public HybrisExecuteCreateUpdateVendor( )
	{
		super.getToken( ) ;
	}

	public void execute( VendorModel vendor )
	{
		String vendorAsString = "" ;
		try
		{
			System.out.println( " :: HybrisExecuteCreateUpdateVendor.execute() starting ::" );
			LOG.debug( " :: HybrisExecuteCreateUpdateVendor.execute() starting ::" );

			// uri information
			final UriComponents uri = UriComponentsBuilder.fromUriString( BASEURL ).path( URICREATEVENDOR )
					.build( ).encode( );

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
			System.out.println( "  HYBRIS - REST API  :: HybrisExecuteCreateUpdateVendor.execute() body :: " + uri.toString() + " - "  + vendorAsString );
			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;

			LOG.debug( "########################## :: HybrisExecuteCreateUpdateVendor.execute() body :: " + uri.toString() + " - "  + vendorAsString );

			// send Rest

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> result = restTemplate
					.postForEntity( uri.toString( ), getRequest( vendorAsString ), String.class );

			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;
			System.out.println( "  STATUS: << OK >>  HybrisExecuteCreateUpdateVendor.execute()" + vendorAsString ) ;
			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;

			System.out.println( "##########################  :: HybrisExecuteCreateUpdateVendor.execute() OK ::" + vendorAsString );
			LOG.debug( "##########################  :: HybrisExecuteCreateUpdateVendor.execute() OK ::" + vendorAsString );
		}
		catch (HttpClientErrorException e)
		{
			LOG.error( " :: HybrisExecuteCreateUpdateVendor.execute() :: HttpClientErrorException :: " + e.getStatusCode( ) + " :: " + e.getResponseBodyAsString( ) );
			LOG.error( "Error :: HttpClientErrorException :: HybrisExecuteCreateUpdateVendor.execute() ", e ) ;
			System.out.println( " :: HybrisExecuteCreateUpdateVendor.execute() :: HttpClientErrorException :: " + e.getStatusCode( ) + " :: " + e.getResponseBodyAsString( ) );
			LOG.debug( " :: HybrisExecuteCreateUpdateVendor.execute() :: HttpClientErrorException :: " + e.getStatusCode( ) + " :: " + e.getResponseBodyAsString( ) );

			DataStore store = null;
			try
			{
				store = MongoDataStore.getInstanceError( );
				store.storeRawEventError( "{ \"error\": \"" + e.getMessage() + " Create-Update Vendor\", \"shopId\":\""
						+ vendor.getCode() + "\",\"message\":"+ e.getResponseBodyAsString( )
						+ ", \"offer\":" + vendorAsString + "}") ;
			}
			catch (Exception exception)
			{
				LOG.error( "Error HybrisExecuteCreateUpdateVendor.exception() ", exception );
				exception.printStackTrace( );
			}
		}
		catch (Exception e)
		{
			LOG.error( " Error :: Exception :: HybrisExecuteCreateUpdateVendor.execute() ", e );
			System.out.println( " ################ HybrisExecuteCreateUpdateVendor.execute() :: HttpClientErrorException :: " + e.getMessage( ) );
		}
	}
}
