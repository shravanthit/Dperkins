package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DPPaymentPage {
    @FindBy(xpath = "//button[@class ='Button Button--secondary Header-right Header-continueShopping']")
    WebElement continueShopping;
}
