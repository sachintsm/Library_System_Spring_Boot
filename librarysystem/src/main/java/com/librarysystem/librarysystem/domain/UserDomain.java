package com.librarysystem.librarysystem.domain;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserDomain {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
	private int userId;
	
	@Column(name = "user_fname")
	private String fname;
	
	@Column(name = "user_lname")
	private String lname;
	
	@Column(name = "user_address")
	private String address;
	
	@Column(name = "user_telephone")
	private String telephone;
	
	@Column(name = "user_email")
	private String email;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
