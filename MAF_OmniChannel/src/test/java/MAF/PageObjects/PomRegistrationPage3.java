package MAF.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MAF.BasePackage.ProjectBaseClass;

public class PomRegistrationPage3 extends ProjectBaseClass {

	//WebDriver Global Variable
	WebDriver ldriver;


	//Crating Constructor for Webdriver Input from Baseclass
	public PomRegistrationPage3 (WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//Finding all the Web elements on the page Landing page

	@FindBy (xpath="//div[@class='user-title__wrapper']//label[1]//i[1]")
	WebElement TitleButton;

	@FindBy (xpath="//input[@id='firstName']")
	WebElement FirstName;

	@FindBy (xpath="//input[@id='lastName']")
	WebElement LastName;

	@FindBy (xpath="//input[@id='mobileNumber']")
	WebElement MobNo;

	@FindBy (xpath="//input[@id='email']")
	WebElement email;

	@FindBy (xpath="//input[@id='pwd']")
	WebElement password;

	@FindBy (xpath="//i[contains(@class,'comp-checkbox--clone')]")
	WebElement CheckBox;

	@FindBy (xpath="//button[contains(text(),'Create a new account')]")
	WebElement CreateAccountButton;



	//Actions For webElements

	public WebElement SelectTitle() {

		TitleButton.click();
		return TitleButton;
	}

	public WebElement SelectFirstName() throws InterruptedException {

		FirstName.click();
		FirstName.clear();
		FirstName.sendKeys(CustomerFirstName);
		Thread.sleep(3000);
		return FirstName;

	}

	public WebElement SelectLastName() throws InterruptedException {

		LastName.click();
		LastName.clear();
		LastName.sendKeys(CustomerLastName);
		Thread.sleep(3000);
		return LastName;
	}

	public WebElement SelectMobNo() throws InterruptedException {

		MobNo.click();
		MobNo.clear();
		MobNo.sendKeys("504130678");
		Thread.sleep(3000);
		return MobNo;

	}

	public WebElement SelectEmail() throws InterruptedException {

		email.click();
		email.clear();
		email.sendKeys(CustomerEmail);
		Thread.sleep(3000);
		return email;
	}

	public WebElement SelectPassword() throws InterruptedException {

		password.click();
		password.clear();
		password.sendKeys(CustomerPassword);
		Thread.sleep(3000);
		return password;
	}


	public WebElement DeselectCheckBox() throws InterruptedException {

		CheckBox.click();
		Thread.sleep(3000);
		return CheckBox;
	}


	public void CreateAccountButton() throws InterruptedException {

		CreateAccountButton.click();
		Thread.sleep(3000);
	}

}
