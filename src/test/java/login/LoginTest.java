package login;

import com.legion.consts.AccConsts;
import com.legion.pages.LoginPage;
import com.legion.utilities.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

@Epic("Login Tests Epic")
@Feature("Login Screen")
public class LoginTest extends BaseTest {

    @Test
    @Story("Login Page.")
    @Description("Verify that the user can successfully open the login page.")
    public void openLoginScreenTest() {
        page.getPage(LoginPage.class)
                .givenIAmAtLoginPage()
                .thenIVerifyPageTitleVisible();
    }

    @Test
    @Story("Login Page.")
    @Description("Verify that the user can successfully login with valid credentials.")
    public void loginWithValidCredentialsTest() {
        page.getPage(LoginPage.class)
                .givenIAmAtLoginPage()
                .whenIEnterUsername(AccConsts.doctorUsername)
                .andIEnterPassword(AccConsts.doctorPassword)
                .andIClickSubmitButton()
                .thenIVerifyPatientsPageTitleIsDisplayed();
    }


}
