package com.unosquare;

import io.restassured.response.Response;
import junit.framework.Assert;

import org.testng.annotations.Test;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeSuite;

import BaseApi.ApiCore;
public class EncapsulationTest {
	ApiCore apiCore;
  @Test
  public void f() throws IOException, ParseException {
	  Response test = apiCore.PostLogin(".\\Json\\LogIn.json", "/login");
	  Assert.assertEquals(200, test.getStatusCode());
  }
  @BeforeSuite
  public void beforeSuite() {
	  apiCore= new ApiCore();
  }

}
