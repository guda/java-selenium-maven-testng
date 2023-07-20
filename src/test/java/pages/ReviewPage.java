package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewPage extends BasePage {

  public By inputReviewTitle = By.name("title");
  public By inputReview = By.name("review");
  public By buttonSubmitReview = By.xpath("//input[@type='submit']");
  public By reviewCard = By.xpath("//app-bootcamp-review");

  public ReviewPage(WebDriver driver) {
    super(driver);
    waitForPageToLoad();
  }

  public BootCampReviewPage writeReview(String title, String review) {
    driver.findElement(inputReviewTitle).sendKeys(title);
    driver.findElement(inputReview).sendKeys(review);
    driver.findElement(buttonSubmitReview).click();
    waitUntilDisplayed(reviewCard);
    return new BootCampReviewPage(driver);
  }

}
