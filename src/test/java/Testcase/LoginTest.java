package Testcase;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import PageObject.*;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    // 🥇 Sign Up navigation
    @Test(priority = 1)
    public void testSignUpButtonNavigation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        By signUpLink = By.xpath("//a[contains(text(),'Sign Up') or contains(.,'Signup')]"); //$NON-NLS-1$
        wait.until(ExpectedConditions.elementToBeClickable(signUpLink)).click();
        wait.until(ExpectedConditions.urlContains("/signup")); //$NON-NLS-1$

        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("signup"), //$NON-NLS-1$
                "❌ Sign Up navigation failed!"); //$NON-NLS-1$
        System.out.println("✅ Sign Up navigation passed!"); //$NON-NLS-1$
    }

    // 🥈 Invalid login
    @Test(priority = 2)
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wronguser@gmail.com", "wrongpass"); //$NON-NLS-1$ //$NON-NLS-2$

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(
                error.toLowerCase().contains("invalid") || error.toLowerCase().contains("incorrect")); //$NON-NLS-1$ //$NON-NLS-2$
        System.out.println("✅ Invalid login error displayed!"); //$NON-NLS-1$
    }

    // 🥉 Valid login
    @Test(priority = 3)
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Difm@gmail.com", "123456"); //$NON-NLS-1$ //$NON-NLS-2$

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("https://www.earthbyhumans.com/")); //$NON-NLS-1$

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.earthbyhumans.com/"); //$NON-NLS-1$
        System.out.println("✅ Valid login successful!"); //$NON-NLS-1$
    }

    // 🟢 Contact Us
    @Test(priority = 4)
    public void testContactUsForm() {
        ContactUsPage contactPage = new ContactUsPage(driver);

        contactPage.openContactForm();
        contactPage.fillContactForm("Sam Test", "difm@gmail.com", "9876543210", "Automation Inquiry", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                "This is a Selenium test."); //$NON-NLS-1$
        contactPage.submitForm();

        Assert.assertTrue(contactPage.isSubmissionSuccessful(), "❌ Contact form submission failed!"); //$NON-NLS-1$
        System.out.println("✅ Contact Us form submitted successfully!"); //$NON-NLS-1$
    }

    // 🟣 Subscribe
    @Test(priority = 5)
    public void testSubscribeNewsletter() {
        SubscribePage subscribePage = new SubscribePage(driver);

        subscribePage.scrollToFooter();
        subscribePage.subscribe("qa.subscription@example.com"); //$NON-NLS-1$

        Assert.assertTrue(subscribePage.isSubscribed(), "❌ Subscription failed!"); //$NON-NLS-1$
        System.out.println("✅ Subscription test passed!"); //$NON-NLS-1$
    }
}
