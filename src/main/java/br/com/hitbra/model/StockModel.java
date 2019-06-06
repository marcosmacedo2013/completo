package br.com.hitbra.model;

public class StockModel
{
	private long value;

	public StockModel( long value )
	{
		this.value = value;
	}

	public StockModel( )
	{
	}

	public long getValue( )
	{
		return value;
	}

	public void setValue( long value )
	{
		this.value = value;
	}
}