package br.com.hitbra.model;

public class OrderLineModel
{
	String order_line_id;
	String order_line_state;
	String product_sku;
	long offer_id;
	String offer_sku;
	int quantity;
	String received_date;
	String shipped_date;

	public String getOrder_line_id( )
	{
		return order_line_id;
	}

	public void setOrder_line_id( String order_line_id )
	{
		this.order_line_id = order_line_id;
	}

	public String getOrder_line_state( )
	{
		return order_line_state;
	}

	public void setOrder_line_state( String order_line_state )
	{
		this.order_line_state = order_line_state;
	}

	public String getProduct_sku( )
	{
		return product_sku;
	}

	public void setProduct_sku( String product_sku )
	{
		this.product_sku = product_sku;
	}

	public long getOffer_id( )
	{
		return offer_id;
	}

	public void setOffer_id( long offer_id )
	{
		this.offer_id = offer_id;
	}

	public String getOffer_sku( )
	{
		return offer_sku;
	}

	public void setOffer_sku( String offer_sku )
	{
		this.offer_sku = offer_sku;
	}

	public int getQuantity( )
	{
		return quantity;
	}

	public void setQuantity( int quantity )
	{
		this.quantity = quantity;
	}

	public String getReceived_date( )
	{
		return received_date;
	}

	public void setReceived_date( String received_date )
	{
		this.received_date = received_date;
	}

	public String getShipped_date( )
	{
		return shipped_date;
	}

	public void setShipped_date( String shipped_date )
	{
		this.shipped_date = shipped_date;
	}

	public OrderLineModel( )
	{

	}

	public OrderLineModel( String order_line_id, String order_line_state, String product_sku,
			long offer_id, String offer_sku, int quantity, String received_date, String shipped_date )
	{
		this.order_line_id = order_line_id ;
		this.order_line_state = order_line_state ;
		this.product_sku = product_sku ;
		this.offer_id = offer_id ;
		this.offer_sku = offer_sku ;
		this.quantity = quantity ;
		this.received_date = received_date ;
		this.shipped_date = shipped_date ;
	}
}