package Products;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//import org.testng.xml.dom.Tag;
import testautomatinau.BaseTest;
import org.testng.Assert.*;

//import static org.testng.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

public class SortTests extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(SortTests.class);

    @Test
    @Tag("SortingTest")
    @Description("Test Description: Sorting Elements in the Products Catalog")
    @Step("Checking Successful Addition using Products Page")
    public void testSort() {
        logger.info("Sorting Test Name AtoZ Started");
        assertEquals(productsPage.sortByNameAZ(), "Sauce Labs Backpack");
        logger.info("Sorting Test Name AtoZ Successful");
        logger.info("Sorting Test Name ZtoA Started");
        assertEquals(productsPage.sortByNameZA(), "Test.allTheThings() T-Shirt (Red)");
        logger.info("Sorting Test Name ZtoA Successful");
        logger.info("Sorting Test Price High to Low Started");
        assertEquals(productsPage.sortHightoLow(), "Sauce Labs Fleece Jacket");
        logger.info("Sorting Test Price High to Low Successful");
        logger.info("Sorting Test Price Low to High Started");
        assertEquals(productsPage.sortLowtoHigh(),"Sauce Labs Onesie");
        logger.info("Sorting Test Price Low to High Successful");


    }
}
