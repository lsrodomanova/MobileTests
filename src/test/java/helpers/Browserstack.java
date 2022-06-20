package helpers;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {

    public static ExtractableResponse<Response> videoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("autotestscloud_qAejV5", "DkvhzD6ZSLTsxYERedAR")
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                //.statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}