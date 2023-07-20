package pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  public WebDriver driver;
  protected WebDriverWait wait;
  protected Wait<WebDriver> fluentWait;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15))
        .pollingEvery(Duration.ofSeconds(1))
        .ignoring(NoSuchElementException.class);
  }

  public void waitForPageToLoad() {
    wait.until(
        webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
            .equals("complete"));
  }

  public void waitUntilDisplayed(By by) {
    fluentWait.until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  public void waitUntilClickable(By by) {
    fluentWait.until(ExpectedConditions.elementToBeClickable(by));
  }


  public Boolean elementExist(By locator) {
    List<WebElement> elements = fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    return elements.size() > 0;
    }

  protected void fullScreen() {
    driver.manage().window().fullscreen();
  }
}

