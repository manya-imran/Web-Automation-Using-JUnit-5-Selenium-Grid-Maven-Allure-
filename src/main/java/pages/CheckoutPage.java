package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutPage {
    private WebDriver driver;
    //private By itemCountCart = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    //*[@id="cart_contents_container"]/div/div[1]
    // #cart_contents_container > div > div.cart_list > div:nth-child(4)
    //*[@id="item_0_title_link"]/div
    //*[@class="cart_item_label"]/a/div
    public Integer getCartElements(){
        Integer count=0;
        try{
            List<WebElement> I = driver.findElements(By.cssSelector("div.inventory_item_name"));
            //System.out.println(I.getText());
            for(WebElement Item : I){
                System.out.println(Item.getText());
                count++;
            }
            return count;
        } catch (Exception e){
            return count;
        }
    }
    public void removeItems(){
        List<WebElement> removeButtons = driver.findElements(By.cssSelector("button.cart_button"));
        for(WebElement button: removeButtons){
            button.click();
        }
    }
    public Payment clickCheckout(){
        driver.findElement(By.id("checkout")).click();
        return new Payment(driver);
    }
//    public String getItemCountCart() {
//        WebElement itemCount =  driver.findElement(itemCountCart);
//        return itemCount.getText();
//    }
}
