package com.unosquare;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;

public class SecondPostPr {
	Object objectRequest;
	String baseURI = "https://reqres.in/api";
  @Test
  public void f() {
	  	RestAssured.baseURI = baseURI; 
		 RequestSpecification httpRequest = RestAssured.given(); 
		 httpRequest.headers("Content-Type", "application/json");
		 httpRequest.body(objectRequest.toString());
		 Response response = httpRequest.post("/users");
		 Reporter.log("Created register with the following values: "+objectRequest.toString());
		 Reporter.log(" | Response Body: "+ response.body().asPrettyString());
		 Reporter.log(" | Response Code: "+ response.getStatusCode() );
		 Reporter.log(" | URL: "+ baseURI+"/users");
  }
  @BeforeMethod
  public void beforeMethod() throws IOException, ParseException{
	  JSONParser json = new JSONParser();
	  FileReader reader = new FileReader(".\\Json\\CreateJob.json");
	  objectRequest = json.parse(reader);
  }
  

}
