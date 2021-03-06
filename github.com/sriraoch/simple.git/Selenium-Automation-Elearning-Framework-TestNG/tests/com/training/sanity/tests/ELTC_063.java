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

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.ELTC_063_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_063 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ELTC_063_POM eltc_063_POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		eltc_063_POM= new ELTC_063_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		loginPOM.sendUserName(properties.getProperty("adminUserName"));// Enter Username
		loginPOM.sendPassword(properties.getProperty("admiPassword"));// Enter Password
		loginPOM.clickLoginBtn();// Click on Login Button
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String fieldsName, String firstName, String lastName, String eMail, String phone,String login, String password) {
		eltc_063_POM.clickOnAdminTab();
		eltc_063_POM.clickOnAddNewUser();
		screenShot.captureScreenShot("After Clicking on Add user button");
		eltc_063_POM.enterFirstName(firstName);
		eltc_063_POM.enterLastName(lastName);
		eltc_063_POM.enterEmail(eMail);
		eltc_063_POM.enterUserName(login);
		eltc_063_POM.enterPassword(password);
		eltc_063_POM.clickOnProfileDropDwon();
		eltc_063_POM.clickOnAddUser();
		String expetedMessage= "The user has been added:" + " "+ firstName+" "+ lastName;
		String actualMesage= eltc_063_POM.getAddUserMessage();
		Assert.assertEquals(actualMesage, expetedMessage);

	}

}
