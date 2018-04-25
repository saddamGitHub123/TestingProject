package com.backend.restbackend.image.model;

import java.util.Arrays;
/**
 * Image JSON response class for showing the particular image from database
 * */
public class ImageResponse {
	private byte[] image;

	public ImageResponse() {
	}
	
	
	public ImageResponse(byte[] image) {
		super();
		this.image = image;
	}

	@Override
	public String toString() {
		return "ImageResponse [image=" + Arrays.toString(image) + "]";
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
}
