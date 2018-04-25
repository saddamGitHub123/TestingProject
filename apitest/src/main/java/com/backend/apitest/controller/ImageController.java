/**
 * 
 */
package com.backend.apitest.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.backend.restbackend.common.JsonModelClass;
import com.backend.restbackend.common.SuccResponse;
import com.backend.restbackend.dao.ImageDAO;
import com.backend.restbackend.image.dto.ImageValue;
import com.backend.restbackend.image.model.ImageModel;
import com.backend.restbackend.image.model.ImageResponse;
import com.fasterxml.jackson.annotation.JsonView;


/**
 * @author Sk Saddam Hosan
 *
 * 18-Apr-2018
 */

//The Controller has two methods Get and Save. 
//Save takes two parameters - User_ID as String and Image as Byte[]
//Get takes one parameter - User_ID as String and Returns Image as Byte[]

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
@EnableWebMvc
@RequestMapping("image")
public class ImageController {
	
	private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

	@Autowired
	public ImageDAO imageDAO;
	
	
	
	//Request URL -> http://192.168.2.127:8080/apitest/image/save (Replace the IP with your own IP/domain)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody SuccResponse  imageSave(HttpServletRequest request, @RequestBody ImageValue imageValue ) {
		
		
		
		logger.info(" Entered imageSave() in imageController  - Send User_ID and Image");
		SuccResponse response = new SuccResponse();
		
		try {
			
			byte[] image = imageValue.getImage();
			//byte[] origLength = 1024;
			int value = image.length;
			System.out.println("the image legth is : "+image.length);
			if( value >= 67108864 ) {
				response.setStatus_code("400");
				response.setStatus_message("image too large");
				return response;
			}
			
			
			//ImageRequest imageRequest = new ImageRequest();
			//checking image is saving or not
			
			if(imageDAO.saveImageByByte(imageValue)) {			
				
				response.setStatus_code("200");
				response.setStatus_message("Succssufully upload");
				return response;
				
			}
			else {
				response.setStatus_code("400");
				response.setStatus_message("Upload Failed");
				return  response; 
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}			
	}
	
	/*
	 * Get the particuler Image
	 * **/
	
	// Request URL -> http://192.168.2.127:8080/apitest/image/get (Replace the IP with your own IP/Domain)
	//Return the Image that matches the User_ID
	
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public @ResponseBody ImageModel  getSavingImage(@RequestBody ImageValue imageValue ) {
		
		
		
		logger.info("User_ID Entered getSavingImage() in ImageController ");
		ImageModel imageModel = new ImageModel();
		ImageResponse imageResponse = null;
		try {
			
			
			String User_ID = imageValue.getUser_ID();
			
			//Searches the Image in DB based on the Parameter User_ID
			ImageValue allImageValue = imageDAO.getImageValue(User_ID);
			
			
			if(allImageValue != null) {
				imageResponse = new ImageResponse(allImageValue.getImage());
				imageModel.setImageResponse(imageResponse);
				imageModel.setStatus_code("200");
				imageModel.setStatus_message("Succsfully getting Image list");
				return imageModel;
			}
			else {
				//imageResponse = new ImageResponse(allImageValue.getImage());
				imageModel.setImageResponse(imageResponse);
				imageModel.setStatus_code("400");
				imageModel.setStatus_message("Image Not Found");
				return imageModel;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}			
	}
	
	
	/**
	 * getting different json format using jsonview
	 * **/
	

	/*
	 * Get the particuler Image
	 * **/
	
	// Request URL -> http://192.168.2.127:8080/apitest/image/get (Replace the IP with your own IP/Domain)
	//Return the Image that matches the User_ID
	
	
	
	@JsonView(JsonModelClass.PublicView.class)
	@RequestMapping(value = "/get/jsonview", method = RequestMethod.POST)
	public @ResponseBody ImageValue  getSavingImageUsingJSONView(@RequestBody ImageValue imageValue ) {
		
		
		
		logger.info("User_ID Entered getSavingImage() in ImageController ");

		try {
			
			
			String User_ID = imageValue.getUser_ID();
			
			//Searches the Image in DB based on the Parameter User_ID
			ImageValue allImageValue = imageDAO.getImageValueUsingJSONView(User_ID);
			
		//	JsonView.with(allImageValue).onClass(ImageValue.class, match().exclude("contains"));
			
			
			if(allImageValue != null) {

				return allImageValue;
			}
			else {

				return allImageValue;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}			
	}
	
	
	

}
