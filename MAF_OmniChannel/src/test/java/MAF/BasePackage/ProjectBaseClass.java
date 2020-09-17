package MAF.BasePackage;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import MAF.Utils.ExcelUtility;
import MAF.Utils.ExcelUtility.ExcelUtilility;

public class ProjectBaseClass {


	//Defining Global Variables
	public static WebDriver driver1;
	public static String projectpath1;
	public static org.apache.logging.log4j.Logger logger;
	public static String URL;
	public static String CustomerFirstName;
	public static String CustomerLastName;
	public static String CustomerMobNo;
	public static String CustomerEmail;
	public static String CustomerPassword;
	public static String LoginUserName1;
	public static String LoginPassword1;

	//Defining Setup Method
	@Parameters ("Browser") //Parametrization

	@BeforeTest
	public static void Setup(String Browser) throws AWTException, InterruptedException, IOException {

		//To Initiate Logger
		logger = org.apache.logging.log4j.LogManager.getLogger();

		//To InitiateWebdriver
		if(Browser.equals("Chrome")) {
			projectpath1 = System.getProperty("user.dir");			
			System.setProperty("webdriver.chrome.driver", projectpath1+"/WebDrivers/chromedriver.exe");
			driver1 = new ChromeDriver();
			driver1.manage().window().maximize();
			driver1.manage().deleteAllCookies();
			driver1.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver1.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//	logger.info("--------------------------------------------------------------------------------------------------------/");

			try {

				logger.info("-------------------------------------New Iteration of Test execution Started-----------------------------------------------/");
				//Read URL From Property File
				URL = MAF.Utils.ReadConfig.readPropertiesFile();
				logger.info("URL Fetched :"+URL);

				//Read Customer Registration Details from Excel File
				MAF.Utils.ExcelUtility.ExcelUtilility excel =new ExcelUtilility(projectpath1+"/src/test/resources/ExcelInputFile/MAFCustomerRegistrationInputForm.xlsx","Sheet1");

				CustomerFirstName = excel.CopyStringString(1, 2);
				CustomerLastName = excel.CopyStringString(2, 2);
				//CustomerMobNo = excel.CopyStringString(3, 2);
				CustomerEmail = excel.CopyStringString(4, 2);
				CustomerPassword = excel.CopyStringString(5, 2);
				LoginUserName1 = excel.CopyStringString(7, 2);
				LoginPassword1 = excel.CopyStringString(8, 2);

				logger.info("--------Following are the Customer detsils fetched from Input excel for customer registration-----");
				logger.info ("CustomerFirstName - "+CustomerFirstName);
				logger.info ("CustomerLastName - "+CustomerLastName);
				logger.info ("CustomerEmail - "+CustomerEmail);
				logger.info ("CustomerPassword - "+CustomerPassword);

				logger.info("--------Following are the Customer detsils fetched from Input excel for customer login-----");
				logger.info ("LoginUserName1 - "+LoginUserName1);
				logger.info ("LoginPassword1 - "+LoginPassword1);
				

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				String msg = e.getMessage();
				System.out.println("Error in Base Class" +msg);	
			}

		}

	}


	//TearDown Methods
	@AfterSuite

	public static void TearDown() throws AWTException, InterruptedException {
		driver1.quit();
		MAF.Utils.ExtentReport.extent1.flush();
		System.out.println("AfterSuite Method executed successfully");

	}
}
