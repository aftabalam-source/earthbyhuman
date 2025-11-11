package PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ContactUsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By contactUsLink = By.xpath("//a[contains(text(),'Contact Us') or @href='/contact-us']"); //$NON-NLS-1$
    private By form = By.id("contactForm"); //$NON-NLS-1$
    private By nameField = By.id("name"); //$NON-NLS-1$
    private By emailField = By.id("email"); //$NON-NLS-1$
    private By phoneField = By.id("phone"); //$NON-NLS-1$
    private By subjectField = By.id("subject"); //$NON-NLS-1$
    private By messageField = By.id("textarea"); //$NON-NLS-1$
    private By sendButton = By.xpath("//button[contains(.,'Send Message')]"); //$NON-NLS-1$

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
    }

    public void openContactForm() {
        WebElement contactLink = wait.until(ExpectedConditions.elementToBeClickable(contactUsLink));
        contactLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(form));
        System.out.println("✅ Contact form opened successfully"); //$NON-NLS-1$
    }

    public void fillContactForm(String name, String email, String phone, String subject, String message) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(subjectField).sendKeys(subject);
        driver.findElement(messageField).sendKeys(message);
    }

    public void submitForm() {
        driver.findElement(sendButton).click();
        System.out.println("📤 Submitted Contact Form"); //$NON-NLS-1$
    }

    public boolean isSubmissionSuccessful() {
        return wait.until(driver ->
            driver.getPageSource().toLowerCase().contains("thank") || //$NON-NLS-1$
            driver.getPageSource().toLowerCase().contains("success") //$NON-NLS-1$
        );
    }
}
