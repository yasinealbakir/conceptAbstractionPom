package tests;

import enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.Page;
import utils.BrowserManager;


public class BaseTest {

    //region Variables
    WebDriver driver;
    public Page page;
    //endregion

    //region Methods
    @BeforeClass
    public void classSetUp() throws Exception {
        driver = BrowserManager.getDriver(DriverType.Chrome);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void methodSetup() {
        page = new BasePage(driver);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    //endregion
}
