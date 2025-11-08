package Testcase;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import PageObject.LoginPage;
import Testcase.TestListener;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wronguser@gmail.com", "wrongpass"); // ❌ Invalid credentials  //$NON-NLS-1$//$NON-NLS-2$

        String actualError = loginPage.getErrorMessage();
        System.out.println("❌ Error Message Found: " + actualError); //$NON-NLS-1$

        // ✅ Expect an error message on invalid login
        Assert.assertTrue(actualError.toLowerCase().contains("invalid") || actualError.toLowerCase().contains("incorrect"), //$NON-NLS-1$ //$NON-NLS-2$
                "Error message mismatch! Expected invalid-login warning, but got: " + actualError); //$NON-NLS-1$
    }

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        // ✅ Use valid credentials here
        loginPage.login("Difm@gmail.com", "123456"); //$NON-NLS-1$ //$NON-NLS-2$

        // Wait until URL changes from login page to home page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.earthbyhumans.com/")); //$NON-NLS-1$

        String actualUrl = driver.getCurrentUrl();
        System.out.println("✅ Login successful! Current URL: " + actualUrl); //$NON-NLS-1$

        // ✅ Assert redirect after successful login
        Assert.assertEquals(actualUrl, "https://www.earthbyhumans.com/",  //$NON-NLS-1$
                "Login failed! User was not redirected to the homepage."); //$NON-NLS-1$
    }
}
