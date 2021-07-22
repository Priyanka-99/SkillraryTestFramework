package com_EduDomain_Skillrary_Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Point;
import org.testng.annotations.Test;

import com_SkillRary_genericLib.BaseClass;
import com_Skillrary_pomPages.AddToCartPage;
import com_Skillrary_pomPages.FacebookLikePage;
import com_Skillrary_pomPages.SkillraryDemoLoginPage;
import com_Skillrary_pomPages.SkillraryLoginPage;

public class ScenarioTest1 extends BaseClass{
	
	@Test
	public void fbLike() throws InterruptedException, FileNotFoundException, IOException {
		test=reports.createTest("Scenario1");
		SkillraryLoginPage slp=new SkillraryLoginPage(driver);
		SkillraryDemoLoginPage sldp = slp.skillraryDemoApp();
		driverUtilities.switchTabs(driver);;
		driverUtilities.mouseHover(driver, sldp.getCourseBtn());
		AddToCartPage acp = sldp.skillraryTrainingBtn();
		driverUtilities.doubleClick(driver, acp.getAddBtn());
		acp.addToCart();
		driverUtilities.alertPopup(driver);
		Point loc = acp.getFacebookIcon().getLocation();
		int x = loc.getX();
		System.out.println("x: "+x);
		int y = loc.getY();
		System.out.println("y: "+y);
		driverUtilities.scrollBar(driver, x, y);
		FacebookLikePage fbp = acp.facebookIconEle();
		fbp.likeBtnClick();
		driverUtilities.verify(driver.getCurrentUrl(),fileUtilities.getPropertyData("facebookCurrentURL"));
		
	}

}
