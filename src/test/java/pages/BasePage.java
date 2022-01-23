package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage extends Page {

    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void click(By locator) {
        waitElementToClickable(locator, 500).click();
    }

    @Override
    public WebElement waitElementToAppear(By locator, long timeout) {
        slowDown(timeout);
        wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Override
    public WebElement waitElementToClickable(By locator, long timeout) {
        slowDown(timeout);
        wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    @Override
    public void writeText(By locator, String text) {
        waitElementToAppear(locator, 100).sendKeys(text);
    }

    @Override
    public String readText(By locator) {
        return waitElementToAppear(locator, 100).getText();
    }

    @Override
    public String getAlertboxText() {
        return driver.switchTo().alert().getText();
    }

    @Override
    public WebElement find(By locator) {
        return waitElementToAppear(locator, 500).findElement(locator);
    }

    @Override
    public List<WebElement> multipleFind(By locator) {
        return waitElementToAppear(locator, 500).findElements(locator);
    }

    @Override
    public void acceptAlertbox() {
        driver.switchTo().alert().accept();
    }

    @Override
    public void selectItem(By locator, String value) {
        new Select(find(locator)).selectByVisibleText(value);
    }

    @Override
    public void slowDown(long milliSecond) {
        try {
            Thread.sleep(milliSecond);

        } catch (InterruptedException exception) {
            exception.getMessage();
        }
    }
}
