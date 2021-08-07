package com_Skillrary_pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseDragPage{
	
	public WebDriver driver;
	
	@FindBy(id="Selenium Training")
	private WebElement seleniumTrainingImg;
	
	@FindBy(id="cartArea")
	private WebElement cartArea;
	
	@FindBy(xpath="//p[@id='the_total']")
	private WebElement totalPrice;
	
	@FindBy(xpath="(//i[@class='fa fa-twitter'])[2]")
	private WebElement twitterIcon;
	
	public CourseDragPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public TwitterPage twitterClick() {
		twitterIcon.click();
		return new TwitterPage(driver);
	}

	//getters
	public WebElement getSeleniumTrainingImg() {
		return seleniumTrainingImg;
	}

	public WebElement getCartArea() {
		return cartArea;
	}

	public WebElement getTotalPrice() {
		return totalPrice;
	}

	public WebElement getTwitterIcon() {
		return twitterIcon;
	}
		
}
