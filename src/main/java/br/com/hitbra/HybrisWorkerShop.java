package br.com.hitbra;

import br.com.hitbra.dao.DataStore;
import br.com.hitbra.dao.MongoDataStore;
import br.com.hitbra.model.VendorModel;
import br.com.hitbra.services.HybrisExecuteChangeStatusVendor;
import br.com.hitbra.services.HybrisExecuteCreateUpdateVendor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DBObject;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

import static org.apache.log4j.Logger.getLogger;

public class HybrisWorkerShop
{
	private static final Logger LOG = getLogger( HybrisWorkerOffer.class.getName( ) );

	public void execute(  )
	{
		System.out.println( " >>>>>>>>>>>>>>>>>>>>>> HybrisWorkerShop.execute() " + new Date( ) + "< <<<<<<<<<<<<<<<<<" ) ;
		DataStore store = null;
		try
		{
			store = MongoDataStore.getInstanceShop( );
			System.out.println( "Mongo Connection Check: " + store.toString( ) );
			List<DBObject> list =  ( List<DBObject> ) store.getAllObjectsShop( ) ;
			System.out.println( " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ " ) ;
			for( int i = 0 ; i < list.size() ; i++ )
			{
				System.out.println( " DADOS ===> " + list.get( i ) ) ;

				ObjectMapper objectMapper = new ObjectMapper( );
				VendorModel vendorModel = objectMapper.readValue(list.get( i ).toString( ), VendorModel.class);


				if ( ! vendorModel.isActive( ) )
				{
					HybrisExecuteChangeStatusVendor executor = new HybrisExecuteChangeStatusVendor( ) ;
					executor.execute( vendorModel );
					System.out.println( " >>>>> Changing Status Vendor <<<<<<< " ) ;
					LOG.info( ">>>>> Changing Status Vendor <<<<<<<" );
				}
				else
				{
					HybrisExecuteCreateUpdateVendor executor = new HybrisExecuteCreateUpdateVendor( ) ;
					executor.execute( vendorModel );
					System.out.println( " >>>>> Creating / Updating Vendor <<<<<<< " ) ;
					LOG.info( ">>>>> Creating / Updating Vendor <<<<<<<" );
				}
				store.removeRawEventShop(  list.get( i ) ) ;
				LOG.info( ">>>>> Deleting Vendor MongoDB <<<<<<<" );

			}
			System.out.println( " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ " ) ;
		}
		catch( Exception e )
		{
			LOG.error( "Error HybrisWorkerShop.run() ", e );
			e.printStackTrace();
		}
	}
}

