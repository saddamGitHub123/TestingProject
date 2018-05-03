package com.backend.restbackend.dao;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpEntity;

public interface PageDAO {
	
	
	CompletableFuture<String> send (HttpEntity<String> entity);

}
