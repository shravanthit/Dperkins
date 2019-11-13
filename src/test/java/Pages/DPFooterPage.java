package Pages;

import WebDriverUtils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DPFooterPage {

    WebDriver driver = DriverFactory.driver;

    @FindBy(id = "email-email")
    WebElement footerEmail;

    @FindBy(className = "Button FooterNewsletter-button")
    WebElement ftemailSubmit;

    @FindBy(className = "FooterSocialLinks-image")
    WebElement fbIcon;

    @FindBy(linkText = "Delivery & returns")
    WebElement deliveryReturns;

    @FindBy(linkText = "Store locator")
    WebElement Storelocator;

    @FindBy(linkText = "Student discount")
    WebElement Studentdiscount;

    @FindBy(linkText = "Gift cards")
    WebElement Giftcards;

    @FindBy(linkText = "Dorothy Perkins Mastercard")
    WebElement DPMastercard;

    @FindBy(linkText = "My account")
    WebElement myAccountFOoter;

    @FindBy(linkText = "FAQs")
    WebElement FAQs;

    @FindBy(linkText = "Contact us")
    WebElement ContactUs;

    @FindBy(linkText = "Our story")
    WebElement OurStory;

    @FindBy(linkText = "Careers")
    WebElement Careers;

    @FindBy(linkText = "Terms & conditions")
    WebElement TerCondtions;

    @FindBy(linkText = "Privacy & cookie policy")
    WebElement PrivacyPolicy;

    @FindBy(linkText = "Modern slavery act")
    WebElement MSAct;

    @FindBy(linkText = "Fashion Footprint")
    WebElement fashnFprint;

    @FindBy(linkText = "Accessibility")
    WebElement Accessibility;

    @FindBy(linkText = "Manage cookies")
    WebElement Managecookies;



}
