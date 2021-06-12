package com.APIAutomation.Tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.APIAutomation.TestBase.TestBase;
import com.APIAutomation.Utilities.VerificationUtility;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;


public class RepoReleases extends TestBase {

	
	@Test(description = "Verifying the Releases Repos API ")

	public void repoAllReleases() {

		Response response = RestAssured.given().request(Method.GET, prop.getProperty("allReleases"));

		// validating the response code of the API
		VerificationUtility.responseCodeValiddation(response, 200);

		// Validating the response of the API

		VerificationUtility.responseTimeValidation(response);
		

		// Printing the response body
		
		System.out.println(response.getBody().asString());
		

		JSONArray result = new JSONArray(response.getBody().asString());
		
		
		// Printing no of releases
		
		System.out.println("The no of releases are: "+result.length());
		
		
		//Printing the all released url and released dates

		for (int i = 0; i < result.length(); i++) {

			JSONObject value = result.getJSONObject(i);

			System.out.println(value.get("url") +   "  ---> " + value.get("published_at"));

		}

	}

}
