package com.legion.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PatientCreationPage extends BasePage {

    //*********Constructor*********
    public PatientCreationPage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    private String baseURL = "/cases/new/";


    //*********Web Elements By Using Page Factory*********
    @FindBy(how = How.ID, using = "cases_first_name")
    public WebElement firstNameInput;

    @FindBy(how = How.ID, using = "cases_last_name")
    public WebElement lastNameInput;

    @FindBy(how = How.ID, using = "cases_middle_name")
    public WebElement middleNameInput;

    @FindBy(how = How.ID, using = "cases_address")
    public WebElement addressInput;


    //*********Page Methods*********

    public PatientCreationPage thenIVerifyNewPatientPageTitleIsDisplayed() {
        assertTrue(isUrlContains(baseURL));
        return this;
    }

    public PatientCreationPage whenIEnterFirstName(String firstName) {
        writeText(firstNameInput, firstName);
        return this;

    }

    public PatientCreationPage andIEnterLastName(String lastName) {
        writeText(lastNameInput, lastName);
        return this;

    }

    public PatientCreationPage andIEnterMiddleName(String middleName) {
        writeText(middleNameInput, middleName);
        return this;

    }

    public PatientCreationPage andIEnterAddress(String address) {
        writeText(addressInput, address);
        return this;

    }

}
