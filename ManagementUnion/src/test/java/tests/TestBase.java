package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.edge.driver",
                "C:\\Users\\anase\\Desktop\\ManagementUnion\\drivers\\msedgedriver.exe");

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://test.erppluscloud.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
