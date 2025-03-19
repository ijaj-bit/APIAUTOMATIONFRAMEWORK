package org.Ijaj.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.Ijaj.asserts.AssertActions;
import org.Ijaj.endpoints.APIConstants;
import org.Ijaj.modules.PayloadManager;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;

    @BeforeClass // Ensures setup runs before any test method in this class
    public void setUP() {
        this.payloadManager = new PayloadManager(); // Fix: Assign to class-level variable
        this.assertActions = new AssertActions();

        requestSpecification = RestAssured.given()
                .baseUri(APIConstants.Base_Url)
                .contentType(ContentType.JSON)
                .log().all();
    }
    public String getToken() {
        requestSpecification = RestAssured
                .given()
                .baseUri(APIConstants.Base_Url)
                .basePath(APIConstants.Auth_Url);

        // Setting the payload
        String payload = payloadManager.setAuthPayload();

        // Get the Token
        response = requestSpecification.contentType(ContentType.JSON).body(payload).when().post();
        // String Extraction
        String token = payloadManager.getTokenFromJson(response.asString());

        return token;


    }


}