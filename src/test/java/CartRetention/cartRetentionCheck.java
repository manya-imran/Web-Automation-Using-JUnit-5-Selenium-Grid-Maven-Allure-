package CartRetention;

import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;
import pages.LoginPage;
import pages.ProductsPage;
import testautomatinau.BaseTest;
import static org.testng.Assert.*;

public class cartRetentionCheck extends BaseTest {
    @Test
    @Tag(name="Cart Retention Test")
    public void cartTest(){
        productsPage.addOneSieToCart();
        productsPage.addBikeLightToCart();
        productsPage.addRedShirtToCart();
        LoginPage loginPage = productsPage.logOut();
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        ProductsPage productPage2 = loginPage.clickLoginButton();
        assertEquals(productPage2.getItemCountCart(), "3");
    }
}
