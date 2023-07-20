package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingleBootcampPage extends BasePage {

  public By reviewButton = By.xpath("//a[text()=' Write a Review']");
  public By buttonAllReviews = By.xpath("//a[text()=' Read Reviews']");

  public SingleBootcampPage(WebDriver driver) {
    super(driver);
    waitForPageToLoad();
  }

  public ReviewPage navigateToReviewPage() {
    driver.findElement(reviewButton).click();
    return new ReviewPage(driver);
  }

  public BootCampReviewPage readReviews() {
    driver.findElement(buttonAllReviews).click();
    return new BootCampReviewPage(driver);
  }

}
