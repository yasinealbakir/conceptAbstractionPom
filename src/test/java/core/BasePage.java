package core;

import configs.ConfigReader;
import configs.IConfig;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BasePage extends Page {

    WebDriverWait wait;
    IConfig config;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    @SneakyThrows
    public void click(By locator) {
        waitElementToClickable(locator, 10).click();
    }

    @Override
    @SneakyThrows
    public WebElement waitElementToAppear(By locator, int timeOutSecond) {
        slowDown(0.5);
        wait = new WebDriverWait(driver, timeOutSecond);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Override
    @SneakyThrows
    public WebElement waitElementToClickable(By locator, int timeOutSecond) {
        slowDown(0.5);
        wait = new WebDriverWait(driver, timeOutSecond);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    @Override
    @SneakyThrows
    public void writeText(By locator, String text) {
        waitElementToAppear(locator, 10).sendKeys(text);
    }

    @Override
    @SneakyThrows
    public String readText(By locator) {
        return waitElementToAppear(locator, 10).getText();
    }

    @Override
    @SneakyThrows
    public String getAlertboxText() {
        return driver.switchTo().alert().getText();
    }

    @Override
    @SneakyThrows
    public WebElement find(By locator) {
        return waitElementToAppear(locator, 10).findElement(locator);
    }

    @Override
    @SneakyThrows
    public List<WebElement> multipleFind(By locator) {
        return waitElementToAppear(locator, 10).findElements(locator);
    }

    @Override
    @SneakyThrows
    public void selectItem(By locator, String value) {
        new Select(find(locator)).selectByVisibleText(value);
    }

    @Override
    @SneakyThrows
    public void slowDown(double second) {
        Thread.sleep((long) (second * 1000));
    }


    @Override
    @SneakyThrows
    public void acceptAlertBox() {
        driver.switchTo().alert().accept();
    }

    @Override
    @SneakyThrows
    public IConfig getConfigs() {
        return config = ConfigReader.reader(IConfig.class);
    }

    @Override
    public void navigateUrl(String url) {
        driver.get(url);
    }

    @Override
    public void verifyAlertboxText(String text) {
        Assert.assertTrue(getAlertboxText().contains(text));
        acceptAlertBox();
    }

    @Override
    public void verifyIsDisplayed(By element) {
        Assert.assertTrue(find(element).isDisplayed());
    }
}
