package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class OpenAccountTest extends BaseTest {

    @Test
    public void openDollarAccountFeature() {
        page.getInstance(LoginPage.class)
                .signIn()
                .navigateOpenAccountPage()
                .openAccount("Harry Potter", "Dollar")
                .verifyTestResult("Account created successfully");
    }

    @Test
    public void openPoundAccountFeature() {
        page.getInstance(HomePage.class)
                .navigateOpenAccountPage()
                .openAccount("Neville Longbottom", "Pound")
                .verifyTestResult("Account created successfully");
    }
}
