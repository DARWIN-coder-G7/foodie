package com.restapi.back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table( name = "order_data")
public class Order {
	public Order() {
		super();
	}
	public Order(long id, String email, String address, String contact, double totalprice, long userid) {
		super();
		this.id = id;
		this.email = email;
		this.address = address;
		this.contact = contact;
		this.totalprice = totalprice;
		this.userid = userid;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", nullable = false)
	private long id;
	@Column(name = "email", nullable = false)
    private String email;
	@Lob
	@Column(name = "address", nullable = false)
    private String address;
	@Column(name = "contact", nullable = false)
    private String contact;
	@Column(name = "totalprice", nullable = false)
    private double totalprice;
	@Column(name = "user_id", nullable = false)
    private long userid;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}

}
