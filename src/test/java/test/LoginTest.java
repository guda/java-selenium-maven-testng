package test;

import assertions.VerifyPageInitialElements;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

  @Test(description = "Validate Login Page")
  void validateLoginPage() {
    LoginPage loginPage = new LoginPage(getDriver());
    loginPage.navigateToLogin();

    VerifyPageInitialElements.elementsExist(getDriver(), loginPage.getLocatorList());

    loginPage.loginUser("user@gmail.com", "123456");
  }
}
