package starter.steps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import starter.page.VicolandCreateNewVico;

public class VicolandCreateNewVicoSteps {

    VicolandCreateNewVico vicolandCreateNewVico;

    @Step
    public void maximizeScreen(WebDriver driver) {
        vicolandCreateNewVico.maximizeScreen(driver);
    }

    @Step
    public void openPage () {
        vicolandCreateNewVico.open();
    }

    @Step
    public void clickBtn () {
        vicolandCreateNewVico.loginButton();
    }

    @Step
    public void fillEmailField(String email) {
        vicolandCreateNewVico.typeEmail(email);
    }

    @Step
    public void fillPasswordField(String password) {
        vicolandCreateNewVico.typePassword(password);
    }

    @Step
    public void clickSubmitBtn () {
        vicolandCreateNewVico.submitButton();
    }

    @Step
    public void newButton () {
        vicolandCreateNewVico.clickOnNewButton();
    }

    @Step
    public void typeVicoName (String name) {
        vicolandCreateNewVico.typeVicoNameField(name);
    }

    @Step
    public void typeVicoDescriptionField (String description) {
        vicolandCreateNewVico.typeVicoDescriptionField(description);
    }

    @Step
    public void typeVicoSkillsField (String text) {
        vicolandCreateNewVico.typeVicoSkillsField(text);
    }

    @Step
    public void selectVicoSkillOption () {
        vicolandCreateNewVico.selectVicoSkillOption();
    }

    @Step
    public void selectNewVicoSkillOption () {
        vicolandCreateNewVico.selectNewVicoSkillOption();
    }

    @Step
    public void clickOnCreateVico () {
        vicolandCreateNewVico.clickOnCreateVico();
    }

    @Step
    public void getVicoNameOnDashboard () {
        vicolandCreateNewVico.getVicoNameOnDashboard();
    }

    @Step
    public void checkVicoNameToggle (String vicoName) {
        vicolandCreateNewVico.checkVicoNameToggle(vicoName);
    }
}
