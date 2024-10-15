package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
    private WebDriver driver;
    private By product = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]");
    private By itemCountCart = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    private WebDriverWait wait;
    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(product));
    }
    //product click item
    public String getProductName() {
        return driver.findElement(product).getText();
    }
    public void clickAddToCart() {
        driver.findElement(By.id("add-to-cart")).click();
    }
    public void clickRemoveFromCart() {
        driver.findElement(By.id("remove")).click();
    }
    public String getCountCart() {
        try{
            WebElement itemCount =  driver.findElement(itemCountCart);
            return itemCount.getText();
        }catch (Exception e){
            return "0";
        }

    }


}
