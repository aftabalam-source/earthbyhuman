package PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class SignUpPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By emailField = By.xpath("//input[contains(@placeholder,'email')]"); //$NON-NLS-1$
    private By passwordField = By.xpath("//input[contains(@placeholder,'password')]"); //$NON-NLS-1$
    private By signUpSubmit = By.xpath("//button[contains(.,'Sign Up') or contains(text(),'SignUp')]"); //$NON-NLS-1$

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void submit() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(signUpSubmit));
        btn.click();
    }
}
