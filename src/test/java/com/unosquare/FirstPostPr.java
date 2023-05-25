package com.unosquare;

import org.json.JSONObject;
import org.json.simple.parser.*;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.*;

import java.io.FileReader;
import java.io.IOException;

public class FirstPostPr {
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
  public void beforeMethod() throws IOException, ParseException {
	  JSONParser json = new JSONParser();
	  FileReader reader = new FileReader(".\\Json\\Register.json");
	  objectRequest = json.parse(reader);
  }

}
