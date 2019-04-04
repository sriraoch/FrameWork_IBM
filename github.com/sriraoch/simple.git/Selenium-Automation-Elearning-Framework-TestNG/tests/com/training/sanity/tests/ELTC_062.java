package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.ELTC_062_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_062 {
		private WebDriver driver;
		private String baseUrl;
		private static Properties properties;
		private ScreenShot screenShot;
		private ELTC_062_POM eltc_062_POM;

		@BeforeClass
		public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		}

		@BeforeMethod
		public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			eltc_062_POM = new ELTC_062_POM(driver);
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver);
			// open the browser
			driver.get(baseUrl);
		}

		@AfterMethod
		public void tearDown() throws Exception {
			//driver.quit();
		}

		@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
		public void loginDBTest(String userName, String password, String firstName, String lastName, String eMail, String phoneNumber, String login, String enterPassword, String profile) {
			eltc_062_POM.sendUserName(userName);
			eltc_062_POM.sendPassword(password);
			eltc_062_POM.clickLoginBtn();
			eltc_062_POM.clickAddAUser();
			eltc_062_POM.sendFirstName(firstName);
			eltc_062_POM.sendLastName(lastName);
			eltc_062_POM.sendEMail(eMail);
			eltc_062_POM.sendPhoneNumber(phoneNumber);
			eltc_062_POM.sendLogin(login);
			eltc_062_POM.clickPasswordRd();
			eltc_062_POM.sendEnterPassword(enterPassword);
			eltc_062_POM.selectProfileDropDown(profile);
			eltc_062_POM.clickAdd();
		}

	}
