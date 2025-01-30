package org.example.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class APITest {

//    This method POSTs and Gets created data name.
    @Test
    public void getPost(){

        RestAssured.baseURI = "https://api.restful-api.dev/objects";

        String requestBody = "{\n" +
                " \"name\" : \"Apple\"," +
                " \"data\" : " +
                "{ \n \"year\" : 2019,\n" +
                " \"price\" : 536, \n " +
                " \"CPU model\" : \"Intel i9\",\n" +
                " \"Hard disk size\" : \"1 TB\" " +
                "}\n" +
                "}";

        String responsePost =

                given()
                        .contentType("application/json")
                        .body(requestBody)
                        .when()
                        .post("")
                        .then()
                        .statusCode(200)
                        .extract().response().path("id");


        String responseGetBody =
                given()
                        .pathParam("id",responsePost)
                        .when()
                        .get("/{id}")
                        .then().extract().path("name");

        System.out.println(responseGetBody);

    }
}
