package com.APIAutomation.Tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.APIAutomation.TestBase.TestBase;
import com.APIAutomation.Utilities.VerificationUtility;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class LastRelease extends TestBase {
	
	@Test(description = "Verfiying the last Release API Repo")

	public void getLastRelease() {

		Response response = RestAssured.given().request(Method.GET, prop.getProperty("lastRelease"));

		// validating the response code of the API
		VerificationUtility.responseCodeValiddation(response, 200);

		// Validating the response of the API

		VerificationUtility.responseTimeValidation(response);
		

		// Printing the response body
		
		System.out.println(response.getBody().asString());
		
		JSONObject value1=new JSONObject(response.getBody().asString());
		
		//Printing the Last release url
		
		System.out.println(value1.get("url"));
			
	}
}
