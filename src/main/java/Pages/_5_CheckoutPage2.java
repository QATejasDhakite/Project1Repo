package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class _5_CheckoutPage2 extends TestBase {
    @FindBy(xpath = "//div[@class='subheader']") private WebElement checkoutPage2Label;
    @FindBy(xpath = "//div[@class=\"summary_value_label\"][1]") private WebElement paymentInfoLabel;
    @FindBy(xpath = "//div[@class=\"summary_value_label\"][2]") private WebElement shippingInfoLabel;
    @FindBy(xpath = "//div[@class='summary_total_label']") private WebElement totalAmountLabel;
    @FindBy(xpath = "//a[@class='btn_action cart_button']") private WebElement finishBtn;
    
    public _5_CheckoutPage2()
    {
    	PageFactory.initElements(driver, this);
    }
    
    public String verifyChekoutPage2Label()
    {
    	return checkoutPage2Label.getText();
    }
    
    public String verifypaymentInfoLabel()
    {
    	return paymentInfoLabel.getText();
    }
    
    public String verifyshippingInfoLabel()
    {
    	return shippingInfoLabel.getText();
    }
    public String verifytotalAmountLabel()
    {
    	return totalAmountLabel.getText();
    }
    
    public void clickfinishBtn()
    {
    	finishBtn.click();
    }
}
