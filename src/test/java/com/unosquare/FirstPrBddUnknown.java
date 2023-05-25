package com.unosquare;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.equalTo;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import static io.restassured.RestAssured.*;

public class FirstPrBddUnknown {
  @Test
  public void f() {
	  given()
	  .when()
	  	.get("https://reqres.in/api/unknwon/2")
	  	.then()
	  		.assertThat()
	  			.statusCode(200)
	  		.assertThat()
	  			.contentType(ContentType.JSON)
	  		.assertThat()
	  			.body("data.name", equalTo("fuchsia rose"))
	  		.assertThat()
	  			.body("data.year", equalTo(2001))
	  		.assertThat()
	  			.body("data.id", equalTo(2))
	  		.assertThat()
	  			.body("data.color", equalTo("#C74375"))
	  		.assertThat()
	  			.body("data.pantone_value", equalTo("17-2031"))
	  			
	  		.assertThat()
	  			.body("support.url", equalTo("https://reqres.in/#support-heading"))
	  		.assertThat()
	  			.body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"))
	  		;
	  
	  Reporter.log("Sucess 200 validation");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  
  }

}
