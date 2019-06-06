package br.com.hitbra.model;

public class BatchOfferModel
{
	private int number;
	private OfferModel request;

	public BatchOfferModel( int number, OfferModel request )
	{
		this.number = number;
		this.request = request;
	}

	public BatchOfferModel( )
	{
	}

	public int getNumber( )
	{
		return number;
	}

	public void setNumber( int number )
	{
		this.number = number;
	}

	public OfferModel getRequest( )
	{
		return request;
	}

	public void setRequest( OfferModel request )
	{
		this.request = request;
	}
}