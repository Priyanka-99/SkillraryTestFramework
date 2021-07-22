package com_Skillrary_pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryLoginPage {
	public WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'GEARS')]")
	private WebElement gearsBtn;
	
	@FindBy(xpath="(//a[contains(text(),'SkillRary Demo APP')])[2]")
	private WebElement skillraryDemoAppEle;


	public SkillraryLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public SkillraryDemoLoginPage skillraryDemoApp() {
		gearsBtn.click();
		skillraryDemoAppEle.click();
		return new SkillraryDemoLoginPage(driver);
	}

	//getters
	public WebElement getGearsBtn() {
		return gearsBtn;
	}

	public WebElement getSkillraryDemoAppEle() {
		return skillraryDemoAppEle;
	}
	
	

}
