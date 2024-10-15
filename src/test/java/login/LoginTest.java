package login;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;
import pages.*;
import testautomatinau.BaseTest;

import static org.testng.Assert.*;
public class LoginTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);
    @Test(groups = "Login Test")

    public void loginTest() {

        assertEquals(productsPage.getHeaderSuccess(), "Products", "Error: Header doesn't match");
        logger.info("Product Page Loaded");
    }
}

// For individual testing
//        loginPage.enterUserName("standard_user");
//        loginPage.enterPassword("secret_sauce");
//        ProductsPage page;
//        page = loginPage.clickLoginButton();
//
//        System.out.println("Current URL after login: " + driver.getCurrentUrl());
//
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header_container\"]/div[2]/span")));
//        assertEquals(productsPage.getHeaderSuccess(), "Products", "Error: Header doesn't match");

