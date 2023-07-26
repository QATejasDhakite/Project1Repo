package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.TestBase;
import Pages._1_LoginPage;
import Utility.CaptureScreenShot;
import Utility.ReadData;


  public class _1_LoginPageTest extends TestBase{
  _1_LoginPage login;
    
	  @BeforeMethod (alwaysRun = true)
      public void setup() throws Exception
      {
    	initalization();
    	login = new _1_LoginPage(); 	
      }
    
	  @Test (enabled = true, priority = 3/*, dependsOnMethods = "verifyURLofAppTest"*/,groups = {"Regression","Sanity"})
	  public void loginToApplicationTest() throws Exception
	  {
		  String expURL = ReadData.readExcelFile(1, 2);
		  String actURL =login.loginToApplication();
		  Assert.assertEquals(expURL,actURL);
		  Reporter.log("Current URL of application :-" +actURL);
	  }
	    
      @Test (enabled = true, priority = 2/*, dependsOnMethods = "verifyURLofAppTest"*/,groups = "Smoke")
      public void verifyLoginLogoTest() 
      {
    	boolean result = login.verifyLoginLogo();
    	Assert.assertEquals(result, true);
    	Reporter.log("visibility of login logo :-" +result);		
      }
    
      @Test (enabled = true, priority = 3/*, dependsOnMethods = "verifyURLofAppTest"*/,groups = "Smoke")
      public void verifyBotLogoTest() 
      {
    	boolean result = login.verifyBotLogo();
    	Assert.assertEquals(result, true);
    	Reporter.log("visibility of Bot logo :-" +result);		
      }
      
      
      
      
      
      @Test(enabled = true, priority = 0,groups = {"Smoke, Sanity"})
	  public void verifyURLofAppTest() throws Exception 
      {
    	String expURL =ReadData.readExcelFile(1, 1);
    	String actURL = login.verifyURLfApp();
    	Assert.assertEquals(expURL, actURL);
    	Reporter.log("Orignal URL of application :-" +actURL);
      }
    
      @Test(enabled = true, priority = 1/*, dependsOnMethods = "verifyURLofAppTest"*/,groups = "Smoke")
	  public void verifyTitleTest() throws Exception 
	  {
		   // String expTitle = "Swag Labs";
		    String expTitle = ReadData.readExcelFile(1, 0);
			String actTitle = login.verifyTitleofApp();
		    Assert.assertEquals(expTitle, actTitle);
	  }
    
	  @AfterMethod (alwaysRun = true)
	  public void closeBrowser(ITestResult it) throws Exception{
	   
		if (ITestResult.FAILURE == it.getStatus())
	   {
		CaptureScreenShot.screenshot(it.getName());
	   }
		report.flush();
		driver.close();
	
   }
 }

	
  
