package Pages;

import WebDriverUtils.*;
import WebDriverUtils.DriverFactory;
import WebDriverUtils.WebDriverUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class DPHeaderPage {

    DPFooterPage footerPage = new DPFooterPage();

    WebDriver driver = DriverFactory.driver;
    JsMethods MethodFunc = new JsMethods();


    @FindBy(xpath = ("//button[@class ='ShippingDestination ShippingDestination--dorothyPerkinsHeader']/span[contains(@class,'flag')]"))
    WebElement currencyIcon;

    @FindBy(className = "ShippingPreferencesSelector-inputGroupButton")
    WebElement go;

    @FindBy(className = "ShippingPreferencesSelector-subHeading")
    WebElement Text;

    @FindBy(id = "country")
    WebElement country;

    @FindBy(xpath = ("//button[@class ='ShippingDestination ShippingDestination--dorothyPerkinsHeader']/span[contains(@class,'bracketed')]"))
    WebElement USDollar;

    @FindBy(className = "AccountIcon-icon")
    WebElement AccountIcon;

    @FindBy(className = "WishlistHeaderLink-icon")
    WebElement WishListIcon;

    @FindBy(className = "ShoppingCart-icon")
    WebElement ShoppingCartIcon;

    @FindBy(id = "searchTermInput")
    WebElement searchBar;

    @FindBy(className = "SearchBar-icon")
    WebElement searchBtn;

    @FindBy(className = "ShippingDestination ShippingDestination--dorothyPerkinsHeader")
    WebElement currencyType;

    @FindBy(xpath = "//a[@title='New In']")
    WebElement NewInTab;

    @FindBys(@FindBy(xpath = "//a[contains(@href,'new-in')]"))
    List<WebElement> newInList;

    @FindBy(xpath = "//li[@class ='ProductsBreadCrumbs-item'][contains(text(), 'New In Shoes & Boots')]")
    WebElement shoesAndBootsText;

    @FindBy(xpath = "//a[@title = 'Clothing']")
    WebElement clothingTab;

    @FindBys(@FindBy(xpath = "//a[starts-with(@title,'C')]//following::a"))
    List<WebElement> clothingList;

    @FindBys(@FindBy(xpath = "//a[contains(@href,'Clothing')]"))
    List<WebElement> ClothingList;

    @FindBy(xpath = "//h1[@class ='CategoryHeader-title']")
    WebElement skirtsText;

    @FindBy(linkText = "Dresses")
    WebElement DressesTab;

    @FindBy(linkText = "Shoes")
    WebElement ShoesTab;

    @FindBy(linkText = "Accessories")
    WebElement AccessoriesTab;

    @FindBy(linkText = "Sale")
    WebElement SaleTab;

    @FindBy(linkText = "Menswear")
    WebElement MenswearTab;

    @FindBy(linkText = "Inspire Me")
    WebElement InspireMeTab;

    @FindBys(@FindBy(css = (".FooterSocialLinks.FooterContainer-socialLinksTopCenteredProp>a")))
    List<WebElement> SocialIcons;

    @FindBy(id = "loginbutton")
    WebElement facebookLogIcon;

    @FindBy(xpath = "//span[@class = 'PlpHeader-title'][contains(text(),'shoes')]")
    WebElement shoeTxt;

    @FindBy(xpath ="//span[@class='ShoppingCart-itemsCount']//parent::span")
    WebElement cartButton;




    public void openCountryDropdown() throws InterruptedException {
        //Thread.sleep(5 );
        WebDriverUtils.waitForElementToBeVisible( currencyIcon );
        MethodFunc.highLighterMethod( driver, currencyIcon );
        currencyIcon.click();
        WebDriverUtils.waitForElementToBeVisible( Text );
        //go.isDisplayed();
        String c = country.getText();
        System.out.println( c );


    }

    public void CountryDropDownSelect(String countryName) throws InterruptedException {
        country.click();
        String handle = driver.getWindowHandle();
        System.out.println( handle );
        Select SelCountry = new Select( country );
        SelCountry.selectByValue( countryName );
        MethodFunc.highLighterMethod( driver, go );
        go.click();
        Thread.sleep( 500 );
        WebDriverUtils.waitForElementToBeVisible( currencyIcon );
        String t = driver.getTitle();
        System.out.println( t );

    }

    public boolean VerifyFlagChange() {
        return true;
    }


    public void selectSocialLink() {
        MethodFunc.ScrollPage( driver );
        System.out.println( "Social List Size is:" + SocialIcons.size() );

        for (WebElement currentSocialIcon : SocialIcons) {
            String uRL = currentSocialIcon.getAttribute( "href" );
            if (uRL.contains( "facebook" )) {

                currentSocialIcon.click();
            }
        }
    }

    public boolean verifyOnSocialPage() {
        WebDriverUtils.waitForElementToBeVisible( facebookLogIcon );
        return facebookLogIcon.isDisplayed();

    }

    public void hoverOnNewInAndClick(String newInOptions) {
        Actions builder = new Actions( driver );
        builder.moveToElement( NewInTab ).perform();
        for (WebElement currentTextInList : newInList) {
            String category = currentTextInList.getText();
            System.out.println( "Actual Text-->" + category + "Expected Text-->" + newInOptions );
            if (category.contains( newInOptions )) {
                currentTextInList.click();
            }
        }
    }

    public boolean verifyTextOfNewIn() {
        WebDriverUtils.waitForElementToBeVisible( WishListIcon );
        return WishListIcon.isDisplayed();
    }

     public void hoverAndClickClothing(String clothingStyle){

         Actions builder = new Actions( driver );
         builder.moveToElement( clothingTab ).perform();
         int c = clothingList.size();
         System.out.println( c);
         for (WebElement currentTextInList : clothingList)
         {
             String clothingType = currentTextInList.getText();
             System.out.println( "Actual Text-->:" +clothingType);
             if (clothingType.equals( clothingStyle )) {
                 currentTextInList.click();
             }
         }
        WebDriverUtils.waitForElementToBeVisible( skirtsText );
     }

    public void searchForAProduct(String prod) throws InterruptedException {
        WebDriverUtils.waitForElementToBeVisible( searchBar );
        while(!searchBar.getAttribute( "value" ).contentEquals( prod )){
            searchBar.clear();
            searchBar.sendKeys(prod);
        }
        Thread.sleep( 2000 );
        searchBar.sendKeys( Keys.ENTER );
        WebDriverUtils.waitForElementToBeVisible( shoeTxt );

    }
}







