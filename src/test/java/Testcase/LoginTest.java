package Testcase;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import PageObject.LoginPage;
import Testcase.TestListener; // ✅ This import is REQUIRED

@Listeners(TestListener.class) // ✅ Correct way
public class LoginTest extends BaseTest {

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Difm@gmail.com", "123456"); //$NON-NLS-2$ , //$NON-NLS-1$
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(actualError, "Invalid email or password.", "Error message mismatch!"); //$NON-NLS-1$//$NON-NLS-2$
    }

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Difm@gmail.com", "123456");  //$NON-NLS-1$//$NON-NLS-2$
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.earthbyhumans.com/dashboard"); //$NON-NLS-1$
    }
}
