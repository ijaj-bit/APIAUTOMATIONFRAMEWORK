package org.Ijaj.tests.crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.Ijaj.base.BaseTest;
import org.Ijaj.endpoints.APIConstants;
import org.Ijaj.pojos.BookingResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.requestSpecification;

public class TestHeakthCheck extends BaseTest {
    @Test(groups = "reg", priority = 1)
    @Owner("Jim")
    @Description("TC#INT3 - Verify Health Check....")
    public void testHealthCheckGET() {

        requestSpecification.basePath(APIConstants.Ping_Url);
        response = RestAssured.given(requestSpecification)
                .get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);

    }
}
