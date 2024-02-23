package com.api.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
		
	public Response response;
	public Map<String, Object> session = new HashMap<String, Object>();
	private static final String CONTENT_TYPE = PropertiesFile.getProperty("content.type");
	
	public RequestSpecification requestSetup() {	
		RestAssured.reset();
		RestAssured.baseURI = PropertiesFile.getProperty("baseURL");	
		return RestAssured.given()
				.filter(new RestAssuredRequestFilter())				
				.contentType(CONTENT_TYPE)
				.accept(CONTENT_TYPE);
	} 
}
