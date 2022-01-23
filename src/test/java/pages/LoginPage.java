package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static configs.BaseCollection.URL;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By btnEnter = By.xpath("//button[contains(text(),'Bank Manager Login')]");

    public HomePage signIn() {
        driver.get(URL);
        click(btnEnter);
        return getInstance(HomePage.class);
    }
}
