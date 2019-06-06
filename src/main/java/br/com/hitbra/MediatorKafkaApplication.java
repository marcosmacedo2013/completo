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
public class MediatorKafkaApplication
{
	private static final Logger LOG = getLogger( MediatorKafkaApplication.class.getName( ) );

	public static void main( String[] args )
	{
		LOG.info( " ::: MediatorKafkaApplication.main() starting ::: " ) ;
		System.out.println( " ::: MediatorKafkaApplication.main() starting ::: " ) ;

		SpringApplication.run( MediatorKafkaApplication.class, args ) ;

		LOG.info( " ::: MediatorKafkaApplication.main() finished ::: " ) ;
		System.out.println( " ::: MediatorKafkaApplication.main() finished ::: " ) ;
	}

	@Scheduled( cron = "0/20 * * * * ?")
	public void execute( )
	{
		System.out.println( " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ " ) ;
		System.out.println( " << RUNNING >> " + new Date() ) ;
		try
		{
			WorkerOffer workerOffer      = new WorkerOffer( ) ;
			{
				System.out.println( " #####################################[ Workers running ]########################################### " ) ;
				workerOffer.execute();
			}
			System.out.println( " @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ " ) ;
		}
		catch( Exception e )
		{
			LOG.error( "Error WorkerShop.run() ", e );
			e.printStackTrace( );
		}
	}
}