package CartRetention;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import login.LoginTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import pages.LoginPage;
import pages.ProductsPage;
import testautomatinau.BaseTest;
//import static org.testng.Assert.*;

public class cartRetentionCheck extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);
    @Test
    @Tag("CartRetentionTest")

    @Description("Test Description: Verifying the cart retains item after re-logging")

    @Step("Checking Successful Cart Retention")
    public void cartTest(){
        logger.info("Cart Retention Test Started");
        logger.info("Adding items to cart");
        productsPage.addOneSieToCart();
        productsPage.addBikeLightToCart();
        productsPage.addRedShirtToCart();
        logger.info("Items added to cart");
        logger.info("Logging out");
        LoginPage loginPage = productsPage.logOut();
        logger.info("Logging In");
        try{
            loginPage.enterUserName("standard_user");
            loginPage.enterPassword("secret_sauce");
            ProductsPage productPage2 = loginPage.clickLoginButton();
            logger.info("Logged In Successfully");
            assertEquals(productPage2.getItemCountCart(), "3");
            logger.info("Items check successful");
        } catch (Exception e){
            logger.info("Logging In Failed");
        }


    }
}
