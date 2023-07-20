package test;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

  protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

  //get thread-safe driver
  public static WebDriver getDriver() {
    return threadLocalDriver.get();
  }

  @BeforeMethod
  void setup() {
    threadLocalDriver.set(new ChromeDriver());
    System.out.println("Before Test Thread ID: " + Thread.currentThread().getId());
  }

  @AfterMethod
  void teardown(ITestResult result) throws IOException {
    if (result.getStatus() == ITestResult.FAILURE) {
      File screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
      Files.move(screenshotFile, new File("target/screenshots" + result.getName() + ".png"));
    }
    getDriver().quit();
    System.out.println("After Test Thread ID: " + Thread.currentThread().getId());
    threadLocalDriver.remove();
  }
}
