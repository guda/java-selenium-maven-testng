package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BootCampReviewPage extends BasePage {

  public BootCampReviewPage(WebDriver driver) {
    super(driver);
  }

  public By getLocator(String text) {
    return By.xpath("//app-bootcamp-review//h5[text()='" + text + "']");
  }
}
