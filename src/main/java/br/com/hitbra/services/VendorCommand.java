package br.com.hitbra.services;

import br.com.hitbra.model.VendorModel;

public interface VendorCommand
{
	void execute( VendorModel model );
}
