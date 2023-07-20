package test;

import assertions.VerifyPageInitialElements;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {

  @Test(description = "Validate Homepage elements are visible")
  void validateHomePageElements() {
    HomePage homePage = new HomePage(getDriver());
    homePage.open();

    VerifyPageInitialElements.elementsExist(getDriver(), homePage.getLocatorList());
  }
}
