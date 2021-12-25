package starter.page;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

@DefaultUrl("https://demo.vicoland.com/en")
public class VicolandCreateNewVico extends PageObject {
    private final By btnLogin = By.linkText("Login");
    private final By emailField = By.xpath("//input[@id='inputEmail']");
    private final By passField = By.xpath("//input[@id='inputPass']");
    private final By submitBtn = By.xpath("//*[@type='submit']");
    private final By btnNew = By.xpath("//*[@title='Create a new Vico']");
    private final By vicoName = By.xpath("//*[@id='name']");
    private final By vicoDescription = By.xpath("//*[@id='description']");
    private final By vicoSkills = By.xpath("//input[@role='combobox']");
    private final By skillOption = By.xpath("//div[@role='listbox']//mat-option[2]");
    private final By newSkillOption = By.xpath("//*[@role='option']//*[@class='mat-option-text']");
    private final By btnCreateVico = By.xpath("//*[contains(@class, 'd-flex')]//*[contains(@class, 'mat-button-base mat-primary')]");
    private final By vicoNameToggle = By.xpath("//div[contains(@class, 'vico-toggle')]");
    private final By vicoNameOnDashboard = By.xpath("//*[(@class='vico-name')]");
    private final By vicoList = By.xpath("//*[contains(@class, 'vico-entry ')]//div[2]");

    public void loginButton () {
        find(btnLogin).shouldBeVisible().isPresent();
        find(btnLogin).click();
    }

    public void maximizeScreen(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public void typeEmail(String email) {
        find(emailField).shouldBeVisible().isPresent();
        find(emailField).sendKeys(email);
    }

    public void typePassword (String password) {
        find(passField).shouldBeVisible().isPresent();
        find(passField).click();
        find(passField).sendKeys(password);
    }

    public void submitButton () {
        find(submitBtn).shouldBeVisible().isClickable();
        find(submitBtn).click();
    }

    public void clickOnNewButton () {
        find(btnNew).isPresent();
        withTimeoutOf(Duration.ofSeconds(150))
                .find(btnNew).click();
    }

    public void typeVicoNameField (String name) {
        find(vicoName).shouldBeVisible().isPresent();
        withTimeoutOf(Duration.ofSeconds(50))
                .find(vicoName)
                .sendKeys(name);
    }

    public void typeVicoDescriptionField (String description) {
        find(vicoDescription).shouldBeVisible().isPresent();
        find(vicoDescription).sendKeys(description);
    }

    public void typeVicoSkillsField (String skills) {
        find(vicoSkills).shouldBeVisible().isPresent();
        find(vicoSkills).sendKeys(skills);
    }

    public void selectVicoSkillOption () {
        find(skillOption).shouldBeVisible().isPresent();
        find(skillOption).click();
    }

    public void selectNewVicoSkillOption () {
        find(newSkillOption).shouldBeVisible().isPresent();
        find(newSkillOption).waitUntilPresent().click();
    }

    public void clickOnCreateVico () {
        find(btnCreateVico).shouldBeVisible().isPresent();
        find(btnCreateVico).click();
    }

    public void getVicoNameOnDashboard () {
        find(vicoNameOnDashboard).shouldBeVisible().isPresent();
    }

    public void checkVicoNameToggle (String vicoName) {
        if(find(vicoNameToggle).isPresent()) {
            find(vicoNameToggle).click();
        }
        assertEquals(find(vicoList).getText(), vicoName);
    }
}
