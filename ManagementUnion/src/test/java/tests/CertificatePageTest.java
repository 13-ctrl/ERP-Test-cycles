package tests;

import Pages.LoginPage;
import Pages.CertificatePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class CertificatePageTest extends TestBase {

    @Test
    public void testMembershipRegistrationFlow() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Login
        LoginPage login = new LoginPage(driver);
        login.enterUsername("mernan");
        login.enterPassword("123456");
        login.clickLogin();

        // Follow the exact steps you specified:
        CertificatePage mp = new CertificatePage(driver);

        // Step 1: ensure Dashboard then open nav
        Assert.assertTrue(mp.isOnDashboard(), "Dashboard header not found.");
        mp.openNav();

        // Step 2: open "Management of Union and Team Memberships"
        mp.openManagementOfUnionAndTeams();

        // Explicit wait for 5 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h6[normalize-space()='Registration Requests']")
        ));

        // Step 3: click "Registration Requests"
        mp.openRegistrationRequests();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 4: click "Add"
        mp.clickAdd();

        // explicit wait for 5 seconds until the next element is visible
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 5: click "Certificate of incorporation"
        mp.clickCertificateOfIncorporation();

        // explicit wait for 5 seconds until the next element is visible
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Step 6-7: fill names
        mp.setCompanyNameAR("testAutomation");
        mp.setCompanyNameEN("testAutomation");

        // Step 8: Legal Entity -> arrow -> 'فردي'
        mp.chooseLegalEntity_Individual();

        // Step 8 (sector): 'Class A'
        mp.chooseSector_ClassA();

        // Step 9: Classification -> 'Direct'
        mp.chooseClassification_Direct();

        // Step 10: Save and verify landing header
        wait.until(ExpectedConditions.elementToBeClickable(By.id("BtnSaveMemberShipRegiteration")));

        mp.saveRegistration();

        Assert.assertTrue(mp.isSaveSuccessful(), "Success message not displayed");

    }
}
