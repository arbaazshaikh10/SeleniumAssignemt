package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

public class LaunchBrowser {

    public WebDriver driver;

    public WebDriver launchBrowser(String browserName){
        if(browserName.equals("Chrome")) {

            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"TRUE");  //NO LOGS
            System.setProperty("webdriver.chrome.driver","C:\\workspace\\chromedriver.exe");
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--disable-notifications");
            ops.addArguments("--start-maximized");
            driver = new ChromeDriver(ops);
        }
        else if(browserName.equals("Firefox")) {

            FirefoxOptions options = new FirefoxOptions();
            FirefoxProfile prof = new FirefoxProfile();
            prof.setPreference("dom.webnotifications.enabled",false);
            options.setProfile(prof);
            driver = new FirefoxDriver();
        }
        else {
            System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }
}
