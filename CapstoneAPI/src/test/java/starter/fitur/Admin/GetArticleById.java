package starter.fitur.Admin;

import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetArticleById {
    protected static String url = "https://13.210.163.192:8080";
    protected static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImFkbWluQGdtYWlsLmNvbSIsInVzZXJuYW1lIjoiYWRtaW4iLCJleHAiOjE2ODc5MjExMjN9.emN-gYe3TUSMSvFvLRXFur0tMwwQSeW82SA9sgCs6Ho";

    public String setGetArticleByIdValidEndpoint(){
        return url + "/admin/articles/7f57f4ab-127f-11ee-8cda-0242ac140003";
    }
    public String setGetArticleByIdInvalidEndpoint(){
        return url + "/admn/articles/5819b9a2-0cd8-11ee-8713-0242ac1d0003";
    }
    public String setGetArticleByIdInvalidId(){
        return url + "/admin/articles/508bc0b11-068c-11ee-a18f-0242c0a8d00";
    }

    public void sendGetArticleByIdValidEndpoint(){
        SerenityRest
                .given().relaxedHTTPSValidation()
                .auth()
                .oauth2(token)
                .get(setGetArticleByIdValidEndpoint());
    }
    public void receivedGetArticleByIdResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    public void sendGetArticleByIdInvalidEndpoint(){
        SerenityRest
                .given().relaxedHTTPSValidation()
                .auth()
                .oauth2(token)
                .get(setGetArticleByIdInvalidEndpoint());
    }
    public void receivedGetArticleByIdResponseCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    public void sendGetArticleByIdInvalidId(){
        SerenityRest
                .given().relaxedHTTPSValidation()
                .auth()
                .oauth2(token)
                .get(setGetArticleByIdInvalidId());
    }
    public void receivedGetArticleByIdResponseCode400(){
        restAssuredThat(response -> response.statusCode(400));
    }

    public void sendGetArticleByIdWithoutToken(){
        SerenityRest
                .given().relaxedHTTPSValidation()
                .get(setGetArticleByIdValidEndpoint());
    }
    public void receivedGetArticleByIdResponseCode401(){
        restAssuredThat(response -> response.statusCode(401));
    }
}
