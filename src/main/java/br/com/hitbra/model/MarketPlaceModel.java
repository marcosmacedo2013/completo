package br.com.hitbra.model;

public class MarketPlaceModel
{
	private String code;
	private int height;
	private int width;
	private int length;
	private int weight;

	public MarketPlaceModel( String code, int height, int width, int length, int weight )
	{
		this.code = code;
		this.height = height;
		this.width = width;
		this.length = length;
		this.weight = weight;
	}

	public MarketPlaceModel( )
	{
	}

	public String getCode( )
	{
		return code;
	}

	public void setCode( String code )
	{
		this.code = code;
	}

	public int getHeight( )
	{
		return height;
	}

	public void setHeight( int height )
	{
		this.height = height;
	}

	public int getWidth( )
	{
		return width;
	}

	public void setWidth( int width )
	{
		this.width = width;
	}

	public int getLength( )
	{
		return length;
	}

	public void setLength( int length )
	{
		this.length = length;
	}

	public int getWeight( )
	{
		return weight;
	}

	public void setWeight( int weight )
	{
		this.weight = weight;
	}
}