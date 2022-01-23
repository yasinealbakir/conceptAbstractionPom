package utils;

import enums.DriverType;
import org.openqa.selenium.WebDriver;

public class BrowserManager {

    private static WebDriver driver;

    public static WebDriver getDriver(DriverType browser) {
        try {
            if (browser == DriverType.Chrome) {
                driver = new Chrome().createInstance();
            } else if (browser == DriverType.Firefox) {
                driver = new Firefox().createInstance();
            } else if (browser == DriverType.Edge) {
                driver = new Edge().createInstance();
            } else {
                throw new BrowserException(browser + " is not supported");
            }
        } catch (BrowserException exception) {
            exception.getMessage();
        }
        return driver;
    }
}
