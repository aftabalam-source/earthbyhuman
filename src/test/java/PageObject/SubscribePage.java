package PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class SubscribePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By emailField = By.xpath("//input[contains(@placeholder,'Enter your email')]"); //$NON-NLS-1$
    private By subscribeButton = By.xpath("//button[contains(.,'Subscribe') or contains(text(),'Subscribe')]"); //$NON-NLS-1$

    public SubscribePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
    }

    public void scrollToFooter() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)"); //$NON-NLS-1$
        System.out.println("📜 Scrolled to footer section"); //$NON-NLS-1$
    }

    public void subscribe(String email) {
        WebElement emailBox = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailBox.clear();
        emailBox.sendKeys(email);
        driver.findElement(subscribeButton).click();
        System.out.println("📩 Clicked Subscribe"); //$NON-NLS-1$
    }

    public boolean isSubscribed() {
        return wait.until(driver ->
            driver.getPageSource().toLowerCase().contains("thank") || //$NON-NLS-1$
            driver.getPageSource().toLowerCase().contains("subscribed") //$NON-NLS-1$
        );
    }
}
