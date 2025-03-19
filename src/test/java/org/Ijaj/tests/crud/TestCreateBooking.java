package org.Ijaj.tests.crud;


import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.Ijaj.base.BaseTest;
import org.Ijaj.endpoints.APIConstants;
import org.Ijaj.pojos.BookingResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.requestSpecification;

public class TestCreateBooking extends BaseTest {

    // Create A Booking, Create a Token
    // Verify that Get booking -
    // Update the Booking
    // Delete the Booking

    @Test(groups = "reg", priority = 1)
    @Owner("Jim")
    @Description("TC#INT1 - Step 1. Verify that the Booking can be Created")
    public void testCreateBookingPOST() {

        requestSpecification.basePath(APIConstants.Creat_Update_Booking_Url);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString())
                .post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        BookingResponse bookingResponse = payloadManager.bookingResponse(response.asString());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(), "Jim");
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());

    }
}