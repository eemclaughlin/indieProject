package com.ericmclaughlin.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Industry identifiers item.
 */
public class IndustryIdentifiersItem{

	@JsonProperty("identifier")
	private String identifier;

	@JsonProperty("type")
	private String type;

	/**
	 * Set identifier.
	 *
	 * @param identifier the identifier
	 */
	public void setIdentifier(String identifier){
		this.identifier = identifier;
	}

	/**
	 * Get identifier string.
	 *
	 * @return the string
	 */
	public String getIdentifier(){
		return identifier;
	}

	/**
	 * Set type.
	 *
	 * @param type the type
	 */
	public void setType(String type){
		this.type = type;
	}

	/**
	 * Get type string.
	 *
	 * @return the string
	 */
	public String getType(){
		return type;
	}
}