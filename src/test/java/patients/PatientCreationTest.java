package patients;

import com.legion.pages.LoginPage;
import com.legion.pages.PatientCreationPage;
import com.legion.utilities.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


@Epic("Create Patients Tests Epic")
@Feature("Create Patients Screen")
public class PatientCreationTest extends BaseTest {
    @BeforeEach
    public void setup() {
        page.getPage(LoginPage.class)
                .givenILoginAsDoctor()
                .whenIPressCreatePatientButton();
    }

    @Test
    @Story("Create Patients Page.")
    @Description("Verify that the user can successfully populate fields.")
    public void populateFieldsTest() {
        page.getPage(PatientCreationPage.class)
                .whenIEnterFirstName("John")
                .andIEnterLastName("Doe")
                .andIEnterMiddleName("Middle")
                .andIEnterAddress("123 Main St");
        // TODO: 6/30/2023 Add more fields
    }




}
