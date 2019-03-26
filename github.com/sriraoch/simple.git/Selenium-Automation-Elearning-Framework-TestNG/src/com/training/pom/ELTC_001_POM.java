package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ELTC_001_POM {
	private WebDriver driver;

	public ELTC_001_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Sign up") // need to check
	private WebElement signUp_Button;

	@FindBy(id = "registration_firstname")
	private WebElement firstName;

	@FindBy(id = "registration_lastname")
	private WebElement lastName;

	@FindBy(id = "registration_email")
	private WebElement email;

	/*
	 * @FindBy(id = "registration_official_code") private WebElement code;
	 */
	@FindBy(id = "username")
	private WebElement userName;

	@FindBy(id = "pass1")
	private WebElement password;

	@FindBy(id = "pass2")
	private WebElement confirmPassword;

	@FindBy(id = "registration_phone")
	private WebElement phoneNumber;

	@FindBy(xpath = "//span[@class='filter-option pull-left']")
	public WebElement language;

	/*
	 * @FindBy(id = "qf_9f3a0c") private WebElement phoneProfile;
	 */

	@FindBy(xpath ="//input[@type='radio' and @value='1']")
	public WebElement studentProfile;
	
	@FindBy(id = "registration_submit")
	private WebElement registerButton;

	// @FindBy(id="registration_submit")
	// private WebElement registration_register_Button;

	// method for signUpbutton
	public void clickSignupbtn() {
		this.signUp_Button.click();
	}

	// method for firstName
	public void sendFirstname(String id) {
		this.firstName.sendKeys(id);
	}

	// method for lastName
	public void sendLastname(String id) {
		this.lastName.sendKeys(id);
	}

	/*
	 * // method for code public void sendCode(String id) {
	 * 
	 * this.code.sendKeys(id); }
	 */

	// method for userName
	public void senduserName(String id) {

		this.userName.sendKeys(id);
	}

	// method for password
	public void sendPassword(String id) {

		this.password.sendKeys(id);
	}

	// method for confirmPassword
	public void sendConfirmPassword(String id) {

		this.confirmPassword.sendKeys(id);
	}

	// Method for phoneNumber
	public void sendPhoneNumber(String id) {

		this.confirmPassword.sendKeys(id);
	}

	/// Method for languageDropdown
	public void selectLanguageDropDown(String string) throws Exception {
			Select drop = new Select(language);
			drop.selectByVisibleText(string);
	}
			///Method for studentRadioButton
	public void selectStudentradiobtn() throws Exception {
		
		this.studentProfile.click();
	}

	public void registerButtonClick() {
		this.registerButton.click();

	}

}
