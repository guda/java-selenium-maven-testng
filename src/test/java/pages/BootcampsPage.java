package pages;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BootcampsPage extends BasePage {

  public By bootcampLink = By.xpath("//app-bootcamps-list//a");
  public By bootcampsSidebar = By.xpath("//app-bootcamps-sidebar");
  public By byLocation = By.xpath("//*[ text() = 'By Location' ]");
  public By inputMiles = By.xpath("//input[@name='miles']");
  public By inputZipCode = By.xpath("//input[@name='zipcode']");
  public By buttonFindBootcamps = By.xpath("//input[@value='Find Bootcamps']");
  public By filter = By.xpath("//*[ text() = 'Filter' ]");
  public By ratingDropdown = By.xpath("//app-bootcamps-sidebar//div[1]//select");
  public By budgetDropdown = By.xpath("//app-bootcamps-sidebar//div[2]//select");
  public By pageNavigation = By.xpath("//nav[@aria-label='Page navigation']");


  public BootcampsPage(WebDriver driver) {
    super(driver);
    waitForPageToLoad();
  }

  public List<By> getBootcampsPageLocatorList() {
    return Arrays.asList(bootcampLink, bootcampsSidebar, byLocation, inputMiles, inputZipCode, buttonFindBootcamps,
        filter, ratingDropdown, budgetDropdown, pageNavigation);
  }

  public SingleBootcampPage openFirstBootcamp() {

    elementExist(bootcampLink);
    waitUntilDisplayed(bootcampLink);
    waitUntilClickable(bootcampLink);
    driver.findElement(bootcampLink).click();
    return new SingleBootcampPage(driver);
  }

  public void selectFromDropdown(By dropdown, String option) {
    driver.findElement(dropdown).click();
    new Select(driver.findElement(dropdown))
        .selectByVisibleText(option);
  }
}
