package com.APIAutomation.Tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.APIAutomation.TestBase.TestBase;
import com.APIAutomation.Utilities.VerificationUtility;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class getAllRepos extends TestBase{
	
	
	@Test (description="Verifying the Repository API")
	
	public void getRequest() {
		
		Response response=RestAssured.given().request(Method.GET, prop.getProperty("repositories"));
		
		// validating the response code of the API 
		VerificationUtility.responseCodeValiddation(response, 200);
		
		
		// Validating the response of the API
		
		VerificationUtility.responseTimeValidation(response);
		
		
		// Printing the response body 
		
		System.out.print(response.getBody().asString());
		
		
		// Printing the name of the repository , stars and no of watchers
		
		JSONArray result=new JSONArray(response.getBody().asString());
		
		for (int i=0;i<result.length();i++) {
			
			JSONObject value=result.getJSONObject(i);
			
			System.out.println("Repository name is: " + value.get("name"));
			
			System.out.println("No of stars: " +value.get("stargazers_count"));
			
			System.out.println("No of watchers: "+ value.get("watchers"));
		}
		
		
	}

}
