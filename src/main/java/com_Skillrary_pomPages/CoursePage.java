package com_Skillrary_pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoursePage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Core Java for Selenium')]")
	private WebElement courseCategory;
	
	public CoursePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public TakeThisCoursePage courseCat() {
		courseCategory.click();
		return new TakeThisCoursePage(driver);
	}

	public WebElement getCourseCategory() {
		return courseCategory;
	}
	
	

}
