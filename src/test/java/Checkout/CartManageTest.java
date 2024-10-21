package Checkout;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import pages.CheckoutPage;
import testautomatinau.BaseTest;

import java.util.Optional;


public class CartManageTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(CartManageTest.class);
    private CheckoutPage checkOutPage;
    @Test
    @Order(1)
    @Tag("UpdateCartByCartPage")

    @Description("Test Description: Adding Items to Cart Functionality")

    @Step("Checking Successful Addition")
    public void cartManageAdd() {
        logger.info("Add to Cart from Cart Page");
        logger.info("Adding items");
        productsPage.addRedShirtToCart();
        productsPage.addBikeLightToCart();
        logger.info("Viewing Cart");
        checkOutPage = productsPage.clickCartButton();
        logger.info("Getting Item Count");
        Integer elements = checkOutPage.getCartElements();
        logger.info("Testing Elements Count");
        assertEquals(elements.intValue(), 2);
        logger.info("Correct Elements Count");
    }
    @Test
    @Tag("UpdateCartByCartPage")
    @Description("Test Description: Removing Items From Cart Functionality")

    @Step("Checking Successful Removing")
    public void cartRemoveAll() {
        logger.info("Adding items before Removing");
        productsPage.addRedShirtToCart();
        productsPage.addBikeLightToCart();
        logger.info("Viewing Cart before Removing");
        checkOutPage = productsPage.clickCartButton();
        logger.info("Removing all items from Cart Page");
        checkOutPage.removeItems();
        Integer elements = checkOutPage.getCartElements();
        logger.info("Testing Elements Count after Removing");
        assertEquals(elements.intValue(), 0);
        logger.info("Correct Elements Count after Removing");
    }
}
