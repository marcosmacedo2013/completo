package br.com.hitbra.services;

import br.com.hitbra.model.VendorModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.apache.log4j.Logger.getLogger;

public class HybrisExecuteCreateProduct extends HybrisConsumer implements VendorCommand
{
	private static final Logger LOG = getLogger( HybrisExecuteCreateProduct.class.getName( ) );

	public HybrisExecuteCreateProduct( )
	{
		super.getToken( ) ;
	}

	public void execute( VendorModel product )
	{
		try
		{
			LOG.info( " :: HybrisExecuteCreateProduct.execute() starting ::" );
			System.out.println( " :: HybrisExecuteCreateProduct.execute() starting ::" );

			// uri information
			final UriComponents uri = UriComponentsBuilder.fromUriString( BASEURL )
					.path( URICREATEPRODUCT ).build( ).encode( );

			// SSL security
			SSLContextBuilder sslcontext = new SSLContextBuilder( );
			sslcontext.loadTrustMaterial( null, new TrustSelfSignedStrategy( ) );
			CloseableHttpClient httpClient = HttpClients.custom( )
					.setSSLContext( sslcontext.build( ) )
					.setSSLHostnameVerifier( NoopHostnameVerifier.INSTANCE ).build( );
			HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory( );
			requestFactory.setHttpClient( httpClient );
			RestTemplate restTemplate = new RestTemplate( requestFactory );

			// authorization
			restTemplate.getInterceptors( )
					.add( new BasicAuthorizationInterceptor( AUTHORIZATIONUSER,
							AUTHORIZATIONPASSWORD ) );

			// body information
			ObjectMapper objectMapper = new ObjectMapper( );
			String productAsString = objectMapper.writeValueAsString( product );

			productAsString = productAsString.replace("\"lm\":0,", "");

			LOG.info( " Offer :: HybrisExecuteCreateProduct.execute() :: " +  productAsString );

			// send Rest
			ResponseEntity<String> result = restTemplate
					.postForEntity( uri.toString( ), getRequest( productAsString ), String.class );

			LOG.info( " Product :: " + result.getBody( )  );
		}
		catch (HttpClientErrorException e)
		{
			LOG.error( " HttpClientErrorException :: " + e.getStatusCode( ) + " :: " + e.getResponseBodyAsString( ) );
			LOG.error( "Error :: HttpClientErrorException :: HybrisExecuteCreateProduct.execute() ", e ) ;
		}
		catch (Exception e)
		{
			LOG.error( "Error :: Exception :: HybrisExecuteCreateProduct.execute() ", e );
		}
	}
}
