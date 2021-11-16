package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class CustomerAddTest extends BaseTest {

    @Test
    public void customerAddFeature() {
        page.getInstance(LoginPage.class)
                .signIn()
                .navigateCustomerAddPage()
                .defineCustomerAdd("Yasin", "Engin", "06690")
                .verifyTestResult("Customer added successfully with customer");
    }

    @Test
    public void withAllRequiredFieldsBlank() {
        page.getInstance(HomePage.class)
                .navigateCustomerAddPage()
                .defineCustomerAdd(" ", " ", " ")
                .verifyTestResult("Please check the details. Customer may be duplicate.");
    }


}
