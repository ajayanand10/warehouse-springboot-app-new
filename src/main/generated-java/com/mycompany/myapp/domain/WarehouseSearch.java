package com.mycompany.myapp.domain;

import com.google.common.base.MoreObjects;

public class WarehouseSearch {
	
	private String location;
	private String type;
	private Integer minStorageSize;
	private Integer maxStorageSize;
	
	//more fields to add in Search
	
	
	
	
	// getters and setters
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	 public Integer getMinStorageSize() {
		return minStorageSize;
	}
	public void setMinStorageSize(Integer minStorageSize) {
		this.minStorageSize = minStorageSize;
	}
	public Integer getMaxStorageSize() {
		return maxStorageSize;
	}
	public void setMaxStorageSize(Integer maxStorageSize) {
		this.maxStorageSize = maxStorageSize;
	}
	
	
	
	@Override
	    public String toString() {
	        return MoreObjects.toStringHelper(this) //
	                .add("location", getLocation()) //
	                .add("minStorage", getMinStorageSize()) //
	                .add("maxStorage", getMaxStorageSize()) //
	                .add("type", getType()) //
	                .toString();
	    }
	
	
    

}
