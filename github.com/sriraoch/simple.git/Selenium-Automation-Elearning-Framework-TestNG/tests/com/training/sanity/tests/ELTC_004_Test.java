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
import com.training.pom.ELTC_004_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_004_Test {

	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private ELTC_004_POM eltc_004_pom;
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
		eltc_004_pom = new ELTC_004_POM(driver);
		eltc_002_pom = new ELTC_002_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		eltc_002_pom.sendId("Shashirao");
		eltc_002_pom.sendPassword("goodluck!");
		eltc_002_pom.clickLoginBtn();
		//driver.quit();// close the browser
	}

	// Call the Methods
	@Test
	public void editProfileTest() throws InterruptedException {
		eltc_004_pom.iLostMyPassword();
		eltc_004_pom.sendMessage("sriraoibm@gmail.com");
		eltc_004_pom.sendMessgeButton();
		screenShot.captureScreenShot("editProfile");
		
	}

}
