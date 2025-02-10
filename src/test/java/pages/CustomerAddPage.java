package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.log.Log;

public class CustomerAddPage extends BasePage {
    public CustomerAddPage(WebDriver driver) {
        super(driver);
    }

    //region Page Elements
    By txtFirstName = By.cssSelector("[placeholder='First Name']");
    By txtLastName = By.cssSelector("[placeholder='Last Name']");
    By txtPostCode = By.cssSelector("[placeholder='Post Code']");
    By btnSave = By.cssSelector(".btn-default");
    //endregion

    //region Page Methods
    public CustomerAddPage defineCustomerAdd(String name, String lastname, String postCode) {
        Log.info("Filling out the require fields");
        writeText(txtFirstName, name);
        writeText(txtLastName, lastname);
        writeText(txtPostCode, postCode);
        click(btnSave);
        return this;
    }
    //endregion
}
