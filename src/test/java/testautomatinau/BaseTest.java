package testautomatinau;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;


import pages.LoginPage;
import pages.ProductsPage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;

    protected String username;
    protected String password;
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    public BaseTest() {
        logger.info("Base Test Instantiated");
    }

    //@BeforeClass
    @BeforeEach

//    @ParameterizedTest
//    @ValueSource(strings = {"chrome", "firefox"})
    //@Parameters("browser") // Add this to specify browser parameter
    public void setUp() throws MalformedURLException {
        String nodeURL = "http://localhost:4444/wd/hub";
        String browser = System.getProperty("browser", "chrome");
        logger.info("BeforeClass setup is running...");
        try {
            loadDataFromJSON("D:/JetBrains/Projects/selenium-assign/src/test/resources/data.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File read");
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        }
        logger.info("Accessing URL");

        driver.get("https://www.saucedemo.com/");
        //driver.manage().window().fullscreen();

        logger.info("Setting the Credentials");
        loginPage = new LoginPage(driver);
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);

        logger.info("Login Completed");
        productsPage = loginPage.clickLoginButton();
        logger.info("Post Login Workflow Started");
    }

    private void loadDataFromJSON(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File(filePath));

        username = jsonNode.get(0).get("username").asText();
        password = jsonNode.get(0).get("password").asText();
    }
    //@AfterClass
    @AfterEach
    public void tearDown(){
        System.out.println("AfterClass");
        if (driver != null) {
            driver.quit();
        }
    }
}
