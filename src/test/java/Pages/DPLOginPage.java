package Pages;

import WebDriverUtils.DriverFactory;
import WebDriverUtils.JsMethods;
import WebDriverUtils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class DPLOginPage {

    JsMethods MethodFunc = new JsMethods();


    WebDriver driver = DriverFactory.driver;

    @FindBy(className = "AccountIcon-icon")
    WebElement AccountIcon;

    @FindBy(id = "Login-email")
    WebElement login;

    @FindBy(id = "Login-password")
    WebElement pwd;

    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement submitBtn;

    @FindBy(id = "truste-consent-button")
    WebElement Accept;

    @FindBy(xpath = ("//div[@class ='Main-inner']//h1"))
    WebElement verifyAccounttxt;

    @FindBy(xpath = ("//div[@class='Message is-shown is-error ']/p[@class='Message-message']"))
    WebElement errorMsg;


    public void LaunchHomePage() {
        driver.get( "https://www.dorothyperkins.com/" );
        driver.manage().timeouts().implicitlyWait( 30, TimeUnit.SECONDS );
        driver.manage().window().maximize();
        Accept.click();
    }

    public void navigateToLoginPage(){
        WebDriverUtils.waitForElementToBeVisible( AccountIcon );
        MethodFunc.highLighterMethod(driver, AccountIcon);
        AccountIcon.click();

    }

    public void EnterDetails(String username, String password) {
        WebDriverUtils.waitForElementToBeVisible( login );
        login.sendKeys( username );
        pwd.sendKeys( password );
        submitBtn.click();

    }

    public boolean VerifySignin() {

        WebDriverUtils.waitForElementToBeVisible( verifyAccounttxt );

        return verifyAccounttxt.isDisplayed();

    }

    public String VerifyErrorMsg(){

       String text = errorMsg.getText();
       System.out.println( text );
       return text;
    }
}
