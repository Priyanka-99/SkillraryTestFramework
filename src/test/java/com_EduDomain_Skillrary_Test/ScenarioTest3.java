package com_EduDomain_Skillrary_Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import com_SkillRary_genericLib.BaseClass;
import com_Skillrary_pomPages.CourseDragPage;
import com_Skillrary_pomPages.SkillraryDemoLoginPage;
import com_Skillrary_pomPages.SkillraryLoginPage;
import com_Skillrary_pomPages.TwitterPage;

public class ScenarioTest3 extends BaseClass{
	
	@Test
	public void tc3() throws FileNotFoundException, IOException, InterruptedException {
		test=reports.createTest("Scenario3");
		SkillraryLoginPage slp=new SkillraryLoginPage(driver);
		SkillraryDemoLoginPage sdlp = slp.skillraryDemoApp();
		driverUtilities.switchTabs(driver);
		driverUtilities.dropDown(sdlp.getTestingDrpdwn(), fileUtilities.getPropertyData("dropdownText"));
		CourseDragPage cdp=new CourseDragPage(driver);
		//driverUtilities.scrollTillElement(driver, cdp.getCartArea());
		driverUtilities.dragAndDrop(driver, cdp.getSeleniumTrainingImg(), cdp.getCartArea());
		driverUtilities.verify((cdp.getTotalPrice().getText()), fileUtilities.getPropertyData("cartPrice"));
		Thread.sleep(2000);	
		TwitterPage twp = cdp.twitterClick();
		driverUtilities.verify(driver.getCurrentUrl(), fileUtilities.getPropertyData("twitterURL"));
	}

}
