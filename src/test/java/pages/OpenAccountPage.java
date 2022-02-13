package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.log.Log;

public class OpenAccountPage extends BasePage {
    public OpenAccountPage(WebDriver driver) {
        super(driver);
    }

    //region Page ELements
    By userSelect = By.xpath("//select[@id='userSelect']");
    By currencySelect = By.xpath("//select[@id='currency']");
    By btnProcess = By.xpath("//button[contains(text(),'Process')]");
    //endregion

    //region Page Methods
    public OpenAccountPage openAccount(String user, String currency) {
        Log.info("Filling out the require fields");
        selectItem(userSelect, user);
        selectItem(currencySelect, currency);
        click(btnProcess);
        return this;
    }

    //endregion


}
