package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class Page {
    WebDriver driver;
    WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 10);
    }

    public abstract void click(By locator);

    public abstract WebElement waitElement(By locator);

    public abstract void writeText(By locator, String text);

    public abstract String readText(By locator);

    public abstract String getAlertboxText();

    public abstract WebElement find(By locator);

    public abstract List<WebElement> multipleFind(By locator);

    public abstract void acceptAlertbox();

    public abstract void selectItem(By locator, String value);

    @SneakyThrows
    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
    }
}
