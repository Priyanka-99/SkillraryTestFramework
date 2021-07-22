package com_Skillrary_pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

	public WebDriver driver;

	@FindBy(name="name")
	private WebElement nameTxtBx;

	@FindBy(name="sender")
	private WebElement emailTxtBx; 

	@FindBy(name="subject")
	private WebElement subjectTxtBx;

	@FindBy(name="message")
	private WebElement msgTxtBx;

	@FindBy(xpath="//button[@class='btn btn-sm btn-primary']")
	private WebElement sendMailBtn;

	@FindBy(name="q")
	private WebElement searchTxtBx;

	@FindBy(xpath="//input[@value='go']")
	private WebElement searchBtn;

	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void contactUs(String name, String email, String subject, String message) {
		nameTxtBx.sendKeys(name);
		emailTxtBx.sendKeys(email);
		subjectTxtBx.sendKeys(subject);
		msgTxtBx.sendKeys(message);
		sendMailBtn.click();
	}
	
	public CoursePage searchCourse(String courseName) {
		searchTxtBx.sendKeys(courseName);
		searchBtn.click();
		return new CoursePage(driver);
	}

	public WebElement getNameTxtBx() {
		return nameTxtBx;
	}

	public WebElement getEmailTxtBx() {
		return emailTxtBx;
	}

	public WebElement getSubjectTxtBx() {
		return subjectTxtBx;
	}

	public WebElement getMsgTxtBx() {
		return msgTxtBx;
	}

	public WebElement getSendMailBtn() {
		return sendMailBtn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchTextBx() {
		return searchTxtBx;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
}
