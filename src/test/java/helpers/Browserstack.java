package helpers;

import config.RemoteConfig;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {

    public static ExtractableResponse<Response> videoUrl(String sessionId) {
        RemoteConfig config = ConfigFactory.create(RemoteConfig.class, System.getProperties());
        String login = config.login();
        String password = config.key();
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(login, password)
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}