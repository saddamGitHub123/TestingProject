package com.backend.restbackend.page.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appToken")
public class AppToken implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1776310176062430250L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Token_ID;
	private String Token_Value;
	
	
	// Generate automatically token
	public AppToken() {
	//	this.Token_Value = UUID.randomUUID().toString().substring(26);
		this.Token_Value = UUID.randomUUID().toString().replace("-", "");
	}
	
	
	public AppToken(int token_ID, String token_Value) {
		super();
		Token_ID = token_ID;
		Token_Value = token_Value;
	}
	@Override
	public String toString() {
		return "Token [Token_ID=" + Token_ID + ", Token_Value=" + Token_Value + "]";
	}
	public int getToken_ID() {
		return Token_ID;
	}
	public void setToken_ID(int token_ID) {
		Token_ID = token_ID;
	}
	public String getToken_Value() {
		return Token_Value;
	}
	public void setToken_Value(String token_Value) {
		Token_Value = token_Value;
	}
	
	
	
	
	
}
