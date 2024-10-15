package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Payment {
    private WebDriver driver;
    private By fname = By.id("first-name");
    private By lname = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By submitButton = By.id("continue");
    public Payment(WebDriver driver) {
        this.driver = driver;
    }
    public void enterFirstName(String firstName) {
        driver.findElement(fname).sendKeys(firstName);
    }
    public void enterLastName(String lastName) {
        driver.findElement(lname).sendKeys(lastName);
    }
    public void enterPostalCode(String PostalCode) {
        driver.findElement(postalCode).sendKeys(PostalCode);
    }
    public ConfirmationPage clickSubmit() {
        driver.findElement(submitButton).click();
        return new ConfirmationPage(driver);
    }

}
