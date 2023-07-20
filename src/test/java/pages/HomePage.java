package pages;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

  public By textTitle = By.xpath("//*[ text() = 'Find a Code Bootcamp' ]");
  public By textSubtitle = By.xpath(
      "//*[ text() = 'Find, rate and read reviews on coding bootcamps' ]");
  public By inputMiles = By.xpath("//input[@name='miles']");
  public By inputZipCode = By.xpath("//input[@name='zipcode']");
  public By buttonFindBootcamps = By.xpath("//input[@value='Find Bootcamps']");
  public By linkBootcampReview = By.linkText("Bootcamp review");
  public By linkBrowseBootcamps = By.linkText("Browse Bootcamps");
  public By registerButton = By.linkText("Register");

  public HomePage(WebDriver driver) {
    super(driver);
    waitForPageToLoad();
  }

  public List<By> getLocatorList() {
    return Arrays.asList(textTitle, textSubtitle, inputMiles, inputZipCode, buttonFindBootcamps, linkBootcampReview,
        linkBrowseBootcamps);
  }

  public HomePage open() {
    driver.get("http://localhost:4200/");
    fullScreen();
    return this;
  }

  public RegisterPage navigateToRegisterPage() {
    driver.findElement(registerButton).click();
    return new RegisterPage(driver);
  }

  public BootcampsPage navigateToBootcampsPage() {
    driver.findElement(linkBrowseBootcamps).click();
    return new BootcampsPage(driver);
  }
}
