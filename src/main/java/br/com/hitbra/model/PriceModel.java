package br.com.hitbra.model;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.apache.log4j.LogManager.getLogger;

public class PriceModel
{
	private static final Logger LOG = getLogger( PriceModel.class.getName( ) );

	SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );

	private BigDecimal value;
	private Date startDate;
	private Date endDate;

	public BigDecimal getValue( )
	{
		return value;
	}

	public void setValue( BigDecimal value )
	{
		this.value = value;
	}

	public String getStartDate( )
	{
		try
		{
			return sdf.format( this.startDate );
		}
		catch (Exception e)
		{
			LOG.error( "Error PriceModel.getStartDate() ", e );
			return null;
		}
	}

	public void setStartDate( Date startDate )
	{
		this.startDate = startDate;
	}

	public String getEndDate( )
	{
		try
		{
			return sdf.format( this.endDate );
		}
		catch( Exception e )
		{
			LOG.error( "Error PriceModel.getEndDate() ", e );
			return null;
		}
	}

	public void setEndDate( Date endDate )
	{
		this.endDate = endDate;
	}

	public PriceModel( BigDecimal value, Date startDate, Date endDate )
	{
		this.value = value;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public PriceModel( )
	{
	}
}
