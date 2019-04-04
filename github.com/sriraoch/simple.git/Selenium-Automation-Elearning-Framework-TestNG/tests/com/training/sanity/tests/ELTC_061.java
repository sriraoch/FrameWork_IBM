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
import com.training.pom.ELTC_061_POM;
//import com.training.pom.ELTC_072POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_061 {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private ELTC_061_POM eltc_061_POM;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		eltc_061_POM = new ELTC_061_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		// driver.quit();
	}

	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String courseName, String testName, String question, String t1) {
		eltc_061_POM.sendUserName("shashi");
		eltc_061_POM.sendPassword("goodLuck99");
		eltc_061_POM.clickLoginBtn();
		eltc_061_POM.clickCreateACourse();
		eltc_061_POM.sendCourseName(courseName);
		eltc_061_POM.clickCreateThisCourse();
		eltc_061_POM.clickTests();
		eltc_061_POM.clickCreateANewCourse();
		eltc_061_POM.sendTestName(testName);
		eltc_061_POM.clickProceedToQuestions();
		eltc_061_POM.clickMultipleChoice();
		eltc_061_POM.sendQuestion(question);
		eltc_061_POM.sendIFrame1(t1);
	}

}
