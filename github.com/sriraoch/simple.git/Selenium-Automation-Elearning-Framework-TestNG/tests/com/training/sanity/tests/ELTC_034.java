package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELTC_031_POM;
import com.training.pom.ELTC_032_POM;
import com.training.pom.ELTC_034_POM;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_034 {
	// Varibale/Object Reference
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePOM homePOM;
	private ELTC_032_POM eltc_032_POM;
	private ELTC_034_POM eltc_034_POM;
	private static Properties properties;
	private ScreenShot screenShot;

	// Pre-Condition: Read Properties Files
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	// Pre Condition: Launch and Open the browser; Enter UserName and Password.
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);// Launch the broswer
		loginPOM = new LoginPOM(driver);
		eltc_032_POM= new ELTC_032_POM(driver);
		eltc_034_POM = new ELTC_034_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);// Open the broswer
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		loginPOM.sendUserName(properties.getProperty("username"));// Enter UserName
		loginPOM.sendPassword(properties.getProperty("password"));// Enter Password
		loginPOM.clickLoginBtn();// Click on Login Button
	}

	@AfterMethod
	public void tearDown() throws Exception {
		//driver.quit();// Quit the browser
	}
	@Test
	public void createTestAndReport()
	{
		eltc_032_POM.clickOnCourseLink(properties.getProperty("searchCourseName"));// Click on Course created
		eltc_034_POM.clickOnTestLink();// Click on Test Link
		eltc_034_POM.clickOnNewTestLink();// Click on New Test link
		eltc_034_POM.enterTestName(properties.getProperty("testName"));// Enter test name
		eltc_034_POM.clickOnAdvanceSetting();// Click on advance setting
		eltc_034_POM.clickOnfeedBackCheckBox();// Click on feedback link
		eltc_034_POM.clickOnStartTimeCheckBox();// Click on enabl start time
		eltc_034_POM.clickOnDateTextBox();// Click on date textbox
		eltc_034_POM.clickOnMonthDropdown();// Select the month
		eltc_034_POM.clickOnYearDropdown();// Select the year
		eltc_034_POM.clickOnDate();// Select date
		eltc_034_POM.clickOnDatedone();// Click on done date button
		eltc_034_POM.enterPassPercentage(properties.getProperty("percentage"));// Enter pass percentage
		eltc_034_POM.clickOnProceedToQues();// Click on proceed to questions
		eltc_034_POM.clickOnMulChoice();// Click oN mulChoice
		eltc_034_POM.enterQuestionName(properties.getProperty("quetsionName"));
		eltc_034_POM.enterFirstOption();
	}
}
