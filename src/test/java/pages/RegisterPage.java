package pages;

import static assertions.VerifyPageValidationErrors.validateValidationError;
import static assertions.VerifyPageValidationErrors.verifyIfButtonIsDisabled;

import com.github.javafaker.Faker;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

  public By textTitle = By.xpath("//h1 ");
  public By textSubtitle = By.xpath(
      "//*[ text() = ' Register to list your bootcamp or rate, review and favorite bootcamps ' ]");
  public By inputName = By.xpath("//input[@name='name']");
  public By inputEmail = By.xpath("//input[@name='email']");
  public By inputPassword = By.xpath("//input[@name='password']");
  public By inputConfirmPassword = By.xpath("//input[@name='password2']");
  public By titleUserRole = By.xpath("//*[ text() = 'User Role' ]");
  public By checkRegularUser = By.xpath(
      "//*[ text() = ' Regular User (Browse, Write reviews, etc) ' ]");
  public By checkBootcampPublisher = By.xpath("//*[ text() = ' Bootcamp Publisher ' ]");
  public By textTitle2 = By.xpath("//p[@class='text-danger']");
  public By buttonRegister = By.xpath("//input[@value='Register']");
  public By radioButton = By.xpath("//input[@value='user']");
  public By userRoleValidationErr = By.xpath(
      "//*[text()=' * You must be affiliated with the bootcamp in some way in order to add it to DevCamper. ']");
  public By passwordValidationErr = By.xpath("//*[text()=' * Passwords must match ']");
  public By navbar = By.id("navbarDropdown");

  Faker faker = new Faker();

  public RegisterPage(WebDriver driver) {
    super(driver);
    waitForPageToLoad();
  }

  public List<By> getLocatorList() {
    return Arrays.asList(textTitle, textSubtitle, inputName, inputEmail, inputPassword,
        inputConfirmPassword, titleUserRole, checkRegularUser, checkBootcampPublisher, textTitle2,
        buttonRegister);
  }

  public RegisterPage navigateToRegister() {
    driver.get("http://localhost:4200/");
    driver.findElement(By.linkText("Register")).click();
    fullScreen();
    return this;
  }

  public HomePage registerUser() {
    populateFormWithData(faker.name().fullName(), faker.internet().emailAddress(), "abcd1234", "abcd1234");
    driver.findElement(buttonRegister).click();
    waitUntilDisplayed(navbar);
    return new HomePage(driver);
  }

  public void verifyRegisterValidation() {

    validateValidationError(driver, userRoleValidationErr, true);
    populateFormWithData(faker.name().fullName(), faker.internet().emailAddress(), "abcd1234", "abcd");
    validateValidationError(driver, passwordValidationErr, true);
    verifyIfButtonIsDisabled(driver, buttonRegister, true);

    driver.findElement(inputConfirmPassword).clear();
    driver.findElement(inputConfirmPassword).sendKeys("abcd1234");
    validateValidationError(driver, passwordValidationErr, false);
    verifyIfButtonIsDisabled(driver, buttonRegister, false);
  }

  private void populateFormWithData(String fullName, String email, String password, String confirmPassword) {
    driver.findElement(inputName).sendKeys(fullName);
    driver.findElement(inputEmail).sendKeys(email);
    driver.findElement(inputPassword).sendKeys(password);
    driver.findElement(inputConfirmPassword).sendKeys(confirmPassword);
    driver.findElement(radioButton).click();
  }
}
