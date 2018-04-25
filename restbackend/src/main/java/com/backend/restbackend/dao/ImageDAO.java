package com.backend.restbackend.dao;

import com.backend.restbackend.image.dto.ImageValue;

/**
 * @author Sk Saddam Hosan
 *
 */
public interface ImageDAO {
	
	
	//for saving the image from user method 
	boolean saveImageByByte(ImageValue imageValue);
	
	
	//getting particular image from database using User_ID
	ImageValue getImageValue(String User_ID);
	
	
	//getting particular image from database using User_ID
		ImageValue getImageValueUsingJSONView(String User_ID);

}
