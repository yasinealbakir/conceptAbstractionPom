package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By btnEnter = By.xpath("//button[contains(text(),'Bank Manager Login')]");

    public HomePage signIn() {
        driver.get(getConfigs().url());
        click(btnEnter);
        return getInstance(HomePage.class);
    }
}
