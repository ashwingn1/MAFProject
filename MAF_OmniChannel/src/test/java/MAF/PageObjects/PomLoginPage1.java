package MAF.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MAF.BasePackage.ProjectBaseClass;

public class PomLoginPage1 extends ProjectBaseClass {
	
	
	WebDriver ldriver;
	

	//Crating Constructor for Webdriver Input from Baseclass
	public PomLoginPage1 (WebDriver rdriver){

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy (xpath="//input[@id='username']")
	WebElement LoginUserName;
	
	@FindBy (xpath="//button[contains(@class,'comp-btn comp-btn--primary')]")
	WebElement LoginContinue;
	
	
	public String EnterUserNameForLogin() throws InterruptedException {

		LoginUserName.click();
		LoginUserName.clear();
		LoginUserName.sendKeys(LoginUserName1);
		Thread.sleep(3000);
		String Username = LoginUserName.getText();
		return Username;

	}
	
	public void ClickLoginContinue() throws InterruptedException {

		LoginContinue.click();
		Thread.sleep(3000);
	}

}


