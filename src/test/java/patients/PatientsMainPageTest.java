package patients;

import com.legion.pages.LoginPage;
import com.legion.pages.PatientsMainPage;
import com.legion.utilities.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


@Epic("Patients Tests Epic")
@Feature("Patients Main Screen")
public class PatientsMainPageTest extends BaseTest {
    @BeforeEach
    public void setup() {
        page.getPage(LoginPage.class)
                .givenILoginAsDoctor();
    }

    @Test
    @Story("Patients Main Page.")
    @Description("Verify that the user can successfully open the patients main page.")
    public void openPatientsMainPageTest() {
        page.getPage(PatientsMainPage.class)
                .whenIPressCreatePatientButton()
                .thenIVerifyNewPatientPageTitleIsDisplayed();
    }


}
