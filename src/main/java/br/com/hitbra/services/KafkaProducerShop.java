package br.com.hitbra.services;

import br.com.hitbra.model.VendorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerShop
{
	@Autowired
	private KafkaTemplate<String, VendorModel> kafkaTemplateShop;

	@Value( "${hmk.topic.shop}" )
	String kafkaTopic = "poc.marketplace.hybris_shop";

	public void send( VendorModel vendor )
	{
		try
		{
			System.out.println( kafkaTopic + " -> sending data= " + vendor );
			kafkaTemplateShop.send( kafkaTopic, vendor );
			System.out.println( " -> enviado para kafka " );
		}
		catch( Exception e )
		{
			System.out.println( " erro no sending " + e.getMessage() ) ;
			System.out.println( " data= " + vendor );

			e.printStackTrace();
		}
	}
}