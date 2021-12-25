package starter.test;
import com.github.javafaker.Faker;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import starter.data.UserData;
import starter.steps.VicolandCreateNewVicoSteps;

@RunWith(SerenityRunner.class)
public class VicolandCreateNewVicoTest {

    Faker faker = new Faker();
    String vicoName = faker.name().title();
    String vicoDescription = faker.lorem().sentence();
    String vicoWord = faker.lorem().word();

    @Steps
    VicolandCreateNewVicoSteps vicolandCreateNewVicoSteps;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    public void LoginPage () {
        // Login as Freelancer
        vicolandCreateNewVicoSteps.openPage();
        vicolandCreateNewVicoSteps.maximizeScreen(driver);
        vicolandCreateNewVicoSteps.clickBtn();
        vicolandCreateNewVicoSteps.fillEmailField(UserData.USERNAME.value());
        vicolandCreateNewVicoSteps.fillPasswordField(UserData.PASSWORD.value());
        vicolandCreateNewVicoSteps.clickSubmitBtn();

        // Click on: “Create a new Vico” CTA
        vicolandCreateNewVicoSteps.newButton();

        // Enter Vico name in the field
        vicolandCreateNewVicoSteps.typeVicoName(vicoName);

        // Enter Vico description in the field
        vicolandCreateNewVicoSteps.typeVicoDescriptionField(vicoDescription);

        // Enter a letter in the field under·”Main skills”
        vicolandCreateNewVicoSteps.typeVicoSkillsField("A");

        // Select a skill from the dropdown
        vicolandCreateNewVicoSteps.selectVicoSkillOption();
        vicolandCreateNewVicoSteps.typeVicoSkillsField(vicoWord);
        vicolandCreateNewVicoSteps.selectNewVicoSkillOption();

        // Click on: “Create a Vico”
        vicolandCreateNewVicoSteps.clickOnCreateVico();

        // Check that Vico is created and it is shown on main menu
        vicolandCreateNewVicoSteps.getVicoNameOnDashboard();
        vicolandCreateNewVicoSteps.checkVicoNameToggle(vicoName);
    }
}
