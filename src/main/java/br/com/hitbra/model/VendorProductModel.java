package br.com.hitbra.model;

import java.util.List;

public class VendorProductModel
{
	private String companyUid;
	private String localeIso;
	private List<ProductModel> productList;

	public VendorProductModel( String companyUid, String localeIso, List<ProductModel> productList )
	{
		this.companyUid = companyUid;
		this.localeIso = localeIso;
		this.productList = productList;
	}

	public VendorProductModel( )
	{
	}

	public String getCompanyUid( )
	{
		return companyUid;
	}

	public void setCompanyUid( String companyUid )
	{
		this.companyUid = companyUid;
	}

	public String getLocaleIso( )
	{
		return localeIso;
	}

	public void setLocaleIso( String localeIso )
	{
		this.localeIso = localeIso;
	}

	public List<ProductModel> getProductList( )
	{
		return productList;
	}

	public void setProductList( List<ProductModel> productList )
	{
		this.productList = productList;
	}
}