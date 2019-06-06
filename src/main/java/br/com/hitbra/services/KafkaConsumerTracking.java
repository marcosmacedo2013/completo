package br.com.hitbra.services;

import br.com.hitbra.Utils;
import br.com.hitbra.dao.DataStore;
import br.com.hitbra.dao.MongoDataStore;
import br.com.hitbra.marketplace.avro.orders.Order;
import br.com.hitbra.model.TrackingModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static org.apache.log4j.Logger.getLogger;

@Service
@Configuration
public class KafkaConsumerTracking
{
	private static final Logger LOG = getLogger( KafkaConsumerTracking.class.getName( ) );

	@KafkaListener( topics = "${hmk.topic.tracking}", groupId = "${hmk.topic.group-id}" )
	public void processMessage( ConsumerRecord<String, Order> orderAvro )
	{
		LOG.info( "KafkaConsumerTracking :: received content tracking ::  " + orderAvro  );
		System.out.println( "KafkaConsumerTracking :: received content tracking ::  " + orderAvro  );

		TrackingModel trackingModel = Utils.translateAvroToTrackingModel( orderAvro.value( ) ) ;

		DataStore store = null;
		try
		{
			store = MongoDataStore.getInstanceTracking( );
			ObjectMapper objectMapper = new ObjectMapper( );
			String trackingModelAsString = objectMapper.writeValueAsString( trackingModel );
			store.storeRawEventTracking( trackingModelAsString );
		}
		catch (Exception e)
		{
			LOG.error( "Error KafkaConsumerTracking.processMessage() ", e );
			e.printStackTrace( );
		}
	}
}