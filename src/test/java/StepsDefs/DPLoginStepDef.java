package StepsDefs;

import Pages.DPLOginPage;
import WebDriverUtils.DriverFactory;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DPLoginStepDef {

    WebDriver driver = DriverFactory.driver;
    DPLOginPage LoginPage = PageFactory.initElements( driver, DPLOginPage.class );

    public String u;
    public String p;
    @Given("^I am on DP HomePage$")
    public void i_am_on_DP_HomePage()  {
        LoginPage.LaunchHomePage();

    }

    @Given("^I am on DP LoginPage$")
    public void i_am_on_DP_LoginPage()  {
        i_am_on_DP_HomePage();
        LoginPage.navigateToLoginPage();

    }

    @When("I enter (.*) and (.*)")
    public void i_enter_credentials(String u, String p) {
        LoginPage.EnterDetails( u, p);

    }

    @Then("^I should be logged in successfully$")
    public void i_should_be_logged_in_successfully() {

        Assert.assertTrue( "account text not displayed", LoginPage.VerifySignin() );
    }

    @Given("I login with credentials (.*) and (.*)")
    public void searchWithLogIn(String uname, String password) throws InterruptedException{
        i_enter_credentials(uname, password);
        i_should_be_logged_in_successfully();

    }
    @Then("Login (.*) should be displayed")
    public void i_should_be_logged_in_successfully(String msg) {
        Assert.assertEquals( "error text not displayed", true, LoginPage.VerifyErrorMsg().contentEquals( msg ));
    }


}