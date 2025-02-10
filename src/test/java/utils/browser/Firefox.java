package utils.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements IBrowser {
    @Override
    public WebDriver createInstance() {
        return new FirefoxDriver();
    }
}
