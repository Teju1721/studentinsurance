package policybazaar.test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.base.com.Driver;
import com.base.com.Excel;

import base.object.CarInsurance;
import base.object.HealthInsurance;
import base.object.TravelInsurance;

public class TravelInsuranceTest{
public WebDriver driver	;
public Driver driversetup; //creating object 
	public TravelInsurance travel; //passing reference 
	public HealthInsurance health;
	public CarInsurance car;
	public ExtentReports extent;
	public ExtentTest test;
	public Excel data;
	

	@BeforeClass
	public void setup() throws IOException {
	driversetup = new Driver(); 
	driver = driversetup.setup(); //calling the setup method from Driver class
	travel = new TravelInsurance(driver); //creating and initializing object 
	health = new HealthInsurance(driver);
	car = new CarInsurance(driver);
	
	
	
	//intialize the extent report 
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\report\\extent-report.html");
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
    extent.setSystemInfo("Application", "PolicyBazaar");
    extent.setSystemInfo("TravelInsurance", "Tejasri");
    extent.setSystemInfo("User Name", System.getProperty("user.name"));
    extent.setSystemInfo("Environemnt", "QA");
	}
	
	@Test (priority=1)
	public void testTravelInsuranceButtonClick() {
		test = extent.createTest("testTravelInsuranceButtonClick");
		test.log(Status.INFO,"clicking on the insurance button");
		
		travel.clicktravelbutton();	
		
		//Add asset validation to verify that button click action is successful
		Assert.assertTrue(travel.isTravelButtonClicked());	
	}
	
	@Test (priority=2)
	public void testSwitchToChildWindow() {
		test = extent.createTest("testSwitchToChildWindow");
        test.log(Status.INFO, "Switching to the child window after clicking on the insurance button");
 
        // Get the window handles
        String parentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
 
        // Switch to the child window
        String childWindowHandle = null;
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                childWindowHandle = windowHandle;
                driver.switchTo().window(childWindowHandle);
                break;
            }
        }
 
        // Add assert validation to verify that the child window is switched successfully
        Assert.assertNotEquals(childWindowHandle, parentWindowHandle, "Failed to switch to the child window");
    }
	
	@Test(groups = ("sanity"), priority = 3)
	public void SelectDestination() throws IOException, InterruptedException {
		Excel data = new Excel();
		data.readData();
		String dest = data.Destination;
		test= extent.createTest("SelectDestination");
		test.log(Status.INFO,"Selecting Destination");
		Thread.sleep(2000);
		travel.clickButton(dest);
		travel.clickdropdownbutton();
		travel.clicknextbutton();
		
		//validate if the expected page is created
		String expectedPageTitle = "PolicyBazaar Travel Insurance"; // Replace with the actual expected page title
		String actualPageTitle = driver.getTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle, "The expected page is not reached");
		        
		//capture screenshot
		 captureScreenshot("selectDestination");
	
	}
	
	@Test(groups=("sanity"),priority=4)
	public void testSelectDate() {
		test=extent.createTest("ClickDate");
		test.log(Status.INFO, "Clicking date");
		
		//perform actions to select the date 
		travel.clickdatebutton();
		travel.choosestartdatebutton();
		travel.chooseenddatebutton();
		travel.choosenextbutton();
		
		//validate if the expected page is reached 
		String expectedPageTitle = "PolicyBazaar Travel Insurance"; // Replace with the actual expected page title
		String actualPageTitle = driver.getTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle, "The expected page is not reached");
		
		//capture sccrenshot 
		captureScreenshot("ClickDate");
	}
	
	@Test(groups=("sanity"),priority=5)
	public void testSelectNumberOfTravellers() {
		test=extent.createTest("ChooseNumberOfTravellers");
		test.log(Status.INFO, " Choosing number of travellers");
		
		//perform actions to select the numbe rof travellers
		//create on instance of the Travel class
		travel.choosenumberoftravellers();
		travel.selectageoftraveller1();
		travel.selectageoftravelleras22();
		travel.selectageoftraveller2();
		travel.selectageoftravelleras21();
		travel.choosenextbutton2();
	
		// Assert that the number of travellers is selected correctly
		            int expectedNumberOfTravellers = 2;
		            int actualNumberOfTravellers = travel.getSelectedTrvellersCount();
		            Assert.assertEquals(actualNumberOfTravellers, expectedNumberOfTravellers, "Number of travellers is not selected correctly");
		 
		            // Capture screenshot
		            captureScreenshot("SelectNumberOfTravellers");		
	}
	@Test(groups=("sanity"),priority=6)
	public void ViewPlan() {
		String Mobno=data.MobileNo; //taking data from excel sheet 
		test = extent.createTest("ViewPlan");
		test.log(Status.INFO,"Viewing plan");
		//perform actions to view the plan 
		travel.entermobilenumber(Mobno);
		travel.selectviewplans();
		
		//Assert that the view plan button is clicked successfully 
		Assert.assertTrue(travel.isPlanViewed(), "Failed to view the plan");
		
		//capture sccrenshot 
		captureScreenshot("Viewpaln");
	}
		
	
	
	
	
	@AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Case Failed: " + result.getName());
            test.log(Status.FAIL, result.getThrowable());
            // Capture screenshot for failed test case
            captureScreenshot(result.getName() + "_failed");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case Passed: " + result.getName());
            // Capture screenshot for passed test case
            captureScreenshot(result.getName() + "_passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case Skipped: " + result.getName());
        }
    }
 
    @AfterClass
    public void tearDown() {
       Driver.CloseBrowser();
 
        // Generate the Extent report
        extent.flush();
    }
 
    private void captureScreenshot(String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = "screenshots/" + screenshotName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
            test.addScreenCaptureFromPath(destination);
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
 