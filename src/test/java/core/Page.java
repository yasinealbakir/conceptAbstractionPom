package core;

import configs.IConfig;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Page {
    WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void click(By locator);

    public abstract WebElement waitElementToAppear(By locator, Duration timeOutSecond);

    public abstract WebElement waitElementToClickable(By locator, Duration timeOutSecond);

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
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Page.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
