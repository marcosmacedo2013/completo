package br.com.hitbra.services;

import br.com.hitbra.dao.DataStore;
import br.com.hitbra.dao.MongoDataStore;
import br.com.hitbra.model.TrackingModel;
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

public class HybrisExecuteUpdateTracking extends HybrisConsumer implements TrackingCommand
{
	private static final Logger LOG = getLogger( HybrisExecuteUpdateTracking.class.getName( ) );

	public HybrisExecuteUpdateTracking( )
	{
		super.getToken( ) ;
	}

	public void execute( TrackingModel tracking )
	{
		String trackingAsString = null ;
		try
		{
			LOG.info( " :: HybrisExecuteUpdateTracking.execute() starting ::" );
			System.out.println( " :: HybrisExecuteUpdateTracking.execute() starting ::" );

			// uri information
			final UriComponents uri = UriComponentsBuilder.fromUriString( BASEURL )
					.path( URIUPDATETRACKING ).build( ).encode( );

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
			trackingAsString = objectMapper.writeValueAsString( tracking );

			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;
			System.out.println( "  HYBRIS - REST API  :: HybrisExecuteUpdateTracking.execute() body :: " + uri.toString() + " - "  + trackingAsString );
			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;

			LOG.debug( "########################## :: HybrisExecuteUpdateTracking.execute() body :: " + uri.toString() + " - "  + trackingAsString );

			// send Rest
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> result = restTemplate
					.exchange( uri.toString( ), HttpMethod.PUT, getRequest( trackingAsString ), String.class );

			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;
			System.out.println( "  STATUS: << OK >>  HybrisExecuteUpdateTracking.execute()" + trackingAsString ) ;
			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;

			System.out.println( "##########################  :: HybrisExecuteUpdateTracking.execute() OK ::" + trackingAsString );
			LOG.debug( "##########################  :: HybrisExecuteUpdateTracking.execute() OK ::" + trackingAsString );

		}
		catch (HttpClientErrorException e)
		{
			LOG.error( " :: HybrisExecuteUpdateTracking.execute() :: HttpClientErrorException :: " + e.getStatusCode( ) + " :: " + e.getResponseBodyAsString( ) );
			LOG.error( "Error :: HybrisExecuteUpdateTracking :: HybrisExecuteCreateOffer.execute() ", e ) ;
			System.out.println( " :: HybrisExecuteUpdateTracking.execute() :: HttpClientErrorException :: " + e.getStatusCode( ) + " :: " + e.getResponseBodyAsString( ) );

			// se o error for 422 com errorCode == 1 entao a Offer ja existe
			DataStore store = null;
			try
			{
				store = MongoDataStore.getInstanceError( );
				store.storeRawEventError( "{ \"error\": \"" + e.getMessage() + " Update Tracking \", \"OrderId\":\""
						+ tracking.getOrder_id() + "\",\"message\":"+ e.getResponseBodyAsString( )
						+ ", \"tracking\":" + trackingAsString + "}") ;
			}
			catch (Exception exception)
			{
				LOG.error( "Error HybrisExecuteUpdateTracking.exception() ", exception );
				exception.printStackTrace( );
			}
		}
		catch (Exception e)
		{
			LOG.error( " Error :: Exception :: HybrisExecuteCreateOffer.execute() ", e );
			System.out.println( " ################ HybrisExecuteCreateOffer.execute() :: HttpClientErrorException :: " + e.getMessage( ) );
		}
	}
}