package com_Skillrary_pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfilePage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),' Edit')]")
	private WebElement editBtn;
	
	public UpdateProfilePage editProfile() {
		editBtn.click();
		return new UpdateProfilePage(driver);
	}
	
	public EditProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEditBtn() {
		return editBtn;
	}
	
	

}
