package com.interview.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class API_StepDefinition  {

    Response response;


    @When("sending a POST request using ContentType.URLENC and sending {int} in the body")
    public void sendingAPOSTRequestUsingContentType(int value) {

        baseURI = "https://qainterview.pythonanywhere.com";
        basePath = "/factorial";
        response = given()
                .contentType(ContentType.URLENC)
                .body("number="+value).log().all()
                .post();

    }


    @Then("Status code {int} should be given")
    public void statusCodeShouldBeGiven(int expectedStatusCode) {
        assertEquals(expectedStatusCode,response.getStatusCode());
    }

    @And("response body answer should be {int}")
    public void responseBodyAnswerShouldBe(int expectedResult) {

        int actualResult = response.path("answer");

        assertEquals(expectedResult,actualResult);
    }
}
