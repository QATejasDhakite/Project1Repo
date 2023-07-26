package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Base.TestBase;
import Utility.HandleDropdown;
import Utility.ReadData;

public class _2_InventoryPage extends TestBase {

	@FindBy(xpath = "//div[@class='product_label']")private WebElement productLabel;
	@FindBy(xpath = "//div[@class='peek']")private WebElement productLogo;
	@FindBy(xpath = "//select[@class='product_sort_container']")private WebElement productSortDropdown;
	@FindBy(xpath = "//li[@class='social_twitter']")private WebElement twitterLogo;
	@FindBy(xpath = "//li[@class='social_facebook']")private WebElement facebookLogo;
	@FindBy(xpath = "//li[@class='social_linkedin']")private WebElement linkedinLogo;
	@FindBy(xpath = "//img[@class='footer_robot']")private WebElement footerLogo;
	@FindBy(xpath = "//div[@class='footer_copy']")private WebElement footerLabel;
	@FindBy(xpath = "(//div[@class='inventory_item'])[5]//button")private WebElement bagPackProduct;
	@FindBy(xpath = "(//div[@class='inventory_item'])[2]//button")private WebElement bikeLightProduct;
	@FindBy(xpath = "(//div[@class='inventory_item'])[3]//button")private WebElement boltBlackTshirtProduct;
	@FindBy(xpath = "(//div[@class='inventory_item'])[6]//button")private WebElement jacketProduct;
	@FindBy(xpath = "(//div[@class='inventory_item'])[1]//button")private WebElement whiteTshirtProduct;
	@FindBy(xpath = "(//div[@class='inventory_item'])[4]//button")private WebElement redTshirtProduct;
	@FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge']")private WebElement cartCount;
	@FindBy(xpath = "(//div[@class='inventory_item'])[5]//button[text()='REMOVE']")private WebElement RemovebagPackProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")private WebElement RemovebikeLightProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']")private WebElement RemoveboltBlackTshirtProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-fleece-jacket']")private WebElement RemovejacketProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']")private WebElement RemovewhiteTshirtProduct;
	@FindBy(xpath = "(//div[@class='inventory_item'])[4]//button[text()='REMOVE']")private WebElement RemoveredTshirtProduct;
	

    public _2_InventoryPage()
    {
	 PageFactory.initElements(driver, this);
    }
 
    public String verifyLabel() 
    {
    	return productLabel.getText();
    }
    
    public boolean verifyProductLogo()
    {
    	return twitterLogo.isDisplayed();
    }
    
    
    public boolean verifyTwitterLogo()
    {
    	return twitterLogo.isDisplayed();
    }
    
    public boolean verifyFacebookLogo()
    {
    	return facebookLogo.isDisplayed();
    }
    
    public boolean verifyLinkinLogo()
    {
    	return linkedinLogo.isDisplayed();
    }
    
    public boolean verifyFooterLogo()
    {
    	return footerLogo.isDisplayed();
    }
    
    public String verifyFooterLabel() 
    {
    	return footerLabel.getText();
    }

   public String add6Product() throws Exception
   {
	HandleDropdown.handleSelectClass(productSortDropdown,ReadData.readExcelFile(0, 0));
	bagPackProduct.click();
	bikeLightProduct.click();
	boltBlackTshirtProduct.click();
	jacketProduct.click();
	whiteTshirtProduct.click();
	redTshirtProduct.click();
	return cartCount.getText();
   }
    
    public String remove2Product() throws Exception 
    {   add6Product();
    	RemovebagPackProduct.click();
    	RemoveredTshirtProduct.click();
    	return cartCount.getText();
    }
    
    public void clickonCartIcon() 
    {
		cartCount.click();
	}
 }
