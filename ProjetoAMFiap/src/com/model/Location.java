package com.model;

public class Location {
	private int user_id;
	private String country;
	private String address;
	
	public Location() {
		
	}
	
	public Location(int user_id, String country, String address) {
		super();
		this.user_id = user_id;
		this.country = country;
		this.address = address;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Location [user_id=" + user_id + ", country=" + country + ", address=" + address + "]";
	}
	
}
