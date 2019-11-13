package WebDriverUtils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver driver;
    private String browser = System.getProperty("browser");


    @Before
    public void setUp() throws MalformedURLException {
        if (browser == null || browser.equals("chrome")) {
            driver = getChromeDriver();
            driver.manage().timeouts().implicitlyWait( 30, TimeUnit.SECONDS );
        } else if (browser.equals("firefox")) {
            //getFirefoxDriver();
        } else if (browser.equals("IE")) {
            //getIEDriver();
        }
    }

    private WebDriver getChromeDriver () throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sraav\\OneDrive\\Documents\\Chromedriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        // Configuration to run on mobile device on grid using Appium
            /*DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setBrowserName( "Chrome" );
            caps.setPlatform( Platform.ANDROID);
            caps.setCapability( "platformName","ANDROID" );
            caps.setCapability( "deviceName","Samsung M10" );
            caps.setCapability( "automationName", "uiautomator2" );*/

        // Configuration to run on Desktop on grid
            /*DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setBrowserName( "chrome" );
            caps.setPlatform( Platform.WIN10);

            return new RemoteWebDriver(new URL( "http://localhost:4444/wd/hub" ), caps);*/
        return new ChromeDriver(options);
    }

    @After
    public void tearDown (Scenario scn) throws IOException {
        if(scn.isFailed()){
            byte[] scrFile = ((TakesScreenshot)driver).getScreenshotAs( OutputType.BYTES);
            scn.embed(scrFile,"image/png");
        }
        driver.close();
    }
}
