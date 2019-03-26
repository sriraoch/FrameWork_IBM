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
import com.training.pom.ELTC_003_POM;

	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

	public class ELTC_003_Test {

		private WebDriver driver;
		private String baseUrl;
		private static Properties properties;
		private ScreenShot screenShot;
		private ELTC_003_POM eltc_003_pom;

		@BeforeClass
		public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		}

		@BeforeMethod
		public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			eltc_003_pom= new ELTC_003_POM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
			eltc_003_pom.sendId("shashirao");
			eltc_003_pom.sendPassword("Yamaha27!");
			eltc_003_pom.clickLoginBtn(); 
		}
		
		@AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			driver.quit();//close the browser
		}
		
		//Call the Methods
		@Test
		public void editProfileTest() throws InterruptedException {
			/*eltc_003_pom.sendId("shashirao");
			eltc_003_pom.sendPassword("Yamaha27!");
			eltc_003_pom.clickLoginBtn(); */
			Thread.sleep(4000);
			eltc_003_pom.clickEditProfile();
			System.out.println("Profile page is displayed.");
			eltc_003_pom.sendPass("Yamaha27!");
			System.out.println("Yamaha27!");
			eltc_003_pom.sendNewPassword("Yamaha28!");
			System.out.println("Yamaha28!");
			eltc_003_pom.sendConfirmPassword("Yamaha28!");
			System.out.println("Yamaha28!");
			eltc_003_pom.saveSettingsBtn();
			String expectedResult = "Your new profile has been saved";
			String actualResult = eltc_003_pom.getWelcomemsg();
			Assert.assertEquals(actualResult, expectedResult);
			System.out.println("The message is :Your new profile has been saved");
			screenShot.captureScreenShot("editProfile");
		}
	

	}


