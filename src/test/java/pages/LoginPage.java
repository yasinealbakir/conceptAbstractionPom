package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.log.Log;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By btnEnter = By.xpath("//button[contains(text(),'Bank Manager Login')]");

    public HomePage signIn() {
        Log.info("Login Page is opening");
        navigateUrl(getConfigs().url());
        click(btnEnter);
        return getInstance(HomePage.class);


    }
}
