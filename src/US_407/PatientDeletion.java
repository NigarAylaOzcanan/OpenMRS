package US_407;

import Utility.BaseDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

// Credentials:
// Username: admin
// Password: Admin123
// Website: https://demo.openmrs.org/openmrs/login.htm

public class PatientDeletion extends BaseDriver {
    String usernameStr = "admin";
    String passwordStr = "Admin123";
    String nameStr = "Cosette";
    String lastNameStr = "Tholomyes";
    String birthDayStr = "1";
    String birtYearStr = "2014";
    String addressStr = "rue blumet avenue purple st. 4/5";
    String cityStr = "Paris";
    String provinceStr = "Ile-de France";
    String countryStr = "France";
    String postalCodeStr = "75000";
    String phoneNumberStr = "+123 222 33 44";
    String patientRelativeStr = "Jean Valjean";
    String patientCredentialsStr = "Cosette Tholomyes";

    @Test(priority = 1)
    public void login() {
        // Log in to the application homepage as an admin user.
        // Enter the valid credentials (valid credentials are specified above.)
        ome.mySendKeys(ome.usernamePlc, usernameStr);
        ome.mySendKeys(ome.passwordPlc, passwordStr);
        ome.myClick(ome.registrationDesk);
        ome.myClick(ome.loginButton);
    }

    @Test(priority = 2)
    public void patientRegistration() {
        // Create a customer/patient account for the test scenario
        // Enter the customer data for registration
        wait.until(ExpectedConditions.elementToBeClickable(ome.registerAPatient));
        ome.myClick(ome.registerAPatient);
        ome.mySendKeys(ome.givenNamePlc, nameStr);
        ome.mySendKeys(ome.familyNamePlc, lastNameStr);
        ome.myClick(ome.nextButton);

        Select select = new Select(ome.genderSelect);
        select.selectByVisibleText("Female");
        ome.myClick(ome.nextButton);
        ome.mySendKeys(ome.birthDay, birthDayStr);

        select = new Select(ome.birthMonthSelect);
        select.selectByVisibleText("January");
        ome.mySendKeys(ome.birthYear, birtYearStr);
        ome.myClick(ome.nextButton);
        ome.mySendKeys(ome.address1, addressStr);
        ome.mySendKeys(ome.cityVillage, cityStr);
        ome.mySendKeys(ome.stateProvince, provinceStr);
        ome.mySendKeys(ome.country, countryStr);
        ome.mySendKeys(ome.postalCode, postalCodeStr);
        ome.myClick(ome.nextButton);
        ome.mySendKeys(ome.phoneNumber, phoneNumberStr);
        ome.myClick(ome.nextButton);

        select = new Select(ome.relationshipTypeSelect);
        select.selectByVisibleText("Parent");
        ome.mySendKeys(ome.personName, patientRelativeStr);
        ome.myClick(ome.nextButton);
        ome.myClick(ome.confirmButton);
    }

    @Test(priority = 3)
    public void deleteThePatientRecord() {
        // Under the General Actions tab, locate and click on the Delete Patient link.
        wait.until(ExpectedConditions.elementToBeClickable(ome.deletePatientButton));
        ome.myClick(ome.deletePatientButton);

        // Enter a valid reason and confirm the deletion action.
        ome.mySendKeys(ome.deletionReason, "Privacy");
        ome.myClick(ome.deletionConfirmButton);
    }

    @Test(priority = 4, dependsOnMethods = {"deleteThePatientRecord"})
    public void verifyTheDeletion() {
        // Enter the name or ID of the deleted patient in the search field.
        wait.until(ExpectedConditions.visibilityOf(ome.patientSearchBox));
        ome.mySendKeys(ome.patientSearchBox, patientCredentialsStr + Keys.ENTER);

        // Verify the deletion process (The patient's records should no longer be accessible in the system.)
        wait.until(ExpectedConditions.elementToBeClickable(ome.noMatchingRecordMsg));
        Assert.assertNotEquals(ome.noMatchingRecordMsg.getText(), "Cosette Tholomyes", "No matching records found");
        logger.info("Search result: " + ome.noMatchingRecordMsg.getText());
    }
}
