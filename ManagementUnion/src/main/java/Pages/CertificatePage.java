package Pages;

import org.openqa.selenium.*;

public class CertificatePage extends PageBase {

    public CertificatePage(WebDriver driver) {
        super(driver);
    }

    // Step 1: Confirm Dashboard present
    private By dashboardH3 = By.xpath("//h3[@class='box-title' and normalize-space()='Dashboard']");

    // Step 1: open nav (hamburger)
    private By navIcon = By.id("nav-icon1");

    // Step 2: open Management of Union and Team Memberships
    private By managementMenu =
            By.xpath("//h6[@class='text-capitalize' and normalize-space()='Management of Union and Team Memberships']");

    // Step 3: Registration Requests
    private By registrationRequestsH6 = By.xpath("//h6[normalize-space()='Registration Requests']");

    // Step 4: Add
    private By addBtn = By.xpath("//button[normalize-space()='Add']");

    // Step 5: Certificate of incorporation
    private By certificateBtn = By.id("BtnAddExtractinPpermissionArranged");
    // Step 6-7: Company names
    private By companyNameAR = By.id("CopmanyNameAR");
    private By companyNameEN = By.id("CopmanyNameEN");

    // Step 8: Legal Entity -> arrow -> option 'فردي'
    private By legalEntityInput = By.xpath("//input[@name='LegalEntityId_input']");

    // Step 8 (sector): open -> choose 'Class A'
    private By sectorInput = By.xpath("//input[@name='SectorId_input']");

    // Step 9: Classification -> choose 'Direct'
    private By classificationInput = By.name("ClassificationId_input");

    // Step 10: Save and success message
    //private By saveBtn = By.xpath("//button[@id='BtnSaveMemberShipRegiteration' and normalize-space()='Save']");
    private By successMessageLabel = By.id("lblAlertMsg");


    //  Actions

    // Step 1
    public boolean isOnDashboard() {
        return visible(dashboardH3).isDisplayed();
    }
    public void openNav() {
        click(navIcon);
    }

    // Step 2
    public void openManagementOfUnionAndTeams() {
        click(managementMenu);
    }

    // Step 3
    public void openRegistrationRequests() {
        click(registrationRequestsH6);
    }

    // Step 4
    public void clickAdd() {
        click(addBtn);
    }

    // Step 5
    public void clickCertificateOfIncorporation() {
        click(certificateBtn);
    }

    // Step 6
    public void setCompanyNameAR(String value) {
        type(companyNameAR, value);
    }

    // Step 7
    public void setCompanyNameEN(String value) {
        type(companyNameEN, value);
    }

    // Step 8 (legal entity)
    public void chooseLegalEntity_Individual() {
        // type directly in the input field
        driver.findElement(legalEntityInput).sendKeys("فردي");

        // press ENTER to confirm selection
        driver.findElement(legalEntityInput).sendKeys(Keys.ENTER);
    }

    // Step 8 (sector)
    public void chooseSector_ClassA() {
        WebElement input = driver.findElement(sectorInput);
        input.clear(); // clear in case something is already typed
        input.sendKeys("Class A");
        input.sendKeys(Keys.ENTER); // confirm selection
    }

    // Step 9
    public void chooseClassification_Direct() {
        WebElement input = driver.findElement(classificationInput);
        input.clear(); // clear in case something is already typed
        input.sendKeys("Direct");
        input.sendKeys(Keys.ENTER); // confirm selection
    }

    // Step 10
    public void saveRegistration() {
        WebElement saveButton = driver.findElement(By.id("BtnSaveMemberShipRegiteration"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
    }
//step11
    public boolean isSaveSuccessful() {
        return visible(successMessageLabel).isDisplayed();
    }

}
