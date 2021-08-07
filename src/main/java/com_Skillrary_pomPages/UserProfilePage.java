package com_Skillrary_pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_SkillRary_genericLib.BaseClass;

public class UserProfilePage extends BaseClass{
	
	public WebDriver driver;
	
	@FindBy(xpath="//img[@class='user-image']")
	private WebElement userIcon;
	
	@FindBy(xpath="//a[text()='Profile']")
	private WebElement profileBtn;
	
	public UserProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public EditProfilePage profile() {
		userIcon.click();
		profileBtn.click();
		return new EditProfilePage(driver);
	}
	
	//getters
	public WebElement getUserIcon() {
		return userIcon;
	}

	public WebElement getProfileBtn() {
		return profileBtn;
	}



}
