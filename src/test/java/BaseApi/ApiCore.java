package BaseApi;

import org.json.JSONObject;
import org.json.simple.parser.*;
import org.testng.Reporter;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileReader;
import java.io.IOException;

public class ApiCore {
	private String baseUri = "https://reqres.in/api/";
	
	private Object request;
	
	public void SetFile(String jsonPath) throws IOException, ParseException {
		JSONParser json = new JSONParser();
		FileReader reader = new FileReader(jsonPath);
		request = json.parse(reader);
		Reporter.log("Current File : " +request.toString());
	}
	
	public Response PostLogin(String jsonPath, String uriPath) throws IOException, ParseException {
		 SetFile(jsonPath);
	  
		 RestAssured.baseURI = baseUri; 
		 RequestSpecification httpRequest = RestAssured.given(); 
		 httpRequest.headers("Content-Type", "application/json");
		 httpRequest.body(request.toString());
		 return httpRequest.post(uriPath);
		
	}

}
