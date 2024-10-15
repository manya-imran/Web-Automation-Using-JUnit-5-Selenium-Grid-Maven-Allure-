package Products;

import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;
import pages.CheckoutPage;
import testautomatinau.BaseTest;

import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class AddToCart extends BaseTest {
    private CheckoutPage checkOutPage;
    @Test
    @Tag(name = "Update Cart - Products Page")
    public void addToCart() {
        productsPage.addBackpackToCart();
        productsPage.addFleeceJacketToCart();
        productsPage.addBikeLightToCart();
        productsPage.addRedShirtToCart();
        assertEquals(productsPage.getItemCountCart(),"4");
    }
    @Test
    @Tag(name = "Update Cart - Products Page")
    public void removeFromCart() {
        productsPage.removeBackpackFromCart();
        productsPage.removeFleeceJacketFromCart();
        assertEquals(productsPage.getItemCountCart(),"2");
    }
}
