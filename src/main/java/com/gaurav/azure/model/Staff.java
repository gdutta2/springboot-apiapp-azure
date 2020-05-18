package com.gaurav.azure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Staffs_New")

public class Staff {
	private Integer staff_id;
	private String first_name;
	private String last_name;
	private String email;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(Integer staff_id) {
		this.staff_id = staff_id;
	}
	
	@Column(name = "first_name", nullable = false)
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Staff [staff_id=" + staff_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + "]";
	}
	public Staff() {
		
	}
	public Staff(Integer staff_id, String first_name, String last_name, String email) {
		super();
		this.staff_id = staff_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}
	
}
