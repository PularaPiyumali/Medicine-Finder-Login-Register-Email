package com.medifinder.LoginRegisterEmail;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;

public class TestingDemo {

    @Test
    public void testGetUserAll (){
        baseURI = "http://localhost:8080/api/v1";
        get("/users/all").then().statusCode(200).log().all();
    }

    @Test
    public void testUserRegistration (){
        JSONObject request = new JSONObject ();
        request.put("email","luke@gmail.com");
        request.put("firstName","James");
        request.put("lastName","Luke");
        request.put("mobileNo","0760983344");
        request.put("password","9099");
        System.out.println(request.toJSONString());

        baseURI = "http://localhost:8080/api/v1";
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().post("/registration").
                then().statusCode(200).log().all();
    }

    @Test
    public void testUpdateUser (){
        JSONObject request = new JSONObject ();
        request.put("first_name","David");
        request.put("last_name","Philip");
        request.put("mobile_no","0760983344");
        request.put("email","philip@gmail.com");
        System.out.println(request.toJSONString());

        baseURI = "http://localhost:8080/api/v1";
        given().contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().put("/users/52").
                then().statusCode(200).log().all();
    }

    @Test
    public void testDeleteMedicine (){
        baseURI = "http://localhost:8080/api/v1";
        when().delete("/medicines/1002").
                then().statusCode(200).log().all();

    }
}
