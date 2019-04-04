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
import com.training.pom.ELTC_032_POM;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_032 {
	//Variable/Object reference initilization
		private WebDriver driver;
		private String baseUrl;
		private LoginPOM loginPOM;
		private ELTC_032_POM eltc_032;
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
			eltc_032= new ELTC_032_POM(driver);
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
		public void unSubscriberuser() throws InterruptedException {
			eltc_032.clickOnCourseLink(properties.getProperty("searchCourseName"));// Click on Course link
			eltc_032.clickOnUserLink();// Click on User Link
			eltc_032.selectCourseCheckBox();// Click on course Check Box
			eltc_032.clickOnUnSubscribe();//Click on unsubscribe button
			
		}


}
