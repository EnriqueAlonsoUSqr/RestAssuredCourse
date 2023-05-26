package com.baseApi;

import org.json.simple.parser.*;
import org.testng.Reporter;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileReader;
import java.io.IOException;

public class CoreApi {
	private enum requests  {Post, Put};
	private Object requestObj;
	
	private String baseUri= "https://reqres.in/api/";
	
	public void SetJsonRequest(String jsonPath) throws IOException, ParseException {
		JSONParser json = new JSONParser();
		FileReader reader = new FileReader(jsonPath);
		requestObj = json.parse(reader);
		Reporter.log("Current File : " +requestObj.toString());
	}
	
	public Response Get(String path) {
		RestAssured.baseURI = baseUri;
		RequestSpecification httpRequest = RestAssured.given();
		return httpRequest.get(path);
	}
	
	private Response SendData(requests type, String jsonPath, String requestPath) throws IOException, ParseException {
		SetJsonRequest(jsonPath);
		RestAssured.baseURI = baseUri; 
		RequestSpecification httpRequest = RestAssured.given(); 
		
		httpRequest.headers("Content-Type", "application/json");
		httpRequest.body(requestObj.toString());
		
		if(type == requests.Post) {
			return httpRequest.post(requestPath);
		}
		else {
			return httpRequest.put(requestPath);
		}
		
	}
	
	public Response Post(String jsonPath, String requestPath) throws IOException, ParseException {
		
		return SendData(requests.Post, jsonPath, requestPath);
	}
	
	public Response Put(String jsonPath, String requestPath)  throws IOException, ParseException {
		return SendData(requests.Put, jsonPath, requestPath);
	}
	
}
