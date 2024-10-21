package Products;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import login.LoginTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CheckoutPage;
import testautomatinau.BaseTest;

import java.util.Optional;
//
//import static org.testng.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

public class AddToCart extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);
    private CheckoutPage checkOutPage;
    @Test
    @Tag("UpdateCartByProductsPage")
    @Description("Test Description: Updating the Cart ")

    @Step("Checking Successful Addition using Products Page")
    public void addToCart() {
        logger.info("Add To Cart - Products Page");
        logger.info("Adding Items to Cart");
        productsPage.addBackpackToCart();
        productsPage.addFleeceJacketToCart();
        productsPage.addBikeLightToCart();
        productsPage.addRedShirtToCart();
        logger.info("Checking Cart after Adding");
        assertEquals(productsPage.getItemCountCart(),"4");
        logger.info("Checking Cart Successful");
    }
    @Test
    @Tag("UpdateCartByProductsPage")
    @Step("Checking Successful Deletion using Products Page")
    public void removeFromCart() {
        logger.info("Removing Items From Cart");
        productsPage.removeBackpackFromCart();
        productsPage.removeFleeceJacketFromCart();
        logger.info("Checking Cart after Removing");
        assertEquals(productsPage.getItemCountCart(),"2");
        logger.info("Checking Cart Successful");
    }
}
