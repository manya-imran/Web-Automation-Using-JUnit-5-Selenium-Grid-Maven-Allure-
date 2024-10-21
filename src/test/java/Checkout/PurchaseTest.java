package Checkout;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import login.LoginTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//import org.testng.xml.dom.Tag;
import pages.*;
import testautomatinau.BaseTest;
//import static org.testng.Assert.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

public class PurchaseTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);
    private CheckoutPage checkoutPage;
    private Payment payPage;
    private ConfirmationPage confirmationPage;
    private DonePage donePage;
    @Test
    @Tag("CompletePurchaseTest")
    @Description("Test Description: Completing the Purchase of an Element")

    @Step("Checking Successful Purchase")
    public void testPurchase() {
        logger.info("Test Purchase Test");
        logger.info("Adding Items to cart");
        productsPage.addBikeLightToCart();
        productsPage.addRedShirtToCart();
        productsPage.addOneSieToCart();
        checkoutPage = productsPage.clickCartButton();
        logger.info("Checking Out");
        payPage = checkoutPage.clickCheckout();
        logger.info("Adding Name and Postal Code");
        payPage.enterFirstName("Manya");
        payPage.enterLastName("Imran");
        payPage.enterPostalCode("46000");
        confirmationPage = payPage.clickSubmit();
        logger.info("Order Confirmation Page");
        assertEquals(confirmationPage.getTotal(),"Total: $36.69");
        donePage = confirmationPage.clickConfirmation();
        assertEquals(donePage.getMessage(), "Thank you for your order!");
        logger.info("Order Confirmed");
    }

}
