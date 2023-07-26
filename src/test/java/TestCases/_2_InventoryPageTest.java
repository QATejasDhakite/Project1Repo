package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages._2_InventoryPage;
import Pages._1_LoginPage;
import Utility.ReadData;

public class _2_InventoryPageTest extends TestBase {
	 _1_LoginPage login;
	 _2_InventoryPage invent;
	 
	@BeforeMethod(alwaysRun = true)
     public void setup() throws Exception 
    {
   	initalization();
   	login = new _1_LoginPage();
   	invent = new _2_InventoryPage();
    login.loginToApplication();
    }
	  
	@Test (enabled = true,groups = "Smoke")
	public void verifyLabelTest() throws Exception
	{
	  String expLabel = ReadData.readExcelFile(1, 3);
	  String actLabel = invent.verifyLabel();
	  Assert.assertEquals(expLabel, actLabel);
	  Reporter.log("Label Title :- "+ actLabel);
	}
	
	@Test (enabled = true,groups = "Smoke")
	public void verifyFooterLabelTest() throws Exception
	{
	  String expLabel = ReadData.readExcelFile(0, 4);
	  String actLabel = invent.verifyFooterLabel();
	  Assert.assertEquals(expLabel, actLabel);
	  Reporter.log("Footer Label Title :- "+ actLabel);
	}
	  
    @Test (enabled = true,groups = {"Regression","Sanity"},invocationCount = 1)//3
    public void add6ProductTest() throws Exception
	{
	   String expCount = ReadData.readExcelFile(1, 4);
	   String actCount = invent.add6Product();
	   Assert.assertEquals(expCount, actCount);
	   Reporter.log("Total Product Added :- "+ actCount);
	}
   
    @Test(enabled = true,groups = "Smoke")
    public void verifyProductLogoTest() 
	{
	   boolean result = invent.verifyProductLogo();
	   Assert.assertEquals(result, true);
	   Reporter.log("Visibility of Product Logo :- "+ result);
	}  
    
    @Test(enabled = true,groups = "Smoke")
    public void verifyTwitterLogoTest() 
	{
	   boolean result = invent.verifyTwitterLogo();
	   Assert.assertEquals(result, true);
	   Reporter.log("Visibility of twitter Logo :- "+ result);
	}
	  
	@Test (enabled = true,groups = "Smoke")
    public void verifyFacebookLogoTest() 
	{
	   boolean result = invent.verifyFacebookLogo();
	   Assert.assertEquals(result, true);
	   Reporter.log("Visibility of Facebook Logo :- "+ result);
	}
	  
    @Test (enabled = true,groups = "Smoke")
	public void verifyLinkedinLogoTest() 
	{
	   boolean result = invent.verifyLinkinLogo();
       Assert.assertEquals(result, true);
	   Reporter.log("Visibility of linkedin Logo :- "+ result);
    }
   
    @Test (enabled = true,groups = "Smoke")
	public void verifyFooterLogoTest() 
	{
	   boolean result = invent.verifyFooterLogo();
       Assert.assertEquals(result, true);
	   Reporter.log("Visibility of footer Logo :- "+ result);
    }
    
	@Test (enabled = true,groups = {"Regression","Sanity"},timeOut = 1000)
	 public void remove2ProductTest() throws Exception
	 {String expCount =ReadData.readExcelFile(1, 5);
	 String actCount = invent.remove2Product();
	 Assert.assertEquals(expCount, actCount);
	 Reporter.log("Count of product after removing :-"+ actCount);}  
	  
	@AfterMethod(alwaysRun = true)
	 public void closeBrowser() 
	 {
	 driver.close();
	 }
	  
}
