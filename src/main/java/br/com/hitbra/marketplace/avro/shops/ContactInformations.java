/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package br.com.hitbra.marketplace.avro.shops;
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ContactInformations extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ContactInformations\",\"namespace\":\"br.com.hitbra.marketplace.avro.shops\",\"fields\":[{\"name\":\"city\",\"type\":\"string\"},{\"name\":\"civility\",\"type\":[\"string\",\"null\"]},{\"name\":\"country\",\"type\":\"string\"},{\"name\":\"email\",\"type\":\"string\"},{\"name\":\"fax\",\"type\":[\"string\",\"null\"]},{\"name\":\"firstname\",\"type\":[\"string\",\"null\"]},{\"name\":\"lastname\",\"type\":\"string\"},{\"name\":\"phone\",\"type\":[\"string\",\"null\"]},{\"name\":\"phone_secondary\",\"type\":[\"string\",\"null\"]},{\"name\":\"state\",\"type\":[\"string\",\"null\"]},{\"name\":\"street1\",\"type\":\"string\"},{\"name\":\"street2\",\"type\":[\"string\",\"null\"]},{\"name\":\"web_site\",\"type\":[\"string\",\"null\"]},{\"name\":\"zip_code\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence city;
  @Deprecated public java.lang.CharSequence civility;
  @Deprecated public java.lang.CharSequence country;
  @Deprecated public java.lang.CharSequence email;
  @Deprecated public java.lang.CharSequence fax;
  @Deprecated public java.lang.CharSequence firstname;
  @Deprecated public java.lang.CharSequence lastname;
  @Deprecated public java.lang.CharSequence phone;
  @Deprecated public java.lang.CharSequence phone_secondary;
  @Deprecated public java.lang.CharSequence state;
  @Deprecated public java.lang.CharSequence street1;
  @Deprecated public java.lang.CharSequence street2;
  @Deprecated public java.lang.CharSequence web_site;
  @Deprecated public java.lang.CharSequence zip_code;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public ContactInformations() {}

  /**
   * All-args constructor.
   */
  public ContactInformations(java.lang.CharSequence city, java.lang.CharSequence civility, java.lang.CharSequence country, java.lang.CharSequence email, java.lang.CharSequence fax, java.lang.CharSequence firstname, java.lang.CharSequence lastname, java.lang.CharSequence phone, java.lang.CharSequence phone_secondary, java.lang.CharSequence state, java.lang.CharSequence street1, java.lang.CharSequence street2, java.lang.CharSequence web_site, java.lang.CharSequence zip_code) {
    this.city = city;
    this.civility = civility;
    this.country = country;
    this.email = email;
    this.fax = fax;
    this.firstname = firstname;
    this.lastname = lastname;
    this.phone = phone;
    this.phone_secondary = phone_secondary;
    this.state = state;
    this.street1 = street1;
    this.street2 = street2;
    this.web_site = web_site;
    this.zip_code = zip_code;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return city;
    case 1: return civility;
    case 2: return country;
    case 3: return email;
    case 4: return fax;
    case 5: return firstname;
    case 6: return lastname;
    case 7: return phone;
    case 8: return phone_secondary;
    case 9: return state;
    case 10: return street1;
    case 11: return street2;
    case 12: return web_site;
    case 13: return zip_code;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: city = (java.lang.CharSequence)value$; break;
    case 1: civility = (java.lang.CharSequence)value$; break;
    case 2: country = (java.lang.CharSequence)value$; break;
    case 3: email = (java.lang.CharSequence)value$; break;
    case 4: fax = (java.lang.CharSequence)value$; break;
    case 5: firstname = (java.lang.CharSequence)value$; break;
    case 6: lastname = (java.lang.CharSequence)value$; break;
    case 7: phone = (java.lang.CharSequence)value$; break;
    case 8: phone_secondary = (java.lang.CharSequence)value$; break;
    case 9: state = (java.lang.CharSequence)value$; break;
    case 10: street1 = (java.lang.CharSequence)value$; break;
    case 11: street2 = (java.lang.CharSequence)value$; break;
    case 12: web_site = (java.lang.CharSequence)value$; break;
    case 13: zip_code = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'city' field.
   */
  public java.lang.CharSequence getCity() {
    return city;
  }

  /**
   * Sets the value of the 'city' field.
   * @param value the value to set.
   */
  public void setCity(java.lang.CharSequence value) {
    this.city = value;
  }

  /**
   * Gets the value of the 'civility' field.
   */
  public java.lang.CharSequence getCivility() {
    return civility;
  }

  /**
   * Sets the value of the 'civility' field.
   * @param value the value to set.
   */
  public void setCivility(java.lang.CharSequence value) {
    this.civility = value;
  }

  /**
   * Gets the value of the 'country' field.
   */
  public java.lang.CharSequence getCountry() {
    return country;
  }

  /**
   * Sets the value of the 'country' field.
   * @param value the value to set.
   */
  public void setCountry(java.lang.CharSequence value) {
    this.country = value;
  }

  /**
   * Gets the value of the 'email' field.
   */
  public java.lang.CharSequence getEmail() {
    return email;
  }

  /**
   * Sets the value of the 'email' field.
   * @param value the value to set.
   */
  public void setEmail(java.lang.CharSequence value) {
    this.email = value;
  }

  /**
   * Gets the value of the 'fax' field.
   */
  public java.lang.CharSequence getFax() {
    return fax;
  }

  /**
   * Sets the value of the 'fax' field.
   * @param value the value to set.
   */
  public void setFax(java.lang.CharSequence value) {
    this.fax = value;
  }

  /**
   * Gets the value of the 'firstname' field.
   */
  public java.lang.CharSequence getFirstname() {
    return firstname;
  }

  /**
   * Sets the value of the 'firstname' field.
   * @param value the value to set.
   */
  public void setFirstname(java.lang.CharSequence value) {
    this.firstname = value;
  }

  /**
   * Gets the value of the 'lastname' field.
   */
  public java.lang.CharSequence getLastname() {
    return lastname;
  }

  /**
   * Sets the value of the 'lastname' field.
   * @param value the value to set.
   */
  public void setLastname(java.lang.CharSequence value) {
    this.lastname = value;
  }

  /**
   * Gets the value of the 'phone' field.
   */
  public java.lang.CharSequence getPhone() {
    return phone;
  }

  /**
   * Sets the value of the 'phone' field.
   * @param value the value to set.
   */
  public void setPhone(java.lang.CharSequence value) {
    this.phone = value;
  }

  /**
   * Gets the value of the 'phone_secondary' field.
   */
  public java.lang.CharSequence getPhoneSecondary() {
    return phone_secondary;
  }

  /**
   * Sets the value of the 'phone_secondary' field.
   * @param value the value to set.
   */
  public void setPhoneSecondary(java.lang.CharSequence value) {
    this.phone_secondary = value;
  }

  /**
   * Gets the value of the 'state' field.
   */
  public java.lang.CharSequence getState() {
    return state;
  }

  /**
   * Sets the value of the 'state' field.
   * @param value the value to set.
   */
  public void setState(java.lang.CharSequence value) {
    this.state = value;
  }

  /**
   * Gets the value of the 'street1' field.
   */
  public java.lang.CharSequence getStreet1() {
    return street1;
  }

  /**
   * Sets the value of the 'street1' field.
   * @param value the value to set.
   */
  public void setStreet1(java.lang.CharSequence value) {
    this.street1 = value;
  }

  /**
   * Gets the value of the 'street2' field.
   */
  public java.lang.CharSequence getStreet2() {
    return street2;
  }

  /**
   * Sets the value of the 'street2' field.
   * @param value the value to set.
   */
  public void setStreet2(java.lang.CharSequence value) {
    this.street2 = value;
  }

  /**
   * Gets the value of the 'web_site' field.
   */
  public java.lang.CharSequence getWebSite() {
    return web_site;
  }

  /**
   * Sets the value of the 'web_site' field.
   * @param value the value to set.
   */
  public void setWebSite(java.lang.CharSequence value) {
    this.web_site = value;
  }

  /**
   * Gets the value of the 'zip_code' field.
   */
  public java.lang.CharSequence getZipCode() {
    return zip_code;
  }

  /**
   * Sets the value of the 'zip_code' field.
   * @param value the value to set.
   */
  public void setZipCode(java.lang.CharSequence value) {
    this.zip_code = value;
  }

  /** Creates a new ContactInformations RecordBuilder */
  public static br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder newBuilder() {
    return new br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder();
  }
  
  /** Creates a new ContactInformations RecordBuilder by copying an existing Builder */
  public static br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder newBuilder( br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder other) {
    return new br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder(other);
  }
  
  /** Creates a new ContactInformations RecordBuilder by copying an existing ContactInformations instance */
  public static br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder newBuilder( br.com.hitbra.marketplace.avro.shops.ContactInformations other) {
    return new br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder(other);
  }
  
  /**
   * RecordBuilder for ContactInformations instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ContactInformations>
    implements org.apache.avro.data.RecordBuilder<ContactInformations> {

    private java.lang.CharSequence city;
    private java.lang.CharSequence civility;
    private java.lang.CharSequence country;
    private java.lang.CharSequence email;
    private java.lang.CharSequence fax;
    private java.lang.CharSequence firstname;
    private java.lang.CharSequence lastname;
    private java.lang.CharSequence phone;
    private java.lang.CharSequence phone_secondary;
    private java.lang.CharSequence state;
    private java.lang.CharSequence street1;
    private java.lang.CharSequence street2;
    private java.lang.CharSequence web_site;
    private java.lang.CharSequence zip_code;

    /** Creates a new Builder */
    private Builder() {
      super(br.com.hitbra.marketplace.avro.shops.ContactInformations.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.city)) {
        this.city = data().deepCopy(fields()[0].schema(), other.city);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.civility)) {
        this.civility = data().deepCopy(fields()[1].schema(), other.civility);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.country)) {
        this.country = data().deepCopy(fields()[2].schema(), other.country);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.email)) {
        this.email = data().deepCopy(fields()[3].schema(), other.email);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.fax)) {
        this.fax = data().deepCopy(fields()[4].schema(), other.fax);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.firstname)) {
        this.firstname = data().deepCopy(fields()[5].schema(), other.firstname);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.lastname)) {
        this.lastname = data().deepCopy(fields()[6].schema(), other.lastname);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.phone)) {
        this.phone = data().deepCopy(fields()[7].schema(), other.phone);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.phone_secondary)) {
        this.phone_secondary = data().deepCopy(fields()[8].schema(), other.phone_secondary);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.state)) {
        this.state = data().deepCopy(fields()[9].schema(), other.state);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.street1)) {
        this.street1 = data().deepCopy(fields()[10].schema(), other.street1);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.street2)) {
        this.street2 = data().deepCopy(fields()[11].schema(), other.street2);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.web_site)) {
        this.web_site = data().deepCopy(fields()[12].schema(), other.web_site);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.zip_code)) {
        this.zip_code = data().deepCopy(fields()[13].schema(), other.zip_code);
        fieldSetFlags()[13] = true;
      }
    }
    
    /** Creates a Builder by copying an existing ContactInformations instance */
    private Builder(br.com.hitbra.marketplace.avro.shops.ContactInformations other) {
            super(br.com.hitbra.marketplace.avro.shops.ContactInformations.SCHEMA$);
      if (isValidValue(fields()[0], other.city)) {
        this.city = data().deepCopy(fields()[0].schema(), other.city);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.civility)) {
        this.civility = data().deepCopy(fields()[1].schema(), other.civility);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.country)) {
        this.country = data().deepCopy(fields()[2].schema(), other.country);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.email)) {
        this.email = data().deepCopy(fields()[3].schema(), other.email);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.fax)) {
        this.fax = data().deepCopy(fields()[4].schema(), other.fax);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.firstname)) {
        this.firstname = data().deepCopy(fields()[5].schema(), other.firstname);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.lastname)) {
        this.lastname = data().deepCopy(fields()[6].schema(), other.lastname);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.phone)) {
        this.phone = data().deepCopy(fields()[7].schema(), other.phone);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.phone_secondary)) {
        this.phone_secondary = data().deepCopy(fields()[8].schema(), other.phone_secondary);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.state)) {
        this.state = data().deepCopy(fields()[9].schema(), other.state);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.street1)) {
        this.street1 = data().deepCopy(fields()[10].schema(), other.street1);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.street2)) {
        this.street2 = data().deepCopy(fields()[11].schema(), other.street2);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.web_site)) {
        this.web_site = data().deepCopy(fields()[12].schema(), other.web_site);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.zip_code)) {
        this.zip_code = data().deepCopy(fields()[13].schema(), other.zip_code);
        fieldSetFlags()[13] = true;
      }
    }

    /** Gets the value of the 'city' field */
    public java.lang.CharSequence getCity() {
      return city;
    }
    
    /** Sets the value of the 'city' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder setCity( java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.city = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'city' field has been set */
    public boolean hasCity() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'city' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder clearCity() {
      city = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'civility' field */
    public java.lang.CharSequence getCivility() {
      return civility;
    }
    
    /** Sets the value of the 'civility' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder setCivility( java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.civility = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'civility' field has been set */
    public boolean hasCivility() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'civility' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder clearCivility() {
      civility = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'country' field */
    public java.lang.CharSequence getCountry() {
      return country;
    }
    
    /** Sets the value of the 'country' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder setCountry( java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.country = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'country' field has been set */
    public boolean hasCountry() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'country' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder clearCountry() {
      country = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'email' field */
    public java.lang.CharSequence getEmail() {
      return email;
    }
    
    /** Sets the value of the 'email' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder setEmail( java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.email = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'email' field has been set */
    public boolean hasEmail() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'email' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder clearEmail() {
      email = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'fax' field */
    public java.lang.CharSequence getFax() {
      return fax;
    }
    
    /** Sets the value of the 'fax' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder setFax( java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.fax = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'fax' field has been set */
    public boolean hasFax() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'fax' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder clearFax() {
      fax = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'firstname' field */
    public java.lang.CharSequence getFirstname() {
      return firstname;
    }
    
    /** Sets the value of the 'firstname' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder setFirstname( java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.firstname = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'firstname' field has been set */
    public boolean hasFirstname() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'firstname' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder clearFirstname() {
      firstname = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'lastname' field */
    public java.lang.CharSequence getLastname() {
      return lastname;
    }
    
    /** Sets the value of the 'lastname' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder setLastname( java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.lastname = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'lastname' field has been set */
    public boolean hasLastname() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'lastname' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder clearLastname() {
      lastname = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'phone' field */
    public java.lang.CharSequence getPhone() {
      return phone;
    }
    
    /** Sets the value of the 'phone' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder setPhone( java.lang.CharSequence value) {
      validate(fields()[7], value);
      this.phone = value;
      fieldSetFlags()[7] = true;
      return this; 
    }
    
    /** Checks whether the 'phone' field has been set */
    public boolean hasPhone() {
      return fieldSetFlags()[7];
    }
    
    /** Clears the value of the 'phone' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder clearPhone() {
      phone = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /** Gets the value of the 'phone_secondary' field */
    public java.lang.CharSequence getPhoneSecondary() {
      return phone_secondary;
    }
    
    /** Sets the value of the 'phone_secondary' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder setPhoneSecondary( java.lang.CharSequence value) {
      validate(fields()[8], value);
      this.phone_secondary = value;
      fieldSetFlags()[8] = true;
      return this; 
    }
    
    /** Checks whether the 'phone_secondary' field has been set */
    public boolean hasPhoneSecondary() {
      return fieldSetFlags()[8];
    }
    
    /** Clears the value of the 'phone_secondary' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder clearPhoneSecondary() {
      phone_secondary = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /** Gets the value of the 'state' field */
    public java.lang.CharSequence getState() {
      return state;
    }
    
    /** Sets the value of the 'state' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder setState( java.lang.CharSequence value) {
      validate(fields()[9], value);
      this.state = value;
      fieldSetFlags()[9] = true;
      return this; 
    }
    
    /** Checks whether the 'state' field has been set */
    public boolean hasState() {
      return fieldSetFlags()[9];
    }
    
    /** Clears the value of the 'state' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder clearState() {
      state = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /** Gets the value of the 'street1' field */
    public java.lang.CharSequence getStreet1() {
      return street1;
    }
    
    /** Sets the value of the 'street1' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder setStreet1( java.lang.CharSequence value) {
      validate(fields()[10], value);
      this.street1 = value;
      fieldSetFlags()[10] = true;
      return this; 
    }
    
    /** Checks whether the 'street1' field has been set */
    public boolean hasStreet1() {
      return fieldSetFlags()[10];
    }
    
    /** Clears the value of the 'street1' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder clearStreet1() {
      street1 = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    /** Gets the value of the 'street2' field */
    public java.lang.CharSequence getStreet2() {
      return street2;
    }
    
    /** Sets the value of the 'street2' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder setStreet2( java.lang.CharSequence value) {
      validate(fields()[11], value);
      this.street2 = value;
      fieldSetFlags()[11] = true;
      return this; 
    }
    
    /** Checks whether the 'street2' field has been set */
    public boolean hasStreet2() {
      return fieldSetFlags()[11];
    }
    
    /** Clears the value of the 'street2' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder clearStreet2() {
      street2 = null;
      fieldSetFlags()[11] = false;
      return this;
    }

    /** Gets the value of the 'web_site' field */
    public java.lang.CharSequence getWebSite() {
      return web_site;
    }
    
    /** Sets the value of the 'web_site' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder setWebSite( java.lang.CharSequence value) {
      validate(fields()[12], value);
      this.web_site = value;
      fieldSetFlags()[12] = true;
      return this; 
    }
    
    /** Checks whether the 'web_site' field has been set */
    public boolean hasWebSite() {
      return fieldSetFlags()[12];
    }
    
    /** Clears the value of the 'web_site' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder clearWebSite() {
      web_site = null;
      fieldSetFlags()[12] = false;
      return this;
    }

    /** Gets the value of the 'zip_code' field */
    public java.lang.CharSequence getZipCode() {
      return zip_code;
    }
    
    /** Sets the value of the 'zip_code' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder setZipCode( java.lang.CharSequence value) {
      validate(fields()[13], value);
      this.zip_code = value;
      fieldSetFlags()[13] = true;
      return this; 
    }
    
    /** Checks whether the 'zip_code' field has been set */
    public boolean hasZipCode() {
      return fieldSetFlags()[13];
    }
    
    /** Clears the value of the 'zip_code' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations.Builder clearZipCode() {
      zip_code = null;
      fieldSetFlags()[13] = false;
      return this;
    }

    @Override
    public ContactInformations build() {
      try {
        ContactInformations record = new ContactInformations();
        record.city = fieldSetFlags()[0] ? this.city : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.civility = fieldSetFlags()[1] ? this.civility : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.country = fieldSetFlags()[2] ? this.country : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.email = fieldSetFlags()[3] ? this.email : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.fax = fieldSetFlags()[4] ? this.fax : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.firstname = fieldSetFlags()[5] ? this.firstname : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.lastname = fieldSetFlags()[6] ? this.lastname : (java.lang.CharSequence) defaultValue(fields()[6]);
        record.phone = fieldSetFlags()[7] ? this.phone : (java.lang.CharSequence) defaultValue(fields()[7]);
        record.phone_secondary = fieldSetFlags()[8] ? this.phone_secondary : (java.lang.CharSequence) defaultValue(fields()[8]);
        record.state = fieldSetFlags()[9] ? this.state : (java.lang.CharSequence) defaultValue(fields()[9]);
        record.street1 = fieldSetFlags()[10] ? this.street1 : (java.lang.CharSequence) defaultValue(fields()[10]);
        record.street2 = fieldSetFlags()[11] ? this.street2 : (java.lang.CharSequence) defaultValue(fields()[11]);
        record.web_site = fieldSetFlags()[12] ? this.web_site : (java.lang.CharSequence) defaultValue(fields()[12]);
        record.zip_code = fieldSetFlags()[13] ? this.zip_code : (java.lang.CharSequence) defaultValue(fields()[13]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
