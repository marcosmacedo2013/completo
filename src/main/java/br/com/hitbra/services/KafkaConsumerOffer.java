package br.com.hitbra.services;

import br.com.hitbra.Utils;
import br.com.hitbra.dao.DataStore;
import br.com.hitbra.dao.MongoDataStore;
import br.com.hitbra.marketplace.avro.offers.Offer;
import br.com.hitbra.model.OfferModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static org.apache.log4j.Logger.getLogger;

@Service
@Configuration
public class KafkaConsumerOffer
{
	private static final Logger LOG = getLogger( KafkaConsumerOffer.class.getName( ) );

	@KafkaListener( topics = "${hitbra.topic.offer}", groupId = "${hitbra.topic.group-id}" )
	public void processMessage( ConsumerRecord<String, Offer> offerAvro )
	{
		LOG.info( "KafkaConsumerOffer :: received content offer ::  " + offerAvro  );
		System.out.println( "KafkaConsumerOffer :: received content offer ::  " + offerAvro  );

		OfferModel offerModel = Utils.translateAvroToOfferModel( offerAvro.value( ) ) ;

		DataStore store = null;
		try
		{
			store = MongoDataStore.getInstanceOffer( );
			ObjectMapper objectMapper = new ObjectMapper( );
			String offerModelAsString = objectMapper.writeValueAsString( offerModel );
			store.storeRawEventOffer( offerModelAsString );
		}
		catch (Exception e)
		{
			LOG.error( "Error KafkaConsumerOffer.processMessage() ", e );
			e.printStackTrace( );
		}
	}
}