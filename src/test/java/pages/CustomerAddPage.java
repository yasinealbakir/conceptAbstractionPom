package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CustomerAddPage extends BasePage {
    public CustomerAddPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //region Page Elements
    By txtFirstName = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]");
    By txtLastName = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/input[1]");
    By txtPostCode = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/input[1]");
    By btnSave = By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]");
    //endregion

    //region Page Methods
    public CustomerAddPage defineCustomerAdd(String name, String lastname, String postCode) {
        writeText(txtFirstName, name);
        writeText(txtLastName, lastname);
        writeText(txtPostCode, postCode);
        click(btnSave);
        return this;
    }

    @SneakyThrows
    public CustomerAddPage verifyTestResult(String expect) {
        slowDown(500);
        Assert.assertTrue(getAlertboxText().contains(expect));
        acceptAlertBox();
        return this;
    }
    //endregion
}
