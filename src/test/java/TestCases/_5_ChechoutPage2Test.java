package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.TestBase;
import Pages._3_CartPage;
import Pages._4_CheckoutPage1;
import Pages._5_CheckoutPage2;
import Utility.ReadData;
import Pages._2_InventoryPage;
import Pages._1_LoginPage;

public class _5_ChechoutPage2Test extends TestBase {
	
	_1_LoginPage login;
	_2_InventoryPage invent;
	_3_CartPage cart;
	_4_CheckoutPage1 check1;
	_5_CheckoutPage2 check2;
	
	@BeforeMethod(alwaysRun = true)
	
	public void setup() throws Exception
    {   initalization();
    	login = new _1_LoginPage();
    	invent = new _2_InventoryPage();
    	cart = new _3_CartPage();
    	check1 = new _4_CheckoutPage1();
    	check2 = new _5_CheckoutPage2();
    	login.loginToApplication();
    	invent.add6Product();
    	invent.clickonCartIcon();
    	cart.clickCheckoutBtn();
    	check1.inputCheckoutInfo();
    	
    }
		
	@Test (groups = "Smoke")
	public void verifyChekoutPage2Label() throws Exception
	{
		String expLabel = ReadData.readExcelFile(1, 11);
		String actLabel = check2.verifyChekoutPage2Label();
		Assert.assertEquals(expLabel, actLabel);
	}
	
	@Test (groups = "Smoke")
	public void verifypaymentInfoLabel() throws Exception
	{
		String expLabel = ReadData.readExcelFile(1, 12);
		String actLabel = check2.verifypaymentInfoLabel();
		Assert.assertEquals(expLabel, actLabel);
	}
	
	@Test (groups = "Smoke")
	public void verifyshippingInfoLabel() throws Exception
	{
		String expLabel = ReadData.readExcelFile(1, 13);
		String actLabel = check2.verifyshippingInfoLabel();
		Assert.assertEquals(expLabel, actLabel);
	}
	
	@Test (groups = "Smoke")
	public void verifytotalAmountLabel() throws Exception
	{
		String expLabel = ReadData.readExcelFile(1, 14);;
		String actLabel = check2.verifytotalAmountLabel();
		Assert.assertEquals(expLabel, actLabel);
	}
	
	@AfterMethod(alwaysRun = true)
	public void closedBrowser()
	{
		driver.close();
	}
}
