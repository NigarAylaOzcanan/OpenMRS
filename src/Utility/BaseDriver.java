package Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseDriver {
    public static Logger logger = LogManager.getLogger();

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static OpenMRS_Elements ome;

    @BeforeClass
    public void InitialProcedure() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ome = new OpenMRS_Elements();
        LoginTest();
    }

    @AfterClass
    public void CloseProcedure() {
        Tools.wait(2);
        driver.quit();
        logger.info("Driver Closed");
    }

    public void LoginTest() {
        logger.info("Login Page Procedure Started");
        driver.get("https://demo.openmrs.org/openmrs/");
        logger.info("Login Page Procedure Finished");
    }

    @BeforeMethod
    public void beforeMethod() {
        logger.info("Method started");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        logger.info(result.getName() + " Method finished " + (result.getStatus() == 1 ? "Passed" : "failed"));
    }
}
