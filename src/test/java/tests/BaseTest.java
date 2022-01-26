package tests;

import configs.IConfig;
import enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.Page;
import utils.BrowserManager;


public class BaseTest {

    //region Variables
    WebDriver driver;
    WebDriverWait wait;
    public Page page;
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

    //endregion
}
