package utils.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static final String reportFileName = "Demo Project Report" + ".html";
    private static final String fileSeperator = System.getProperty("file.separator");
    private static final String reportFilepath = System.getProperty("user.dir") + fileSeperator + "test-report";
    private static final String reportFileLocation = reportFilepath + fileSeperator + reportFileName;
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportFileLocation);
        reporter.config().setReportName("Demo Project Regression Test Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Author", "yasin");
        return extentReports;
    }
}
