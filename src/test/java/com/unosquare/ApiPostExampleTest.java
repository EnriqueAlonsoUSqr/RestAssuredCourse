package com.unosquare;

import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiPostExampleTest {
  @Test
  public void f() {
	  JSONObject requestParams = new JSONObject();
	  requestParams.put("name","JohnAPI");
	  requestParams.put("job","QA");
	  
		 RestAssured.baseURI = "https://reqres.in/api"; 
		 RequestSpecification httpRequest = RestAssured.given(); 
		 httpRequest.headers("Content-Type", "application/json");
		 httpRequest.body(requestParams.toString());
		 Response response = httpRequest.post("/users");
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

}
