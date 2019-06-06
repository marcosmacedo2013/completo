package br.com.hitbra.model;

public class OfferModel extends Model
{
	private int offer;
	private String product;
	private String vendor;
	private String shopSKU ;
	private StockModel stock;
	private PriceModel price;
	private PriceModel specialPrice;
	private boolean active;
	private boolean delete;

	public OfferModel( int offer, String product, String vendor, String shopSKU, StockModel stock, PriceModel price,
			PriceModel specialPrice )
	{
		this.offer = offer;
		this.product = product;
		this.vendor = vendor;
		this.shopSKU = shopSKU ;
		this.stock = stock;
		this.price = price;
		this.specialPrice = specialPrice;
	}

	public OfferModel( )
	{
	}

	public boolean isActive( )
	{
		return active;
	}

	public void setActive( boolean active )
	{
		this.active = active;
	}

	public boolean isDelete( )
	{
		return delete;
	}

	public void setDelete( boolean delete )
	{
		this.delete = delete;
	}

	public int getOffer( )
	{
		return offer;
	}

	public void setOffer( int offer )
	{
		this.offer = offer;
	}

	public String getProduct( )
	{
		return product;
	}

	public void setProduct( String product )
	{
		this.product = product;
	}

	public String getVendor( )
	{
		return vendor;
	}

	public void setVendor( String vendor )
	{
		this.vendor = vendor;
	}

	public StockModel getStock( )
	{
		return stock;
	}

	public void setStock( StockModel stock )
	{
		this.stock = stock;
	}

	public PriceModel getPrice( )
	{
		return price;
	}

	public void setPrice( PriceModel price )
	{
		this.price = price;
	}

	public PriceModel getSpecialPrice( )
	{
		return specialPrice;
	}

	public void setSpecialPrice( PriceModel specialPrice )
	{
		this.specialPrice = specialPrice;
	}

	public String getShopSKU( )
	{
		return shopSKU;
	}

	public void setShopSKU( String shopSKU )
	{
		this.shopSKU = shopSKU;
	}
}