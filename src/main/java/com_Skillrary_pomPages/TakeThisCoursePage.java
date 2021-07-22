package com_Skillrary_pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TakeThisCoursePage {

	public WebDriver driver;

	@FindBy(xpath="//div[@class='play-icon']")
	private WebElement playBtn;

	@FindBy(xpath="//div[@class='pause-icon']")
	private WebElement pauseBtn;

	@FindBy(xpath="//div[@class='btn btn-primary datapopup']")
	private WebElement takeThisCourseBtn;

	@FindBy(xpath="//div[@class='youtube_video']")
	private WebElement frameEle;

	public TakeThisCoursePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void playVideo() throws InterruptedException {
		playBtn.click();
		Thread.sleep(5000);
		pauseBtn.click();
	}

	public void tkthisCourse() {
		takeThisCourseBtn.click();
	}

	public WebElement getPlayBtn() {
		return playBtn;
	}

	public WebElement getPauseBtn() {
		return pauseBtn;
	}

	public WebElement getTakeThisCourseBtn() {
		return takeThisCourseBtn;
	}

	public WebElement getFrameEle() {
		return frameEle;
	}



}
