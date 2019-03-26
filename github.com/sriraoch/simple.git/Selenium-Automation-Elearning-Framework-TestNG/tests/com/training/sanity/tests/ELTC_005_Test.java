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

import com.training.pom.ELTC_005_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_005_Test {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private ELTC_005_POM eltc_005_pom;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		eltc_005_pom = new ELTC_005_POM(driver);
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
	public void editProfileTest() throws Exception {
		eltc_005_pom.clickSignupbtn();
		eltc_005_pom.sendFirstname("Srini");
		eltc_005_pom.sendLastname("Rao");
		eltc_005_pom.senduserName("srirao");
		eltc_005_pom.sendPassword("Yamaha27");
		eltc_005_pom.sendConfirmPassword("Yamaha27!");
		eltc_005_pom.sendPhoneNumber("9876543210");
		eltc_005_pom.selectLanguageDropDown("English");
		eltc_005_pom.selectTeacherRadiobtn();
		eltc_005_pom.registerButtonClick();
		
	}
}

	



