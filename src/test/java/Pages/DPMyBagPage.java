package Pages;

import WebDriverUtils.WebDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static WebDriverUtils.DriverFactory.driver;

public class DPMyBagPage {

    DPHeaderPage headerPage = new DPHeaderPage();

    @FindBys(@FindBy(css = ".OrderProducts-deleteIcon"))
    List<WebElement> deleteIcon;

    @FindBy(xpath = "//button[@class ='Button Button--secondary Header-right Header-continueShopping']")
    WebElement continueShopping;

    @FindBy(xpath = "//button[@class ='Button OrderProducts-deleteButton']")
    WebElement deleteBtn;

    public void deleteItemsFromBag() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait( 30,TimeUnit.SECONDS );
        continueShopping.click();
        WebDriverUtils.waitForElementToBeVisible(headerPage.cartButton );
        Thread.sleep( 1000 );
        headerPage.cartButton.click();
        WebDriverUtils.waitForElementToBeVisible( deleteIcon );
        System.out.println( "Size of delete items is :" +deleteIcon);
        for (WebElement currentelementInDelete:deleteIcon) {
            System.out.println( currentelementInDelete );
            currentelementInDelete.click();
            deleteBtn.click();
        }
        System.out.println( deleteIcon.size() );
        }
    }
