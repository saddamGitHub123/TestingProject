package com.backend.restbackend.common;

/**
 * This is the JSON Response class  using JSON view 
 * we can used interface inheritance also like - 
 * */
public class JsonModelClass {
	
	public interface PublicView {}
	
	public interface PublicViewDemo extends PublicView {}
	
	public interface LoginJsonResponse{}

}
