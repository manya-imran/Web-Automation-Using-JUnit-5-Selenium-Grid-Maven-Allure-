package Products;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;
import testautomatinau.BaseTest;
import org.testng.Assert.*;

import static org.testng.Assert.assertEquals;

public class SortTests extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(SortTests.class);

    @Test
    @Tag(name="Sorting Test")
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
