package com.APIAutomation.Utilities;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class VerificationUtility {
	
	public static void responseCodeValiddation(Response response, int statusCode) {

		try {
			Assert.assertEquals(statusCode, response.getStatusCode());
			
			System.out.println("Successfully validdated status code, status code is :: " + response.getStatusCode());
			
		} catch (AssertionError e) {
			
			System.out.println(e.fillInStackTrace());
			
			System.out.println("Expected status code is :: " + statusCode + " , insted of getting :: " + response.getStatusCode());
			
		} catch (Exception e) {
			
			System.out.println(e.fillInStackTrace());
			
		}
	}
	
	public static void responseTimeValidation(Response response) {
		try {
			
			long time=response.time();
			
			System.out.println("Api response time is :: " + time);
			
		} catch (Exception e) {
			
			System.out.println(e.fillInStackTrace());
		}
	}

}
