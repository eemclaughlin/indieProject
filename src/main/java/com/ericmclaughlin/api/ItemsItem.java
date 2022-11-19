package com.ericmclaughlin.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Items item.
 */
public class ItemsItem{

	@JsonProperty("volumeInfo")
	private VolumeInfo volumeInfo;

	/**
	 * Set volume info.
	 *
	 * @param volumeInfo the volume info
	 */
	public void setVolumeInfo(VolumeInfo volumeInfo){
		this.volumeInfo = volumeInfo;
	}

	/**
	 * Get volume info volume info.
	 *
	 * @return the volume info
	 */
	public VolumeInfo getVolumeInfo(){
		return volumeInfo;
	}
}