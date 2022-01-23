package utils;

import enums.BrowserType;
import org.openqa.selenium.WebDriver;

public class BrowserManager {

    private static WebDriver driver;

    public static WebDriver getDriver(BrowserType browser) {
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
        return driver;
    }
}
