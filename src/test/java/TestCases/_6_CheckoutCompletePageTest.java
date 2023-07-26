package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.TestBase;
import Pages._3_CartPage;
import Pages._6_CheckoutCompletePage;
import Utility.ReadData;
import Pages._4_CheckoutPage1;
import Pages._5_CheckoutPage2;
import Pages._2_InventoryPage;
import Pages._1_LoginPage;

public class _6_CheckoutCompletePageTest extends TestBase {
	_1_LoginPage login;
	_2_InventoryPage invent;
	_3_CartPage cart;
	_4_CheckoutPage1 check1;
	_5_CheckoutPage2 check2;
	_6_CheckoutCompletePage check3;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception
    {   initalization();
    	login = new _1_LoginPage();
    	invent = new _2_InventoryPage();
    	cart = new _3_CartPage();
    	check1 = new _4_CheckoutPage1();
    	check2 = new _5_CheckoutPage2();
    	check3 = new _6_CheckoutCompletePage();
    	login.loginToApplication();
    	invent.add6Product();
    	invent.clickonCartIcon();
    	cart.clickCheckoutBtn();
    	check1.inputCheckoutInfo();
    	check2.clickfinishBtn();
    }
	
	@Test (groups = {"Smoke, Sanity"})
	public void verifyCompletePageURLTest() throws Exception
	{
		String expURL =ReadData.readExcelFile(1, 15);
		String actURL =check3.verifyCompletePageURL();
		Assert.assertEquals(expURL, actURL);
	}
	
	@Test (groups = "Smoke")
	public void verifyCheckoutCompleteLabel1Test() throws Exception
	{   String expLabel = ReadData.readExcelFile(1, 16) ;
		String actLabel = check3.verifyCompleteLabel1();
		Assert.assertEquals(expLabel, actLabel);
		//Reporter.log("URL of checkout page Label :-"+ actLabel);
	}
	
	@Test (groups = "Smoke")
	public void verifyCheckoutCompleteLabel2Test() throws Exception
	{   String expLabel = ReadData.readExcelFile(1, 17);
		String actLabel = check3.verifyCompleteLabel2();
		Assert.assertEquals(expLabel, actLabel);
		//Reporter.log("URL of checkout page Label :-"+ actLabel);
	}
	
	@Test (groups = "Smoke")
	public void verifyCheckoutCompleteLabel3Test() throws Exception
	{   String expLabel = ReadData.readExcelFile(1, 18);
		String actLabel = check3.verifyCompleteLabel3();
		Assert.assertEquals(expLabel, actLabel);
		//Reporter.log("URL of checkout page Label :-"+ actLabel);
	}
	
	@Test (groups = "Smoke")
	public void verifylogo()
	{
	 boolean result = check3.verifylogo();
	 Assert.assertEquals(result, true);
	}
	
	@AfterMethod(alwaysRun = true)
	public void closedBrowser()
	{
		driver.close();
	}	
}
