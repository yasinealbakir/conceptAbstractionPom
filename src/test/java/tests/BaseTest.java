package tests;

import enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.Page;
import utils.browser.BrowserManager;


public class BaseTest {

    //region Variables
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Page page;
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
