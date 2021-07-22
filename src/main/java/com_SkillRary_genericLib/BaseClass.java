package com_SkillRary_genericLib;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Priyanka
 *
 */
public class BaseClass {

	public WebDriver driver;
	public FileUtilities fileUtilities=new FileUtilities();
	public WebDriverUtilities driverUtilities=new WebDriverUtilities();
	public static Connection con;
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports reports;
	public static ExtentTest test;

	@BeforeSuite
	public void configBS() throws SQLException {
		/**
		 * Connection to database
		 * Report
		 */
		System.out.println("********** Connected to Database **********");
		con=FileUtilities.getDb();

		htmlReport=new ExtentHtmlReporter(AutoConstant.reportsPath);
		htmlReport.config().setDocumentTitle("SkillRary Report");
		htmlReport.config().setTheme(Theme.STANDARD);
		reports=new ExtentReports();
		reports.attachReporter(htmlReport);

	}

	/**
	 * Open the application
	 * Enter url
	 * Wait for DOM elements
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@BeforeMethod
	public void openApp() throws FileNotFoundException, IOException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(fileUtilities.getPropertyData("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}

	/**
	 * Verify the test script results
	 * Takes the screenshot of failed test cases
	 * Closes the application
	 * @param r
	 * @throws IOException
	 */
	@AfterMethod
	public void closeApp(ITestResult r) throws IOException {
		int result=r.getStatus();
		if(result==ITestResult.FAILURE) {
			test.log(Status.FAIL,r.getName()+" Test case failed");
			test.log(Status.FAIL, r.getThrowable()+" Test case failed exception");
			test.addScreenCaptureFromPath(driverUtilities.screenshot(driver, r.getName()));	
		}else if(result==ITestResult.SUCCESS){
			test.log(Status.PASS, r.getName()+" Test case passed");

		}else if(result==ITestResult.SKIP){
			test.log(Status.SKIP, r.getName()+" Test case skipped");
		}
		driver.quit();
	}

	/**
	 * Closes the database connection
	 * Flush the reports
	 * @throws SQLException
	 */
	@AfterSuite
	public void configAS() throws SQLException {
		htmlReport.flush();
		reports.flush();
		fileUtilities.closeDb();
		System.out.println("********** Database closed **********");
	}

}
