package com.api.rest.clients;

import com.constants.RestConstants;
import com.constants.RestEndPoints;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class RestClients {

    RequestSpecification requestSpecification;

    public void setRequestSpecification() {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        requestSpecification = specBuilder.setAccept("application/json")
                .setContentType("application/json")
                .setBaseUri(RestConstants.BASE_URL)
                .build();
    }

    public String getAuthToken(String username, String password) {

        setRequestSpecification();
        JSONObject request = new JSONObject();
        request.put("username", username);
        request.put("password", password);

        Response response =
                given()
                        .spec(requestSpecification)
                        .body(request.toString()).log().all()
                        .when()
                        .post(RestEndPoints.CREATE_AUTH_TOKEN)
                        .then()
                        .log().ifError().extract().response();

        JSONObject res = new JSONObject(response.getBody().asString());
        return res.get("token").toString();
    }

    public Response getAllBookings() {
        setRequestSpecification();
        return given()
                .spec(requestSpecification)
                .log().all()
                .when()
                .get(RestEndPoints.GET_ALL_BOOKINGS)
                .then()
                .log().ifError().extract().response();

    }
}
