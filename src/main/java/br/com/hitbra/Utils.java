package br.com.hitbra;

import br.com.hitbra.marketplace.avro.offers.Offer;
import br.com.hitbra.marketplace.avro.orders.Order;
import br.com.hitbra.marketplace.avro.orders.OrderLine;
import br.com.hitbra.model.*;
import io.confluent.ksql.avro_schemas.KsqlDataSourceSchema;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.log4j.Logger.getLogger;

public class Utils
{
	private static final Logger LOG = getLogger( Utils.class.getName( ) );

	public static OfferModel translateAvroToOfferModel( Offer avro )
	{
		System.out.println(
				" ::: Utils.translateAvroToOfferModel ::: " + avro.getOfferId( ).toString( ) + "|"
						+ avro.getProductSku( ).toString( ) );

		OfferModel offer = new OfferModel( );

		offer.setOffer( avro.getOfferId( ).intValue( ) );

		if (avro.getProductSku( ) != null
				&& avro.getProductSku( ).toString( ).trim( ).length( ) > 0)
		{
			offer.setProduct( avro.getProductSku( ).toString( ) );
		}
		if (avro.getShopId( ) != null && avro.getShopId( ).toString( ).trim( ).length( ) > 0)
		{
			offer.setVendor( avro.getShopId( ).toString( ) );
		}

		if (avro.getShopSku( ) != null
				&& avro.getShopSku( ).toString( ).trim( ).length( ) > 0)
		{
			offer.setShopSKU( avro.getShopSku( ).toString( ) );
		}

		StockModel stock = new StockModel( );
		if (avro.getQuantity( ) != null && avro.getQuantity( ).toString( ).trim( ).length( ) > 0)
		{
			stock.setValue( avro.getQuantity( ) );
		}

		offer.setStock( stock );

		PriceModel price = new PriceModel( );

		if (( avro.getAvailableStartDate( ) != null
				&& avro.getAvailableStartDate( ).toString( ).trim( ).length( ) > 0 ) && ( !avro
				.getAvailableStartDate( ).toString( ).equalsIgnoreCase( "null" ) ))
		{
			price.setStartDate( new Date(
					new Long( avro.getAvailableStartDate( ).toString( ) ).longValue( ) ) );
		}
		if (( avro.getAvailableEndDate( ) != null
				&& avro.getAvailableEndDate( ).toString( ).trim( ).length( ) > 0 ) && ( !avro
				.getAvailableEndDate( ).toString( ).equalsIgnoreCase( "null" ) ))
		{
			price.setEndDate(
					new Date( new Long( avro.getAvailableEndDate( ).toString( ) ).longValue( ) ) );
		}
		// originPrice
		if (avro.getOriginPrice( ) == null)
		{
			{
				price.setValue( new BigDecimal(
						avro.getPrice( ).getPrecision( ) + "." + avro.getPrice( ).getScale( )
								.intValue( ) ) );
			}
		}
		else
		{
			if (avro.getOriginPrice( ) != null && avro.getOriginPrice( ).getPrecision( ) != null
					&& ( avro.getOriginPrice( ).getPrecision( ).toString( ).trim( ).length( ) > 0 ))
			{
				price.setValue( new BigDecimal(
						avro.getOriginPrice( ).getPrecision( ) + "." + avro.getOriginPrice( )
								.getScale( ).intValue( ) ) );
			}
		}
		offer.setPrice( price );

		PriceModel specialPrice = new PriceModel( );
		if (( avro.getDiscountStartDate( ) != null
				&& avro.getDiscountStartDate( ).toString( ).trim( ).length( ) > 0 ) && ( !avro
				.getDiscountStartDate( ).toString( ).equalsIgnoreCase( "null" ) ))
		{
			specialPrice.setStartDate(
					new Date( new Long( avro.getDiscountStartDate( ).toString( ) ).longValue( ) ) );
		}
		if (( avro.getDiscountEndDate( ) != null
				&& avro.getDiscountEndDate( ).toString( ).trim( ).length( ) > 0 ) && ( !avro
				.getDiscountEndDate( ).toString( ).equalsIgnoreCase( "null" ) ))
		{
			specialPrice.setEndDate(
					new Date( new Long( avro.getDiscountEndDate( ).toString( ) ).longValue( ) ) );
		}
		if (avro.getPrice( ).getPrecision( ) != null && (
				avro.getPrice( ).getPrecision( ).toString( ).trim( ).length( ) > 0 ))
		{
			specialPrice.setValue( new BigDecimal(
					avro.getPrice( ).getPrecision( ) + "." + avro.getPrice( ).getScale( )
							.intValue( ) ) );
		}
		offer.setSpecialPrice( specialPrice );

		offer.setActive( avro.getActive( ).booleanValue( ) );
		offer.setDelete( avro.getDeleted( ).booleanValue( ) );

		return offer;
	}

	public static VendorModel translateAvroToShopModel( KsqlDataSourceSchema avro )
	{
		System.out.println(
				" ::: Utils.translateAvroToShopModel ::: " + avro.getSHOPID( ).toString( ) + "|"
						+ avro.getSHOPNAME( ).toString( ) );
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		VendorModel vendor = new VendorModel( );

		try
		{
			vendor.setCode( avro.getSHOPID( ).toString( ) );
			vendor.setName( avro.getSHOPNAME( ).toString( ) );

			if (( avro.getSHOPSTATE( ).toString( ).equalsIgnoreCase( "CLOSE" ) ) || ( avro
					.getSHOPSTATE( ).toString( ).equalsIgnoreCase( "SUSPENDED" ) ))
			{
				vendor.setActive( false );
			}
			else
			{
				vendor.setActive( true );
			}
			if (avro.getLOGO( ) != null && avro.getLOGO( ).toString( ).trim( ).length( ) > 0)
			{
				vendor.setLogoUrl( avro.getLOGO( ).toString( ) );
			}
			if (avro.getBANNER( ) != null && avro.getBANNER( ).toString( ).trim( ).length( ) > 0)
			{
				vendor.setBannerUrl( avro.getBANNER( ).toString( ) );
			}
			if (avro.getDATECREATED( ) != null
					&& avro.getDATECREATED( ).toString( ).trim( ).length( ) > 0)
			{
				vendor.setExternalCreationDate(
						new Date( new Long( avro.getDATECREATED( ).toString( ) ).longValue( ) ) );
			}
			if (avro.getEVALUATIONSCOUNT( ) != null
					&& avro.getEVALUATIONSCOUNT( ).toString( ).trim( ).length( ) > 0)
			{
				vendor.setReviewCount( avro.getEVALUATIONSCOUNT( ).intValue( ) );
			}
			if (avro.getLASTUPDATEDDATE( ) != null
					&& avro.getLASTUPDATEDDATE( ).toString( ).trim( ).length( ) > 0)
			{
				vendor.setExternalUpdateDate( new Date(
						new Long( avro.getLASTUPDATEDDATE( ).toString( ) ).longValue( ) ) );
			}
			if (avro.getOFFERSCOUNT( ) != null
					&& avro.getOFFERSCOUNT( ).toString( ).trim( ).length( ) > 0)
			{
				vendor.setProductQuantity( avro.getOFFERSCOUNT( ).intValue( ) );
			}
			if (avro.getOPERATORINTERNALID( ) != null
					&& avro.getOPERATORINTERNALID( ).toString( ).trim( ).length( ) > 0)
			{
				vendor.setExternalOperatorId( avro.getOPERATORINTERNALID( ).toString( ) );
			}

			if (avro.getCONTACTINFORMATIONS( ).getZIPCODE( ) != null
					&& avro.getCONTACTINFORMATIONS( ).getZIPCODE( ).toString( ).trim( ).length( )
					> 0)
			{
				vendor.setZipCode( avro.getCONTACTINFORMATIONS( ).getZIPCODE( ).toString( ) );
			}

			ContactInformationModel contact = new ContactInformationModel( );

			if (avro.getCONTACTINFORMATIONS( ) != null)
			{
				if (avro.getCONTACTINFORMATIONS( ).getCITY( ) != null
						&& avro.getCONTACTINFORMATIONS( ).getCITY( ).toString( ).trim( ).length( )
						> 0)
				{
					contact.setTown( avro.getCONTACTINFORMATIONS( ).getCITY( ).toString( ) );
				}
				if (avro.getCONTACTINFORMATIONS( ).getCOUNTRY( ) != null &&
						avro.getCONTACTINFORMATIONS( ).getCOUNTRY( ).toString( ).trim( ).length( )
								> 0)
				{
					contact.setCountry( avro.getCONTACTINFORMATIONS( ).getCOUNTRY( ).toString( )
							.substring( 0, 2 ) );
				}
				if (avro.getCONTACTINFORMATIONS( ).getEMAIL( ) != null
						&& avro.getCONTACTINFORMATIONS( ).getEMAIL( ).toString( ).trim( ).length( )
						> 0)
				{
					contact.setEmail( avro.getCONTACTINFORMATIONS( ).getEMAIL( ).toString( ) );
				}
				if (avro.getCONTACTINFORMATIONS( ).getFAX( ) != null
						&& avro.getCONTACTINFORMATIONS( ).getFAX( ).toString( ).trim( ).length( )
						> 0)
				{
					contact.setFax( avro.getCONTACTINFORMATIONS( ).getFAX( ).toString( ) );
				}
				if (avro.getCONTACTINFORMATIONS( ).getFIRSTNAME( ) != null &&
						avro.getCONTACTINFORMATIONS( ).getFIRSTNAME( ).toString( ).trim( ).length( )
								> 0)
				{
					contact.setFirstName(
							avro.getCONTACTINFORMATIONS( ).getFIRSTNAME( ).toString( ) );
				}
				if (avro.getCONTACTINFORMATIONS( ).getLASTNAME( ) != null &&
						avro.getCONTACTINFORMATIONS( ).getLASTNAME( ).toString( ).trim( ).length( )
								> 0)
				{
					contact.setLastName(
							avro.getCONTACTINFORMATIONS( ).getLASTNAME( ).toString( ) );
				}
				if (avro.getCONTACTINFORMATIONS( ).getPHONE( ) != null
						&& avro.getCONTACTINFORMATIONS( ).getPHONE( ).toString( ).trim( ).length( )
						> 0)
				{
					contact.setPhone1( avro.getCONTACTINFORMATIONS( ).getPHONE( ).toString( ) );
				}
				if (avro.getCONTACTINFORMATIONS( ).getPHONESECONDARY( ) != null &&
						avro.getCONTACTINFORMATIONS( ).getPHONESECONDARY( ).toString( ).trim( )
								.length( ) > 0)
				{
					contact.setPhone2(
							avro.getCONTACTINFORMATIONS( ).getPHONESECONDARY( ).toString( ) );
				}
				if (avro.getCONTACTINFORMATIONS( ).getSTATE( ) != null
						&& avro.getCONTACTINFORMATIONS( ).getSTATE( ).toString( ).trim( ).length( )
						> 0)
				{
					contact.setRegion(
							avro.getCONTACTINFORMATIONS( ).getSTATE( ).toString( ).toUpperCase( ) );
				}
				if (avro.getCONTACTINFORMATIONS( ).getSTREET1( ) != null &&
						avro.getCONTACTINFORMATIONS( ).getSTREET1( ).toString( ).trim( ).length( )
								> 0)
				{
					contact.setStreetname(
							avro.getCONTACTINFORMATIONS( ).getSTREET1( ).toString( ) );
				}
				if (avro.getCONTACTINFORMATIONS( ).getSTREET2( ) != null &&
						avro.getCONTACTINFORMATIONS( ).getSTREET2( ).toString( ).trim( ).length( )
								> 0)
				{
					contact.setComplement(
							avro.getCONTACTINFORMATIONS( ).getSTREET2( ).toString( ) );
				}
				if (avro.getCONTACTINFORMATIONS( ).getWEBSITE( ) != null &&
						avro.getCONTACTINFORMATIONS( ).getWEBSITE( ).toString( ).trim( ).length( )
								> 0)
				{
					contact.setUrl( avro.getCONTACTINFORMATIONS( ).getWEBSITE( ).toString( ) );
				}
				if (avro.getCONTACTINFORMATIONS( ).getZIPCODE( ) != null &&
						avro.getCONTACTINFORMATIONS( ).getZIPCODE( ).toString( ).trim( ).length( )
								> 0)
				{
					contact.setPostalCode(
							avro.getCONTACTINFORMATIONS( ).getZIPCODE( ).toString( ) );
				}
			}
			vendor.setContactInformation( contact );

			return vendor;
		}
		catch (Exception e)
		{
			LOG.error( " Exception :: Utils.translateAvroToShopModel", e );
			e.printStackTrace( );
		}
		return vendor;
	}

	public static TrackingModel translateAvroToTrackingModel( Order avro )
	{
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" ) ;

		System.out.println(
				" ::: Utils.translateAvroToTrackingModel ::: " + avro.getOrderId( ).toString( )
						+ "|" + avro.getOrderState( ).toString( ) );

		TrackingModel tracking = new TrackingModel( );

		if (( avro.getCommercialId( ) != null ) && (
				avro.getCommercialId( ).toString( ).trim( ).length( ) > 0 ))
		{
			tracking.setCommercial_id( avro.getCommercialId( ).toString( ) );
		}
		if (( avro.getOrderId( ) != null ) && ( avro.getOrderId( ).toString( ).trim( ).length( )
				> 0 ))
		{
			tracking.setOrder_id( avro.getOrderId( ).toString( ) );
		}
		if (( avro.getOrderState( ) != null ) && (
				avro.getOrderState( ).toString( ).trim( ).length( ) > 0 ))
		{
			tracking.setOrder_state( avro.getOrderState( ).toString( ) );
		}
		if (( avro.getShopId( ) != null ) && ( avro.getShopId( ).toString( ).trim( ).length( )
				> 0 ))
		{
			tracking.setShop_id( avro.getShopId( ) );
		}
		if (( avro.getShippingCarrierCode( ) != null ) && (
				avro.getShippingCarrierCode( ).toString( ).trim( ).length( ) > 0 ))
		{
			tracking.setShipping_carrier_code( avro.getShippingCarrierCode( ).toString( ) );
		}
		if (( avro.getShippingCompany( ) != null ) && (
				avro.getShippingCompany( ).toString( ).trim( ).length( ) > 0 ))
		{
			tracking.setShipping_company( avro.getShippingCompany( ).toString( ) );
		}
		if (( avro.getShippingTracking( ) != null ) && (
				avro.getShippingTracking( ).toString( ).trim( ).length( ) > 0 ))
		{
			tracking.setShipping_tracking( avro.getShippingTracking( ).toString( ) );
		}
		if (( avro.getShippingTrackingUrl( ) != null ) && (
				avro.getShippingTrackingUrl( ).toString( ).trim( ).length( ) > 0 ))
		{
			tracking.setShipping_tracking_url( avro.getShippingTrackingUrl( ).toString( ) );
		}
		if (( avro.getDeliveryDate( ) != null ) && (
				avro.getDeliveryDate( ).toString( ).trim( ).length( ) > 0 ))
		{
			Date data = new Date( new Long( avro.getDeliveryDate( ).toString( ) ).longValue( ) ) ;
			tracking.setDelivery_date( sdf.format(  data  ) );
		}
		if (( avro.getInvoiceAccessKey( ) != null ) && (
				avro.getInvoiceAccessKey( ).toString( ).trim( ).length( ) > 0 ))
		{
			tracking.setInvoice_access_key( avro.getInvoiceAccessKey( ).toString( ) );
		}
		if (( avro.getInvoiceDate( ) != null ) && (
				avro.getInvoiceDate( ).toString( ).trim( ).length( ) > 0 ))
		{
			Date data = new Date( new Long( avro.getInvoiceDate( ).toString( ) ).longValue( ) ) ;
			tracking.setInvoice_date( sdf.format(  data  ) );
		}
		if (( avro.getInvoiceLine( ) != null ) && (
				avro.getInvoiceLine( ).toString( ).trim( ).length( ) > 0 ))
		{
			tracking.setInvoice_line( avro.getInvoiceLine( ).toString( ) );
		}
		if (( avro.getInvoiceNumber( ) != null ) && (
				avro.getInvoiceNumber( ).toString( ).trim( ).length( ) > 0 ))
		{
			tracking.setInvoice_number( avro.getInvoiceNumber( ).toString( ) );
		}


		if ( ( avro.getOrderLines() != null ) && ( avro.getOrderLines().size() > 0 ) )
		{
			List<OrderLineModel> orderLines = new ArrayList<OrderLineModel>( ) ;
			for ( int i = 0 ; i < avro.getOrderLines().size() ; i ++ )
			{
				OrderLineModel orderLine = new OrderLineModel( );

				OrderLine orderLineAvro = avro.getOrderLines( ).get( i ) ;

				if (( orderLineAvro.getOrderLineId( ) != null ) && (
						orderLineAvro.getOrderLineId( ).toString( ).trim( ).length( ) > 0 ))
				{
					orderLine.setOrder_line_id( orderLineAvro.getOrderLineId( ).toString( ) );
				}
				if (( orderLineAvro.getOrderLineState( ) != null ) && (
						orderLineAvro.getOrderLineState( ).toString( ).trim( ).length( ) > 0 ))
				{
					orderLine.setOrder_line_state( orderLineAvro.getOrderLineState( ).toString( ) );
				}
				if (( orderLineAvro.getProductSku( ) != null ) && (
						orderLineAvro.getProductSku( ).toString( ).trim( ).length( ) > 0 ))
				{
					orderLine.setProduct_sku( orderLineAvro.getProductSku( ).toString( ) );
				}
				if (( orderLineAvro.getOfferId( ) != null ) && (
						orderLineAvro.getOfferId( ).toString( ).trim( ).length( ) > 0 ))
				{
					orderLine.setOffer_id( orderLineAvro.getOfferId( ) );
				}
				if (( orderLineAvro.getOfferSku( ) != null ) && (
						orderLineAvro.getOfferSku( ).toString( ).trim( ).length( ) > 0 ))
				{
					orderLine.setOffer_sku( orderLineAvro.getOfferSku( ).toString( ) );
				}
				if (( orderLineAvro.getQuantity( ) != null ) && (
						orderLineAvro.getQuantity( ).toString( ).trim( ).length( ) > 0 ))
				{
					orderLine.setQuantity( orderLineAvro.getQuantity( ) );
				}
				if (( orderLineAvro.getReceivedDate( ) != null ) && (
						orderLineAvro.getReceivedDate( ).toString( ).trim( ).length( ) > 0 ))
				{
					Date data = new Date( new Long( orderLineAvro.getReceivedDate( ).toString( ) ).longValue( ) ) ;
					orderLine.setReceived_date( sdf.format(  data  ) );
				}
				if (( orderLineAvro.getShippedDate( ) != null ) && (
						orderLineAvro.getShippedDate( ).toString( ).trim( ).length( ) > 0 ))
				{
					Date data = new Date( new Long( orderLineAvro.getShippedDate( ).toString( ) ).longValue( ) ) ;
					orderLine.setShipped_date( sdf.format(  data  ) );
				}
				orderLines.add( orderLine ) ;
			}
			tracking.setOrder_lines( orderLines );
		}
		return tracking;
	}
}
