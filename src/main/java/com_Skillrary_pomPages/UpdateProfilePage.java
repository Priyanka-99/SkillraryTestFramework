package com_Skillrary_pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateProfilePage {
	
	public WebDriver driver;
	
	@FindBy(id="firstname")
	private WebElement firstNameTxtBx;
	
	@FindBy(id="lastname")
	private WebElement lastNameTxtBx;
	
	@FindBy(id="email")
	private WebElement emailTxtBx;
	
	@FindBy(id="password")
	private WebElement pswdTxtBx;
	
	@FindBy(id="contact")
	private WebElement contactTxtBx;
	
	@FindBy(name="addresstype")
	private WebElement addressdrpDwn;
	
	@FindBy(name="gender")
	private WebElement genderChkBx;
	
	@FindBy(id="photo")
	private WebElement photoUploadEle;
	
	public UpdateProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void editDetails(String fname, String lname, String email, String pswd, String contact) {
		firstNameTxtBx.sendKeys(fname);
		lastNameTxtBx.sendKeys(lname);
		emailTxtBx.sendKeys(email);
		pswdTxtBx.sendKeys(pswd);
		contactTxtBx.sendKeys(contact);
		
	}
	
	public void photoUpload(String filePath) {
		photoUploadEle.click();
		photoUploadEle.sendKeys(filePath);
	}

	//getters
	public WebElement getFirstNameTxtBx() {
		return firstNameTxtBx;
	}

	public WebElement getLastNameTxtBx() {
		return lastNameTxtBx;
	}

	public WebElement getEmailTxtBx() {
		return emailTxtBx;
	}

	public WebElement getPswdTxtBx() {
		return pswdTxtBx;
	}

	public WebElement getContactTxtBx() {
		return contactTxtBx;
	}

	public WebElement getAddressdrpDwn() {
		return addressdrpDwn;
	}

	public WebElement getGenderChkBx() {
		return genderChkBx;
	}

	public WebElement getPhotoUploadEle() {
		return photoUploadEle;
	}
	
	

}
