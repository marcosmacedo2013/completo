package br.com.hitbra.model;

import org.apache.log4j.Logger;

import java.util.List;

import static org.apache.log4j.LogManager.getLogger;

public class TrackingModel extends Model
{
	private static final Logger LOG = getLogger( TrackingModel.class.getName( ) );

	String commercial_id;
	String order_id;
	String order_state;
	long shop_id;
	String shipping_carrier_code;
	String shipping_company;
	String shipping_tracking;
	String shipping_tracking_url;
	String delivery_date;
	String invoice_access_key;
	String invoice_date;
	String invoice_line;
	String invoice_number;

	List<OrderLineModel> order_lines;

	public String getCommercial_id( )
	{
		return commercial_id;
	}

	public void setCommercial_id( String commercial_id )
	{
		this.commercial_id = commercial_id;
	}

	public String getOrder_id( )
	{
		return order_id;
	}

	public void setOrder_id( String order_id )
	{
		this.order_id = order_id;
	}

	public String getOrder_state( )
	{
		return order_state;
	}

	public void setOrder_state( String order_state )
	{
		this.order_state = order_state;
	}

	public long getShop_id( )
	{
		return shop_id;
	}

	public void setShop_id( long shop_id )
	{
		this.shop_id = shop_id;
	}

	public String getShipping_carrier_code( )
	{
		return shipping_carrier_code;
	}

	public void setShipping_carrier_code( String shipping_carrier_code )
	{
		this.shipping_carrier_code = shipping_carrier_code;
	}

	public String getShipping_company( )
	{
		return shipping_company;
	}

	public void setShipping_company( String shipping_company )
	{
		this.shipping_company = shipping_company;
	}

	public String getShipping_tracking( )
	{
		return shipping_tracking;
	}

	public void setShipping_tracking( String shipping_tracking )
	{
		this.shipping_tracking = shipping_tracking;
	}

	public String getShipping_tracking_url( )
	{
		return shipping_tracking_url;
	}

	public void setShipping_tracking_url( String shipping_tracking_url )
	{
		this.shipping_tracking_url = shipping_tracking_url;
	}

	public String getDelivery_date( )
	{
		return delivery_date;
	}

	public void setDelivery_date( String delivery_date )
	{
		this.delivery_date = delivery_date;
	}

	public String getInvoice_access_key( )
	{
		return invoice_access_key;
	}

	public void setInvoice_access_key( String invoice_access_key )
	{
		this.invoice_access_key = invoice_access_key;
	}

	public String getInvoice_date( )
	{
		return invoice_date;
	}

	public void setInvoice_date( String invoice_date )
	{
		this.invoice_date = invoice_date;
	}

	public String getInvoice_line( )
	{
		return invoice_line;
	}

	public void setInvoice_line( String invoice_line )
	{
		this.invoice_line = invoice_line;
	}

	public String getInvoice_number( )
	{
		return invoice_number;
	}

	public void setInvoice_number( String invoice_number )
	{
		this.invoice_number = invoice_number;
	}

	public List<OrderLineModel> getOrder_lines( )
	{
		return order_lines;
	}

	public void setOrder_lines( List<OrderLineModel> order_lines )
	{
		this.order_lines = order_lines;
	}

	public TrackingModel( )
	{
	}

	public TrackingModel(  String commercial_id, String order_id, String order_state, long shop_id,
			String shipping_carrier_code, String shipping_company, String shipping_tracking,
			String shipping_tracking_url, String delivery_date, String invoice_access_key,
			String invoice_date, String invoice_line, String invoice_number, List<OrderLineModel> order_lines )
	{
		this.commercial_id = commercial_id ;
		this.order_id = order_id ;
		this.order_state = order_state ;
		this.shop_id = shop_id ;
		this.shipping_carrier_code = shipping_carrier_code ;
		this.shipping_company = shipping_company ;
		this.shipping_tracking = shipping_tracking ;
		this.shipping_tracking_url = shipping_tracking_url ;
		this.delivery_date = delivery_date ;
		this.invoice_access_key = invoice_access_key ;
		this.invoice_date = invoice_date ;
		this.invoice_line = invoice_line ;
		this.invoice_number = invoice_number ;
		this.order_lines = order_lines ;
	}
}