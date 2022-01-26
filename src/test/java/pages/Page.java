package pages;

import configs.IConfig;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class Page {
    WebDriver driver;
    WebDriverWait wait;

    public Page(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public abstract void click(By locator);

    public abstract WebElement waitElementToAppear(By locator);

    public abstract WebElement waitElementToClickable(By locator);

    public abstract void writeText(By locator, String text);

    public abstract String readText(By locator);

    public abstract String getAlertboxText();

    public abstract WebElement find(By locator);

    public abstract List<WebElement> multipleFind(By locator);

    public abstract void selectItem(By locator, String value);

    public abstract void slowDown(long miliSecond);

    public abstract void acceptAlertBox();

    public abstract IConfig getConfigs();

    @SneakyThrows
    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver, this.wait);
    }
}
