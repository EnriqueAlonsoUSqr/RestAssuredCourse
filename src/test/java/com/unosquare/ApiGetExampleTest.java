package com.unosquare;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;

public class ApiGetExampleTest {
  @Test
  public void f() {
	  RestAssured.baseURI = "https://reqres.in/api/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/users/2");
		
		int statusCode = response.getStatusCode();

		// Assert that correct status code is returned.
		Assert.assertEquals(statusCode,200);
		Reporter.log("Sucess 200 validation");
		
		response.then().body("data.first_name", equalTo("Janet"));
		response.then().body("data.last_name", equalTo("Weaver"));
		Reporter.log(response.body().asString());
  }
  @BeforeMethod
  public void beforeMethod() {
  }

}
