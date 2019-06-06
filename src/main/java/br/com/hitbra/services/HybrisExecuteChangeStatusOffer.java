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

public class HybrisExecuteChangeStatusOffer extends HybrisConsumer implements OfferCommand
{
	private static final Logger LOG = getLogger( HybrisExecuteChangeStatusOffer.class.getName( ) );

	public HybrisExecuteChangeStatusOffer( )
	{
		super.getToken();
	}

	public void execute( OfferModel offer )
	{
		String offerModelAsString = null ;
		try
		{
			LOG.info( " :: HybrisExecuteChangeStatusOffer.execute() starting ::" );
			System.out.println( " :: HybrisExecuteChangeStatusOffer.execute() starting ::" );

			// uri information
			UriComponents uri = null ;
			if ( offer.isActive( ) )
			{
				uri = UriComponentsBuilder.fromUriString( BASEURL ).path( URIACTIVEOFFER ).build( ).encode( );
			}
			else
			{
				uri = UriComponentsBuilder.fromUriString( BASEURL ).path( URIDESACTIVEOFFER ).build( ).encode( );
			}

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

			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;
			System.out.println( "  HYBRIS - REST API  :: HybrisExecuteChangeStatusOffer.execute() body :: " + uri.toString() + " - "  + offerModelAsString );
			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;

			// send Rest
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> result = restTemplate
					.exchange( uri.toString( ), HttpMethod.PUT, getRequest( offerModelAsString ), String.class );


			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;
			System.out.println( "  STATUS: << OK >>  HybrisExecuteChangeStatusOffer.execute()" + offerModelAsString ) ;
			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;

			System.out.println( "##########################  :: HybrisExecuteChangeStatusOffer.execute() OK ::" + offerModelAsString );
			LOG.debug( "##########################  :: HybrisExecuteChangeStatusOffer.execute() OK ::" + offerModelAsString );

		}
		catch (HttpClientErrorException e)
		{
			LOG.error( " :: HybrisExecuteChangeStatusOffer.execute() :: HttpClientErrorException :: " + e.getStatusCode( ) + " :: " + e.getResponseBodyAsString( ) );
			LOG.error( "Error :: HybrisExecuteChangeStatusOffer :: HybrisExecuteChangeStatusOffer.execute() ", e ) ;
			System.out.println( " :: HybrisExecuteChangeStatusOffer.execute() :: HttpClientErrorException :: " + e.getStatusCode( ) + " :: " + e.getResponseBodyAsString( ) );

			DataStore store = null;
			try
			{
				store = MongoDataStore.getInstanceError( );
				store.storeRawEventError( "{ \"error\": \"" + e.getMessage() + " - ChangeStatus Offer\", \"offerId\":\""
						+ offer.getOffer() + "\",\"message\":"+ e.getResponseBodyAsString( )
						+ ", \"offer\":" + offerModelAsString + "}") ;
			}
			catch (Exception exception)
			{
				LOG.error( "Error HybrisExecuteChangeStatusOffer.exception() ", exception );
				exception.printStackTrace( );
			}
		}
		catch (Exception e)
		{
			LOG.error( " Error :: Exception :: HybrisExecuteChangeStatusOffer.execute() ", e );
			System.out.println( " ################ HybrisExecuteChangeStatusOffer.execute() :: HttpClientErrorException :: " + e.getMessage( ) );
		}
	}
}