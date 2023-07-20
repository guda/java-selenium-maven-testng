package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import pages.HomePage;
import testdata.Fixtures;

public class ReviewTests extends BaseTest {

  @Test(description = "Validate that review option is working as expected")
  void reviewTest() {
    Fixtures fixtures = new Fixtures();

    var reviewPage = new HomePage(getDriver())
        .open()
        .navigateToRegisterPage()
        .registerUser()
        .navigateToBootcampsPage()
        .openFirstBootcamp()
        .navigateToReviewPage()
        .writeReview(fixtures.title, fixtures.review);

    assertEquals(fixtures.title, getDriver().findElement(reviewPage.getLocator(fixtures.title)).getText(),
        "Values are not matching.");
  }
}
