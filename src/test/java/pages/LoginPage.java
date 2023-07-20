package pages;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

  public By textTitle = By.xpath("//h1 ");
  public By textSubtitle = By.xpath(
      "//*[ text() = ' Log in to list your bootcamp or rate, review and favorite bootcamps ' ]");
  public By inputEmail = By.xpath("//input[@name='email']");
  public By inputPassword = By.xpath("//input[@name='password']");
  public By buttonLogin = By.xpath("//input[@value='Login']");


  public LoginPage(WebDriver driver) {
    super(driver);
    waitForPageToLoad();
  }

  public List<By> getLocatorList() {
    return Arrays.asList(textTitle, textSubtitle, inputEmail, inputPassword, buttonLogin);
  }

  public LoginPage navigateToLogin() {
    driver.get("http://localhost:4200/");
    driver.findElement(By.linkText("Login")).click();
    fullScreen();
    return this;
  }

  public HomePage loginUser(String email, String password) {
    driver.findElement(inputEmail).sendKeys(email);
    driver.findElement(inputPassword).sendKeys(password);
    driver.findElement(buttonLogin).click();
    return new HomePage(driver);
  }
}

