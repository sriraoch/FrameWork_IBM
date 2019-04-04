package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ELTC_062_POM {
	private WebDriver driver;

	public ELTC_062_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Element for loginId
	@FindBy(id = "login")
	private WebElement userName;

	// Element for Password
	@FindBy(id = "password")
	private WebElement password;

	// Element for loginButton
	@FindBy(id = "form-login_submitAuth")
	private WebElement loginBtn;

	// Element for AddAUser
	@FindBy(partialLinkText = "Add a us")
	private WebElement addAUser;

	// Element for firstName
	@FindBy(id = "firstname")
	private WebElement firstName;

	// Element for lastName
	@FindBy(id = "lastname")
	private WebElement lastName;

	// Element for eMail
	@FindBy(id = "email")
	private WebElement eMail;

	// Element for phoneNumber
	@FindBy(id = "phone")
	private WebElement phoneNumber;

	// Element for login
	@FindBy(id = "username")
	private WebElement login;

	// Element for passwordRd
	@FindBy(name = "password[password_auto]")
	private WebElement passwordRd;

	// Element for enterPassword
	@FindBy(id = "password")
	private WebElement enterPassword;

	// Element for profileDd
	@FindBy(id = "status_select")
	private WebElement profile;

	//Element for add
	@FindBy(name="submit")
	private WebElement add;

	// Method for loginId
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	// Method for password
	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	// Method for loginButton
	public void clickLoginBtn() {
		this.loginBtn.click();
	}

	// Method for addAUser
	public void clickAddAUser() {
		this.addAUser.click();
	}

	// Method for firstName
	public void sendFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}

	// Method for lastName
	public void sendLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}

	// Method for eMail
	public void sendEMail(String eMail) {
		this.eMail.sendKeys(eMail);
	}

	// Method for phoneNumber
	public void sendPhoneNumber(String phoneNumber) {
		this.phoneNumber.sendKeys(phoneNumber);
	}

	// Method for login
	public void sendLogin(String login) {
		this.login.sendKeys(login);
	}

	// Method for passwordRd
	public void clickPasswordRd() {
		this.passwordRd.click();
	}
	
	//Method for enterPassword
	public void sendEnterPassword(String enterPassword) {
		this.enterPassword.sendKeys(enterPassword);
	}

	// Method for Profile dropDown
	public void selectProfileDropDown(String string) {
		Select drop = new Select(profile);
		drop.selectByVisibleText(string);
	}
	
	//Method for add
	public void clickAdd() {
		this.add.click();
	}
	
}
