/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package br.com.hitbra.marketplace.avro.shops;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Shop extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Shop\",\"namespace\":\"br.com.hitbra.marketplace.avro.shops\",\"fields\":[{\"name\":\"shop_id\",\"type\":\"long\"},{\"name\":\"shop_name\",\"type\":\"string\"},{\"name\":\"shop_state\",\"type\":{\"type\":\"enum\",\"name\":\"ShopState\",\"symbols\":[\"OPEN\",\"CLOSE\",\"SUSPENDED\"]}},{\"name\":\"logo\",\"type\":[\"string\",\"null\"]},{\"name\":\"banner\",\"type\":[\"string\",\"null\"]},{\"name\":\"date_created\",\"type\":\"long\",\"logicalType\":\"time-millis\"},{\"name\":\"last_updated_date\",\"type\":\"long\",\"logicalType\":\"time-millis\"},{\"name\":\"description\",\"type\":[\"string\",\"null\"]},{\"name\":\"evaluations_count\",\"type\":\"long\"},{\"name\":\"offers_count\",\"type\":\"long\"},{\"name\":\"operator_internal_id\",\"type\":[\"string\",\"null\"]},{\"name\":\"order_messages_response_delay\",\"type\":[\"long\",\"null\"]},{\"name\":\"orders_count\",\"type\":\"long\"},{\"name\":\"premium\",\"type\":\"boolean\"},{\"name\":\"return_policy\",\"type\":[\"string\",\"null\"]},{\"name\":\"contact_informations\",\"type\":{\"type\":\"record\",\"name\":\"ContactInformations\",\"fields\":[{\"name\":\"city\",\"type\":\"string\"},{\"name\":\"civility\",\"type\":[\"string\",\"null\"]},{\"name\":\"country\",\"type\":\"string\"},{\"name\":\"email\",\"type\":\"string\"},{\"name\":\"fax\",\"type\":[\"string\",\"null\"]},{\"name\":\"firstname\",\"type\":[\"string\",\"null\"]},{\"name\":\"lastname\",\"type\":\"string\"},{\"name\":\"phone\",\"type\":[\"string\",\"null\"]},{\"name\":\"phone_secondary\",\"type\":[\"string\",\"null\"]},{\"name\":\"state\",\"type\":[\"string\",\"null\"]},{\"name\":\"street1\",\"type\":\"string\"},{\"name\":\"street2\",\"type\":[\"string\",\"null\"]},{\"name\":\"web_site\",\"type\":[\"string\",\"null\"]},{\"name\":\"zip_code\",\"type\":\"string\"}]}},{\"name\":\"pro_details\",\"type\":{\"type\":\"record\",\"name\":\"ProDetails\",\"fields\":[{\"name\":\"corporate_name\",\"type\":[\"string\",\"null\"]},{\"name\":\"identification_number\",\"type\":[\"string\",\"null\"]},{\"name\":\"tax_identification_number\",\"type\":[\"string\",\"null\"]}]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public long shop_id;
  @Deprecated public java.lang.CharSequence shop_name;
  @Deprecated public br.com.hitbra.marketplace.avro.shops.ShopState shop_state;
  @Deprecated public java.lang.CharSequence logo;
  @Deprecated public java.lang.CharSequence banner;
  @Deprecated public long date_created;
  @Deprecated public long last_updated_date;
  @Deprecated public java.lang.CharSequence description;
  @Deprecated public long evaluations_count;
  @Deprecated public long offers_count;
  @Deprecated public java.lang.CharSequence operator_internal_id;
  @Deprecated public java.lang.Long order_messages_response_delay;
  @Deprecated public long orders_count;
  @Deprecated public boolean premium;
  @Deprecated public java.lang.CharSequence return_policy;
  @Deprecated public br.com.hitbra.marketplace.avro.shops.ContactInformations contact_informations;
  @Deprecated public br.com.hitbra.marketplace.avro.shops.ProDetails pro_details;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Shop() {}

  /**
   * All-args constructor.
   */
  public Shop(java.lang.Long shop_id, java.lang.CharSequence shop_name, br.com.hitbra.marketplace.avro.shops.ShopState shop_state, java.lang.CharSequence logo, java.lang.CharSequence banner, java.lang.Long date_created, java.lang.Long last_updated_date, java.lang.CharSequence description, java.lang.Long evaluations_count, java.lang.Long offers_count, java.lang.CharSequence operator_internal_id, java.lang.Long order_messages_response_delay, java.lang.Long orders_count, java.lang.Boolean premium, java.lang.CharSequence return_policy, br.com.hitbra.marketplace.avro.shops.ContactInformations contact_informations, br.com.hitbra.marketplace.avro.shops.ProDetails pro_details) {
    this.shop_id = shop_id;
    this.shop_name = shop_name;
    this.shop_state = shop_state;
    this.logo = logo;
    this.banner = banner;
    this.date_created = date_created;
    this.last_updated_date = last_updated_date;
    this.description = description;
    this.evaluations_count = evaluations_count;
    this.offers_count = offers_count;
    this.operator_internal_id = operator_internal_id;
    this.order_messages_response_delay = order_messages_response_delay;
    this.orders_count = orders_count;
    this.premium = premium;
    this.return_policy = return_policy;
    this.contact_informations = contact_informations;
    this.pro_details = pro_details;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return shop_id;
    case 1: return shop_name;
    case 2: return shop_state;
    case 3: return logo;
    case 4: return banner;
    case 5: return date_created;
    case 6: return last_updated_date;
    case 7: return description;
    case 8: return evaluations_count;
    case 9: return offers_count;
    case 10: return operator_internal_id;
    case 11: return order_messages_response_delay;
    case 12: return orders_count;
    case 13: return premium;
    case 14: return return_policy;
    case 15: return contact_informations;
    case 16: return pro_details;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: shop_id = (java.lang.Long)value$; break;
    case 1: shop_name = (java.lang.CharSequence)value$; break;
    case 2: shop_state = (br.com.hitbra.marketplace.avro.shops.ShopState)value$; break;
    case 3: logo = (java.lang.CharSequence)value$; break;
    case 4: banner = (java.lang.CharSequence)value$; break;
    case 5: date_created = (java.lang.Long)value$; break;
    case 6: last_updated_date = (java.lang.Long)value$; break;
    case 7: description = (java.lang.CharSequence)value$; break;
    case 8: evaluations_count = (java.lang.Long)value$; break;
    case 9: offers_count = (java.lang.Long)value$; break;
    case 10: operator_internal_id = (java.lang.CharSequence)value$; break;
    case 11: order_messages_response_delay = (java.lang.Long)value$; break;
    case 12: orders_count = (java.lang.Long)value$; break;
    case 13: premium = (java.lang.Boolean)value$; break;
    case 14: return_policy = (java.lang.CharSequence)value$; break;
    case 15: contact_informations = (br.com.hitbra.marketplace.avro.shops.ContactInformations)value$; break;
    case 16: pro_details = (br.com.hitbra.marketplace.avro.shops.ProDetails)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'shop_id' field.
   */
  public java.lang.Long getShopId() {
    return shop_id;
  }

  /**
   * Sets the value of the 'shop_id' field.
   * @param value the value to set.
   */
  public void setShopId(java.lang.Long value) {
    this.shop_id = value;
  }

  /**
   * Gets the value of the 'shop_name' field.
   */
  public java.lang.CharSequence getShopName() {
    return shop_name;
  }

  /**
   * Sets the value of the 'shop_name' field.
   * @param value the value to set.
   */
  public void setShopName(java.lang.CharSequence value) {
    this.shop_name = value;
  }

  /**
   * Gets the value of the 'shop_state' field.
   */
  public br.com.hitbra.marketplace.avro.shops.ShopState getShopState() {
    return shop_state;
  }

  /**
   * Sets the value of the 'shop_state' field.
   * @param value the value to set.
   */
  public void setShopState(br.com.hitbra.marketplace.avro.shops.ShopState value) {
    this.shop_state = value;
  }

  /**
   * Gets the value of the 'logo' field.
   */
  public java.lang.CharSequence getLogo() {
    return logo;
  }

  /**
   * Sets the value of the 'logo' field.
   * @param value the value to set.
   */
  public void setLogo(java.lang.CharSequence value) {
    this.logo = value;
  }

  /**
   * Gets the value of the 'banner' field.
   */
  public java.lang.CharSequence getBanner() {
    return banner;
  }

  /**
   * Sets the value of the 'banner' field.
   * @param value the value to set.
   */
  public void setBanner(java.lang.CharSequence value) {
    this.banner = value;
  }

  /**
   * Gets the value of the 'date_created' field.
   */
  public java.lang.Long getDateCreated() {
    return date_created;
  }

  /**
   * Sets the value of the 'date_created' field.
   * @param value the value to set.
   */
  public void setDateCreated(java.lang.Long value) {
    this.date_created = value;
  }

  /**
   * Gets the value of the 'last_updated_date' field.
   */
  public java.lang.Long getLastUpdatedDate() {
    return last_updated_date;
  }

  /**
   * Sets the value of the 'last_updated_date' field.
   * @param value the value to set.
   */
  public void setLastUpdatedDate(java.lang.Long value) {
    this.last_updated_date = value;
  }

  /**
   * Gets the value of the 'description' field.
   */
  public java.lang.CharSequence getDescription() {
    return description;
  }

  /**
   * Sets the value of the 'description' field.
   * @param value the value to set.
   */
  public void setDescription(java.lang.CharSequence value) {
    this.description = value;
  }

  /**
   * Gets the value of the 'evaluations_count' field.
   */
  public java.lang.Long getEvaluationsCount() {
    return evaluations_count;
  }

  /**
   * Sets the value of the 'evaluations_count' field.
   * @param value the value to set.
   */
  public void setEvaluationsCount(java.lang.Long value) {
    this.evaluations_count = value;
  }

  /**
   * Gets the value of the 'offers_count' field.
   */
  public java.lang.Long getOffersCount() {
    return offers_count;
  }

  /**
   * Sets the value of the 'offers_count' field.
   * @param value the value to set.
   */
  public void setOffersCount(java.lang.Long value) {
    this.offers_count = value;
  }

  /**
   * Gets the value of the 'operator_internal_id' field.
   */
  public java.lang.CharSequence getOperatorInternalId() {
    return operator_internal_id;
  }

  /**
   * Sets the value of the 'operator_internal_id' field.
   * @param value the value to set.
   */
  public void setOperatorInternalId(java.lang.CharSequence value) {
    this.operator_internal_id = value;
  }

  /**
   * Gets the value of the 'order_messages_response_delay' field.
   */
  public java.lang.Long getOrderMessagesResponseDelay() {
    return order_messages_response_delay;
  }

  /**
   * Sets the value of the 'order_messages_response_delay' field.
   * @param value the value to set.
   */
  public void setOrderMessagesResponseDelay(java.lang.Long value) {
    this.order_messages_response_delay = value;
  }

  /**
   * Gets the value of the 'orders_count' field.
   */
  public java.lang.Long getOrdersCount() {
    return orders_count;
  }

  /**
   * Sets the value of the 'orders_count' field.
   * @param value the value to set.
   */
  public void setOrdersCount(java.lang.Long value) {
    this.orders_count = value;
  }

  /**
   * Gets the value of the 'premium' field.
   */
  public java.lang.Boolean getPremium() {
    return premium;
  }

  /**
   * Sets the value of the 'premium' field.
   * @param value the value to set.
   */
  public void setPremium(java.lang.Boolean value) {
    this.premium = value;
  }

  /**
   * Gets the value of the 'return_policy' field.
   */
  public java.lang.CharSequence getReturnPolicy() {
    return return_policy;
  }

  /**
   * Sets the value of the 'return_policy' field.
   * @param value the value to set.
   */
  public void setReturnPolicy(java.lang.CharSequence value) {
    this.return_policy = value;
  }

  /**
   * Gets the value of the 'contact_informations' field.
   */
  public br.com.hitbra.marketplace.avro.shops.ContactInformations getContactInformations() {
    return contact_informations;
  }

  /**
   * Sets the value of the 'contact_informations' field.
   * @param value the value to set.
   */
  public void setContactInformations(br.com.hitbra.marketplace.avro.shops.ContactInformations value) {
    this.contact_informations = value;
  }

  /**
   * Gets the value of the 'pro_details' field.
   */
  public br.com.hitbra.marketplace.avro.shops.ProDetails getProDetails() {
    return pro_details;
  }

  /**
   * Sets the value of the 'pro_details' field.
   * @param value the value to set.
   */
  public void setProDetails(br.com.hitbra.marketplace.avro.shops.ProDetails value) {
    this.pro_details = value;
  }

  /** Creates a new Shop RecordBuilder */
  public static br.com.hitbra.marketplace.avro.shops.Shop.Builder newBuilder() {
    return new br.com.hitbra.marketplace.avro.shops.Shop.Builder();
  }
  
  /** Creates a new Shop RecordBuilder by copying an existing Builder */
  public static br.com.hitbra.marketplace.avro.shops.Shop.Builder newBuilder(br.com.hitbra.marketplace.avro.shops.Shop.Builder other) {
    return new br.com.hitbra.marketplace.avro.shops.Shop.Builder(other);
  }
  
  /** Creates a new Shop RecordBuilder by copying an existing Shop instance */
  public static br.com.hitbra.marketplace.avro.shops.Shop.Builder newBuilder(br.com.hitbra.marketplace.avro.shops.Shop other) {
    return new br.com.hitbra.marketplace.avro.shops.Shop.Builder(other);
  }
  
  /**
   * RecordBuilder for Shop instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Shop>
    implements org.apache.avro.data.RecordBuilder<Shop> {

    private long shop_id;
    private java.lang.CharSequence shop_name;
    private br.com.hitbra.marketplace.avro.shops.ShopState shop_state;
    private java.lang.CharSequence logo;
    private java.lang.CharSequence banner;
    private long date_created;
    private long last_updated_date;
    private java.lang.CharSequence description;
    private long evaluations_count;
    private long offers_count;
    private java.lang.CharSequence operator_internal_id;
    private java.lang.Long order_messages_response_delay;
    private long orders_count;
    private boolean premium;
    private java.lang.CharSequence return_policy;
    private br.com.hitbra.marketplace.avro.shops.ContactInformations contact_informations;
    private br.com.hitbra.marketplace.avro.shops.ProDetails pro_details;

    /** Creates a new Builder */
    private Builder() {
      super(br.com.hitbra.marketplace.avro.shops.Shop.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(br.com.hitbra.marketplace.avro.shops.Shop.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.shop_id)) {
        this.shop_id = data().deepCopy(fields()[0].schema(), other.shop_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.shop_name)) {
        this.shop_name = data().deepCopy(fields()[1].schema(), other.shop_name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.shop_state)) {
        this.shop_state = data().deepCopy(fields()[2].schema(), other.shop_state);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.logo)) {
        this.logo = data().deepCopy(fields()[3].schema(), other.logo);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.banner)) {
        this.banner = data().deepCopy(fields()[4].schema(), other.banner);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.date_created)) {
        this.date_created = data().deepCopy(fields()[5].schema(), other.date_created);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.last_updated_date)) {
        this.last_updated_date = data().deepCopy(fields()[6].schema(), other.last_updated_date);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.description)) {
        this.description = data().deepCopy(fields()[7].schema(), other.description);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.evaluations_count)) {
        this.evaluations_count = data().deepCopy(fields()[8].schema(), other.evaluations_count);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.offers_count)) {
        this.offers_count = data().deepCopy(fields()[9].schema(), other.offers_count);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.operator_internal_id)) {
        this.operator_internal_id = data().deepCopy(fields()[10].schema(), other.operator_internal_id);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.order_messages_response_delay)) {
        this.order_messages_response_delay = data().deepCopy(fields()[11].schema(), other.order_messages_response_delay);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.orders_count)) {
        this.orders_count = data().deepCopy(fields()[12].schema(), other.orders_count);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.premium)) {
        this.premium = data().deepCopy(fields()[13].schema(), other.premium);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.return_policy)) {
        this.return_policy = data().deepCopy(fields()[14].schema(), other.return_policy);
        fieldSetFlags()[14] = true;
      }
      if (isValidValue(fields()[15], other.contact_informations)) {
        this.contact_informations = data().deepCopy(fields()[15].schema(), other.contact_informations);
        fieldSetFlags()[15] = true;
      }
      if (isValidValue(fields()[16], other.pro_details)) {
        this.pro_details = data().deepCopy(fields()[16].schema(), other.pro_details);
        fieldSetFlags()[16] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Shop instance */
    private Builder(br.com.hitbra.marketplace.avro.shops.Shop other) {
            super(br.com.hitbra.marketplace.avro.shops.Shop.SCHEMA$);
      if (isValidValue(fields()[0], other.shop_id)) {
        this.shop_id = data().deepCopy(fields()[0].schema(), other.shop_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.shop_name)) {
        this.shop_name = data().deepCopy(fields()[1].schema(), other.shop_name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.shop_state)) {
        this.shop_state = data().deepCopy(fields()[2].schema(), other.shop_state);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.logo)) {
        this.logo = data().deepCopy(fields()[3].schema(), other.logo);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.banner)) {
        this.banner = data().deepCopy(fields()[4].schema(), other.banner);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.date_created)) {
        this.date_created = data().deepCopy(fields()[5].schema(), other.date_created);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.last_updated_date)) {
        this.last_updated_date = data().deepCopy(fields()[6].schema(), other.last_updated_date);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.description)) {
        this.description = data().deepCopy(fields()[7].schema(), other.description);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.evaluations_count)) {
        this.evaluations_count = data().deepCopy(fields()[8].schema(), other.evaluations_count);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.offers_count)) {
        this.offers_count = data().deepCopy(fields()[9].schema(), other.offers_count);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.operator_internal_id)) {
        this.operator_internal_id = data().deepCopy(fields()[10].schema(), other.operator_internal_id);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.order_messages_response_delay)) {
        this.order_messages_response_delay = data().deepCopy(fields()[11].schema(), other.order_messages_response_delay);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.orders_count)) {
        this.orders_count = data().deepCopy(fields()[12].schema(), other.orders_count);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.premium)) {
        this.premium = data().deepCopy(fields()[13].schema(), other.premium);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.return_policy)) {
        this.return_policy = data().deepCopy(fields()[14].schema(), other.return_policy);
        fieldSetFlags()[14] = true;
      }
      if (isValidValue(fields()[15], other.contact_informations)) {
        this.contact_informations = data().deepCopy(fields()[15].schema(), other.contact_informations);
        fieldSetFlags()[15] = true;
      }
      if (isValidValue(fields()[16], other.pro_details)) {
        this.pro_details = data().deepCopy(fields()[16].schema(), other.pro_details);
        fieldSetFlags()[16] = true;
      }
    }

    /** Gets the value of the 'shop_id' field */
    public java.lang.Long getShopId() {
      return shop_id;
    }
    
    /** Sets the value of the 'shop_id' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder setShopId(long value) {
      validate(fields()[0], value);
      this.shop_id = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'shop_id' field has been set */
    public boolean hasShopId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'shop_id' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder clearShopId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'shop_name' field */
    public java.lang.CharSequence getShopName() {
      return shop_name;
    }
    
    /** Sets the value of the 'shop_name' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder setShopName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.shop_name = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'shop_name' field has been set */
    public boolean hasShopName() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'shop_name' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder clearShopName() {
      shop_name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'shop_state' field */
    public br.com.hitbra.marketplace.avro.shops.ShopState getShopState() {
      return shop_state;
    }
    
    /** Sets the value of the 'shop_state' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder setShopState(br.com.hitbra.marketplace.avro.shops.ShopState value) {
      validate(fields()[2], value);
      this.shop_state = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'shop_state' field has been set */
    public boolean hasShopState() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'shop_state' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder clearShopState() {
      shop_state = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'logo' field */
    public java.lang.CharSequence getLogo() {
      return logo;
    }
    
    /** Sets the value of the 'logo' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder setLogo(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.logo = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'logo' field has been set */
    public boolean hasLogo() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'logo' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder clearLogo() {
      logo = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'banner' field */
    public java.lang.CharSequence getBanner() {
      return banner;
    }
    
    /** Sets the value of the 'banner' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder setBanner(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.banner = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'banner' field has been set */
    public boolean hasBanner() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'banner' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder clearBanner() {
      banner = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'date_created' field */
    public java.lang.Long getDateCreated() {
      return date_created;
    }
    
    /** Sets the value of the 'date_created' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder setDateCreated(long value) {
      validate(fields()[5], value);
      this.date_created = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'date_created' field has been set */
    public boolean hasDateCreated() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'date_created' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder clearDateCreated() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'last_updated_date' field */
    public java.lang.Long getLastUpdatedDate() {
      return last_updated_date;
    }
    
    /** Sets the value of the 'last_updated_date' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder setLastUpdatedDate(long value) {
      validate(fields()[6], value);
      this.last_updated_date = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'last_updated_date' field has been set */
    public boolean hasLastUpdatedDate() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'last_updated_date' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder clearLastUpdatedDate() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'description' field */
    public java.lang.CharSequence getDescription() {
      return description;
    }
    
    /** Sets the value of the 'description' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder setDescription(java.lang.CharSequence value) {
      validate(fields()[7], value);
      this.description = value;
      fieldSetFlags()[7] = true;
      return this; 
    }
    
    /** Checks whether the 'description' field has been set */
    public boolean hasDescription() {
      return fieldSetFlags()[7];
    }
    
    /** Clears the value of the 'description' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder clearDescription() {
      description = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /** Gets the value of the 'evaluations_count' field */
    public java.lang.Long getEvaluationsCount() {
      return evaluations_count;
    }
    
    /** Sets the value of the 'evaluations_count' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder setEvaluationsCount(long value) {
      validate(fields()[8], value);
      this.evaluations_count = value;
      fieldSetFlags()[8] = true;
      return this; 
    }
    
    /** Checks whether the 'evaluations_count' field has been set */
    public boolean hasEvaluationsCount() {
      return fieldSetFlags()[8];
    }
    
    /** Clears the value of the 'evaluations_count' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder clearEvaluationsCount() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /** Gets the value of the 'offers_count' field */
    public java.lang.Long getOffersCount() {
      return offers_count;
    }
    
    /** Sets the value of the 'offers_count' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder setOffersCount(long value) {
      validate(fields()[9], value);
      this.offers_count = value;
      fieldSetFlags()[9] = true;
      return this; 
    }
    
    /** Checks whether the 'offers_count' field has been set */
    public boolean hasOffersCount() {
      return fieldSetFlags()[9];
    }
    
    /** Clears the value of the 'offers_count' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder clearOffersCount() {
      fieldSetFlags()[9] = false;
      return this;
    }

    /** Gets the value of the 'operator_internal_id' field */
    public java.lang.CharSequence getOperatorInternalId() {
      return operator_internal_id;
    }
    
    /** Sets the value of the 'operator_internal_id' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder setOperatorInternalId(java.lang.CharSequence value) {
      validate(fields()[10], value);
      this.operator_internal_id = value;
      fieldSetFlags()[10] = true;
      return this; 
    }
    
    /** Checks whether the 'operator_internal_id' field has been set */
    public boolean hasOperatorInternalId() {
      return fieldSetFlags()[10];
    }
    
    /** Clears the value of the 'operator_internal_id' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder clearOperatorInternalId() {
      operator_internal_id = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    /** Gets the value of the 'order_messages_response_delay' field */
    public java.lang.Long getOrderMessagesResponseDelay() {
      return order_messages_response_delay;
    }
    
    /** Sets the value of the 'order_messages_response_delay' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder setOrderMessagesResponseDelay(java.lang.Long value) {
      validate(fields()[11], value);
      this.order_messages_response_delay = value;
      fieldSetFlags()[11] = true;
      return this; 
    }
    
    /** Checks whether the 'order_messages_response_delay' field has been set */
    public boolean hasOrderMessagesResponseDelay() {
      return fieldSetFlags()[11];
    }
    
    /** Clears the value of the 'order_messages_response_delay' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder clearOrderMessagesResponseDelay() {
      order_messages_response_delay = null;
      fieldSetFlags()[11] = false;
      return this;
    }

    /** Gets the value of the 'orders_count' field */
    public java.lang.Long getOrdersCount() {
      return orders_count;
    }
    
    /** Sets the value of the 'orders_count' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder setOrdersCount(long value) {
      validate(fields()[12], value);
      this.orders_count = value;
      fieldSetFlags()[12] = true;
      return this; 
    }
    
    /** Checks whether the 'orders_count' field has been set */
    public boolean hasOrdersCount() {
      return fieldSetFlags()[12];
    }
    
    /** Clears the value of the 'orders_count' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder clearOrdersCount() {
      fieldSetFlags()[12] = false;
      return this;
    }

    /** Gets the value of the 'premium' field */
    public java.lang.Boolean getPremium() {
      return premium;
    }
    
    /** Sets the value of the 'premium' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder setPremium(boolean value) {
      validate(fields()[13], value);
      this.premium = value;
      fieldSetFlags()[13] = true;
      return this; 
    }
    
    /** Checks whether the 'premium' field has been set */
    public boolean hasPremium() {
      return fieldSetFlags()[13];
    }
    
    /** Clears the value of the 'premium' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder clearPremium() {
      fieldSetFlags()[13] = false;
      return this;
    }

    /** Gets the value of the 'return_policy' field */
    public java.lang.CharSequence getReturnPolicy() {
      return return_policy;
    }
    
    /** Sets the value of the 'return_policy' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder setReturnPolicy(java.lang.CharSequence value) {
      validate(fields()[14], value);
      this.return_policy = value;
      fieldSetFlags()[14] = true;
      return this; 
    }
    
    /** Checks whether the 'return_policy' field has been set */
    public boolean hasReturnPolicy() {
      return fieldSetFlags()[14];
    }
    
    /** Clears the value of the 'return_policy' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder clearReturnPolicy() {
      return_policy = null;
      fieldSetFlags()[14] = false;
      return this;
    }

    /** Gets the value of the 'contact_informations' field */
    public br.com.hitbra.marketplace.avro.shops.ContactInformations getContactInformations() {
      return contact_informations;
    }
    
    /** Sets the value of the 'contact_informations' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder setContactInformations(br.com.hitbra.marketplace.avro.shops.ContactInformations value) {
      validate(fields()[15], value);
      this.contact_informations = value;
      fieldSetFlags()[15] = true;
      return this; 
    }
    
    /** Checks whether the 'contact_informations' field has been set */
    public boolean hasContactInformations() {
      return fieldSetFlags()[15];
    }
    
    /** Clears the value of the 'contact_informations' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder clearContactInformations() {
      contact_informations = null;
      fieldSetFlags()[15] = false;
      return this;
    }

    /** Gets the value of the 'pro_details' field */
    public br.com.hitbra.marketplace.avro.shops.ProDetails getProDetails() {
      return pro_details;
    }
    
    /** Sets the value of the 'pro_details' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder setProDetails(br.com.hitbra.marketplace.avro.shops.ProDetails value) {
      validate(fields()[16], value);
      this.pro_details = value;
      fieldSetFlags()[16] = true;
      return this; 
    }
    
    /** Checks whether the 'pro_details' field has been set */
    public boolean hasProDetails() {
      return fieldSetFlags()[16];
    }
    
    /** Clears the value of the 'pro_details' field */
    public br.com.hitbra.marketplace.avro.shops.Shop.Builder clearProDetails() {
      pro_details = null;
      fieldSetFlags()[16] = false;
      return this;
    }

    @Override
    public Shop build() {
      try {
        Shop record = new Shop();
        record.shop_id = fieldSetFlags()[0] ? this.shop_id : (java.lang.Long) defaultValue(fields()[0]);
        record.shop_name = fieldSetFlags()[1] ? this.shop_name : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.shop_state = fieldSetFlags()[2] ? this.shop_state : (br.com.hitbra.marketplace.avro.shops.ShopState) defaultValue(fields()[2]);
        record.logo = fieldSetFlags()[3] ? this.logo : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.banner = fieldSetFlags()[4] ? this.banner : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.date_created = fieldSetFlags()[5] ? this.date_created : (java.lang.Long) defaultValue(fields()[5]);
        record.last_updated_date = fieldSetFlags()[6] ? this.last_updated_date : (java.lang.Long) defaultValue(fields()[6]);
        record.description = fieldSetFlags()[7] ? this.description : (java.lang.CharSequence) defaultValue(fields()[7]);
        record.evaluations_count = fieldSetFlags()[8] ? this.evaluations_count : (java.lang.Long) defaultValue(fields()[8]);
        record.offers_count = fieldSetFlags()[9] ? this.offers_count : (java.lang.Long) defaultValue(fields()[9]);
        record.operator_internal_id = fieldSetFlags()[10] ? this.operator_internal_id : (java.lang.CharSequence) defaultValue(fields()[10]);
        record.order_messages_response_delay = fieldSetFlags()[11] ? this.order_messages_response_delay : (java.lang.Long) defaultValue(fields()[11]);
        record.orders_count = fieldSetFlags()[12] ? this.orders_count : (java.lang.Long) defaultValue(fields()[12]);
        record.premium = fieldSetFlags()[13] ? this.premium : (java.lang.Boolean) defaultValue(fields()[13]);
        record.return_policy = fieldSetFlags()[14] ? this.return_policy : (java.lang.CharSequence) defaultValue(fields()[14]);
        record.contact_informations = fieldSetFlags()[15] ? this.contact_informations : (br.com.hitbra.marketplace.avro.shops.ContactInformations) defaultValue(fields()[15]);
        record.pro_details = fieldSetFlags()[16] ? this.pro_details : (br.com.hitbra.marketplace.avro.shops.ProDetails) defaultValue(fields()[16]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
