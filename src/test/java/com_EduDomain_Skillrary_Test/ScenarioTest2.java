package com_EduDomain_Skillrary_Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Point;
import org.testng.annotations.Test;

import com_SkillRary_genericLib.BaseClass;
import com_Skillrary_pomPages.ContactUsPage;
import com_Skillrary_pomPages.CoursePage;
import com_Skillrary_pomPages.SkillraryDemoLoginPage;
import com_Skillrary_pomPages.SkillraryLoginPage;
import com_Skillrary_pomPages.TakeThisCoursePage;

public class ScenarioTest2 extends BaseClass{
	
	@Test
	public void tc2() throws FileNotFoundException, IOException, InterruptedException {
		test=reports.createTest("Scenario2");
		SkillraryLoginPage slp=new SkillraryLoginPage(driver);
		SkillraryDemoLoginPage sldp = slp.skillraryDemoApp();
		driverUtilities.switchTabs(driver);
		Point loc = sldp.getContactUsEle().getLocation();
		int x=loc.getX();
		int y=loc.getY();
		driverUtilities.scrollBar(driver, x, y);
		ContactUsPage cup = sldp.contactUsClick();
		cup.contactUs(fileUtilities.getPropertyData("name"), fileUtilities.getPropertyData("email"), fileUtilities.getPropertyData("subject"), fileUtilities.getPropertyData("message"));
		CoursePage cp = cup.searchCourse(fileUtilities.getPropertyData("courseName"));
		TakeThisCoursePage ttc = cp.courseCat();
		driverUtilities.switchFrame(driver, ttc.getFrameEle());
		ttc.playVideo();
		driverUtilities.switchBackFromFrame(driver);
		ttc.tkthisCourse();
		
	}

}
