package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.lang.reflect.Method;

import static utils.report.ExtentTestManager.startTest;

public class CustomerAddTest extends BaseTest {

    @Test
    public void customerAddFeature(Method method) {
        startTest(method.getName(), "Tüm zorunlu alanların formata uygun ve tam doldurularak müşteri tanımlanması");
        page.getInstance(LoginPage.class)
                .signIn()
                .navigateCustomerAddPage()
                .defineCustomerAdd(faker.name().firstName(), faker.name().lastName(), faker.address().zipCode())
                .verifyAlertboxText("Customer added successfully with customer");
    }

    @Test
    public void withAllRequiredFieldsBlank(Method method) {
        startTest(method.getName(), "Tüm zorunlu alanların boş bırakılması");
        page.getInstance(HomePage.class)
                .navigateCustomerAddPage()
                .defineCustomerAdd(" ", " ", " ")
                .verifyAlertboxText("Please check the details. Customer may be duplicate");
    }


}
