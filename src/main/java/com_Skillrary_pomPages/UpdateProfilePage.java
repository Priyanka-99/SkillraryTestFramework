package com_Skillrary_pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UpdateProfilePage {
	
	public WebDriver driver;
	
	public UpdateProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

}
