package tests;

import Pages.LoginPage;
import Pages.CertificatePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CertificatePageTest extends TestBase {
    private CertificatePage cp;

    @BeforeMethod
    public void setUpTest() {
        // Use driver from TestBase (already initialized there)
        driver.get("https://test.erppluscloud.com");
        cp = new CertificatePage(driver); // Initialize page object with existing driver
    }

    @Test
    public void testMembershipRegistrationFlow() {
        String companyName = "testAutomation";
        // Step 1: Login
        LoginPage login = new LoginPage(driver);
        login.enterUsername("Anasbayoumi");
        login.enterPassword("Anas123");
        login.clickLogin();

        // Step 2: ensure Dashboard then open nav
        Assert.assertTrue(cp.isOnDashboard(), "Dashboard header not found.");
        cp.openNav();
        sleep(2000);

        // Step 3: open "Management of Union and Team Memberships"
        cp.openManagementOfUnionAndTeams();
        sleep(2000);

        // Step 4: click "Registration Requests"
        cp.openRegistrationRequests();
        sleep(2000);

        // Step 5: click "Add"
        cp.clickAdd();
        sleep(4000);

        // Step 6: click "Certificate of incorporation"
        cp.clickCertificateOfIncorporation();
        sleep(5000);

        // Step 7: fill names
        cp.setCompanyNameAR(companyName);
        cp.setCompanyNameEN(companyName);

        // Step 8: Legal Entity -> 'فردي'
        cp.chooseLegalEntity_Individual();

        // Step 9: Sector -> 'Class A'
        cp.chooseSector_ClassA();

        // Step 10: Classification -> 'Direct'
        cp.chooseClassification_Direct();
        sleep(2000);

        // Step 11: Save and verify success
        sleep(2000);
        cp.saveRegistration();

        sleep(2000);
        Assert.assertTrue(cp.isSaveSuccessful(), "Expected success message was not displayed!");

    }

    // Utility sleep method
    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
