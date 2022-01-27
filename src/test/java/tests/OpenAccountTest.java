package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.lang.reflect.Method;

import static utils.report.ExtentTestManager.startTest;

public class OpenAccountTest extends BaseTest {

    @Test
    public void openDollarAccountFeature(Method method) {
        startTest(method.getName(), "Dolar hesabı açılması");
        page.getInstance(LoginPage.class)
                .signIn()
                .navigateOpenAccountPage()
                .openAccount("Harry Potter", "Dollar")
                .verifyTestResult("Account created successfully");
    }

    @Test
    public void openPoundAccountFeature(Method method) {
        startTest(method.getName(), "Pound hesabı açılması");
        page.getInstance(HomePage.class)
                .navigateOpenAccountPage()
                .openAccount("Neville Longbottom", "Pound")
                .verifyTestResult("Account created successfully");
    }
}
