package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
    private WebDriver driver;
    private By finishButton = By.id("finish");
    private By totalValue = By.cssSelector("div.summary_total_label");
    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getTotal(){
        return driver.findElement(totalValue).getText();
    }
    public DonePage clickConfirmation() {
        driver.findElement(finishButton).click();
        return new DonePage(driver);
    }
}
