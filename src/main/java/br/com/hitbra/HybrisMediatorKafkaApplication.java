package br.com.hitbra;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

import static org.apache.log4j.Logger.getLogger;

@SpringBootApplication
@EnableScheduling
public class HybrisMediatorKafkaApplication
{
	private static final Logger LOG = getLogger( HybrisMediatorKafkaApplication.class.getName( ) );

	public static void main( String[] args )
	{
		LOG.info( " ::: HybrisMediatorKafkaApplication.main() starting ::: " ) ;
		System.out.println( " ::: HybrisMediatorKafkaApplication.main() starting ::: " ) ;

		SpringApplication.run( HybrisMediatorKafkaApplication.class, args ) ;

		LOG.info( " ::: HybrisMediatorKafkaApplication.main() finished ::: " ) ;
		System.out.println( " ::: HybrisMediatorKafkaApplication.main() finished ::: " ) ;
	}

	@Scheduled( cron = "0/20 * * * * ?")
	public void execute( )
	{
		System.out.println( " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ " ) ;
		System.out.println( " << RUNNING >> " + new Date() ) ;
		try
		{
			HybrisWorkerShop workerShop        = new HybrisWorkerShop( ) ;
			HybrisWorkerOffer workerOffer      = new HybrisWorkerOffer( ) ;
			HybrisWorkerTracking workerTracker = new HybrisWorkerTracking( ) ;
			{
				System.out.println( " #####################################[ Workers running ]########################################### " ) ;

				workerShop.execute();
				workerOffer.execute();
				workerTracker.execute();

			}
			System.out.println( " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ " ) ;
		}
		catch( Exception e )
		{
			LOG.error( "Error HybrisWorkerShop.run() ", e );
			e.printStackTrace( );
		}
	}
}