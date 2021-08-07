package com_Skillrary_pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	
	public WebDriver driver;
	
	@FindBy(id="email")
	private WebElement emailEle;
	
	@FindBy(id="password")
	private WebElement pswdEle;
	
	@FindBy(id="last")
	private WebElement loginBtn;
	
	
	//Lazy initialization using PageFactory class
	public UserLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public UserProfilePage userDetails(String email, String password) {
		emailEle.sendKeys(email);
		pswdEle.sendKeys(password);
		loginBtn.click();
		return new UserProfilePage(driver);
	}
	
	public WebElement getEmailEle() {
		return emailEle;
	}

	public WebElement getPswdEle() {
		return pswdEle;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	

	
	
	

}
