package Checkout;

import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;
import pages.*;
import testautomatinau.BaseTest;
import static org.testng.Assert.*;

public class PurchaseTest extends BaseTest {
    private CheckoutPage checkoutPage;
    private Payment payPage;
    private ConfirmationPage confirmationPage;
    private DonePage donePage;
    @Test
    @Tag(name = "Complete Purchase Test")
    public void testPurchase() {
        productsPage.addBikeLightToCart();
        productsPage.addRedShirtToCart();
        productsPage.addOneSieToCart();
        checkoutPage = productsPage.clickCartButton();

        payPage = checkoutPage.clickCheckout();
        payPage.enterFirstName("Manya");
        payPage.enterLastName("Imran");
        payPage.enterPostalCode("46000");
        confirmationPage = payPage.clickSubmit();
        assertEquals(confirmationPage.getTotal(),"Total: $36.69");
        donePage = confirmationPage.clickConfirmation();
        assertEquals(donePage.getMessage(), "Thank you for your order!");
    }

}
