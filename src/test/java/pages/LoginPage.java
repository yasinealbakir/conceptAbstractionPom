package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static collections.BaseCollection.URL;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By btnEnter = By.xpath("//button[contains(text(),'Bank Manager Login')]");

    public HomePage signIn() {
        System.out.println("Login sayfası açılıyor");
        driver.get(URL);
        click(btnEnter);
        return getInstance(HomePage.class);
    }
}
