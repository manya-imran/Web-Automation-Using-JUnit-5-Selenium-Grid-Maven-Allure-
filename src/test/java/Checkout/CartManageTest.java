package Checkout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;
import pages.CheckoutPage;
import testautomatinau.BaseTest;

import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class CartManageTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(CartManageTest.class);
    private CheckoutPage checkOutPage;
    @Test
    @Tag(name = "Update Cart - Cart Page")
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
    @Tag(name = "Update Cart - Cart Page")
    public void cartRemoveAll() {
        logger.info("Removing all items from Cart Page");
        checkOutPage.removeItems();
        Integer elements = checkOutPage.getCartElements();
        logger.info("Testing Elements Count after Removing");
        assertEquals(elements.intValue(), 0);
        logger.info("Correct Elements Count after Removing");
    }
}
