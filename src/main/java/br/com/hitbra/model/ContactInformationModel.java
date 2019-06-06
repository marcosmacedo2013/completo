package br.com.hitbra.model;

public class ContactInformationModel
{
	private String town ;
	private String country ;
	private String email ;
	private String fax ;
	private String firstName ;
	private String lastName ;
	private String phone1 ;
	private String phone2 ;
	private String region ;
	private String streetname ;
	private String complement ;
	private String url ;

	@Override public String toString( )
	{
		return " town " + town + " country " + country + " email " + email + " fax " + fax + " firstName " + firstName + " lastName " + lastName +
				" phone1 " + phone1 + " phone2 " + phone2 + " region " + region + " streetname " + streetname + " complement " + complement +
				" url " + url + " postalCode " + postalCode ;
	}

	private String postalCode ;

	public ContactInformationModel( String town, String country, String email, String fax,
			String firstName, String lastName, String phone1, String phone2, String region,
			String streetname, String complement, String url, String postalCode )
	{
		this.town = town;
		this.country = country;
		this.email = email;
		this.fax = fax;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.region = region;
		this.streetname = streetname;
		this.complement = complement;
		this.url = url;
		this.postalCode = postalCode;
	}

	public ContactInformationModel( )
	{
	}

	public String getTown( )
	{
		return town;
	}

	public void setTown( String town )
	{
		this.town = town;
	}

	public String getCountry( )
	{
		return country;
	}

	public void setCountry( String country )
	{
		this.country = country;
	}

	public String getEmail( )
	{
		return email;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}

	public String getFax( )
	{
		return fax;
	}

	public void setFax( String fax )
	{
		this.fax = fax;
	}

	public String getFirstName( )
	{
		return firstName;
	}

	public void setFirstName( String firstName )
	{
		this.firstName = firstName;
	}

	public String getLastName( )
	{
		return lastName;
	}

	public void setLastName( String lastName )
	{
		this.lastName = lastName;
	}

	public String getPhone1( )
	{
		return phone1;
	}

	public void setPhone1( String phone1 )
	{
		this.phone1 = phone1;
	}

	public String getPhone2( )
	{
		return phone2;
	}

	public void setPhone2( String phone2 )
	{
		this.phone2 = phone2;
	}

	public String getRegion( )
	{
		return region;
	}

	public void setRegion( String region )
	{
		this.region = region;
	}

	public String getStreetname( )
	{
		return streetname;
	}

	public void setStreetname( String streetname )
	{
		this.streetname = streetname;
	}

	public String getComplement( )
	{
		return complement;
	}

	public void setComplement( String complement )
	{
		this.complement = complement;
	}

	public String getUrl( )
	{
		return url;
	}

	public void setUrl( String url )
	{
		this.url = url;
	}

	public String getPostalCode( )
	{
		return postalCode;
	}

	public void setPostalCode( String postalCode )
	{
		this.postalCode = postalCode;
	}
}