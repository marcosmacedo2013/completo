package br.com.hitbra;

import br.com.hitbra.dao.DataStore;
import br.com.hitbra.dao.MongoDataStore;
import br.com.hitbra.model.TrackingModel;
import br.com.hitbra.services.HybrisExecuteUpdateTracking;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DBObject;
import org.apache.log4j.Logger;

import java.util.List;

import static org.apache.log4j.Logger.getLogger;

public class HybrisWorkerTracking
{
	private static final Logger LOG = getLogger( HybrisWorkerTracking.class.getName( ) );

	public void execute( )
	{
		System.out.println( " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ " ) ;

		DataStore store = null;
		try
		{
			store = MongoDataStore.getInstanceTracking( );
			System.out.println( "Mongo Connection Check: " + store.toString( ) );
			List<DBObject> list =  ( List<DBObject> ) store.getAllObjectsTracking( ) ;
			System.out.println( " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ " ) ;
			for( int i = 0 ; i < list.size() ; i++ )
			{
				System.out.println( " DADOS ===> " + list.get( i ) ) ;

				ObjectMapper objectMapper = new ObjectMapper( );
				TrackingModel trackingModel = objectMapper.readValue(list.get( i ).toString( ), TrackingModel.class);

				// sempre criar/atualizar um Tracking
				HybrisExecuteUpdateTracking executor = new HybrisExecuteUpdateTracking( ) ;
				executor.execute( trackingModel );
				System.out.println( " >>>>> Creating Tracking <<<<<<< " ) ;
				LOG.info( ">>>>> Creating Tracking <<<<<<<" );


				store.removeRawEventTracking(  list.get( i ) ) ;
				LOG.info( ">>>>> Deleting Tracking MongoDB <<<<<<<" );
			}
			System.out.println( " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ " ) ;
		}
		catch( Exception e )
		{
			LOG.error( "Error HybrisWorkerTracking.run() ", e );
			e.printStackTrace();
		}
	}
}