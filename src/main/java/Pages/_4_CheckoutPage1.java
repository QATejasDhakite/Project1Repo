package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.TestBase;
import Utility.ReadData;

public class _4_CheckoutPage1 extends TestBase{

	@FindBy(xpath="//div[@class='subheader']") private WebElement checkout1Label;
	@FindBy(xpath="//input[@id=\"first-name\"]") private WebElement firstnameTextbox;
	@FindBy(xpath="//input[@id=\"last-name\"]") private WebElement lastnameTextbox;
	@FindBy(xpath="//input[@id=\"postal-code\"]") private WebElement zipcodeTextbox;
	@FindBy(xpath="//input[@class='btn_primary cart_button']") private WebElement continuebtn;
	
	public _4_CheckoutPage1()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCheckoutPage1URL() 
	{
		return driver.getCurrentUrl();
	}
	
	public String verifyCheckoutPage1Label() 
	{
		return checkout1Label.getText();
	}
	
	public String inputCheckoutInfo() throws Exception 
	{
		firstnameTextbox.sendKeys(ReadData.readExcelFile(0, 1));
		lastnameTextbox.sendKeys(ReadData.readExcelFile(0, 2));
		zipcodeTextbox.sendKeys(ReadData.readExcelFile(0, 3));
		continuebtn.click();
		return driver.getCurrentUrl();	
	}
	
	public void clickContinueBtn()
	{
		continuebtn.click();
	}
	
}
