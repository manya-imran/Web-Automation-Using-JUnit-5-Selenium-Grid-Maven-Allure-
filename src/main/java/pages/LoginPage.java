package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {
    private WebDriver driver;
    private By username = By.id("user-name");
    private By password = By.id("password");
    //private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
         this.driver = driver;
         System.out.println("Login Page");
     }
     public void enterUserName(String userName) {
         WebDriverWait wait = new WebDriverWait(driver, 10);
         WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
         usernameField.sendKeys(userName);

         //driver.findElement(username).sendKeys(userName);
     }
     public void enterPassword(String Password) {
        driver.findElement(password).sendKeys(Password);
     }
     public ProductsPage clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
            ////*[@id="login-button"]
            WebElement loginButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("login-button"))
            );
            System.out.println("login secured");
            loginButton.click();
            System.out.println("not-clicking");
            return new ProductsPage(driver);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
     }

}
