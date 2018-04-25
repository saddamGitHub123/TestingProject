package com.backend.restbackend.image.dto;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.backend.restbackend.common.JsonModelClass;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

/*
 * This is image entity class it's connect from database as well as image model class for request json
 * **/

@Entity
@Table(name = "testing")
public class ImageValue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	
	
	private String User_ID;
	@JsonView(JsonModelClass.PublicView.class)
	
	
	@Lob
	@Column( length = 100 )
	private byte[] image;
	@Override
	public String toString() {
		return "ImageValue [ID=" + ID + ", User_ID=" + User_ID + ", image=" + Arrays.toString(image) + "]";
	}
	@JsonIgnore
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(String user_ID) {
		User_ID = user_ID;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	


}
