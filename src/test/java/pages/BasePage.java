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

    @Override
    public void click(By locator) {
        System.out.println("Click element");
        waitElement(locator).click();
    }

    @SneakyThrows
    @Override
    public WebElement waitElement(By locator) {
        Thread.sleep(500);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Override
    public void writeText(By locator, String text) {
        System.out.println("Send key");
        waitElement(locator).sendKeys(text);
    }

    @Override
    public String readText(By locator) {
        System.out.println("Read text");
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

    @SneakyThrows
    @Override
    public void acceptAlertbox() {
        Thread.sleep(500);
        driver.switchTo().alert().accept();
    }

    @Override
    public void selectItem(By locator, String value) {
        new Select(find(locator)).selectByVisibleText(value);
    }
}
