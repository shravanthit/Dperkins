package Pages;

import WebDriverUtils.JsMethods;
import WebDriverUtils.WebDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static WebDriverUtils.DriverFactory.driver;

public class DPDeliveryPage {

    JsMethods MethodFunc = new JsMethods();

    @FindBy(xpath = "//div[@class ='DeliveryMethods-options']//parent::label")
    List<WebElement> deliveryOptions;

    @FindBys(@FindBy(xpath = "//*[@id ='title']//parent::option"))
    List<WebElement> titleList;

    @FindBys(@FindBy(xpath = "//*[@id ='country']//parent::option"))
    List<WebElement> countryList;
    @FindBy(id = "firstName-text")
    WebElement firstName;

    @FindBy(id = "lastName-text")
    WebElement lastName;

    @FindBy(id = "telephone-tel")
    WebElement phoneNum;

    @FindBy(id = "country")
    WebElement deliveryCountry;

    @FindBy(id = "address1-text")
    WebElement address1;

    @FindBy(id = "address2-text")
    WebElement address2;

    @FindBy(id = "postcode-text")
    WebElement postCode;

    @FindBy(id="city-text")
    WebElement town;

    @FindBy(xpath = "//button[@class ='Button']")
    WebElement findAddressButton;
    
    @FindBys(@FindBy(css = ".DeliveryMethods"))
    List<WebElement> deliveryMethod;

    @FindBy(xpath = "//div[@class = 'DeliveryCTAProceed-nextButtonContainer']//button[contains(text(),'Proceed to Payment')]")
    WebElement  proceedToPaymentBtn;

    @FindBy(className = "MiniBag-lock")
    WebElement checkoutIcon;

    @FindBy(xpath = "//button[@class ='Button PaymentBtnWithTC-paynow']")
    WebElement confirmAndPayNow;

    @FindBy(xpath = "//img[@class = 'OrderProducts-deleteIcon']")
    List<WebElement> deleteIcon;



    public void deliveryOptions(){
        WebDriverUtils.waitForElementToBeVisible( checkoutIcon );
        checkoutIcon.click();
        /*System.out.println("delivery options size is :" +deliveryOptions.size());
        Random sendreq = new Random();
        int randomvalue;
        randomvalue=sendreq.nextInt( deliveryOptions.size()-1 )+1;
        System.out.println( "random no of delivery option eis: " + randomvalue );
        deliveryOptions.get( randomvalue ).click();*/

    }

    public void enterDetailsForDelivery() {
        JsMethods jsMethod = new JsMethods();

        System.out.println("title size is:" +titleList.size());
        Random sendreq = new Random();
        int randomvalue;
        randomvalue=sendreq.nextInt( titleList.size()-1 ) + 1;
        System.out.println( "random title no is: " + randomvalue );
        titleList.get( randomvalue ).click();
        WebDriverUtils.waitForElementToBeVisible( firstName );
        firstName.sendKeys( "Shravanthi" );
        lastName.sendKeys( "Thuma" );
        phoneNum.sendKeys( "07466977028" );
        System.out.println("country size is :" +countryList.size());
        Random sendreq1 = new Random();
        int randomvalue1;
        randomvalue1=sendreq1.nextInt( countryList.size()-1 ) + 1;
        System.out.println( "random country no is: " + randomvalue1 );
        countryList.get( randomvalue ).click();
        address1.sendKeys( "Mayfield" );
        address2.sendKeys( "bexley" );
        driver.manage().timeouts().implicitlyWait( 30, TimeUnit.SECONDS );
        jsMethod.click( driver,postCode );
        postCode.clear();
        postCode.sendKeys( "DA74DH" );
        town.sendKeys( "kent" );
        /*System.out.println("delivery method size is :" +deliveryMethod.size());
        Random sendreq2 = new Random();
        int randomvalue2;
        randomvalue2=sendreq2.nextInt( deliveryMethod.size()-1 ) + 1;
        System.out.println( "random delivery method no is: " + randomvalue2 );
        countryList.get( randomvalue ).click();*/
        driver.manage().timeouts().implicitlyWait( 15,TimeUnit.SECONDS );
        jsMethod.ScrollToButton( driver,proceedToPaymentBtn);
        jsMethod.click( driver,proceedToPaymentBtn );
        /*WebDriverUtils.waitForElementToBeVisible( deleteIcon );
        System.out.println( "Size of delete items is :" +deleteIcon);
        for (WebElement currentelementInDelete: deleteIcon) {
            System.out.println( currentelementInDelete );
            currentelementInDelete.click();
        }
        System.out.println( deleteIcon.size() );*/



        
    }


}
