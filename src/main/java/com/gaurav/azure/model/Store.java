package com.gaurav.azure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Store_New")

public class Store {
	private Integer store_id;
	private String store_name;
	private String phone;
	private String email;
	private String street;
	private String city;
	private String state;
	private Integer zip_code;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	
	@Column(name = "store_name", nullable = false)
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	
	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "street")
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	@Column(name = "city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name = "zip_code")
	public Integer getZip_code() {
		return zip_code;
	}
	public void setZip_code(Integer zip_code) {
		this.zip_code = zip_code;
	}
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Store(Integer store_id, String store_name, String phone, String email, String street, String city,
			String state, Integer zip_code) {
		super();
		this.store_id = store_id;
		this.store_name = store_name;
		this.phone = phone;
		this.email = email;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip_code = zip_code;
	}
	
	@Override
	public String toString() {
		return "Stores [store_id=" + store_id + ", store_name=" + store_name + ", phone=" + phone + ", email=" + email
				+ ", street=" + street + ", city=" + city + ", state=" + state + ", zip_code=" + zip_code + "]";
	}
	
	
}
