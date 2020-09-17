package MAF.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomRegistrationPage1 {

	//WebDriver Global Variable
	WebDriver ldriver;


	//Crating Constructor for Webdriver Input from Baseclass
	public PomRegistrationPage1 (WebDriver rdriver){

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//Finding all the Web elements on the page Landing page

	@FindBy (xpath="//span[@class='css-m3vu4q']")
	WebElement LoginRegisterButton;


	//Action For LoginRegisterButton
	public void CLickLoginRegister() throws WebDriverException {

		LoginRegisterButton.click();
	}


}
