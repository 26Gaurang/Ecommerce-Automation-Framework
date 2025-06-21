package BaseTest;


import java.util.Properties;
import java.lang.reflect.Method;
import java.lang.RuntimeException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import AbstractComp.AbstractComponents;
import Resources.ConfigReader;
import Resources.ReportManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void Reporting() {
        extent = ReportManager.getInstance();
        if (extent == null) {
            throw new RuntimeException("Extent report instance is null. Check ReportManager.");
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void Setup(Method method) {
    	
    	 AbstractComponents.testFolderName = method.getName();
    	
        try {
            Properties prop = ConfigReader.globalProp();

            if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));

            if (extent == null) {
                throw new RuntimeException("ExtentReports object is NULL in setup()");
            }

            test = extent.createTest(method.getName());

        } catch (Exception e) {
            System.out.println("Exception in setup(): " + e.getMessage());
            e.printStackTrace();
            throw new SkipException("Skipping test due to setup failure: " + e.getMessage());
        } 
        
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (driver != null) {
            driver.quit();
        }

        if (test != null) {
            switch (result.getStatus()) {
                case ITestResult.FAILURE:
                    test.fail(result.getThrowable());
                    break;
                case ITestResult.SUCCESS:
                    test.pass("Test Passed");
                    break;
                case ITestResult.SKIP:
                    test.skip("Test Skipped");
                    break;
            }
        }
    }

    @AfterSuite
    public void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
