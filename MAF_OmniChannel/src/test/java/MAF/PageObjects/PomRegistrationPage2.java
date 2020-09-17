package MAF.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomRegistrationPage2 {

	//WebDriver Global Variable
	WebDriver ldriver;


	//Crating Constructor for Webdriver Input from Baseclass
	public PomRegistrationPage2 (WebDriver rdriver){

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//Finding all the Web elements on the page Landing page

	@FindBy (xpath="//button[contains(text(),'Register')]")
	WebElement RegisterButton;


	//Action For LoginRegisterButton
	public void CLickRegister() throws WebDriverException, InterruptedException {

		RegisterButton.click();
		Thread.sleep(3000);
	}


}
