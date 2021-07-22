package com_Skillrary_pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLikePage {
	public WebDriver driver;
	
	@FindBy(xpath="//button[@class='likeButton _4jy0 _4jy4 _517h _51sy _42ft']")
	private WebElement likeBtn;
	
	public FacebookLikePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void likeBtnClick() {
		likeBtn.click();
	}

	public WebElement getLikeBtn() {
		return likeBtn;
	}
	

}
