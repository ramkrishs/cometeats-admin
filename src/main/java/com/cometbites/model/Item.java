package com.cometbites.model;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
"name",
"id",
"price",
"qty",
"image",
"description"
})
public class Item {

@JsonProperty("name")
private String name;
@JsonProperty("id")
private String id;
@JsonProperty("price")
private String price;
@JsonProperty("qty")
private String qty;
@JsonProperty("image")
private String image;
@JsonProperty("description")
private String description;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The name
*/
@JsonProperty("name")
public String getName() {
return name;
}

/**
* 
* @param name
* The name
*/
@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

/**
* 
* @return
* The id
*/
@JsonProperty("id")
public String getId() {
return id;
}

/**
* 
* @param id
* The id
*/
@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

/**
* 
* @return
* The price
*/
@JsonProperty("price")
public String getPrice() {
return price;
}

/**
* 
* @param price
* The price
*/
@JsonProperty("price")
public void setPrice(String price) {
this.price = price;
}

/**
* 
* @return
* The qty
*/
@JsonProperty("qty")
public String getQty() {
return qty;
}

/**
* 
* @param qty
* The qty
*/
@JsonProperty("qty")
public void setQty(String qty) {
this.qty = qty;
}

/**
* 
* @return
* The image
*/
@JsonProperty("image")
public String getImage() {
return image;
}

/**
* 
* @param image
* The image
*/
@JsonProperty("image")
public void setImage(String image) {
this.image = image;
}

/**
* 
* @return
* The description
*/
@JsonProperty("description")
public String getDescription() {
return description;
}

/**
* 
* @param description
* The description
*/
@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}



@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}