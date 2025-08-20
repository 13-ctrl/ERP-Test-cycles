package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    // Locators
    private By usernameField = By.id("UserName");
    private By passwordField = By.id("Password");
    private By loginButton   = By.xpath("//button[@type='submit']");
    private By dashboardTitle = By.xpath("//h3[@class='box-title']");

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public String getDashboardTitle() {
        return getText(dashboardTitle);
    }
}
