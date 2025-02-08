package com.rest.herokuapp;

import com.api.rest.clients.RestClients;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APICRUDTest {

    @Test
    public void testGetAPIToken(){
        RestClients client = new RestClients();
        String token = client.getAuthToken("admin","password123");
        Assert.assertNotNull(token,"token is null");
    }

    @Test
    public void testGetAllBookings(){
        RestClients client = new RestClients();
        Response respone = client.getAllBookings();

        JSONArray array = new JSONArray(respone.asString());
        Assert.assertTrue(array.isEmpty());
        System.out.println("Total Bookings : "+array.length());
        for(Object booking : array){
            JSONObject obj = (JSONObject) booking;
            System.out.println("BookingId : "+obj.get("bookingid").toString());
        }
    }
}
