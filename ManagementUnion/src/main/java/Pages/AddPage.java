package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddPage extends PageBase {

    public AddPage(WebDriver driver) {
        super(driver); //calls PageBase constructor
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

    // Step 5: Add Page
    private By certificateBtn = By.id("BtnAddRegistration");


    // Step 6-7: Company names
    private By companyNameAR = By.id("CopmanyNameAR");
    private By companyNameEN = By.id("CopmanyNameEN");

    // Step 8, 9
    public void selectFirstOption(String listboxId) {
        // Click dropdown arrow
        By dropdownArrow = By.xpath("//span[@aria-controls='" + listboxId + "']");
        WebElement arrow = wait.until(ExpectedConditions.elementToBeClickable(dropdownArrow));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", arrow);

        // Wait until the listbox is visible
        By firstOptionLocator = By.xpath("//ul[@id='" + listboxId + "']/li[1]");
        WebElement firstOption = wait.until(ExpectedConditions.visibilityOfElementLocated(firstOptionLocator));

        // Click first option
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstOption);
    }

    // Step 10: Save and success message
    private By saveButton = By.id("BtnSaveMemberShipRegiteration");
    //step 11
    private By successMessage = By.id("lblAlertMsg");


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

    // step 8 , 9
    // Step-specific helpers
    public void chooseLegalEntity_Individual() {
        selectFirstOption("LegalEntityId_listbox");
    }

    public void chooseSector_ClassA() {
        selectFirstOption("SectorId_listbox");
    }

    public void chooseClassification_Direct() {
        selectFirstOption("ClassificationId_listbox");
    }


    // Step 10
    public void saveRegistration() {
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(saveButton));

        // Scroll into view (sometimes offscreen)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

        wait.until(ExpectedConditions.elementToBeClickable(button));

        try {
            button.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }
    }
    //step11
    public boolean isSaveSuccessful() {
        // Wait until the label contains the text "Saved Successfully"
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(
                successMessage, "Saved Successfully"
        ));
    }



}
