package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ELTC_002_POM {
private WebDriver driver; 
	
	public ELTC_002_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userNameText; 
	
	@FindBy(id="password")
	private WebElement passwordText;
	
	@FindBy(name="submitAuth")
	private WebElement loginButton;
	
	//Method for User Id
			public void sendId(String loginUserName) {
				this.userNameText.clear();
				this.userNameText.sendKeys(loginUserName);
			}

			//Method for Password
			public void sendPassword(String loginPassword) {
				this.passwordText.clear();
				this.passwordText.sendKeys(loginPassword);
			}

			//Method for Login Button
			public void clickLoginBtn() {
				this.loginButton.click();
			}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@FindBy(linkText="Change your password")
	private WebElement ChangePasswordlink; 
	
	@FindBy(name="password")
	private WebElement newpassword;
	
	@FindBy(name="confirm")
	private WebElement confirmpassword; 
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continuebtn;
	
	public void changePasswordlink(){
		this.ChangePasswordlink.click();
	}
	
	public void sendChangedpassword(String newpassword) {
		this.newpassword.clear();
		this.newpassword.sendKeys(newpassword);
}

public void sendConfirmPassword(String confirmpassword) {
	this.confirmpassword.clear(); 
	this.confirmpassword.sendKeys(confirmpassword); 
}

public void clickcontinuebtn() {
	this.continuebtn.click(); 
}

}
