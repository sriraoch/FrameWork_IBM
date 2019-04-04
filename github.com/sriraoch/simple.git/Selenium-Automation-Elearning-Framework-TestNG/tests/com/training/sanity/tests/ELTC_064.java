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
import com.training.pom.ELTC_064_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_064 {
		private WebDriver driver;
		private String baseUrl;
		private static Properties properties;
		private ScreenShot screenShot;
		private ELTC_064_POM eltc_064_POM;


		@BeforeClass
		public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		}

		@BeforeMethod
		public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			eltc_064_POM = new ELTC_064_POM(driver);
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver);
			// open the browser
			driver.get(baseUrl);
		}

		@AfterMethod
		public void tearDown() throws Exception {
			driver.quit();
		}

		@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
		public void loginDBTest(String categoryCode, String categoryName, String title, String code, String category, String language) throws Exception {
			eltc_064_POM.sendUserName("admin");
			eltc_064_POM.sendPassword("admin@123");
			eltc_064_POM.clickLoginBtn();
			eltc_064_POM.clickCourseCategory();
			eltc_064_POM.clickAddCategory();
			eltc_064_POM.sendCategoryCode(categoryCode);
			eltc_064_POM.sendCategoryName(categoryName);
			eltc_064_POM.clickAllowCoursesRdBtn();
			eltc_064_POM.clickAddCategoryBtn();
			eltc_064_POM.clickAdministration();
			eltc_064_POM.clickCreateACourse();
			eltc_064_POM.sendTitle(title);
			eltc_064_POM.sendCode(code);
			eltc_064_POM.selectCategoryDropDown(category);
			//eLTC_073POM.sendTeacher("ujjwal kumari (uk_122)");
			eltc_064_POM.selectlanguageDropDown(language);
			eltc_064_POM.clickCreateACourseBtn();
		}

	}
