package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;

import com.training.pom.ELTC_002_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_002_Test {

	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private ELTC_002_POM eltc_002_pom;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		eltc_002_pom = new ELTC_002_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();// close the browser
	}

	// Call the Methods
	@Test
	public void editProfileTest() {
		eltc_002_pom.sendId("Shashirao");
		System.out.println("Shashirao");
		eltc_002_pom.sendPassword("Yamaha27!");
		System.out.println("Yamaha28");
		eltc_002_pom.clickLoginBtn();
		
		/*System.out.println("Profile page is displayed.");
		eltc_002_pom.sendPass("Yamaha27!");
		System.out.println("Yamaha27!");
		eltc_002_pom.sendNewPassword("Yamaha28!");
		System.out.println("Yamaha28!");
		eltc_002_pom.sendConfirmPassword("Yamaha28!");
		System.out.println("Yamaha28!");
		eltc_002_pom.saveSettingsBtn();
		String expectedResult = "Your new profile has been saved";
		String actualResult = eltc_002_pom.getTextForSaveSettings();
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("The message is :Your new profile has been saved");
		screenShot.captureScreenShot("editProfile");*/
	}
}

