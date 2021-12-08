package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //region Page Elements
    By btnAddCustomer = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[1]");
    By btnOpenAccount = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[2]");
    //endregion

    //region Page Methods
    public CustomerAddPage navigateCustomerAddPage() {
        click(btnAddCustomer);
        return getInstance(CustomerAddPage.class);
    }

    public OpenAccountPage navigateOpenAccountPage() {
        click(btnOpenAccount);
        return getInstance(OpenAccountPage.class);
    }
    //endregion
}
