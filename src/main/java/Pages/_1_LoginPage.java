package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import Utility.ReadData;

public class _1_LoginPage extends TestBase {
   @FindBy(xpath = "//div[@class='login_logo']")private WebElement loginLogo;
   @FindBy(xpath = "//img[@class='bot_column']")private WebElement botLogo;
   @FindBy(xpath = "//input[@id='user-name']")private WebElement usernameTextbox;
   @FindBy(xpath = "//input[@id='password']")private WebElement passwordTextbox;
   @FindBy(xpath = "//input[@id='login-button']")private WebElement loginBtn;
    
   public _1_LoginPage() 
   {
	   PageFactory.initElements(driver, this);
   }
   
   public String loginToApplication() throws Exception
   {
	logger = report.createTest("Test Case of Login to Sauce Lab Application");
	usernameTextbox.sendKeys(ReadData.readPropertyFile("username"));
	logger.log(Status.INFO, "Username is entered");
	passwordTextbox.sendKeys(ReadData.readPropertyFile("password"));
	logger.log(Status.INFO, "Password is entered");
	loginBtn.click();
	logger.log(Status.INFO, "Login button is Clicked.");
	logger.log(Status.PASS, "Login Sucessful");
    return driver.getCurrentUrl(); 
   }
   
   public boolean verifyLoginLogo()
   {   
	   logger = report.createTest("Test Case of Verify Login Logo ");
	   logger.log(Status.INFO, "Logo is displayed");
	   logger.log(Status.PASS, "Login Logo verification is passed");
	   return loginLogo.isDisplayed();
   }
   
   public boolean verifyBotLogo()
   {   
	   logger = report.createTest("Test Case of Verify Bot Logo ");
	   logger.log(Status.INFO, "Logo is displayed");
	   logger.log(Status.PASS, "Bot Logo verification is passed");
	   return botLogo.isDisplayed();
   }
   
   
   
   
   
	public String verifyTitleofApp() 
	{
	logger = report.createTest("Test Case of Verify Application Title ");
    logger.log(Status.INFO, "Application Title is available");
    logger.log(Status.PASS, "Application Title is verified");
	return driver.getTitle();
    }
	  
	public String verifyURLfApp()
	{
    logger = report.createTest("Test Case of Verify URL of Application ");
    logger.log(Status.INFO, "URL of Application is available");
	logger.log(Status.PASS, "URL of Application is verified");
	return driver.getCurrentUrl();
	}
	
	public String loginToAppWithMultipleCreds(String un, String pwd) throws Exception
	   {
		usernameTextbox.sendKeys(un);
		passwordTextbox.sendKeys(pwd);
		loginBtn.click();
	    return driver.getCurrentUrl(); 
	   }
}
