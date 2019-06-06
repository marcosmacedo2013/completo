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

public class HybrisExecuteCreatePriceOffer extends HybrisConsumer implements OfferCommand
{
	private static final Logger LOG = getLogger( HybrisExecuteCreatePriceOffer.class.getName( ) );

	public HybrisExecuteCreatePriceOffer( )
	{
		super.getToken( ) ;
	}

	public void execute( OfferModel offer )
	{
		String offerAsString = null ;
		try
		{
			LOG.info( " :: HybrisExecuteCreatePriceOffer.execute() starting ::" );
			System.out.println( " :: HybrisExecuteCreatePriceOffer.execute() starting ::" );

			// uri information
			final UriComponents uri = UriComponentsBuilder.fromUriString( BASEURL )
					.path( URICREATEPRICEOFFER ).build( ).encode( );

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
			offerAsString = objectMapper.writeValueAsString( offer );

			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;
			System.out.println( "  HYBRIS - REST API  :: HybrisExecuteCreatePriceOffer.execute() body :: " + uri.toString() + " - "  + offerAsString );
			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;

			LOG.info( " Offer :: HybrisExecuteCreatePriceOffer.execute() :: " +  offerAsString );

			// send Rest
			RestTemplate restTemplate = new RestTemplate( );
			ResponseEntity<String> result = restTemplate
					.exchange( uri.toString( ), HttpMethod.PUT, getRequest( offerAsString ), String.class );

			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;
			System.out.println( "  STATUS: << OK >>  HybrisExecuteCreatePriceOffer.execute()" + offerAsString ) ;
			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;

			System.out.println( "##########################  :: HybrisExecuteCreatePriceOffer.execute() OK ::" + offerAsString );
			LOG.debug( "##########################  :: HybrisExecuteCreatePriceOffer.execute() OK ::" + offerAsString );

		}
		catch (HttpClientErrorException e)
		{
			LOG.error( " :: HybrisExecuteCreatePriceOffer.execute() :: HttpClientErrorException :: " + e.getStatusCode( ) + " :: " + e.getResponseBodyAsString( ) );
			LOG.error( "Error :: HybrisExecuteCreatePriceOffer :: HybrisExecuteChangeStatusOffer.execute() ", e ) ;
			System.out.println( " :: HybrisExecuteCreatePriceOffer.execute() :: HttpClientErrorException :: " + e.getStatusCode( ) + " :: " + e.getResponseBodyAsString( ) );

			DataStore store = null;
			try
			{
				store = MongoDataStore.getInstanceError( );
				store.storeRawEventError( "{ \"error\": \"" + e.getMessage() + " - Create Price Offer\", \"offerId\":\""
						+ offer.getOffer() + "\",\"message\":"+ e.getResponseBodyAsString( )
						+ ", \"offer\":" + offerAsString + "}") ;
			}
			catch (Exception exception)
			{
				LOG.error( "Error HybrisExecuteCreatePriceOffer.exception() ", exception );
				exception.printStackTrace( );
			}
		}
		catch (Exception e)
		{
			LOG.error( " Error :: Exception :: HybrisExecuteCreatePriceOffer.execute() ", e );
			System.out.println( " ################ HybrisExecuteCreatePriceOffer.execute() :: HttpClientErrorException :: " + e.getMessage( ) );
		}
	}
}