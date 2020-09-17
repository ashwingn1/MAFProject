package MAF.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MAF.BasePackage.ProjectBaseClass;

public class PomLoginPage2 extends ProjectBaseClass{
	
	WebDriver ldriver;

	//Crating Constructor for Webdriver Input from Baseclass
	
	public PomLoginPage2 (WebDriver rdriver){

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}

	@FindBy (xpath="//input[@id='password']")
	WebElement LoginPassword;
	
	@FindBy (xpath=" //button[contains(@class,'comp-btn comp-btn--tertiary')]")
	WebElement FinalLoginButton;
	
	
	public String EnterUserNameForLogin() throws InterruptedException {

		LoginPassword.click();
		LoginPassword.clear();
		LoginPassword.sendKeys(LoginPassword1);
		Thread.sleep(3000);
		String Password = LoginPassword.getText();
		return Password;

	}
	
	public void ClickFinalLogin() throws InterruptedException {

		FinalLoginButton.click();
		Thread.sleep(3000);
	}

}
