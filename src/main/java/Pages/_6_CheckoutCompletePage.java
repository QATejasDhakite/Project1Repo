package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.TestBase;

public class _6_CheckoutCompletePage extends TestBase{
	
	@FindBy(xpath = "//div[@class='subheader']") private WebElement checkoutCompleteLabel1;
	@FindBy(xpath = "//h2[@class='complete-header']") private WebElement checkoutCompleteLabel2;
	@FindBy(xpath = "//div[@class='complete-text']") private WebElement checkoutCompleteLabel3;
	@FindBy(xpath = "//img[@class='pony_express']") private WebElement logo;

	public _6_CheckoutCompletePage()
	{
		PageFactory.initElements(driver, this);
	}

    public String verifyCompletePageURL()
    {
		return driver.getCurrentUrl();
    }

    public String verifyCompleteLabel1()
    {
		return checkoutCompleteLabel1.getText();
    }
    
    public String verifyCompleteLabel2()
    {
		return checkoutCompleteLabel2.getText();
    }
    
    public String verifyCompleteLabel3()
    {
		return checkoutCompleteLabel3.getText();	
    }
    
    public boolean verifylogo()
    {	
		return logo.isDisplayed();
    }    
}
