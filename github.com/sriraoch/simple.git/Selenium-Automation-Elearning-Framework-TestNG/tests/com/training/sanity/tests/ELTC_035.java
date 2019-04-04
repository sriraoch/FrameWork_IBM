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
//import com.training.pom.ELTC_007POM;
import com.training.pom.ELTC_032_POM;
import com.training.pom.ELTC_035_POM;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_035 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePOM homePOM;
	private ELTC_035_POM eltc_035_POM;
	private ELTC_032_POM eltc_032_POM;
	private static Properties properties;
	private ScreenShot screenShot;
	// Read Properties file
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	// Launching/Opening with E-learning URL
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);//Launch Browser
		loginPOM = new LoginPOM(driver);
		eltc_032_POM= new ELTC_032_POM(driver);
		eltc_035_POM= new ELTC_035_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);// Opening Browser
		loginPOM.sendUserName(properties.getProperty("username"));// Enter Username
		loginPOM.sendPassword(properties.getProperty("password"));// Enter Password
		loginPOM.clickLoginBtn();// Click on Login Button
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();// Quiting the browser
	}
	//Add New Course Details
	@Test
	public void addNewCourseTest() throws InterruptedException {
		eltc_032_POM.clickOnCourseLink(properties.getProperty("searchCourseName"));// Search for CourseName
		eltc_035_POM.clickOnTestLink();// Click on particular Test
		eltc_035_POM.selectParticularTest(properties.getProperty("testName"));//Click on testName
		eltc_035_POM.selectGradeLink();// Select Grade link
		String expectedMessage="Congratulations you passed the test!";
		String actualMessage= eltc_035_POM.getMessge();// Get Actual Message
		Assert.assertEquals(actualMessage, expectedMessage);// Perform Assertion on Message
		eltc_035_POM.selectCheckBox();// Select Checkbox
		eltc_035_POM.clickOnCorrectButton();//Click on Send Email, As we have not configured email so just clicking on the button
		}

}
