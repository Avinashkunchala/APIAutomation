package com.APIAutomation.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import io.restassured.RestAssured;


@Listeners(com.APIAutomation.Listeners.TestNGListeners.class)


public class TestBase {

	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();

			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//config.properties");
			prop.load(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@BeforeTest
	
	public void baseURL() {
		
		RestAssured.baseURI=prop.getProperty("baseURI");
	}

}
