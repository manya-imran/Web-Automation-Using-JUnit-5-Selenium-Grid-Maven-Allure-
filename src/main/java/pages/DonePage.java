package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DonePage {
    private WebDriver driver;
    private By message = By.cssSelector("h2.complete-header");
    public DonePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getMessage(){
        String headerInfo = driver.findElement(message).getText();
        return headerInfo;

    }
    public ProductsPage clickHome(){
        driver.findElement(By.id("back-to-products")).click();
        return new ProductsPage(driver);
    }
}
