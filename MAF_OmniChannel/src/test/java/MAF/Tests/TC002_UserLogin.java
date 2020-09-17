package MAF.Tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import MAF.BasePackage.ProjectBaseClass;
import MAF.PageObjects.PomLoginPage1;
import MAF.PageObjects.PomLoginPage2;
import MAF.PageObjects.PomRegistrationPage1;

@Listeners(MAF.Utils.ITestListenereBase.class)
public class TC002_UserLogin extends ProjectBaseClass{
	
	
	@Test(priority=1)
	public static void CustomerLogin_OpenURL() throws InterruptedException {

		logger.info("---------------------------------------------New test ( TC002_UserLogin) Started-----------------------------------------------------/");

		//Open URL
		driver1.get(URL);
		Thread.sleep(60000);
		logger.info("Login TC - Browser opened & URL entered is Successful");
		String LandPageTitle = driver1.getTitle();
		org.testng.Assert.assertEquals(LandPageTitle, "Carrefour UAE - Shop Online for Food, Grocery, Mobiles, Electronics & More");
	}

	
	@Test(priority=2)
	public static void CustomerLogin_ClickLoginRegister() throws InterruptedException {

		//CLickOn Login/Register
		PomRegistrationPage1 Page1 = new PomRegistrationPage1(driver1);
		Page1.CLickLoginRegister();
		String LoginPageTitle = driver1.getTitle();
		Assert.assertEquals(LoginPageTitle, "Login");
		logger.info("Login TC - Clicked Successfully on Login/register");
	}
	
	@Test(priority=2)
	public static void CustomerLogin_EnterUserName() throws InterruptedException {

		//CLickOn Login/Register
		PomLoginPage1 LoginPage1 = new PomLoginPage1(driver1);
		String a1 = LoginPage1.EnterUserNameForLogin();
		//Assert.assertEquals(a1, LoginUserName1);
		logger.info("Login TC - UserName Entered successfully for Login");
		
		LoginPage1.ClickLoginContinue();
		Assert.assertEquals(driver1.getTitle(), "Login");
	}
	
	@Test(priority=3)
	public static void CustomerLogin_EnterPassword() throws InterruptedException {

		//CLickOn Login/Register
		PomLoginPage2 LoginPage2 = new PomLoginPage2(driver1);
		String a2 = LoginPage2.EnterUserNameForLogin();
		//Assert.assertEquals(a2, LoginPassword1);
		logger.info("Login TC - Password Entered successfully for Login");
		
		LoginPage2.ClickFinalLogin();
		Thread.sleep(5000);
		Assert.assertEquals(driver1.getTitle(), "Carrefour UAE - Shop Online for Food, Grocery, Mobiles, Electronics & More");
		logger.info("user Login Is Successful");
	}
	
	@Test(priority=4)
	//tearDoownMethod
		public static void tearDown() {
			
			driver1.close();
		}

}
