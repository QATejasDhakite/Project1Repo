package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.TestBase;
import Pages._3_CartPage;
import Utility.ReadData;
import Pages._2_InventoryPage;
import Pages._1_LoginPage;

public class _3_cartPageTest extends TestBase {
        
	_1_LoginPage login;
	_2_InventoryPage invent;
	_3_CartPage cart;
	
	    @BeforeMethod(alwaysRun = true)
        public void setup() throws Exception
        {   initalization();
	    	login = new _1_LoginPage();
	    	invent = new _2_InventoryPage();
	    	cart = new _3_CartPage();
	    	login.loginToApplication();
	    	invent.add6Product();
	    	invent.clickonCartIcon();
	    }
	     
        @Test (groups = {"Smoke, Sanity"})
        public void verifyCartPageURLTest() throws Exception
        {   String expURL = ReadData.readExcelFile(1, 6);
        	String actURL = cart.verifyCartPageURL();
        	Assert.assertEquals(expURL, actURL);
        	Reporter.log("URL of Cart page :-"+ actURL);
        }
        
        @Test (groups = "Smoke")
        public void verifyCartLabelTest() throws Exception
        {    String expLabel =ReadData.readExcelFile(1, 7);
        	String actLabel = cart.verifyCartLabel();
        	Assert.assertEquals(expLabel, actLabel);
        	Reporter.log("Label of Cart page :-"+ actLabel);
        }
        
        @AfterMethod(alwaysRun = true)
        public void closeBrowser()
        {
        	driver.close();
        }
  }
