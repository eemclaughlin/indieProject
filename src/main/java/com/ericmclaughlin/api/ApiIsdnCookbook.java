package com.ericmclaughlin.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Api isdn cookbook.
 */
public class ApiIsdnCookbook{

	@JsonProperty("items")
	private List<ItemsItem> items;

	/**
	 * Set items.
	 * @param items the items
	 */
	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	/**
	 * Get items list.
	 * @return the list
	 */
	public List<ItemsItem> getItems(){
		return items;
	}
}