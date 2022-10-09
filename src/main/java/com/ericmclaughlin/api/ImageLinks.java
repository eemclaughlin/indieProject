package com.ericmclaughlin.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageLinks{

	@JsonProperty("thumbnail")
	private String thumbnail;

	@JsonProperty("smallThumbnail")
	private String smallThumbnail;

	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public void setSmallThumbnail(String smallThumbnail){
		this.smallThumbnail = smallThumbnail;
	}

	public String getSmallThumbnail(){
		return smallThumbnail;
	}
}