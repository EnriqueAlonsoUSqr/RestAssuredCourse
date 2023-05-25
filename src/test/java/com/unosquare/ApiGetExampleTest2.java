package com.unosquare;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import static io.restassured.RestAssured.*;

public class ApiGetExampleTest2 {
  @Test
  public void f() {
	  given()
	  .when()
	  	.get("https://reqres.in/api/users/2")
	  		.then().assertThat().statusCode(200).assertThat().contentType(ContentType.JSON)
	  		;
	  
	  Reporter.log("Sucess 200 validation");
  }
  @BeforeMethod
  public void beforeMethod() {
  }

}
