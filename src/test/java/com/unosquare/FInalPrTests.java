package com.unosquare;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import com.baseApi.CoreApi;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.Reporter;

public class FInalPrTests {
	
	CoreApi coreApi;
	
	//Gets
  @Test
  public void GetSingleUser() {
	  Response response = coreApi.Get("users/2");
	  
	  int statusCode = response.getStatusCode();

	  Assert.assertEquals(statusCode,200);
	  Reporter.log("Sucess 200 validation");
	
	  response.then().body("data.first_name", equalTo("Janet"));
	  response.then().body("data.last_name", equalTo("Weaver"));
	  response.then().body("data.email", equalTo("janet.weaver@reqres.in"));
	  response.then().body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"));
	  
	  response.then().body("data.id", equalTo(2));
	  Reporter.log(response.body().asString());
	  
  }
  @Test
  public void GetListUnknowns() {
Response response = coreApi.Get("unknown");
	  
	  int statusCode = response.getStatusCode();

	  Assert.assertEquals(statusCode,200);
	  Reporter.log("Sucess 200 validation");
	
	  response.then().body("page", equalTo(1));
	  response.then().body("per_page", equalTo(6));
	  response.then().body("total", equalTo(12));
	  response.then().body("total_pages", equalTo(2));
	  
	  Reporter.log(response.body().asString());
  }
  
  @Test
  public void GetSingleUnknown() {
	  Response response = coreApi.Get("unknown/2");
	  
	  int statusCode = response.getStatusCode();

	  Assert.assertEquals(statusCode,200);
	  Reporter.log("Sucess 200 validation");
	
	  response.then().body("data.name", equalTo("fuchsia rose"));
	  response.then().body("data.color", equalTo("#C74375"));
	  response.then().body("data.year", equalTo(2001));
	  response.then().body("data.pantone_value", equalTo("17-2031"));
	  
	  response.then().body("data.id", equalTo(2));
	  Reporter.log(response.body().asString());
  }
  
  @Test
  public void GetUnknownNotFound() {
	  Response response = coreApi.Get("unknown/23");
	  
	  int statusCode = response.getStatusCode();

	  Assert.assertEquals(statusCode,404);
	  Reporter.log("Sucess 404 validation");

	  Reporter.log(response.body().asString());
  }
  
  //Posts
  @Test
  public void PostCreateUser() throws IOException, ParseException {
	  Response response  = coreApi.Post(".\\Json\\Create.json", "/users");
	  
	  int statusCode = response.getStatusCode();
	  Assert.assertEquals(statusCode, 201);
	  
	  response.then().body("name", equalTo("morpheus"));
	  response.then().body("job", equalTo("leader"));
	  
  }
  
  @Test
  public void PostRegister() throws IOException, ParseException {
	  Response response  = coreApi.Post(".\\Json\\Register.json", "/register");
	  
	  int statusCode = response.getStatusCode();
	  Reporter.log(response.toString());
	  
	  Assert.assertEquals(statusCode, 200);
  }
  
  @Test
  public void PostRegisterFail() throws IOException, ParseException {
	  Response response  = coreApi.Post(".\\Json\\RegisterFail.json", "/register");
	  
	  int statusCode = response.getStatusCode();
	  Assert.assertEquals(statusCode, 400);
	  
	  response.then().body("error", equalTo("Missing password"));
  }
  
  @Test
  public void PostLogIn() throws IOException, ParseException {
	  Response response  = coreApi.Post(".\\Json\\LogIn.json", "/login");
	  
	  int statusCode = response.getStatusCode();
	  Assert.assertEquals(statusCode, 200);
  }
  
  //Put
  @Test
  public void PutUpdate() throws IOException, ParseException {
	  Response response  = coreApi.Put(".\\Json\\Update.json", "/users/2");
	  
	  int statusCode = response.getStatusCode();
	  Assert.assertEquals(statusCode, 200);
	  
	  response.then().body("name", equalTo("morpheus"));
	  response.then().body("job", equalTo("zion resident"));
  }
  
  @BeforeSuite
  public void beforeSuite() {
	  coreApi = new CoreApi();
  }

}
