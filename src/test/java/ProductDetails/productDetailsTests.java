package ProductDetails;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import login.LoginTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//import org.testng.xml.dom.Tag;
//import org.junit.jupiter.api.Tag;
import pages.ProductDetailsPage;
import testautomatinau.BaseTest;

//import static org.testng.AssertJUnit.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

public class productDetailsTests extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);
    @Test()
    @Tag("UpdateCartByProductDetailsPage")
    @Description("Test Description: Adding Items to Cart Functionality")

    @Step("Checking Successful Addition")
    public void productDetailsTest() {
        try{
            logger.info("Clicking Product Details Page");
            ProductDetailsPage productDetailsPage = productsPage.clickBackpack();
            System.out.println(productDetailsPage.getProductName());
            logger.info("Product adding" + productDetailsPage.getProductName());
            productDetailsPage.clickAddToCart();
            assertEquals(productDetailsPage.getCountCart(), "1");
            logger.info("Product removing" + productDetailsPage.getProductName());
            productDetailsPage.clickRemoveFromCart();
            assertEquals(productDetailsPage.getCountCart(), "0");
            logger.info("Product adding and removing successful");
        } catch (Exception e) {
            logger.info("Product not Found");
        }

    }
}
