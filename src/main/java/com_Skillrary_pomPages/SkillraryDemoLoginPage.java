package com_Skillrary_pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryDemoLoginPage {
	public WebDriver driver;
	
	@FindBy(id="course")
	private WebElement courseBtn;
	
	@FindBy(xpath="//div[@class='dropdown-content']//a[text()='Selenium Training']")
	private WebElement seleniumTrainingEle;
	
	@FindBy(xpath="//a[text()='Contact Us']")
	private WebElement contactUsEle;
	
	public SkillraryDemoLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public AddToCartPage skillraryTrainingBtn() {
		seleniumTrainingEle.click();
		return new AddToCartPage(driver);
	}
	
	public ContactUsPage contactUsClick() {
		contactUsEle.click();
		return new ContactUsPage(driver);
	}

	//getters
	public WebElement getCourseBtn() {
		return courseBtn;
	}

	public WebElement getSeleniumTrainingEle() {
		return seleniumTrainingEle;
	}

	public WebElement getContactUsEle() {
		return contactUsEle;
	}
	
	
	
}
