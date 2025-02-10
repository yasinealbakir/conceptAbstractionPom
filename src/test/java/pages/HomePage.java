package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.log.Log;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //region Page Elements
    By btnAddCustomer = By.xpath("//button[contains(.,'Add Customer')]");
    By btnOpenAccount = By.xpath("//button[contains(.,'Open Account')]");
    //endregion

    //region Page Methods
    public CustomerAddPage navigateCustomerAddPage() {
        Log.info("Going to Customer Add Page");
        click(btnAddCustomer);
        return getInstance(CustomerAddPage.class);
    }

    public OpenAccountPage navigateOpenAccountPage() {
        Log.info("Going to Open Account Page");
        click(btnOpenAccount);
        return getInstance(OpenAccountPage.class);
    }
    //endregion
}
