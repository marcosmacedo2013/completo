package br.com.hitbra.services;

import br.com.hitbra.dao.DataStore;
import br.com.hitbra.dao.MongoDataStore;
import br.com.hitbra.model.BatchOfferModel;
import br.com.hitbra.model.OfferModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.apache.log4j.Logger.getLogger;

public class HybrisExecuteCreateOfferInBatch extends HybrisConsumer implements OfferCommand
{
	private static final Logger LOG = getLogger( HybrisExecuteCreateOfferInBatch.class.getName( ) );

	public HybrisExecuteCreateOfferInBatch( )
	{
		super.getToken( ) ;
	}

	public void execute( OfferModel model )
	{
		String listOfferModelAsString = null ;
		try
		{
			LOG.info( " :: HybrisExecuteCreateOfferInBatch.execute() starting ::" );
			System.out.println( " :: HybrisExecuteCreateOfferInBatch.execute() starting ::" );

			List<BatchOfferModel> list = null ;

			// uri information
			final UriComponents uri = UriComponentsBuilder.fromUriString( BASEURL )
					.path( URICREATEOFFERBATCH ).build( ).encode( );

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
			listOfferModelAsString = objectMapper.writeValueAsString( list );

			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;
			System.out.println( "  HYBRIS - REST API  :: HybrisExecuteCreateOfferInBatch.execute() body :: " + uri.toString() + " - "  + listOfferModelAsString );
			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;

			LOG.info( " Offer :: HybrisExecuteCreateOfferInBatch.execute() :: " +  listOfferModelAsString );

			// send Rest
			RestTemplate restTemplate = new RestTemplate(  );
			ResponseEntity<String> result = restTemplate
					.postForEntity( uri.toString( ), getRequest( listOfferModelAsString ), String.class );

			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;
			System.out.println( "  STATUS: << OK >>  HybrisExecuteCreateOfferInBatch.execute()" + listOfferModelAsString ) ;
			System.out.println( "----------------------------------------------------------------------------------------------------------------------------------" ) ;

			System.out.println( "##########################  :: HybrisExecuteCreateOfferInBatch.execute() OK ::" + listOfferModelAsString );
			LOG.debug( "##########################  :: HybrisExecuteCreateOfferInBatch.execute() OK ::" + listOfferModelAsString );
		}
		catch (HttpClientErrorException e)
		{
			LOG.error( " :: HybrisExecuteCreateOfferInBatch.execute() :: HttpClientErrorException :: " + e.getStatusCode( ) + " :: " + e.getResponseBodyAsString( ) );
			LOG.error( "Error :: HybrisExecuteCreateOfferInBatch :: HybrisExecuteCreateOfferInBatch.execute() ", e ) ;
			System.out.println( " :: HybrisExecuteCreateOfferInBatch.execute() :: HttpClientErrorException :: " + e.getStatusCode( ) + " :: " + e.getResponseBodyAsString( ) );

			DataStore store = null;
			try
			{
				store = MongoDataStore.getInstanceError( );
				store.storeRawEventError( "{ \"error\": \"" + e.getMessage() + " - Create in Batch Offer\", \"offerId\":\""
						+ model.getOffer() + "\",\"message\":"+ e.getResponseBodyAsString( )
						+ ", \"offers\":" + listOfferModelAsString + "}") ;
			}
			catch (Exception exception)
			{
				LOG.error( "Error HybrisExecuteCreateOfferInBatch.exception() ", exception );
				exception.printStackTrace( );
			}
		}
		catch (Exception e)
		{
			LOG.error( "Error :: Exception :: HybrisExecuteCreateOfferInBatch.execute() ", e );
		}
	}
}