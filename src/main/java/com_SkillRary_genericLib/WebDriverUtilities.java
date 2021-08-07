package com_SkillRary_genericLib;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Contains web driver specific reusable utilities
 * @author Priyanka
 *
 */
public class WebDriverUtilities {
	
	/**
	 * Select the value from the dropdown based on visible test
	 * @param ele
	 * @param text
	 */
	public void dropDown(WebElement ele, String text) {
		Select s=new Select(ele);
		s.selectByVisibleText(text);
		//s.selectByIndex(indexNum);
		List<WebElement> options = s.getOptions();
		int count = options.size();
		System.out.println("Total options: "+count);
	}
	
	/**
	 * Used to take mouse cursor on expected element on the browser
	 * @param driver
	 * @param ele
	 */
	public void mouseHover(WebDriver driver, WebElement ele) {
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
	}

	/**
	 * Used to drag and drop from source to target element 
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions a=new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
	}

	/**
	 * Used to perform double click on the element
	 * @param driver
	 * @param ele
	 */
	public void doubleClick(WebDriver driver, WebElement ele) {
		Actions a=new Actions(driver);
		a.doubleClick(ele).perform();
	}
	
	/**
	 * Used to switch to frame
	 * @param driver
	 */
	public void switchFrame(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}
	
	/**
	 * Used to switch control back from frame
	 * @param driver
	 */
	public void switchBackFromFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * Used to scroll to required element using coordinates
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollBar(WebDriver driver, int x, int y) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");	
		
	}
	
	/**
	 * Used to scroll till element using scrollIntoView
	 * @param driver
	 * @param ele
	 */
	public void scrollTillElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	/**
	 * Used to take the screenshot of failed test cases
	 * @param driver
	 * @param name
	 * @return
	 * @throws IOException
	 */
	public String screenshot(WebDriver driver, String name) throws IOException {
		Date d=new Date();
		String date = d.toString().replaceAll(":", "-");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File(AutoConstant.photoPath+date+name+".png");
		FileUtils.copyFile(srcFile, destFile);
		return date;
	}
	
	/**
	 * Used to switch to alert popup and click on OK button
	 * @param driver
	 */
	public void alertPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * Used to switch to another browser window
	 * @param driver
	 */
	public void switchTabs(WebDriver driver) {
		Set<String> child=driver.getWindowHandles();
		for(String b:child) {
			driver.switchTo().window(b);
		}
	}

	/**
	 * To verify the expected page results
	 * @param actual
	 * @param expected
	 */
	public void verify(String actual,String expected) {
		Assert.assertEquals(actual, expected);
	}

	/**
	 * Used to wait for expected element visibility in GUI
	 * @param driver
	 * @param ele
	 */
	public void explicitlyWait(WebDriver driver, WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	/**
	 * Used to click on webElement using JavascriptExecutor
	 * @param driver
	 * @param ele
	 */
	public void elementClick(WebDriver driver, WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",ele);	
	}
}
