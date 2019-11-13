package Pages;

import WebDriverUtils.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.Random;


public class DPProductDetailsPage {

    @FindBys(@FindBy(css = ".ProductSizes-list>button"))
    List<WebElement> prodSizeList;

    @FindBy(className = "Button")
    WebElement addToBasket;


    public void addToBasket() {
        WebDriverUtils.waitForAllElementsToBeVisible( prodSizeList );
        System.out.println( "size is of prod size list is:" + prodSizeList.size() );
        Random sendreq = new Random();
            int randomvalue;
            randomvalue=sendreq.nextInt( prodSizeList.size()-1 ) + 1;
            System.out.println( "random no of prod size is: " + randomvalue );
            prodSizeList.get( randomvalue ).click();
            addToBasket.click();
        }


}