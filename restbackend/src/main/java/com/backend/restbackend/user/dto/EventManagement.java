package com.backend.restbackend.user.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="eventmanagement")
public class EventManagement implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	private String SP_ID;
	private String User_ID;
	//List<Date> Block_Date;
	/**
	 * If we used list of data into dto class then u must have to used @ElementCollection annotation 
	 * */
	@ElementCollection
	List<String> Block_Date;
	//java.sql.Timestamp Event_Date;
	//java.sql.Timestamp Start_Date;
	//java.sql.Timestamp End_Date;
	private String Message;
	
	@Override
	public String toString() {
		return "EventManagement [ID=" + ID + ", SP_ID=" + SP_ID + ", User_ID=" + User_ID + ", Block_Date=" + Block_Date
				+ ", Message=" + Message + "]";
	}
	
	public EventManagement() {}

	public EventManagement(String sP_ID, String user_ID, List<String> block_Date, String message) {
		super();
		SP_ID = sP_ID;
		User_ID = user_ID;
		Block_Date = block_Date;
		Message = message;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getSP_ID() {
		return SP_ID;
	}

	public void setSP_ID(String sP_ID) {
		SP_ID = sP_ID;
	}

	public String getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(String user_ID) {
		User_ID = user_ID;
	}

	public List<String> getBlock_Date() {
		return Block_Date;
	}

	public void setBlock_Date(List<String> block_Date) {
		Block_Date = block_Date;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	
	
	
	

	

	
	
	
}
