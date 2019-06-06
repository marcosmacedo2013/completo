package br.com.hitbra.model;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.apache.log4j.LogManager.getLogger;

public class VendorModel extends Model
{
	private static final Logger LOG = getLogger( VendorModel.class.getName( ) );

	SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

	private String code;
	private String name;
	private boolean active;
	private String logoUrl;
	private String bannerUrl;
	private Date externalCreationDate;
	private int reviewCount;
	private Date externalUpdateDate;
	private int productQuantity;
	private String externalOperatorId;
	private String zipCode;
	private ContactInformationModel contactInformation;

	public String getCode( )
	{
		return code;
	}

	public void setCode( String code )
	{
		this.code = code;
	}

	public String getName( )
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public boolean isActive( )
	{
		return active;
	}

	public void setActive( Boolean active )
	{
		this.active = active;
	}

	public String getLogoUrl( )
	{
		return logoUrl;
	}

	public void setLogoUrl( String logoUrl )
	{
		this.logoUrl = logoUrl;
	}

	public String getBannerUrl( )
	{
		return bannerUrl;
	}

	public void setBannerUrl( String bannerUrl )
	{
		this.bannerUrl = bannerUrl;
	}

	public String getExternalCreationDate( )
	{
		try
		{
			return sdf.format( this.externalCreationDate );
		}
		catch (Exception e)
		{
			LOG.error( "Error VendorModel.getExternalCreationDate() ", e );
			return null;
		}
	}

	public void setExternalCreationDate( String externalCreationDate )
	{
		try
		{
			this.externalCreationDate =  sdf.parse( externalCreationDate );
		}
		catch (Exception e)
		{
			LOG.error( "Error VendorModel.setExternalCreationDate() ", e );
		}
	}

	public void setExternalCreationDate( Date externalCreationDate )
	{
		this.externalCreationDate = externalCreationDate ;
	}

	public int getReviewCount( )
	{
		return reviewCount;
	}

	public void setReviewCount( int reviewCount )
	{
		this.reviewCount = reviewCount;
	}

	public String getExternalUpdateDate( )
	{
		try
		{
			return sdf.format( this.externalUpdateDate );
		}
		catch (Exception e)
		{
			LOG.error( "Error VendorModel.getExternalUpdateDate() ", e );
			return null;
		}
	}

	public void setExternalUpdateDate( String externalUpdateDate )
	{
		try
		{
			this.externalUpdateDate =  sdf.parse( externalUpdateDate );
		}
		catch (Exception e)
		{
			LOG.error( "Error VendorModel.setExternalUpdateDate() ", e );
		}
	}

	public void setExternalUpdateDate( Date externalUpdateDate )
	{
		this.externalUpdateDate = externalUpdateDate ;
	}

	public int getProductQuantity( )
	{
		return productQuantity;
	}

	public void setProductQuantity( int productQuantity )
	{
		this.productQuantity = productQuantity;
	}

	public String getExternalOperatorId( )
	{
		return externalOperatorId;
	}

	public void setExternalOperatorId( String externalOperatorId )
	{
		this.externalOperatorId = externalOperatorId;
	}

	public String getZipCode( )
	{
		return zipCode;
	}

	public void setZipCode( String zipCode )
	{
		this.zipCode = zipCode;
	}

	public ContactInformationModel getContactInformation( )
	{
		return contactInformation;
	}

	@Override public String toString( )
	{
		return " code " + code + " name " + name + " active " + active + " logoUrl "
				+ logoUrl + " bannerUrl " + bannerUrl + " externalCreationDate "
				+ externalCreationDate + " reviewCount " + reviewCount + " externalUpdateDate "
				+ externalUpdateDate + " productQuantity " + productQuantity
				+ " externalOperatorId " + externalOperatorId + " zipCode " + zipCode
				+ " contactInformation " + contactInformation;
	}

	public void setContactInformation( ContactInformationModel contactInformation )
	{
		this.contactInformation = contactInformation;
	}

	public VendorModel( String code, String name, Boolean active, String logoUrl, String bannerUrl,
			Date externalCreationDate, int reviewCount, Date externalUpdateDate,
			int productQuantity, String externalOperatorId, String zipCode,
			ContactInformationModel contactInformation )
	{
		this.code = code;
		this.name = name;
		this.active = active;
		this.logoUrl = logoUrl;
		this.bannerUrl = bannerUrl;
		this.externalCreationDate = externalCreationDate;
		this.reviewCount = reviewCount;
		this.externalUpdateDate = externalUpdateDate;
		this.productQuantity = productQuantity;
		this.externalOperatorId = externalOperatorId;
		this.zipCode = zipCode;
		this.contactInformation = contactInformation;
	}

	public VendorModel( )
	{
	}
}