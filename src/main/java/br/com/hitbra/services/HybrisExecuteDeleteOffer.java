package br.com.hitbra.services;

import br.com.hitbra.dao.DataStore;
import br.com.hitbra.dao.MongoDataStore;
import br.com.hitbra.model.OfferModel;
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

public class HybrisExecuteDeleteOffer extends HybrisConsumer implements OfferCommand
{
	private static final Logger LOG = getLogger( HybrisExecuteDeleteOffer.class.getName( ) );

	public HybrisExecuteDeleteOffer( )
	{
		super.getToken( ) ;
	}

	public void execute( OfferModel offer )
	{
		String offerModelAsString = null ;
		try
		{
			LOG.info( " :: HybrisExecuteDeleteOffer.execute() starting ::" );
			System.out.println( " :: HybrisExecuteDeleteOffer.execute() starting ::" );

			// uri information
			UriComponents uri = UriComponentsBuilder.fromUriString( BASEURL ).path( URIDELETEOFFER ).build( ).encode( );

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
			offerModelAsString = objectMapper.writeValueAsString( offer );

			LOG.info( " Offer :: HybrisExecuteDeleteOffer.execute() :: " +  offerModelAsString );

			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;
			System.out.println( "  HYBRIS - REST API  :: HybrisExecuteDeleteOffer.execute() body :: " + uri.toString() + " - "  + offerModelAsString );
			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;

			// send Rest
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> result = restTemplate
					.exchange( uri.toString( ), HttpMethod.DELETE, getRequest( offerModelAsString ), String.class );

			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;
			System.out.println( "  STATUS: << OK >>  HybrisExecuteDeleteOffer.execute()" + offerModelAsString ) ;
			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;

			System.out.println( "##########################  :: HybrisExecuteDeleteOffer.execute() OK ::" + offerModelAsString );
			LOG.debug( "##########################  :: HybrisExecuteDeleteOffer.execute() OK ::" + offerModelAsString );
		}
		catch (HttpClientErrorException e)
		{
			LOG.error( " :: HybrisExecuteDeleteOffer.execute() :: HttpClientErrorException :: " + e.getStatusCode( ) + " :: " + e.getResponseBodyAsString( ) );
			LOG.error( "Error :: HybrisExecuteDeleteOffer :: HybrisExecuteDeleteOffer.execute() ", e ) ;
			System.out.println( " :: HybrisExecuteDeleteOffer.execute() :: HttpClientErrorException :: " + e.getStatusCode( ) + " :: " + e.getResponseBodyAsString( ) );

			DataStore store = null;
			try
			{
				store = MongoDataStore.getInstanceError( );
				store.storeRawEventError( "{ \"error\": \"" + e.getMessage() + " Delete Offer\", \"offerId\":\""
						+ offer.getOffer() + "\",\"message\":"+ e.getResponseBodyAsString( )
						+ ", \"offer\":" + offerModelAsString + "}") ;
			}
			catch (Exception exception)
			{
				LOG.error( "Error HybrisExecuteDeleteOffer.exception() ", exception );
				exception.printStackTrace( );
			}
		}
		catch (Exception e)
		{
			LOG.error( " Error :: Exception :: HybrisExecuteDeleteOffer.execute() ", e );
			System.out.println( " ################ HybrisExecuteDeleteOffer.execute() :: HttpClientErrorException :: " + e.getMessage( ) );
		}
	}
}