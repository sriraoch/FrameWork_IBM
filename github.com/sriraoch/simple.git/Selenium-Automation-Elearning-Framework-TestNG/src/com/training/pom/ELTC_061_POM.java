package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ELTC_061_POM {
	private WebDriver driver;

	public ELTC_061_POM(WebDriver driver) {
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

	// Element for createACourse
	@FindBy(partialLinkText = "Create a cour")
	private WebElement createACourse;

	// Element for courseName
	@FindBy(id = "title")
	private WebElement courseName;

	// Element for createThisCourse
	@FindBy(name = "submit")
	private WebElement createThisCourse;

	// Element for tests
	@FindBy(linkText = "Tests")
	private WebElement tests;

	// Element for createANewCourse
	@FindBy(partialLinkText = "Create a new te")
	private WebElement createANewCourse;

	// Element for testName
	@FindBy(id = "exercise_title")
	private WebElement testName;

	// Element for proceedToQuestions
	@FindBy(id = "exercise_admin_submitExercise")
	private WebElement proceedToQuestions;

	// Element for multipleChoice
	@FindBy(xpath = "//img[@title='Multiple choice']")
	private WebElement multipleChoice;

	// Element for question
	@FindBy(id = "question_admin_form_questionName")
	private WebElement question;

	// Element for iframe1
	@FindBy(id = "cke_answer[1]")
	private WebElement iframe1;

	// Element for iframe2
	@FindBy(xpath = "//*[@id='cke_4_contents']/iframe")
	private WebElement iframe2;

	// Element for iframe3
	@FindBy(xpath = "//*[@id='cke_6_contents']/iframe")
	private WebElement iframe3;
	
	// Element for iframe4
		@FindBy(xpath = "//*[@id='cke_8_contents']/iframe")
		private WebElement iframe4;
		
		//Element for 2nd RdioBtn
		@FindBy(xpath="//input[@id='qf_def47e']")
		private WebElement rdioBtn;
		
		//Element for addThisQuestion
		@FindBy(css="#submit-question")
		private WebElement addThisQuestion;
		
		//Element for preview
		@FindBy(xpath="//img[@title='Preview']")
		private WebElement preview;

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

	// Method for createACourse
	public void clickCreateACourse() {
		this.createACourse.click();
	}

	// Method for courseName
	public void sendCourseName(String courseName) {
		this.courseName.sendKeys(courseName);
	}

	// Method for createThisCourse
	public void clickCreateThisCourse() {
		this.createThisCourse.click();
	}

	// Method for tests
	public void clickTests() {
		this.tests.click();
	}

	// Method for createANewCourse
	public void clickCreateANewCourse() {
		this.createANewCourse.click();
	}

	// Method for testName
	public void sendTestName(String testName) {
		this.testName.sendKeys(testName);
	}

	// Method for proceedToQuestions
	public void clickProceedToQuestions() {
		this.proceedToQuestions.click();
	}

	// Method for multipleChoice
	public void clickMultipleChoice() {
		this.multipleChoice.click();
	}

	// Method for question
	public void sendQuestion(String question) {
		this.question.sendKeys(question);
	}

	// Method for iframe1
	public void sendIFrame1(String iframe1) {
		driver.switchTo().frame(iframe1);
		this.iframe1.clear();
		this.iframe1.sendKeys(iframe1);
		driver.switchTo().defaultContent();
	}

}
