package com.legion.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PatientsMainPage extends BasePage {

    //*********Constructor*********
    public PatientsMainPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements By Using Page Factory*********
    @FindBy(how = How.XPATH, using = ("//a[contains(text(),'Patients')]"))
    public WebElement patientsTab;

    @FindBy(how = How.XPATH, using = ("//*[@href='/cases/new/']"))
    public WebElement createPatientButton;


    //*********Page Methods*********

    public void thenIVerifyPatientsPageTitleIsDisplayed() {
        assertTrue(isElementPresent(patientsTab));
    }

    public PatientCreationPage whenIPressCreatePatientButton() {
        click(createPatientButton);
        return new PageFactory().initElements(driver, PatientCreationPage.class);
    }

}
