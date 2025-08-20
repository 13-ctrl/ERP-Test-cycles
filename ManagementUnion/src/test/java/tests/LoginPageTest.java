package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginPageTest extends TestBase {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.edge.driver",
                "C:\\Users\\anase\\Desktop\\ManagementUnion\\drivers\\msedgedriver.exe");

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://test.erppluscloud.com");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.enterUsername("mernan");
        loginPage.enterPassword("123456");
        loginPage.clickLogin();

        String dashboardTitle = loginPage.getDashboardTitle();
        Assert.assertEquals(dashboardTitle, "Dashboard",
                "Login failed or Dashboard not found!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
