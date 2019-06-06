package br.com.hitbra.config;

import br.com.hitbra.marketplace.avro.orders.Order;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.apache.log4j.Logger.getLogger;

@EnableKafka
@Configuration
public class KafkaConsumerConfigTracking
{
	private static final Logger LOG = getLogger( KafkaConsumerConfigTracking.class.getName( ) );

	@Value( "${hmk.kafka.bootstrap-servers}" )
	private String bootstrapServer;

	@Value( "${hmk.consumer.group-id}" )
	private String groupId;

	@Value( "${hmk.kafka.schema.registry}")
	private String schemaRegistry ;

	@Value ( "${hmk.user.pwd.kafka}")
	private String userPwdKafka ;

	@Value ( "${hmk.truststore.location}")
	private String trustStoreLocation ;

	@Value ("${hmk.truststore.password}")
	private String certificatePwd ;

	@Value ( "${hmk.keystore.location}")
	private String keystoreLocation ;

	@Bean
	public Map<String, Object> consumerConfigs()
	{
		Map<String, Object> props = new HashMap<>();

		LOG.info( " :: Consumindo mensagens - Tracking ::" );
		System.out.println( " :: Consumindo mensagens - Tracking ::" ) ;

		props.put( ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer );
		props.put( ConsumerConfig.GROUP_ID_CONFIG, groupId );
		props.put( ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");

		props.put( ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName() );
		props.put( ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName() );

		props.put( ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 5000 );
		props.put( ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true );

		props.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistry ) ;
		props.put("avro.serializer.auto.register.schemas", false);

		props.put("basic.auth.credentials.source", "USER_INFO");
		props.put("basic.auth.user.info", userPwdKafka );

		props.put("security.protocol", "SSL");
		props.put("ssl.truststore.location", trustStoreLocation );
		props.put("ssl.truststore.password", certificatePwd );

		props.put("ssl.keystore.type", "PKCS12");
		props.put("ssl.keystore.location", keystoreLocation );
		props.put("ssl.keystore.password", certificatePwd );

		props.put("ssl.key.password", certificatePwd );

		props.put( KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true ) ;

		LOG.info( " :: KafkaConsumerConfigTracking.consumerConfigs() ::" );
		System.out.println( " :: KafkaConsumerConfigTracking.consumerConfigs() ::" );

		return props;
	}

	@Bean
	public ConsumerFactory<String, Order> consumerFactory()
	{
		return new DefaultKafkaConsumerFactory<>(consumerConfigs());
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Order> kafkaListenerContainerFactory()
	{
		ConcurrentKafkaListenerContainerFactory<String, Order> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
}