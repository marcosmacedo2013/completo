package br.com.hitbra.services;

import br.com.hitbra.model.OfferModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerOffer
{
	@Autowired
	private KafkaTemplate<String, OfferModel> kafkaTemplateOffer;

	@Value( "${hmk.topic.offer}" )
	String kafkaTopic = "poc.marketplace.hybris_offer";

	public void send( OfferModel offer )
	{
		try
		{
			System.out.println( kafkaTopic + " -> sending data - offer " + offer );
			kafkaTemplateOffer.send( kafkaTopic, offer );
			System.out.println( " -> enviado para kafka offers " );
		}
		catch( Exception e )
		{
			System.out.println( " erro no sending - offer " + e.getMessage() ) ;
			System.out.println( " data= " + offer );

			e.printStackTrace();
		}
	}
}