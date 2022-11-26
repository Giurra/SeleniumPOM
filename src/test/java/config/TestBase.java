package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class TestBase {
    public WebDriver webDriver;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    @BeforeClass(alwaysRun = true)
    public void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        webDriver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDown(ITestResult iTestResult, Method method) {
        if (ITestResult.FAILURE == iTestResult.getStatus()) {
            String reportName = method.getName();
            saveScreenShotOnFailure(reportName);
        }
        webDriver.quit();
    }

    @AfterClass(alwaysRun = true)
    public void closeRun() {
        if (getWebDriver() != null) getWebDriver().quit();
    }

    private void saveScreenShotOnFailure(String reportName) {
        File file = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("screenshots/" + reportName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
