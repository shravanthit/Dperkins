package StepsDefs;

import Pages.DPHeaderPage;
import Pages.DPProductsPage;
import WebDriverUtils.DriverFactory;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DPHeaderStepDef {
    WebDriver driver = DriverFactory.driver;
    DPHeaderPage headerPage = PageFactory.initElements( driver, DPHeaderPage.class );
    DPProductsPage productsPage = PageFactory.initElements( driver, DPProductsPage.class );

    @When("^I click on Flag icon and change the country to (.*)$")
    public void clickFlagIconAndChangeCountry(String country) throws InterruptedException {
        headerPage.openCountryDropdown();
        headerPage.CountryDropDownSelect( country );

    }

    @Then("^I should be able to see the respective Country Currency$")
    public void checkCurrencyIcon() throws InterruptedException {
        Assert.assertTrue( "AccountIcon not displayed", headerPage.VerifyFlagChange() );

    }

    @When("I click on icon")
    public void selectSocial() {
        headerPage.selectSocialLink();
    }

    @Then("I should be redirected to that page")
    public void verifyicon() {
        Assert.assertTrue( "not displayed ", headerPage.verifyOnSocialPage() );

    }

    @When("I click on (.*)")
    public void clickNewInBootsAndShoes(String newInText) {
        headerPage.hoverOnNewInAndClick( newInText );


    }

    @Then("I should be able to list of shoes and boots available")
    public void verifListOfNewInShoesAndBoots() {
        Assert.assertTrue( "texxt not dispalyed", headerPage.verifyTextOfNewIn() );


    }

    @When("I am on (.*) link")
    public void clickOnSkirts(String clothingType) {
        headerPage.hoverAndClickClothing( clothingType );

    }

    @Then("I should be able to list of skirts avaialble on site")
    public void verifListOfSkirts() {
        //Assert.assertTrue("texxt not dispalyed",headerPage.verifyTextOfNewIn());

    }


    @When("I search for (.*) in searchbar and select a random product")
    public void searchProductAndSelect(String product) throws InterruptedException {
        headerPage.searchForAProduct(product);
        productsPage.selectRandomProd();


    }

}
