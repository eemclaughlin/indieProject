package com.ericmclaughlin.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiIsdnCookbook{

	@JsonProperty("items")
	private List<ItemsItem> items;

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	public List<ItemsItem> getItems(){
		return items;
	}
}