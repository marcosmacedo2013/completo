package br.com.hitbra.model;

public class ProductModel
{
	private String id;
	private String name;
	private String summary;
	private String quotationName;
	private String externalImageUrl;
	private long lm;
	private MarketPlaceModel marketplace;

	public ProductModel( String id, String name, String summary, String quotationName,
			String externalImageUrl, long lm, MarketPlaceModel marketplace )
	{
		this.id = id;
		this.name = name;
		this.summary = summary;
		this.quotationName = quotationName;
		this.externalImageUrl = externalImageUrl;
		this.lm = lm;
		this.marketplace = marketplace;
	}

	public ProductModel( )
	{
	}

	public String getId( )
	{
		return id;
	}

	public void setId( String id )
	{
		this.id = id;
	}

	public String getName( )
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public String getSummary( )
	{
		return summary;
	}

	public void setSummary( String summary )
	{
		this.summary = summary;
	}

	public String getQuotationName( )
	{
		return quotationName;
	}

	public void setQuotationName( String quotationName )
	{
		this.quotationName = quotationName;
	}

	public String getExternalImageUrl( )
	{
		return externalImageUrl;
	}

	public void setExternalImageUrl( String externalImageUrl )
	{
		this.externalImageUrl = externalImageUrl;
	}

	public long getLm( )
	{
		return lm;
	}

	public void setLm( long lm )
	{
		this.lm = lm;
	}

	public MarketPlaceModel getMarketplace( )
	{
		return marketplace;
	}

	public void setMarketplace( MarketPlaceModel marketplace )
	{
		this.marketplace = marketplace;
	}
}