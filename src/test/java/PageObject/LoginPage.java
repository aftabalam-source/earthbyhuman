package PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // ✅ Locators (update these only if your site HTML changes)
    private By emailField = By.xpath("//input[@placeholder='Enter email/username']"); //$NON-NLS-1$
    private By passwordField = By.xpath("//input[@placeholder='Enter password']"); //$NON-NLS-1$
    private By loginButton = By.xpath("//button[normalize-space()='Log In']"); //$NON-NLS-1$
    private By errorMessage = By.xpath("//*[contains(text(),'Invalid') or contains(text(),'incorrect') or contains(text(),'wrong')]"); //$NON-NLS-1$

    // ✅ Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // wait up to 10s
    }

    // ✅ Enter Email
    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    // ✅ Enter Password
    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    // ✅ Click Login Button
    public void clickLogin() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }

    // ✅ Get Error Message (wait for visibility)
    public String getErrorMessage() {
        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            return error.getText();
        } catch (TimeoutException e) {
            return "No error message found"; //$NON-NLS-1$
        }
    }

    // ✅ Combined login method
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }
}
