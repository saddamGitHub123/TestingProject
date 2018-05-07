package com.backend.restbackend.dao;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpEntity;

import com.backend.restbackend.page.dto.AppToken;

public interface PageDAO {
	
	
	CompletableFuture<String> send (HttpEntity<String> entity);
	
	
	//   creating the methode of new token and svae into databse 
	
     AppToken CreateTokenAndSave();
     
     
     //validation for the app token 
     
     AppToken validateAppToken(AppToken appToken);
     
     
     //Getting random token value using randomTokenValue() method
     
     AppToken randomTokenValue();
}
