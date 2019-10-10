package com.model;

public class JobOpening {
	private int jo_code;
	private String title;
	private String overview;
	private String country;
	private String city;
	private String address;
	private String description;
	
	public JobOpening() {
		
	}

	public JobOpening(int jo_code, String title, String overview, String country, String city, String address,String description) {
		super();
		this.jo_code = jo_code;
		this.title = title;
		this.overview = overview;
		this.country = country;
		this.city = city;
		this.address = address;
		this.description = description;
	}
	
	public JobOpening(String title, String overview, String country, String city, String address,String description) {
		super();
		this.title = title;
		this.overview = overview;
		this.country = country;
		this.city = city;
		this.address = address;
		this.description = description;
	}

	public int getJo_code() {
		return jo_code;
	}

	public void setJo_code(int jo_code) {
		this.jo_code = jo_code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "JobOpening [jo_code=" + jo_code + ", title=" + title + ", overview=" + overview + ", country=" + country
				+ ", city=" + city + ", address=" + address + ", description=" + description + "]";
	}
	
}
