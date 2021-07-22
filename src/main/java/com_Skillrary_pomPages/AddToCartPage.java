package com_Skillrary_pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	public WebDriver driver;
	
	@FindBy(xpath="//button[@id='add']")
	private WebElement addBtn;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-lg btn-flat']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="(//i[@class='fa fa-facebook'])[2]")
	private WebElement facebookIcon;
	
	public AddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void addToCart() {
		addToCartBtn.click();
	}
	
	public FacebookLikePage facebookIconEle() throws InterruptedException {
		facebookIcon.click();
		return new FacebookLikePage(driver);
	}

	//getters
	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getFacebookIcon() {
		return facebookIcon;
	}	
	
	

}
