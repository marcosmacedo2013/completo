package br.com.hitbra.model;

import java.util.Date;

public class ShopModel
{
	private long shop_id;

	private String shop_name;

	private String shop_state;

	private String logo;

	private String banner;

	private Date date_created;

	private String description;

	private Long evaluations_count;

	private Date last_updated_date;

	private Long offers_count;

	private String operator_internal_id;

	private Long order_messages_order_delay;

	private Long orders_count;

	private Boolean premium;

	private String return_policy;

	private String zip_code;

	private String contact_informations;

	public ShopModel( )
	{
	}

	public ShopModel( long shop_id, String shop_name, String shop_state, String logo, String banner,
			Date date_created, String description, Long evaluations_count, Date last_updated_date,
			Long offers_count, String operator_internal_id, Long order_messages_order_delay,
			Long orders_count, Boolean premium, String return_policy, String zip_code,
			String contact_informations )
	{
		this.shop_id = shop_id;
		this.shop_name = shop_name;
		this.shop_state = shop_state;
		this.logo = logo;
		this.banner = banner;
		this.date_created = date_created;
		this.description = description;
		this.evaluations_count = evaluations_count;
		this.last_updated_date = last_updated_date;
		this.offers_count = offers_count;
		this.operator_internal_id = operator_internal_id;
		this.order_messages_order_delay = order_messages_order_delay;
		this.orders_count = orders_count;
		this.premium = premium;
		this.return_policy = return_policy;
		this.zip_code = zip_code;
		this.contact_informations = contact_informations;
	}

	public long getShop_id( )
	{
		return this.shop_id;
	}

	public String getShop_name( )
	{
		return this.shop_name;
	}

	public String getShop_state( )
	{
		return shop_state;
	}

	public String getLogo( )
	{
		return logo;
	}

	public String getBanner( )
	{
		return banner;
	}

	public Date getDate_created( )
	{
		return date_created;
	}

	public String getDescription( )
	{
		return description;
	}

	public Long getEvaluations_count( )
	{
		return evaluations_count;
	}

	public Date getLast_updated_date( )
	{
		return last_updated_date;
	}

	public Long getOffers_count( )
	{
		return offers_count;
	}

	public String getOperator_internal_id( )
	{
		return operator_internal_id;
	}

	public Long getOrder_messages_order_delay( )
	{
		return order_messages_order_delay;
	}

	public Long getOrders_count( )
	{
		return orders_count;
	}

	public Boolean getPremium( )
	{
		return premium;
	}

	public String getReturn_policy( )
	{
		return return_policy;
	}

	public String getZip_code( )
	{
		return zip_code;
	}

	public String getContact_informations( )
	{
		return contact_informations;
	}

	@Override public String toString( )
	{
		String info = String.format("{ 'shop name': %s, 'shop id': %d}", shop_name, shop_id);
		return info ;
	}
}