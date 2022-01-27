package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.log.Log;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //region Page Elements
    By btnAddCustomer = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[1]");
    By btnOpenAccount = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[2]");
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
