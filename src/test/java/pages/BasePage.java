package pages;

import lombok.SneakyThrows;
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

    @SneakyThrows
    @Override
    public void click(By locator) {
        waitElement(locator).click();
    }

    @SneakyThrows
    @Override
    public WebElement waitElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @SneakyThrows
    @Override
    public void writeText(By locator, String text) {
        waitElement(locator).sendKeys(text);
    }

    @SneakyThrows
    @Override
    public String readText(By locator) {
        return waitElement(locator).getText();
    }

    @SneakyThrows
    @Override
    public String getAlertboxText() {
        return driver.switchTo().alert().getText();
    }

    @SneakyThrows
    @Override
    public WebElement find(By locator) {
        return waitElement(locator).findElement(locator);
    }

    @SneakyThrows
    @Override
    public List<WebElement> multipleFind(By locator) {
        return waitElement(locator).findElements(locator);
    }

    @SneakyThrows
    @Override
    public void acceptAlertbox() {
        Thread.sleep(500);
        driver.switchTo().alert().accept();
    }

    @SneakyThrows
    @Override
    public void selectItem(By locator, String value) {
        new Select(find(locator)).selectByVisibleText(value);
    }
}
