package US_409;

import Utility.BaseDriver;
import Utility.ParentPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PatientRecordMerge extends BaseDriver {
    ParentPage pp = new ParentPage();
    String usernameStr = "admin";
    String passwordStr = "Admin123";
    String ID1;
    String ID2;

    @Test(priority = 1)
    public void login() {
        // Login procedure
        ome.mySendKeys(ome.usernamePlc, usernameStr);
        ome.mySendKeys(ome.passwordPlc, passwordStr);
        ome.myClick(ome.inpatientWard);
        ome.myClick(ome.loginButton);
    }

    @Test(priority = 2)
    public void firstPatient() {
        // Click "Register a Patient" button
        ome.myClick(ome.registerAPatient);

        // Patient full name info
        ome.mySendKeys(ome.givenNamePlc, "Roshaunda");
        ome.mySendKeys(ome.middleNamePlc, "Kenyanna");
        ome.mySendKeys(ome.familyNamePlc, "Petitt");

        ome.myClick(ome.nextButton);

        // Select Gender
        Select select = new Select(ome.genderSelect);
        select.selectByIndex(1);

        ome.myClick(ome.nextButton);

        // Enter birthdate information
        ome.mySendKeys(ome.birthDay, "21");

        select = new Select(ome.birthMonthSelect);
        select.selectByIndex(8);

        ome.mySendKeys(ome.birthYear, "1998");
        ome.myClick(ome.nextButton);

        // Patient address information
        ome.mySendKeys(ome.address1, "Readers St 2423, Andersonville, Malawi, 326145");
        ome.mySendKeys(ome.cityVillage, "Nenana");
        ome.mySendKeys(ome.stateProvince, "Gig Harbor");
        ome.mySendKeys(ome.country, "France");
        ome.mySendKeys(ome.postalCode, "73438");
        ome.myClick(ome.nextButton);

        // Phone number
        ome.mySendKeys(ome.phoneNumber, "13391");
        ome.myClick(ome.nextButton);
        ome.myClick(ome.nextButton);

        ome.myClick(ome.confirmButton);
        ID1 = ome.patientID.getText();
        ome.myClick(ome.homePageBtn);
    }

    @Test(priority = 3)
    public void secondPatient() {
        // Click "Register a Patient" button
        ome.myClick(ome.registerAPatient);

        // Patient full name info
        ome.mySendKeys(ome.givenNamePlc, "Nava");
        ome.mySendKeys(ome.middleNamePlc, "Lashara");
        ome.mySendKeys(ome.familyNamePlc, "Agan");

        ome.myClick(ome.nextButton);

        // Select Gender
        Select select = new Select(ome.genderSelect);
        select.selectByIndex(0);

        ome.myClick(ome.nextButton);

        // Enter birthdate information
        ome.mySendKeys(ome.birthDay, "15");

        select = new Select(ome.birthMonthSelect);
        select.selectByIndex(4);

        ome.mySendKeys(ome.birthYear, "1998");
        ome.myClick(ome.nextButton);

        // Patient address information
        ome.mySendKeys(ome.address1, "Geography Street 266, Mastic Beach, Australia, 529179");
        ome.mySendKeys(ome.cityVillage, "Suwanee");
        ome.mySendKeys(ome.stateProvince, "Gallagher");
        ome.mySendKeys(ome.country, "Barbados");
        ome.mySendKeys(ome.postalCode, "63351");

        ome.myClick(ome.nextButton);

        // Phone number
        ome.mySendKeys(ome.phoneNumber, "4643344");

        ome.myClick(ome.nextButton);
        ome.myClick(ome.nextButton);
        ome.myClick(ome.confirmButton);
        ID2 = ome.patientID.getText();
        ome.myClick(ome.homePageBtn);
    }

    @Test(priority = 4)
    public void patientRecordMerge() {
        // Navigate to Merge Patient Page
        ome.myClick(ome.dataManagement);
        ome.myClick(ome.mergePatientBtn);

        // Merge Patients
        ome.mySendKeys(ome.patient1, ID1);
        ome.mySendKeys(ome.patient2, ID2);
        new Actions(driver).sendKeys(Keys.ENTER).build().perform();
        ome.myClick(ome.mergeContinueBtn);

        pp.verifyContainsText(ome.beforeMergeMessage, "undone");

        ome.myClick(ome.secondPatient);
        ome.myClick(ome.mergeContinueBtn);

        // Assertion for success message
        Assert.assertEquals(ome.mergedPatientIDs.size(), 2);
    }
}
