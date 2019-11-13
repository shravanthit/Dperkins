package WebDriverUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public interface WebDriverUtils {

    WebDriver driver = DriverFactory.driver;
    WebDriverWait wait = new WebDriverWait( driver, 30 );

    static void waitForElementToBeVisible(List<WebElement> element) {
        wait.until( ExpectedConditions.visibilityOf( (WebElement) element ) );
    }

    static void waitForElementToBeClickable(WebElement element) {
        wait.until( ExpectedConditions.elementToBeClickable( element ) );
    }

    static void waitForElementToBeVisible(WebElement element) {
        wait.until( ExpectedConditions.visibilityOf( element ) );
    }

    static void waitForAllElementsToBeVisible(List<WebElement> elements){
        wait.until( ExpectedConditions.visibilityOfAllElements(elements  ) );
    }
}

