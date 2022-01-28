package tests;

import com.github.javafaker.Faker;
import enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.Page;
import utils.browser.BrowserManager;

import java.util.Locale;


public class BaseTest {

    //region Variables
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Page page;
    protected Faker faker;
    //endregion

    //region Methods
    @BeforeClass
    public void classSetUp() throws Exception {
        driver = BrowserManager.getDriver(BrowserType.Chrome);
    }

    @BeforeMethod
    public void methodSetup() {
        wait = new WebDriverWait(driver, 10);
        page = new BasePage(driver, wait);
        faker = new Faker(new Locale("tr"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    //endregion
}
