package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseDriverParameter {
    public static final Logger logger4j2 = LogManager.getLogger();
    public static WebDriverWait wait;
    public WebDriver driver;

    @BeforeClass
    @Parameters("browserType")
    public void initialOperations(String browserType) {
        switch (browserType.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "safari":
                driver = new SafariDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                driver = new ChromeDriver();
        }

        driver.manage().window().maximize(); // It maximizes the screen.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 30 sec delay: time to load the page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));  // 30 sec delay: time to find the element
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        login();
    }

    public void login() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement inputEmail = driver.findElement(By.id("input-email"));
        inputEmail.sendKeys("testng1@gmail.com");

        WebElement inputPassword = driver.findElement(By.id("input-password"));
        inputPassword.sendKeys("123qweasd");

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        wait.until(ExpectedConditions.titleIs("My Account"));
        Assert.assertEquals(driver.getTitle(), "My Account");
    }

    @AfterClass
    public void finishingOperations() {
        Tools.wait(5);
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        logger4j2.info("Test Method has started.");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        logger4j2.info(result.getName() + " test method has finished. --> " + (result.getStatus() == 1 ? "Passed" : "Failed"));
    }
}
