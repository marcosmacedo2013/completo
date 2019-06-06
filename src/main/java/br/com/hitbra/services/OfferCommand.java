package br.com.hitbra.services;

import br.com.hitbra.model.OfferModel;

public interface OfferCommand
{
	void execute( OfferModel model );
}
