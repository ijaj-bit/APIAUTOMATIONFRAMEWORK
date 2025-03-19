package org.Ijaj.tests.crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.Ijaj.base.BaseTest;
import org.Ijaj.endpoints.APIConstants;
import org.Ijaj.pojos.BookingResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.requestSpecification;

public class TestCreateToken extends BaseTest {

    @Test(groups = "reg", priority = 1)
    @Owner("Jim")
    @Description("TC#INT2 - Step 1. Create Token And Verify")
    public void testToken() {

        requestSpecification.basePath(APIConstants.Auth_Url);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.setAuthPayload())
                .post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        String token = payloadManager.getTokenFromJson(response.asString());
        assertActions.verifyStringKeyNotNull(token);
    }
}
