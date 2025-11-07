package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // ✅ Replaced with valid, working XPaths based on your <form> HTML
    private By emailField = By.xpath("//input[@placeholder='Enter email/username']"); //$NON-NLS-1$
    private By passwordField = By.xpath("//input[@placeholder='Enter password']"); //$NON-NLS-1$
    private By loginButton = By.xpath("//button[normalize-space(text())='Log In']"); //$NON-NLS-1$
    private By errorMessage = By.xpath("//p[contains(text(),'Invalid') or contains(text(),'incorrect')]"); //$NON-NLS-1$

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Enter Email
    public void enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    // ✅ Enter Password
    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    // ✅ Click Login Button
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // ✅ Get Error Message
    public String getErrorMessage() {
        try {
            return driver.findElement(errorMessage).getText();
        } catch (Exception e) {
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
