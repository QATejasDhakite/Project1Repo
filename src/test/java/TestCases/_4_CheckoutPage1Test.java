package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.TestBase;
import Pages._3_CartPage;
import Pages._4_CheckoutPage1;
import Utility.ReadData;
import Pages._2_InventoryPage;
import Pages._1_LoginPage;

public class _4_CheckoutPage1Test extends TestBase {
	_1_LoginPage login;
	_2_InventoryPage invent;
	_3_CartPage cart;
	_4_CheckoutPage1 check1;
	
	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception
    {   initalization();
    	login = new _1_LoginPage();
    	invent = new _2_InventoryPage();
    	cart = new _3_CartPage();
    	check1 = new _4_CheckoutPage1();
    	login.loginToApplication();
    	invent.add6Product();
    	invent.clickonCartIcon();
    	cart.clickCheckoutBtn();
    	
    }
		
	@Test (groups = {"Smoke, Sanity"})
	public void verifyCheckoutPage1URLTest() throws Exception
	{
		
		String expURL = ReadData.readExcelFile(1, 8);
		String actURL = check1.verifyCheckoutPage1URL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of checkout page 1 :-"+ actURL);
	}
		
	@Test (groups = "Smoke")
	public void verifyCheckoutPage1LabelTest() throws Exception
	{   String expLabel = ReadData.readExcelFile(1, 9);
		String actLabel = check1.verifyCheckoutPage1Label();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Label of checkout page Label :-"+ actLabel);
	}
	
	@Test (groups = "Sanity")
	public void inputCheckoutInfoTest() throws Exception
	{   
		String expURL =ReadData.readExcelFile(1, 10);;
		String actURL = check1.inputCheckoutInfo();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("URL of checkout page 2 :-"+ actURL);
	}
	
	@AfterMethod(alwaysRun = true)
	public void closedBrowser()
	{
		driver.close();
	}	
}
