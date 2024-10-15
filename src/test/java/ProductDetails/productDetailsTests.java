package ProductDetails;

import org.testng.annotations.Test;
//import org.testng.xml.dom.Tag;
//import org.junit.jupiter.api.Tag;
import pages.ProductDetailsPage;
import testautomatinau.BaseTest;

import static org.testng.AssertJUnit.assertEquals;

public class productDetailsTests extends BaseTest {
    @Test(groups = {"Update Cart - Product Details Page"})
    //@Tag("Update Cart - Product Details Page")
    public void productDetailsTest() {
        ProductDetailsPage productDetailsPage = productsPage.clickBackpack();
        System.out.println(productDetailsPage.getProductName());
        productDetailsPage.clickAddToCart();
        assertEquals(productDetailsPage.getCountCart(), "1");
        productDetailsPage.clickRemoveFromCart();
        assertEquals(productDetailsPage.getCountCart(), "0");
    }
}
