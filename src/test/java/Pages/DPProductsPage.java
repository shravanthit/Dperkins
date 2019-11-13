package Pages;

import WebDriverUtils.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class DPProductsPage {
    WebDriver driver = DriverFactory.driver;

    @FindBy(id = "searchTermInput")
    WebElement searchBar;

    @FindBy(className = "SearchBar-button")
    WebElement searchButton;

    @FindBy(className = "Product-nameLink")
    List<WebElement> prodList;


    @FindBy(className = "SizeGuide-icon")
    WebElement sizeGuideIcon;

  JsMethods jsMethod = new JsMethods();

    public void selectRandomProd() throws InterruptedException {
        System.out.println("Size of products is :" +prodList.size());
        Random sendreq = new Random();
        int randomValue = sendreq.nextInt(prodList.size());
        System.out.println("random no products is:" +randomValue);
        jsMethod.ScrollToButton(driver, prodList.get(randomValue) );
        jsMethod.click( driver, prodList.get(randomValue) );

    }
}