package MAF.Tests;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MAF.BasePackage.ProjectBaseClass;
import MAF.PageObjects.PomRegistrationPage1;
import MAF.PageObjects.PomRegistrationPage2;
import MAF.PageObjects.PomRegistrationPage3;

@Listeners(MAF.Utils.ITestListenereBase.class)
public class TC001_UserRegistration extends ProjectBaseClass{

	@Test(priority=1)
	public static void CustomerRegistration_OpenURL() throws InterruptedException {

		logger.info("---------------------------------------------New test ( TC001_UserRegistration) Started-----------------------------------------------------/");

		//Open URL
		driver1.get(URL);
		Thread.sleep(60000);
		logger.info("Browser opened & URL entered is Successful");
		String LandPageTitle = driver1.getTitle();
		org.testng.Assert.assertEquals(LandPageTitle, "Carrefour UAE - Shop Online for Food, Grocery, Mobiles, Electronics & More");
	}

	
	@Test(priority=2)
	public static void CustomerRegistration_ClickLoginRegister() throws InterruptedException {

		//CLickOn Login/Register
		PomRegistrationPage1 Page1 = new PomRegistrationPage1(driver1);
		Page1.CLickLoginRegister();
		String LoginPageTitle = driver1.getTitle();
		Assert.assertEquals(LoginPageTitle, "Login1");
		logger.info("Clicked Successfully on Login/register");
	}

	
	@Test(priority=3)
	public static void CustomerRegistration_ClickRegister() throws InterruptedException {

		//CLickOn Registration Button
		PomRegistrationPage2 Page2 = new PomRegistrationPage2(driver1);
		Page2.CLickRegister();
		String RegPageTitle = driver1.getTitle();
		Assert.assertEquals(RegPageTitle, "Register");
		logger.info("cLickOn Registration Button - Successful");

	}

	
	@Test(priority=4)
	public static void CustomerRegistration_FillForm() throws InterruptedException {
		//Enter Customer details
		PomRegistrationPage3 Page3 = new PomRegistrationPage3(driver1);
		WebElement TitleButton1 = Page3.SelectTitle();


		WebElement FirstName1 = Page3.SelectFirstName();
		Assert.assertNotNull(FirstName1);

		WebElement LastName1 = Page3.SelectLastName();
		Assert.assertNotNull(LastName1);

		WebElement MobNo1 = Page3.SelectMobNo();
		Assert.assertNotNull(MobNo1);

		WebElement Email1 = Page3.SelectEmail();
		Assert.assertNotNull(Email1);

		WebElement Password1 = Page3.SelectPassword();
		Assert.assertNotNull(Password1);

		WebElement CheckBox1 = Page3.DeselectCheckBox();
		Assert.assertNotEquals(CheckBox1, CheckBox1.isSelected());
		logger.info("Enter Customer details - Successful");

	}
	
	@Test(priority=5)
	//tearDoownMethod
	public static void tearDown() {
		
		driver1.close();
	}

}



