package com.restapi.back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "user")
public class UserData {
	public UserData() {
		super();
	}
	public UserData(long userid, String username, String useremail, String userpass) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.userpass = userpass;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private long userid;
	@Column(name = "user_name", nullable = false)
    private String username;
	@Column(name = "user_email", nullable = false)
    private String useremail;
	@Column(name = "user_pass", nullable = false)
    private  String userpass;
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
}
