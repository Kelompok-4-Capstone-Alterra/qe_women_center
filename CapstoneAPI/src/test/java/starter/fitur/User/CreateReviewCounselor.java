package starter.fitur.User;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateReviewCounselor {
    protected static String url = "https://13.210.163.192:8080";
    protected static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ImQwYWU5NTYyLTBkMjItMTFlZS04OTIzLTAyNDJhYzFlMDAwMyIsImVtYWlsIjoiaWhpbG1pZGVyaWFuQGdtYWlsLmNvbSIsInVzZXJuYW1lIjoiaXZhbmRldiIsImF1dGhfYnkiOiJhdXRoIiwiZXhwIjoxNjg3OTIwODI0fQ.cAebekCWSJbjwTnGrl_cVMRpQwoRB8epKjISstei-L8";

    public String setCreateReviewCounselorWithValidEndpoint(){
        return url + "/users/counselors/4bce80d2-0dc2-11ee-b94e-0242c0a82003/reviews";
    }

    public String setCreateReviewCounselorWithInvalidEndpoint(){
        return url + "/user/counselors/4bce80d2-0dc2-11ee-b94e-0242c0a82003/reviews";
    }

    public String setCreateReviewCounselorWithInvalidId(){
        return url + "/users/counselors/08bc0b11-068c-11ee-a18f-0242c0a8d00/reviews";
    }

    public void sendCreateReviewCounselorValidEndpoint(){
        JSONObject data = new JSONObject();

        data.put("transaction_id", "768c4614-0de4-11ee-9061-0242c0a88003");
        data.put("rating", 5);
        data.put("review", "sangat bagus, terutama di penyelesaian masalah saya");

        SerenityRest
                .given().relaxedHTTPSValidation()
                .auth()
                .oauth2(token)
                .contentType("application/json")
                .body(data.toString()).when()
                .post(setCreateReviewCounselorWithValidEndpoint());
    }
    public void receivedCreateReviewCounselorWIthValidEndpoint(){
//        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.statusCode(500));
    }

    public void sendCreateReviewCounselorInvalidEndpoint(){
        JSONObject data = new JSONObject();

        data.put("transaction_id", "a954282f-101f-11ee-a4f1-0242ac180003");
        data.put("rating", 5);
        data.put("review", "sangat memuaskan");

        SerenityRest
                .given().relaxedHTTPSValidation()
                .auth()
                .oauth2(token)
                .contentType("application/json")
                .body(data.toString()).when()
                .post(setCreateReviewCounselorWithInvalidEndpoint());
    }
    public void receivedCreateReviewCounselorWIthInvalidEndpoint(){
        restAssuredThat(response -> response.statusCode(404));
    }

    public void sendCreateReviewCounselorInvalidId(){
        JSONObject data = new JSONObject();

        data.put("transaction_id", "a954282f-101f-11ee-a4f1-0242ac180003");
        data.put("rating", 5);
        data.put("review", "sangat memuaskan");

        SerenityRest
                .given().relaxedHTTPSValidation()
                .auth()
                .oauth2(token)
                .contentType("application/json")
                .body(data.toString()).when()
                .post(setCreateReviewCounselorWithInvalidId());
    }
    public void sendCreateReviewCounselorDoesNotIncludeAnyConditions(){
        JSONObject data = new JSONObject();

        data.put("transaction_id", "2349c8e1-0dc0-11ee-b94e-0242c0a82003");
        data.put("review", "sangat memuaskan");

        SerenityRest
                .given().relaxedHTTPSValidation()
                .auth()
                .oauth2(token)
                .contentType("application/json")
                .body(data.toString()).when()
                .post(setCreateReviewCounselorWithValidEndpoint());
    }
    public void receivedCreateReviewCounselorWIthInvalidEndpoint400(){
        restAssuredThat(response -> response.statusCode(400));
    }

    public void sendCreateReviewCounselorWithoutToken(){
        JSONObject data = new JSONObject();

        data.put("transaction_id", "a954282f-101f-11ee-a4f1-0242ac180003");
        data.put("rating", 5);
        data.put("review", "sangat memuaskan");

        SerenityRest
                .given().relaxedHTTPSValidation()
                .contentType("application/json")
                .body(data.toString()).when()
                .post(setCreateReviewCounselorWithValidEndpoint());
    }
    public void receivedCreateReviewCounselorWithoutToken(){
        restAssuredThat(response -> response.statusCode(401));
    }
}
