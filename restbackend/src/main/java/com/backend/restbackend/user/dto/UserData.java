
package com.backend.restbackend.user.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.backend.restbackend.common.JsonModelClass;
import com.fasterxml.jackson.annotation.JsonView;
/**
 * This class used for password encryption 
 * **/
@Entity
@Table(name = "user")
public class UserData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@JsonView(JsonModelClass.LoginJsonResponse.class) 
	@Column(name = "user_name")
	private String userName;

	@JsonView(JsonModelClass.LoginJsonResponse.class) 
	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "password")
	private String password;

	@JsonView(JsonModelClass.LoginJsonResponse.class) 
	@Column(name = "gender")
	private String userGender;

	@JsonView(JsonModelClass.LoginJsonResponse.class) 
	@Column(name = "phone_no")
	private String phoneNo;

	@JsonView(JsonModelClass.LoginJsonResponse.class) 
	@Column(name = "address")
	private String address;

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
}