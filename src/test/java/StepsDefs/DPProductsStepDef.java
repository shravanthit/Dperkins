package StepsDefs;

import Pages.DPDeliveryPage;
import Pages.DPMyBagPage;
import Pages.DPProductDetailsPage;
import WebDriverUtils.DriverFactory;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DPProductsStepDef {
    WebDriver driver = DriverFactory.driver;
    DPProductDetailsPage productDetailsPage = PageFactory.initElements( driver, DPProductDetailsPage.class );
    DPDeliveryPage dpDeliveryPage = PageFactory.initElements( driver, DPDeliveryPage.class );
    DPMyBagPage dpMyBagPage = PageFactory.initElements( driver, DPMyBagPage.class );


    @When("I add to basket and checkout")
    public void addBasket(){
        productDetailsPage.addToBasket();
    }

    @Then("I should be on Delivery page")
    public void onDelievryPage() throws InterruptedException {
        dpDeliveryPage.deliveryOptions();
        dpDeliveryPage.enterDetailsForDelivery();
        dpMyBagPage.deleteItemsFromBag();

    }


}
