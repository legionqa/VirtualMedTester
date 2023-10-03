package com.legion.pages;

import com.legion.consts.AccConsts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BasePage {

    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    //*********Page Variables*********
    // TODO: 6/30/2023  username and password should be read from properties file
//    public final static String baseURL = PropertiesUtil.getProperty("baseURL");
//    public final static String doctorUsername = PropertiesUtil.getProperty("doctorUsername");
//    public final static String doctorPassword = PropertiesUtil.getProperty("doctorPassword");

    //*********Web Elements By Using Page Factory*********
    @FindBy(how = How.ID, using = "username")
    public WebElement usernameInput;

    @FindBy(how = How.ID, using = "password")
    public WebElement passwordInput;

    @FindBy(how = How.ID, using = "_submit")
    public WebElement submitButton;

    @FindBy(how = How.ID, using = "remember_me")
    public WebElement rememberMeCheckbox;

    @FindBy(how = How.XPATH, using = "//*[text()='Forgot username/password?]")
    public WebElement forgotUsernamePasswordLink;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Log-in to your account')]")
    public WebElement loginToYourAccountText;


    //*********Page Methods*********
    //Go to Login Page
    public LoginPage givenIAmAtLoginPage() {
        driver.get(AccConsts.baseURL);
        return this;
    }

    public LoginPage whenIClickForgotUsernamePasswordLink() {
        click(forgotUsernamePasswordLink);
        return this;
    }

    public LoginPage whenIEnterUsername(String username) {
        writeText(usernameInput, username);
        return this;
    }

    public LoginPage andIEnterPassword(String password) {
        writeText(passwordInput, password);
        return this;
    }

    public LoginPage andIClickRememberMeCheckbox() {
        click(rememberMeCheckbox);
        return this;
    }

    public PatientsMainPage andIClickSubmitButton() {
        click(submitButton);
        return new PageFactory().initElements(driver, PatientsMainPage.class);
    }

    public LoginPage thenIVerifyUsernameInputIsVisible() {
        assertTrue(isElementPresent(usernameInput));
        return this;
    }

    public LoginPage thenIVerifyPasswordInputIsVisible() {
        assertTrue(isElementPresent(passwordInput));
        return this;
    }

    public LoginPage thenIVerifyRememberMeCheckboxIsVisible() {
        assertTrue(isElementPresent(rememberMeCheckbox));
        return this;
    }

    public LoginPage thenIVerifySubmitButtonIsVisible() {
        assertTrue(isElementPresent(submitButton));
        return this;
    }

    public LoginPage thenIVerifyForgotUsernamePasswordLinkIsVisible() {
        assertTrue(isElementPresent(forgotUsernamePasswordLink));
        return this;
    }

    public void thenIVerifyPageTitleVisible() {
        assertTrue(isElementPresent(loginToYourAccountText));
    }
     public PatientsMainPage givenILoginAsDoctor() {
         driver.get(AccConsts.baseURL);
         writeText(usernameInput, AccConsts.doctorUsername);
         writeText(passwordInput, AccConsts.doctorPassword);
         click(submitButton);
         return new PageFactory().initElements(driver, PatientsMainPage.class);
     }



}
