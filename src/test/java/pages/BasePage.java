package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage extends Page {
    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void click(By locator) {
        waitElement(locator).click();
    }

    @Override
    public WebElement waitElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Override
    public void writeText(By locator, String text) {
        waitElement(locator).sendKeys(text);
    }

    @Override
    public String readText(By locator) {
        return waitElement(locator).getText();
    }

    @Override
    public String getAlertboxText() {
        return driver.switchTo().alert().getText();
    }

    @Override
    public WebElement find(By locator) {
        return waitElement(locator).findElement(locator);
    }

    @Override
    public List<WebElement> multipleFind(By locator) {
        return waitElement(locator).findElements(locator);
    }

    @Override
    public void acceptAlertbox() {
        driver.switchTo().alert().accept();
    }

    @Override
    public void selectItem(By locator, String value) {
        new Select(find(locator)).selectByVisibleText(value);
    }
}
