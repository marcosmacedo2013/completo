package br.com.hitbra;

import br.com.hitbra.dao.DataStore;
import br.com.hitbra.dao.MongoDataStore;
import br.com.hitbra.model.OfferModel;
import br.com.hitbra.services.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DBObject;
import org.apache.log4j.Logger;

import java.util.List;

import static org.apache.log4j.Logger.getLogger;

public class WorkerOffer
{
	private static final Logger LOG = getLogger( WorkerOffer.class.getName( ) );

	public void execute( )
	{
		System.out.println( " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ " ) ;

		DataStore store = null;
		try
		{
			store = MongoDataStore.getInstanceOffer( );
			System.out.println( "Mongo Connection Check: " + store.toString( ) );
			List<DBObject> list =  ( List<DBObject> ) store.getAllObjectsOffer( ) ;
			System.out.println( " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ " ) ;
			for( int i = 0 ; i < list.size() ; i++ )
			{
				System.out.println( " DADOS ===> " + list.get( i ) ) ;

				ObjectMapper objectMapper = new ObjectMapper( );
				OfferModel offerModel = objectMapper.readValue(list.get( i ).toString( ), OfferModel.class);

				// sempre criar/atualizar a Offer
				ExecuteCreateOffer executor = new ExecuteCreateOffer( ) ;
				executor.execute( offerModel );
				System.out.println( " >>>>> Creating Offer <<<<<<< " ) ;
				LOG.info( ">>>>> Creating Offer <<<<<<<" );

				store.removeRawEventOffer(  list.get( i ) ) ;
				LOG.info( ">>>>> Deleting Offer MongoDB <<<<<<<" );
			}
			System.out.println( " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ " ) ;
		}
		catch( Exception e )
		{
			LOG.error( "Error WorkerOffer.run() ", e );
			e.printStackTrace();
		}
	}
}