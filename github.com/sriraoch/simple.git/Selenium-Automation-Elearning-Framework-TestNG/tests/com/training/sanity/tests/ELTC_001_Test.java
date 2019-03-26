package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELTC_001_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_001_Test {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ELTC_001_POM eltc_001_POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUp() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		eltc_001_POM = new ELTC_001_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		// Login to the applications
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("First");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	// Validating message to verify password and confirm password are same.
	@Test
	public void validPwChangeTest() throws Exception {
		eltc_001_POM.clickSignupbtn();
		eltc_001_POM.sendFirstname("Srini");
		eltc_001_POM.sendLastname("Rao");
		eltc_001_POM.senduserName("srirao");
		eltc_001_POM.sendPassword("Yamaha27");
		eltc_001_POM.sendConfirmPassword("Yamaha27!");
		eltc_001_POM.sendPhoneNumber("9876543210");
		eltc_001_POM.selectLanguageDropDown("English");
		eltc_001_POM.selectStudentradiobtn();
		eltc_001_POM.registerButtonClick();
	}

}
