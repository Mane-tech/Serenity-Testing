package starter.tests;
import org.junit.Test;
import starter.steps.VicolandCreateProjectSteps;

public class VicolandCreateProjectTest {
    VicolandCreateProjectSteps vicolandCreateProjectSteps = new VicolandCreateProjectSteps();

    @Test
    public void CreateProjectTest() {
        // Login as Client and get token
        String token = vicolandCreateProjectSteps.postLogin();

        // Set project title and get projectId
        String projectId = vicolandCreateProjectSteps.postProjectTitle(token);

        // Select any skills of the dropdown
        vicolandCreateProjectSteps.patchProjectSkill(token, projectId);

        // Select: "No"
        vicolandCreateProjectSteps.patchProjectNDA(token, projectId);

        // Pick any date of the field under “Project end date"
        vicolandCreateProjectSteps.postProjectDescriptionTime(token, projectId);

        // Submit new project
        vicolandCreateProjectSteps.postProjectSubmit(token, projectId);

        // Project is created and it is exist on main menu
        vicolandCreateProjectSteps.checkProjectExist(token);
    }
}
