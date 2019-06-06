package br.com.hitbra.services;

import br.com.hitbra.Utils;
import br.com.hitbra.dao.DataStore;
import br.com.hitbra.dao.MongoDataStore;
import br.com.hitbra.model.VendorModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.confluent.ksql.avro_schemas.KsqlDataSourceSchema;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static org.apache.log4j.Logger.getLogger;

@Service
@Configuration
public class KafkaConsumerShop
{
	private static final Logger LOG = getLogger( KafkaConsumerShop.class.getName( ) );

	@KafkaListener( topics = "${hmk.topic.shop}", groupId = "${hmk.topic.group-id}" )
	public void processMessage( ConsumerRecord<String, KsqlDataSourceSchema> shopAvro)
	{
		LOG.info( "KafkaConsumerShop :: received content shop ::  " + shopAvro  );
		System.out.println( "KafkaConsumerShop :: received content shop ::  " + shopAvro  );

		VendorModel vendorModel = Utils.translateAvroToShopModel( shopAvro.value( ) ) ;

		DataStore store = null;
		try
		{
			store = MongoDataStore.getInstanceShop( );
			ObjectMapper objectMapper = new ObjectMapper( );
			String vendorModelAsString = objectMapper.writeValueAsString( vendorModel );
			store.storeRawEventShop( vendorModelAsString );
		}
		catch (Exception e)
		{
			LOG.error( "Error KafkaConsumerShop.processMessage() ", e );
			e.printStackTrace( );
		}
	}
}
