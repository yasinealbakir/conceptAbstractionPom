package utils.browser;

import enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BrowserManager {

    private static WebDriver driver;

    public static WebDriver getDriver(BrowserType browser) throws InterruptedException {
        try {
            if (browser == BrowserType.Chrome) {
                driver = new Chrome().createInstance();
            } else if (browser == BrowserType.Firefox) {
                driver = new Firefox().createInstance();
            } else if (browser == BrowserType.Edge) {
                driver = new Edge().createInstance();
            } else {
                throw new BrowserException(browser + " is not supported");
            }
        } catch (BrowserException exception) {
            exception.getMessage();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
