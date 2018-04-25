package com.backend.restbackend.image.model;

import com.backend.restbackend.common.SuccResponse;

/*
 * Its showing Image JSON response for saving image
 * **/

public class ImageModel extends SuccResponse{
	
	ImageResponse imageResponse;

	public ImageResponse getImageResponse() {
		return imageResponse;
	}

	public void setImageResponse(ImageResponse imageResponse) {
		this.imageResponse = imageResponse;
	}
	

	

}
