package utils.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements IBrowser {

    @Override
    public WebDriver createInstance() {
        return new ChromeDriver();
    }
}
