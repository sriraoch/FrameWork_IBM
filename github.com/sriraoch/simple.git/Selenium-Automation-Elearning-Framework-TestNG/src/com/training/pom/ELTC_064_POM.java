package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ELTC_064_POM {
	private WebDriver driver;

	public ELTC_064_POM(WebDriver driver) {
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

	// Element for courseCategory
	@FindBy(partialLinkText = "Courses categori")
	private WebElement courseCategory;

	// Element for addCategory
	@FindBy(css = "main.section-platform_admin section:nth-child(3) div.container div.actions a:nth-child(1) > img:nth-child(1)")
	private WebElement addCategory;

	// Element for categoryCode
	@FindBy(id = "course_category_code")
	private WebElement categoryCode;

	// Element for categoryName
	@FindBy(id = "course_category_name")
	private WebElement categoryName;

	// Element for allowCoursesRdBtn
	@FindBy(xpath = "//input[@value='TRUE']")
	private WebElement allowCoursesRdBtn;

	// Element for addCategoryBtn
	@FindBy(id = "course_category_submit")
	private WebElement addCategoryBtn;

	// Element for administration
	@FindBy(linkText = "Administration")
	private WebElement administration;

	// Element for createACourse
	@FindBy(partialLinkText = "Create a cour")
	private WebElement createACourse;

	// Element for title
	@FindBy(xpath = "//input[@id='update_course_title']")
	private WebElement title;

	//Element for code
	@FindBy(xpath="//input[@id='visual_code']")
	private WebElement code;
	
	//Element for category
	@FindBy(xpath="//select[@id='update_course_category_code']")
	private WebElement category;
	
	//Element for teacher
	@FindBy(xpath="//*[@id=\"update_course\"]/fieldset/div[4]/div[1]/span/span[1]/span/ul/li/input")
    private WebElement teacher;
	
	//Element for languageDD
	@FindBy(name="course_language")
	private WebElement language;
	
	//Element for createACourseBtn
	@FindBy(id="update_course_submit")
	private WebElement createACourseBtn;
	
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

	// Method for courseCategory
	public void clickCourseCategory() throws Exception {
		this.courseCategory.click();
		Thread.sleep(3000);
	}

	// Method for addCategory
	public void clickAddCategory() throws Exception {
		this.addCategory.click();
		Thread.sleep(3000);
	}

	// Method for categoryCode
	public void sendCategoryCode(String categoryCode) {
		this.categoryCode.sendKeys(categoryCode);
	}

	// Method for categoryName
	public void sendCategoryName(String categoryName) {
		this.categoryName.sendKeys(categoryName);
	}

	// Method for allowCoursesRdBtn
	public void clickAllowCoursesRdBtn() {
		this.allowCoursesRdBtn.click();
	}

	// Method for addCategoryBtn
	public void clickAddCategoryBtn() {
		this.addCategoryBtn.click();
	}

	// Method for administration
	public void clickAdministration() {
		this.administration.click();
	}
	
	//Method for createACourse
	public void clickCreateACourse() {
		this.createACourse.click();
	}

	// Method for title
	public void sendTitle(String title) {
		this.title.sendKeys(title);
	}
	
	//Method for code
	public void sendCode(String code) {
		this.code.sendKeys(code);
	}
	
	//method for categoryDD
	public void selectCategoryDropDown(String string) {
		Select drop = new Select(category);
		drop.selectByVisibleText(string);
	}
	
	//Method for teacher
	public void sendTeacher(String teacher) {
		this.teacher.clear();
		this.teacher.sendKeys(teacher);
	}	
	
	//Method for languageDD
	public void selectlanguageDropDown(String string) {
		Select drop = new Select(language);
		drop.selectByVisibleText(string);
	}
	
	//Method for createACourseBtn
	public void clickCreateACourseBtn() {
		this.createACourseBtn.click();
	}
}
