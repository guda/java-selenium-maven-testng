package test;

import assertions.VerifyPageInitialElements;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

  @Test(description = "Validate Register Page")
  void validateRegisterPage() {
    RegisterPage registerPage = new RegisterPage(getDriver());
    registerPage.navigateToRegister();
    VerifyPageInitialElements.elementsExist(getDriver(), registerPage.getLocatorList());
    registerPage.registerUser();
  }

  @Test(description = "Validate Validation Errors on Register Page")
  void negativeRegisterTest() {

    new HomePage(getDriver())
        .open()
        .navigateToRegisterPage()
        .verifyRegisterValidation();
  }
}
