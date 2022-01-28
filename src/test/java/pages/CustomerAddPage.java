package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.log.Log;

public class CustomerAddPage extends BasePage {
    public CustomerAddPage(WebDriver driver) {
        super(driver);
    }

    //region Page Elements
    By txtFirstName = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]");
    By txtLastName = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/input[1]");
    By txtPostCode = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/input[1]");
    By btnSave = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]");
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

    @SneakyThrows
    public CustomerAddPage verifyTestResult(String expect) {
        Log.info("Verifying test result");
        slowDown(1);
        Assert.assertTrue(getAlertboxText().contains(expect));
        acceptAlertBox();
        return this;
    }
    //endregion
}
