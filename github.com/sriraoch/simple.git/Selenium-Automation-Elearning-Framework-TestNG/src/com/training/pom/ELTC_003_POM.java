package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_003_POM {
	private WebDriver driver;

	public ELTC_003_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Element for userId
	@FindBy(id = "login")
	private WebElement id;

	// Element for password
	@FindBy(id = "password")
	private WebElement password;

	// Element for login Button
	@FindBy(name = "submitAuth")
	private WebElement loginBtn;

	// Element for login Button

	@FindBy(xpath = "//*[text()='Edit profile']")
	private WebElement editProfilePartialLink;

	@FindBy(name = "password0")
	private WebElement editProfileOldPassText;

	@FindBy(id = "password1")
	private WebElement editProfileNewPassText;

	@FindBy(id = "profile_password2")
	private WebElement editProfileConfirmPassText;

	@FindBy(id = "profile_apply_change")
	private WebElement editProfileSaveSettingsButton;

	@FindBy(xpath = "//div[@class='alert alert-info']")
	private WebElement getWelcomeMessage;

	/*** Methods ***/

	// Method for User Id
	public void sendId(String id) {
		this.id.clear();
		this.id.sendKeys(id);
	}

	// Method for Password
	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	// Method for Login Button
	public void clickLoginBtn() {
		this.loginBtn.click();
	}

	// Element for Edit Profile
	public void clickEditProfile() {
		this.editProfilePartialLink.click();
	}

	// Element for enter Old password
	public void sendPass(String password) {
		this.editProfileOldPassText.sendKeys(password);
	}

	// Element for enter new Password
	public void sendNewPassword(String newPassword) {
		this.editProfileNewPassText.sendKeys(newPassword);
	}

	// Element for Confirm password
	public void sendConfirmPassword(String confirmPassword) {
		this.editProfileConfirmPassText.sendKeys(confirmPassword);
	}

	// Element for Save Settings
	public void saveSettingsBtn() {
		this.editProfileSaveSettingsButton.click();
	}

	public String getWelcomemsg() {
		String actualResults = this.getWelcomeMessage.getText();
		return actualResults;
	}
}
