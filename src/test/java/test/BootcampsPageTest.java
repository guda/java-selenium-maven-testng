package test;

import assertions.VerifyPageInitialElements;
import org.testng.annotations.Test;
import pages.BootcampsPage;
import pages.HomePage;

public class BootcampsPageTest extends BaseTest {

  @Test(description = "Validate BootcampsPage elements are visible")
  void validateBootcampsPageElements() {
    BootcampsPage bootcampsPage = new HomePage(getDriver())
        .open()
        .navigateToBootcampsPage();

    VerifyPageInitialElements.elementsExist(getDriver(), bootcampsPage.getBootcampsPageLocatorList());
  }

  @Test(description = "Filter Bootcamps by rating and budget")
  void filterBootcamps() {
    BootcampsPage bootcampsPage = new HomePage(getDriver())
        .open()
        .navigateToBootcampsPage();

    bootcampsPage.selectFromDropdown(bootcampsPage.ratingDropdown, "9+");
    bootcampsPage.selectFromDropdown(bootcampsPage.budgetDropdown, "$20,000");
    getDriver().findElements(bootcampsPage.buttonFindBootcamps).get(1).click();
  }
}
