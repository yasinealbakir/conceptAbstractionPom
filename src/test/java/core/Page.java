package core;

import configs.IConfig;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class Page {
    WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void click(By locator);

    public abstract WebElement waitElementToAppear(By locator, int timeOutSecond);

    public abstract WebElement waitElementToClickable(By locator, int timeOutSecond);

    public abstract void writeText(By locator, String text);

    public abstract String readText(By locator);

    public abstract String getAlertboxText();

    public abstract WebElement find(By locator);

    public abstract List<WebElement> multipleFind(By locator);

    public abstract void selectItem(By locator, String value);

    public abstract void slowDown(double second);

    public abstract void acceptAlertBox();

    public abstract IConfig getConfigs();

    public abstract void navigateUrl(String url);

    public abstract void verifyAlertboxText(String text);

    public abstract void verifyIsDisplayed(By element);

    @SneakyThrows
    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
    }
}
