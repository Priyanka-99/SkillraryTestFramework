package com_EduDomain_Skillrary_Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.Test;
import com_SkillRary_genericLib.ConfigDataProvider;
import com_Skillrary_pomPages.EditProfilePage;
import com_Skillrary_pomPages.SkillraryDemoLoginPage;
import com_Skillrary_pomPages.SkillraryLoginPage;
import com_Skillrary_pomPages.UpdateProfilePage;
import com_Skillrary_pomPages.UserLoginPage;
import com_Skillrary_pomPages.UserProfilePage;

public class ScenarioTest4 extends ConfigDataProvider{
	
	@Test(dataProvider = "fetchData")
	public void tc4(String fname, String lname, String email, String pswd, String contact) throws InterruptedException, FileNotFoundException, IOException {
		test=reports.createTest("Scenario4");
		SkillraryLoginPage slp=new SkillraryLoginPage(driver);
		SkillraryDemoLoginPage sdlp = slp.skillraryDemoApp();
		driverUtilities.switchTabs(driver);
		UserLoginPage ulp = sdlp.login();
		UserProfilePage upp = ulp.userDetails(fileUtilities.getPropertyData("useremail"), fileUtilities.getPropertyData("userpassword"));
		EditProfilePage epp = upp.profile();
		UpdateProfilePage updp = epp.editProfile();
		updp.editDetails(fname, lname, email, pswd, contact);
		updp.photoUpload(fileUtilities.getPropertyData("photopath"));
		Thread.sleep(2000);
	}
}
