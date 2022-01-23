package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage extends Page {

    public BasePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public void click(By locator) {
        waitElementToClickable(locator).click();
    }

    @Override
    public WebElement waitElementToAppear(By locator) {
        slowDown(500);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Override
    public WebElement waitElementToClickable(By locator) {
        slowDown(500);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    @Override
    public void writeText(By locator, String text) {
        waitElementToAppear(locator).sendKeys(text);
    }

    @Override
    public String readText(By locator) {
        return waitElementToAppear(locator).getText();
    }

    @Override
    public String getAlertboxText() {
        return driver.switchTo().alert().getText();
    }

    @Override
    public WebElement find(By locator) {
        return waitElementToAppear(locator).findElement(locator);
    }

    @Override
    public List<WebElement> multipleFind(By locator) {
        return waitElementToAppear(locator).findElements(locator);
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

    @Override
    public void acceptAlertBox() {
        driver.switchTo().alert().accept();
    }
}
