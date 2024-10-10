package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OpenMRS_Elements extends ParentPage {
    public OpenMRS_Elements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(id = "username")
    public WebElement usernamePlc;
    @FindBy(id = "password")
    public WebElement passwordPlc;
    @FindBy(xpath = "//li[@id='Inpatient Ward']")
    public WebElement inpatientWard;
    @FindBy(xpath = "//li[@id='Registration Desk']")
    public WebElement registrationDesk;
    @FindBy(id = "loginButton")
    public WebElement loginButton;
    @FindBy(xpath = "//a[@id='referenceapplication-registrationapp" +
            "-registerPatient-homepageLink-referenceapplication-registrationapp" +
            "-registerPatient-homepageLink-extension']")
    public WebElement registerAPatient;
    @FindBy(xpath = "//input[@name='givenName']")
    public WebElement givenNamePlc;
    @FindBy(xpath = "//input[@name='middleName']")
    public WebElement middleNamePlc;
    @FindBy(xpath = "//input[@name='familyName']")
    public WebElement familyNamePlc;
    @FindBy(xpath = "//button[@id='next-button']")
    public WebElement nextButton;
    @FindBy(xpath = "//button[@id='prev-button']")
    public WebElement prevButton;
    @FindBy(xpath = "//select[@id='gender-field']")
    public WebElement genderSelect;
    @FindBy(xpath = "//input[@id='birthdateDay-field']")
    public WebElement birthDay;
    @FindBy(xpath = "//select[@id='birthdateMonth-field']")
    public WebElement birthMonthSelect;
    @FindBy(xpath = "//input[@id='birthdateYear-field']")
    public WebElement birthYear;
    @FindBy(css = "#address1")
    public WebElement address1;
    @FindBy(css = "#address2")
    public WebElement address2;
    @FindBy(xpath = "//input[@id='cityVillage']")
    public WebElement cityVillage;
    @FindBy(xpath = "//input[@id='stateProvince']")
    public WebElement stateProvince;
    @FindBy(xpath = "//input[@id='country']")
    public WebElement country;
    @FindBy(xpath = "//input[@id='postalCode']")
    public WebElement postalCode;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    public WebElement phoneNumber;
    @FindBy(xpath = "//select[@id='relationship_type']")
    public WebElement relationshipTypeSelect;
    @FindBy(xpath = "//input[@placeholder='Person Name']")
    public WebElement personName;
    @FindBy(xpath = "//input[@id='submit']")
    public WebElement confirmButton;
    @FindBy(xpath = "//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']")
    public WebElement findPatientRecord;
    @FindBy(xpath = "//input[@id='patient-search']")
    public WebElement patientSearchBox;
    @FindBy(xpath = "//td[contains(text(),'Cosette Tholomyes')]")
    public WebElement searchedPatient;
    @FindBy(xpath = "//div[contains(text(),'Delete Patient')]")
    public WebElement deletePatientButton;
    @FindBy(xpath = "//input[@id='delete-reason']")
    public WebElement deletionReason;
    @FindBy(xpath = "(//button[@class='confirm right'])[6]")
    public WebElement deletionConfirmButton;
    @FindBy(xpath = "//td[contains(text(),'No matching records found')]")
    public WebElement noMatchingRecordMsg;
    @FindBy(css = "tbody > tr")
    public List<WebElement> patientList;
    @FindBy(id = "patient-search-results-table_info")
    public WebElement patientListInfo;
    @FindBy(id = "patient-search-results-table_next")
    public WebElement patientListNextBtn;
    @FindBy(xpath = "//a[@id='appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension']")
    public WebElement appointmentScheduling;
    @FindBy(xpath = "//a[@id='appointmentschedulingui-manageAppointments-app']")
    public WebElement manageAppointments;
    @FindBy(xpath = "//p[contains(text(),'Your computer is not set to the right time zone. P')]")
    public WebElement timeZoneWarningMessage;
    @FindBy(xpath = "//td[contains(text(),'Robert Smith')]")
    public WebElement getSearchedPatientForApt;
    @FindBy(css = "div[class=\"logo\"]")
    public WebElement homePageBtn;
    @FindBy(css = "div[class=\"float-sm-right\"] span")
    public WebElement patientID;
    @FindBy(css = "a[id=\"coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension\"]")
    public WebElement dataManagement;
    @FindBy(css = "a[id=\"coreapps-mergePatientsHomepageLink-app\"]")
    public WebElement mergePatientBtn;
    @FindBy(id = "patient1-text")
    public WebElement patient1;
    @FindBy(id = "patient2-text")
    public WebElement patient2;
    @FindBy(id = "confirm-button")
    public WebElement mergeContinueBtn;
    @FindBy(id = "second-patient")
    public WebElement secondPatient;
    @FindBy(xpath = "//h1[contains(text(),'Merging cannot be undone!')]")
    public WebElement beforeMergeMessage;
    @FindBy(xpath = "//div[@class=\"float-sm-right\"] // span")
    public List<WebElement> mergedPatientIDs;
    @FindBy(xpath = "//li[@class='nav-item identifier']")
    public WebElement adminButton;
    @FindBy(xpath = "//*[@id='user-account-menu']/li/a")
    public WebElement myAccount;
    @FindBy(xpath = "//div[@id='tasks']//a[1]")
    public WebElement changePassword;
    @FindBy(xpath = "//div[@id='tasks']//a[2]")
    public WebElement myLanguages;
    @FindBy(css = "[class='icon-signout small']")
    public WebElement logoutButton;
    @FindBy(id = "sessionLocationError")
    public WebElement sessionLocationError;
    @FindBy(id = "error-message")
    public WebElement errorMessage;
    @FindBy(xpath = "(//i[@class='icon-calendar'])[1]")
    public WebElement activeVisits;
    @FindBy(css = "[id='active-visits_filter'] input")
    public WebElement fenceBox;
    @FindBy(xpath = "(//*[@id='active-visits']//a)[1]")
    public WebElement nameFence;
    @FindBy(css = "[class='col-11 col-lg-10']")
    public List<WebElement> patientInformation;
    @FindBy(xpath = "//td[contains(text(),'No entries')]")
    public WebElement NoEntriesText;
}
