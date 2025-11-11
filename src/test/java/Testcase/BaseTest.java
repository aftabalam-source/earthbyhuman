package Testcase;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // ✅ Setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.earthbyhumans.com"); //$NON-NLS-1$

        // ✅ Wait for and click Login button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement loginButton = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(normalize-space(),'Login')]")) //$NON-NLS-1$
        );
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
