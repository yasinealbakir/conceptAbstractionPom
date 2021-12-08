package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.Page;

public class BaseTest {

    //region Variables
    protected WebDriver driver;
    protected ChromeOptions chromeOptions;
    public Page page;
    //endregion


    @BeforeClass
    public void classSetUp() {
        WebDriverManager.chromedriver().setup();
        chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        driver = new ChromeDriver(chromeOptions);
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
}
