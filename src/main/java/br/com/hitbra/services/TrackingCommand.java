package br.com.hitbra.services;

import br.com.hitbra.model.TrackingModel;

public interface TrackingCommand
{
	void execute( TrackingModel model );
}
