package pages;

import configs.ConfigReader;
import configs.IConfig;
import lombok.SneakyThrows;
import org.aeonbits.owner.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage extends Page {

    IConfig config;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    @SneakyThrows
    public void click(By locator) {
        waitElementToClickable(locator).click();
    }

    @Override
    @SneakyThrows
    public WebElement waitElementToAppear(By locator) {
        slowDown(200);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Override
    @SneakyThrows
    public WebElement waitElementToClickable(By locator) {
        slowDown(200);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    @Override
    @SneakyThrows
    public void writeText(By locator, String text) {
        waitElementToAppear(locator).sendKeys(text);
    }

    @Override
    @SneakyThrows
    public String readText(By locator) {
        return waitElementToAppear(locator).getText();
    }

    @Override
    @SneakyThrows
    public String getAlertboxText() {
        return driver.switchTo().alert().getText();
    }

    @Override
    @SneakyThrows
    public WebElement find(By locator) {
        return waitElementToAppear(locator).findElement(locator);
    }

    @Override
    @SneakyThrows
    public List<WebElement> multipleFind(By locator) {
        return waitElementToAppear(locator).findElements(locator);
    }

    @Override
    @SneakyThrows
    public void selectItem(By locator, String value) {
        new Select(find(locator)).selectByVisibleText(value);
    }

    @Override
    @SneakyThrows
    public void slowDown(long milliSecond) {
        try {
            Thread.sleep(milliSecond);

        } catch (InterruptedException exception) {
            exception.getMessage();
        }
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
}
