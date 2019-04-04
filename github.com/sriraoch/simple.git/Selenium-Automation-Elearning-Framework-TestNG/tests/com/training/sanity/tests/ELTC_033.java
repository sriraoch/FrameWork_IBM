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
import com.training.pom.ELTC_031_POM;
import com.training.pom.ELTC_032_POM;
import com.training.pom.ELTC_033_POM;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_033 {
	//Variable/Object reference initilization
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePOM homePOM;
	private ELTC_031_POM eltc_031_POM;
	private ELTC_032_POM eltc_032_POM;
	private ELTC_033_POM eltc_033_POM;
	private static Properties properties;
	private ScreenShot screenShot;

	// Read properties File
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");// Reading porperties file
		properties.load(inStream);
	}
	//Launch/Open the browser and Elearning application with given credentials
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);// Launch browser
		loginPOM = new LoginPOM(driver);
		homePOM = new HomePOM(driver);
		eltc_031_POM = new ELTC_031_POM(driver);
		eltc_032_POM = new ELTC_032_POM(driver);
		eltc_033_POM = new ELTC_033_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);// Open the browser
		loginPOM.sendUserName(properties.getProperty("username"));// Enter Username
		loginPOM.sendPassword(properties.getProperty("password"));// Enter Password
		loginPOM.clickLoginBtn();// Click on Login Button
	}
	// Quiting the browser
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();// Quit the browser
	}

	// Serach the Courses
	@Test
	public void searchCoureses() {
		eltc_033_POM.clickOnCourseCatalog();// Click on Course catalog link
		eltc_033_POM.enterSearchCatalogText(properties.getProperty("searchCatalogText"));// Enter searchtext in textbox area
		eltc_033_POM.clickOnSubmitButton();//Click on Submit button
		String expected="Search results for: "+ properties.getProperty("searchCatalogText");
		String actual=eltc_033_POM.getSerachResults();
		Assert.assertEquals(actual, expected);// Validating the text present on web page
	}

}
