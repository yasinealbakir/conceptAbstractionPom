package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OpenAccountPage extends BasePage {
    public OpenAccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //region Page ELements
    By userSelect = By.xpath("//select[@id='userSelect']");
    By currencySelect = By.xpath("//select[@id='currency']");
    By btnProcess = By.xpath("//button[contains(text(),'Process')]");
    //endregion

    //region Page Methods
    public OpenAccountPage openAccount(String user, String currency) {
        selectItem(userSelect, user);
        selectItem(currencySelect, currency);
        click(btnProcess);
        return this;
    }

    public OpenAccountPage verifyTestResult(String expect) {
        slowDown(500);
        Assert.assertTrue(getAlertboxText().contains(expect));
        acceptAlertBox();
        return this;
    }
    //endregion


}
