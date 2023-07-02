package com.dchcompany.dchtesttask.controller;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.springframework.http.HttpStatus;

public class Specifications {
    public static RequestSpecification requestSpec(String url){
        return  new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpecGX200(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

    }

    public static ResponseSpecification responseSpecGX201(){
        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
    }
    public static ResponseSpecification responseSpecGX204(){
        return new ResponseSpecBuilder()
                .expectStatusCode(204)
                .build();
    }
    public static void installSpecification(RequestSpecification request, ResponseSpecification response){
        RestAssured.requestSpecification=request;
        RestAssured.responseSpecification=response;
    }
}
