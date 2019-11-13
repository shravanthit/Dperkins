package WebDriverUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class JsMethods {

    public void highLighterMethod(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript( "arguments[0].setAttribute('style', 'background: ; border: 2px solid red;');", element );
    }

    public void ScrollToButton(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void ScrollPage(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void click(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void CountryDropDownSelect(WebElement element, String Value){
        Select SelCountry =new Select(element);
        SelCountry.selectByValue(Value);
    }

    public void actions(WebDriver driver, WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
        element.click();
    }

    public void selectDropDown(WebElement element, String p){
        Select SelCountry = new Select( element );
        SelCountry.selectByValue( p );
    }
}
