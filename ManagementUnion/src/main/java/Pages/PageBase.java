package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        this.actions = new Actions(driver);
    }

    // Core wrappers
    protected WebElement visible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement clickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator) {
        clickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement el = visible(locator);
        el.clear();
        el.sendKeys(text);
    }

    protected String getText(By locator) {
        return visible(locator).getText();
    }

    // ====== EXTRA helpers (to fix CertificatePage issues) ======

    // Click using By locator
    protected void clickButton(By locator) {
        WebElement el = clickable(locator);
        try {
            el.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
        }
    }

    // Type into input using By locator
    protected void setTextElementText(By locator, String value) {
        WebElement el = visible(locator);
        el.clear();
        el.sendKeys(value);
    }

    // Scroll into view
    protected void scrollToElement(By locator) {
        WebElement el = visible(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
    }

    // Select from <select> by index
    protected void selectElementByIndex(By locator, int index) {
        WebElement el = visible(locator);
        Select select = new Select(el);
        select.selectByIndex(index);
    }

    // Select by visible text
    protected void selectElementByText(By locator, String text) {
        WebElement el = visible(locator);
        Select select = new Select(el);
        select.selectByVisibleText(text);
    }

    // Get input value
    protected String getInputValue(By locator) {
        return visible(locator).getAttribute("value");
    }
}
