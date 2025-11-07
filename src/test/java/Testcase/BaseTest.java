package Testcase;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.earthbyhumans.com"); //$NON-NLS-1$

        // Wait for the "Login" button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement loginButton = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='Login']"))//$NON-NLS-1$
        );

        // Click the Login button
        loginButton.click();
        System.out.println("✅ Login button clicked successfully"); //$NON-NLS-1$
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("🧹 Browser closed successfully"); //$NON-NLS-1$
        }
    }
}
