package starter.steps;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import starter.data.UserData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VicolandCreateProjectSteps {
    Faker faker = new Faker();
    String projectTitle = faker.name().title();

    @Step
    public String postLogin() {
        RestAssured.baseURI = "https://demo-env-be.vicoland.com/index.php/api/v1";
        Response loginResponse = RestAssured.given().urlEncodingEnabled(true).log().all()
                .param("username", UserData.USERNAME.value())
                .param("password", UserData.PASSWORD.value())
                .post("/members/login");
        assertEquals(loginResponse.statusCode(), 200);
        String token = loginResponse.then().log().all().extract().path("data.token").toString();
        return token;
    }

    @Step
    public String postProjectTitle(String token) {
        Response projectTitleResponse = RestAssured.given().urlEncodingEnabled(true).log().all()
                .header("x-auth-token", token)
                .param("title", projectTitle)
                .post("/briefings/briefing");
        assertEquals(projectTitleResponse.statusCode(), 200);
        String projectId = projectTitleResponse.then().log().all().extract().path("data.project.id").toString();
        return projectId;
    }

    @Step
    public void patchProjectSkill(String token, String projectId) {
        Response projectSkillResponse = RestAssured.given().urlEncodingEnabled(true).log().all()
                .header("x-auth-token", token)
                .param("skills[0]", "Acceptance testing")
                .patch("/briefings/briefing/" + projectId);
        projectSkillResponse.then().log().all();
        assertEquals(projectSkillResponse.statusCode(), 200);
    }

    @Step
    public void patchProjectNDA(String token, String projectId) {
        Response ndaResponse = RestAssured.given().urlEncodingEnabled(true).log().all()
                .header("x-auth-token", token)
                .param("ndaType", "0")
                .patch("briefings/briefing/" + projectId);
        ndaResponse.then().log().all();
        assertEquals(ndaResponse.statusCode(), 200);
    }

    @Step
    public void postProjectDescriptionTime(String token, String projectId) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = df.format(now);
        Response projectDescriptionTimeResponse = RestAssured.given().urlEncodingEnabled(true).log().all()
                .header("x-auth-token", token)
                .param("dateType", "2")
                .param("dateVal", date)
                .param("title", "Project end date")
                .param("sourceId", projectId)
                .param("sourceType", "1")
                .param("project", projectId)
                .post("/timelines/timeline");

        projectDescriptionTimeResponse.then().log().all();
        assertEquals(projectDescriptionTimeResponse.statusCode(), 200);
    }

    @Step
    public void postProjectSubmit(String token, String projectId) {
        Response submitResponse = RestAssured.given().urlEncodingEnabled(true).log().all()
                .header("x-auth-token", token)
                .post("/briefings/" + projectId + "/help");

        submitResponse.then().log().all();
        assertEquals(submitResponse.statusCode(), 200);
    }

    @Step
    public void checkProjectExist(String token) {
        Response getProjectListResponse = RestAssured.given().urlEncodingEnabled(true).log().all()
                .header("x-auth-token", token)
                .get("/projects/nav_list");

        assertEquals(getProjectListResponse.statusCode(), 200);

        String allProjects = getProjectListResponse.then().log().all().extract().path("data.projects.project").toString();
        assertTrue(allProjects.contains(projectTitle));
    }
}
