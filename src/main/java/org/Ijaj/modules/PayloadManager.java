package org.Ijaj.modules;

import com.google.gson.Gson;
import org.Ijaj.pojos.*;

public class PayloadManager {


    //Convert Java Obj to Gson
    //Gson Ser-Dser

    Gson gson;

    public String createPayloadBookingAsString() {

        Booking booking = new Booking();
        booking.setFirstname("Jim");
        booking.setLastname("Brown");
        booking.setDepositpaid(true);
        booking.setTotalprice(5501);

        Bookingdates bookingdates = new Bookingdates();

        bookingdates.setCheckin("5000-01-01");
        bookingdates.setCheckout("5001-01-01");
        booking.setAdditionalneeds("Breakfast");
        booking.setBookingdates(bookingdates);

        System.out.println(booking);
        //java object -> String
        Gson gson = new Gson();
        String jasonStringBooking = gson.toJson(booking);
        System.out.println(jasonStringBooking);


        return jasonStringBooking;
    }


    public BookingResponse bookingResponse(String responseString)
    {
        gson = new Gson();
        BookingResponse bookingResponse= gson.fromJson(responseString,BookingResponse.class);

        return bookingResponse;
    }

    public String setAuthPayload()
    {
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        Gson gson = new Gson();
        String jsonPayloadString= gson.toJson(auth);
        System.out.println("Payload Set ti the-->"+jsonPayloadString);
        return jsonPayloadString;
    }

    //Json to Java

    public String getTokenFromJson(String tokenResponse)
    {
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse,TokenResponse.class);
        return tokenResponse1.getToken().toString();
    }

    public Booking getResponseFromJason(String getResponse)
    {
        Booking booking=gson.fromJson(getResponse,Booking.class);
        return booking;
    }
    public String fullUpdatePayloadAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Ijaj");
        booking.setLastname("Shaikh");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        return gson.toJson(booking);


    }
}
