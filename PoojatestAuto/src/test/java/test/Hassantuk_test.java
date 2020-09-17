package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Hassantuk_test {

	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	//public ExtentTest _baseLogger;
	public static ExtentTest logger;

	@BeforeTest
	public void startReport() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/" + "ExtendReport" + ".html");
		// Create an object of Extent Reports
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Hassantuk");
		extent.setSystemInfo("Environment", "Webtest");
		extent.setSystemInfo("User Name", "Ashwin");
		htmlReporter.config().setDocumentTitle("Hassantuk");
		// Name of the report
		htmlReporter.config().setReportName("Hassantuk");
		// Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD);
		logger = extent.createTest("To verify Failed Report Details with Error screenshot");
		// _baseLogger = extent.createTest("To verify Failed Report Details with Error
		// screenshot");
	}

	@Test
	public void setup() throws InterruptedException {
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://home.moi.gov.ae/moi/index?lang=en");
		Thread.sleep(10000);

String LoginPage = LoginMethod();
		
		if (LoginPage.equals("sucess")) {
			logger.log(Status.PASS, "Login" + "Test Cases are passed");
		}	
		
	}

	
	public String LoginMethod() {
		
		try {
			
			driver.findElement(By.id("back")).click();
			Thread.sleep(3000);
			
			  driver.findElement(By.xpath(
			  "//label[@class='floating-label'][contains(text(),'Passport')]")).click();
			  Thread.sleep(10000);
			  
			  WebElement Passport =
			  driver.findElement(By.xpath("//input[@id='documentNumber']"));
			  Passport.click(); Passport.sendKeys("H2670098"); Passport.sendKeys(Keys.TAB);
			  Thread.sleep(10000);
			  
			  WebElement Upload_Passport = driver.findElement(By.
			  xpath("//label[@class='btn btn-default col-xs-12 uploade-label']"));
			  Upload_Passport.click(); Thread.sleep(10000);
			  
			  Runtime.getRuntime().exec("C:/Users/hp/Desktop/FileUpoadScript.exe");
			  Thread.sleep(20000);
			  
			  
			  driver.findElement(By.xpath("//button[@id='submitOwnerIdForm']")).click();
			  Thread.sleep(15000);
			  
			  WebElement emailid =
			  driver.findElement(By.xpath("//input[@id='useremail']")); emailid.click();
			  emailid.clear(); emailid.sendKeys("ashwin.gn111@gmail.com");
			  Thread.sleep(15000); emailid.sendKeys(Keys.TAB); Thread.sleep(15000);
			  
			  WebElement Contact_no =
			  driver.findElement(By.xpath("//input[@id='primaryMobileNumber']"));
			  Contact_no.clear(); Contact_no.sendKeys("0504130678"); Thread.sleep(10000);
			  
			  driver.findElement(By.xpath("//button[@id='submitRegFormTwo']")).click();
			  Thread.sleep(10000);
			  
			  WebElement new_pas =
			  driver.findElement(By.xpath("//input[@id='newpassword']")); new_pas.clear();
			  new_pas.sendKeys("Chiru123"); Thread.sleep(10000);
			  
			  WebElement confirm_pas =
			  driver.findElement(By.xpath("//input[@id='confirmpassword']"));
			  confirm_pas.clear(); confirm_pas.sendKeys("Chiru123"); Thread.sleep(10000);
			  
			  driver.findElement(By.xpath("//button[@id='submitRegFormThree']")).click();
			  Thread.sleep(10000);
			  
			
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "sucess";

	}
	
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			// MarkupHelper is used to display the output in different colors

			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			// add image/failed screenshot to jenkins extent report

			/* String ScreenshotFailed = */
			FailedScreenshot.getScreenhot(driver);
			// if required send screenshot in email use this

			logger.fail("Test Case Failed Snapshot is below "
					+ logger.addScreenCaptureFromPath("./Screenshot/screenshotName.png"));

		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
		driver.quit();
	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}

	
	
	

}
	

