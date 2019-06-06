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

public class HybrisExecuteCreateStockOffer extends HybrisConsumer implements OfferCommand
{
	private static final Logger LOG = getLogger( HybrisExecuteCreatePriceOffer.class.getName( ) );

	public HybrisExecuteCreateStockOffer( )
	{
		super.getToken( ) ;
	}

	public void execute( OfferModel offer )
	{
		String offerAsString = null ;
		try
		{
			LOG.info( " :: HybrisExecuteCreateStockOffer.execute() starting ::" );
			System.out.println( " :: HybrisExecuteCreateStockOffer.execute() starting ::" );

			// uri information
			final UriComponents uri = UriComponentsBuilder.fromUriString( BASEURL )
					.path( URICREATESTOCKOFFER ).build( ).encode( );

			// SSL security
			SSLContextBuilder sslcontext = new SSLContextBuilder( );
			sslcontext.loadTrustMaterial( null, new TrustSelfSignedStrategy( ) );
			CloseableHttpClient httpClient = HttpClients.custom( )
					.setSSLContext( sslcontext.build( ) )
					.setSSLHostnameVerifier( NoopHostnameVerifier.INSTANCE ).build( );
			HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory( );
			requestFactory.setHttpClient( httpClient );
			RestTemplate restTemplate = new RestTemplate( requestFactory );

			// body information
			ObjectMapper objectMapper = new ObjectMapper( );
			offerAsString = objectMapper.writeValueAsString( offer );

			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;
			System.out.println( "  HYBRIS - REST API  :: HybrisExecuteCreateStockOffer.execute() body :: " + uri.toString() + " - "  + offerAsString );
			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;

			// send Rest
			ResponseEntity<String> result = restTemplate
					.exchange( uri.toString( ), HttpMethod.PUT, getRequest( offerAsString ), String.class );

			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;
			System.out.println( "  STATUS: << OK >>  HybrisExecuteCreateStockOffer.execute()" + offerAsString ) ;
			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;

			System.out.println( "##########################  :: HybrisExecuteCreateStockOffer.execute() OK ::" + offerAsString );
			LOG.debug( "##########################  :: HybrisExecuteCreateStockOffer.execute() OK ::" + offerAsString );

		}
		catch (HttpClientErrorException e)
		{
			LOG.error( " :: HybrisExecuteCreateStockOffer.execute() :: HttpClientErrorException :: " + e.getStatusCode( ) + " :: " + e.getResponseBodyAsString( ) );
			LOG.error( "Error :: HybrisExecuteCreateStockOffer :: HybrisExecuteCreateStockOffer.execute() ", e ) ;
			System.out.println( " :: HybrisExecuteCreateStockOffer.execute() :: HttpClientErrorException :: " + e.getStatusCode( ) + " :: " + e.getResponseBodyAsString( ) );

			DataStore store = null;
			try
			{
				store = MongoDataStore.getInstanceError( );
				store.storeRawEventError( "{ \"error\": \"" + e.getMessage() + " - Create Stock Offer\", \"offerId\":\""
						+ offer.getOffer() + "\",\"message\":"+ e.getResponseBodyAsString( )
						+ ", \"offer\":" + offerAsString + "}") ;
			}
			catch (Exception exception)
			{
				LOG.error( "Error HybrisExecuteCreateStockOffer.exception() ", exception );
				exception.printStackTrace( );
			}
		}
		catch (Exception e)
		{
			LOG.error( " Error :: Exception :: HybrisExecuteCreateStockOffer.execute() ", e );
			System.out.println( " ################ HybrisExecuteCreateStockOffer.execute() :: HttpClientErrorException :: " + e.getMessage( ) );
		}
	}
}