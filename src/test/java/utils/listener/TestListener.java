package utils.listener;

import org.testng.ITestListener;
import tests.BaseTest;
import com.aventstack.extentreports.Status;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import utils.log.Log;
import utils.report.ExtentManager;

import java.util.Objects;

import static utils.report.ExtentTestManager.getTest;

public class TestListener extends BaseTest implements ITestListener {

    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log.info(getTestMethodName(result) + " Test is starting");
    }

    @SneakyThrows
    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info(getTestMethodName(result) + " Test is succeed");
        getTest().log(Status.PASS, "Test passed");
    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
        Log.error(getTestMethodName(result) + " Test failed");
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
        String base64Screenshot =
                "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        getTest().log(Status.FAIL, "TEST FAILED",
                getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
    }

    @SneakyThrows
    @Override
    public void onTestSkipped(ITestResult result) {
        Log.warn(getTestMethodName(result) + " Test is skipped");
        getTest().log(Status.SKIP, "Test is skipped");
    }

    @Override
    public void onStart(ITestContext context) {
        context.setAttribute("WebDriver", this.driver);
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.extentReports.flush();
    }
}
