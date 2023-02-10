package com.restapi.back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "admin")
public class Admin {
public Admin() {
		super();
	}
public Admin(int adminId, String adminName, String adminKey) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminKey = adminKey;
	}
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "admid", nullable = false)
private int adminId;
@Column(name = "adminname", nullable = false)
private String adminName;
@Column(name = "adminkey", nullable = false)
private String adminKey;
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
public String getAdminName() {
	return adminName;
}
public void setAdminName(String adminName) {
	this.adminName = adminName;
}
public String getAdminKey() {
	return adminKey;
}
public void setAdminKey(String adminKey) {
	this.adminKey = adminKey;
}
}
