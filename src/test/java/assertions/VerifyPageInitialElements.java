package assertions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class VerifyPageInitialElements {

  public static void elementsExist(WebDriver driver, List<By> locators) {
    SoftAssert softAssert = new SoftAssert();
    locators.forEach(locator -> softAssert.assertTrue(driver.findElements(locator).size() > 0, "Element not found: " + locator.toString()));
    softAssert.assertAll("Validate all page elements present");
  }
}
