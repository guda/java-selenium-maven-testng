package assertions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class VerifyPageValidationErrors {

  public static void validateValidationError(WebDriver driver, By locator, Boolean shouldBeDisplayed) {
    List<WebElement> elements = driver.findElements(locator);
    Assert.assertEquals(elements.size() > 0, shouldBeDisplayed);
  }

  public static void verifyIfButtonIsDisabled(WebDriver driver, By locator, Boolean shouldBeDisabled) {
    Assert.assertEquals(driver.findElement(locator).isEnabled(), !shouldBeDisabled);
  }
}
