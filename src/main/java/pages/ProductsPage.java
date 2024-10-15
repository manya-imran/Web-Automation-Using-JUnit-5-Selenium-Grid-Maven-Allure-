package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.WebDriver.Window;

public class ProductsPage {
    private WebDriver driver;
    private By backpack = By.id("add-to-cart-sauce-labs-backpack");
    private By bikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private By tShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By fleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By oneSie = By.id("add-to-cart-sauce-labs-onesie");
    private By redShirt = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");

    //*[@id="shopping_cart_container"]/a/span

    //*[@id="shopping_cart_container"]/a/span
    private By cartButton = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    private By itemCountCart = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    private By sortOption = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");

    private WebDriverWait wait;
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(backpack));

    }
    public ProductDetailsPage clickBackpack() {
        WebElement backPack = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]"));
        // Scroll to the element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", backPack);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item_4_title_link\"]")));
        try{
            backPack.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProductDetailsPage(driver);
    }
    public void removeBackpackFromCart() {
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
    }
    public void removeBikeLightFromCart() {
        driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
    }
    public void removeShirtFromCart() {
        driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
    }
    public void removeFleeceJacketFromCart() {
        driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();
    }
    public void removeOneSieFromCart() {
        driver.findElement(By.id("remove-sauce-labs-onesie")).click();
    }
    public void removeRedShirtFromCart() {
        driver.findElement(By.id("remove-test.allthethings()-t-shirt-(red)")).click();
    }

    public void addBackpackToCart() {
        driver.findElement(backpack).click();
    }
    public void addBikeLightToCart() {
        driver.findElement(bikeLight).click();
    }
    public void addShirtToCart() {
        driver.findElement(tShirt).click();
    }
    public void addFleeceJacketToCart() {
        driver.findElement(fleeceJacket).click();
    }
    public void addOneSieToCart() {
        driver.findElement(oneSie).click();
    }
    public void addRedShirtToCart() {
        driver.findElement(redShirt).click();
    }
    public LoginPage logOut(){
        WebElement options = driver.findElement(By.id("react-burger-menu-btn"));
        options.click();
        WebElement logoutButton = wait.until(
                ExpectedConditions.elementToBeClickable(driver.findElement(By.id("logout_sidebar_link")))
        );
        logoutButton.click();
        return new LoginPage(driver);

    }
    public String sortByNameAZ(){
        WebElement options = driver.findElement(sortOption);
        options.click();
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div/a/img"))
        );

        WebElement firstProd = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div/a/img"));
        return firstProd.getAttribute("alt");

    }
    public String sortByNameZA(){
        WebElement options = driver.findElement(sortOption);
        options.click();
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div/a/img"))
        );

        WebElement firstProd = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div/a/img"));
        return firstProd.getAttribute("alt");

    }
    public String sortLowtoHigh(){
        WebElement options = driver.findElement(sortOption);
        options.click();
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div/a/img"))
        );

        WebElement firstProd = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div/a/img"));
        return firstProd.getAttribute("alt");

    }
    public String sortHightoLow(){
        WebElement options = driver.findElement(sortOption);
        options.click();
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div/a/img"))
        );

        WebElement firstProd = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div/a/img"));
        return firstProd.getAttribute("alt");

    }
    public String getItemCountCart() {
        try{
            WebElement itemCount =  driver.findElement(itemCountCart);
            return itemCount.getText();
        }catch (Exception e){
            return "0";
        }

    }
    public CheckoutPage clickCartButton() {
        driver.findElement(cartButton).click();
        return new CheckoutPage(driver);
    }

    public String getHeaderSuccess() {
        return driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
    }
}
