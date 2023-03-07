package postRequest;

import BaseURLs.GoRestCoBaseURL;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.GoRestApiTestData;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post02 extends GoRestCoBaseURL {
    /*

    Given
        https://gorest.co.in/public/v2/users
    And

           Request Body olarak aşağıdaki pattern de body gönderiniz
           {
  "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
}
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "201" olduğunu Assert et
    And
           Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
             {
  "name": "Tenali Ramakrishna",
  "gender": "male",
  "email": "tenali.ramakrishna@15ce.com",
  "status": "active"
}

   */

    @Test
    public void post02(){

        //Set Base URL
        //https://gorest.co.in/public/v2/users
        specification.pathParam("usersPath","users");

        //Step 2: Set Expected and Request Body
        GoRestApiTestData goRestApiTestData = new GoRestApiTestData();
        HashMap<String,String> reqBodyAndExpectedDataMap = goRestApiTestData.reqBodyAndExpectedData("Drake F Clarusway SDET","male",
                "drakeff@clarusway.commmm","active");

        System.out.println("reqBodyAndExpectedDataMap: " + reqBodyAndExpectedDataMap);
        //Step 3: Send a request
        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                body(reqBodyAndExpectedDataMap).
                when().
                header("Authorization","Bearer d22162f73a409e33eedc4b33cd0fc1a41aa3833a376eb705e2c0967e4baa9281").
                post("/{usersPath}");


        System.out.println("Response Body: " );
        response.prettyPrint();
        //Step 4: Assertion

        //Pojo kullanrak assert ediniz.
        HashMap<String, String> actualData =response.as(HashMap.class);  // De-Ser.
        System.out.println("Actual Data: " + actualData);

        assertEquals(reqBodyAndExpectedDataMap.get("StatusCode"),response.statusCode());
        assertEquals(reqBodyAndExpectedDataMap.get("name"),actualData.get("Drake F Clarusway SDET"));
        assertEquals(reqBodyAndExpectedDataMap.get("gender"),actualData.get("male"));
        assertEquals(reqBodyAndExpectedDataMap.get("email"),actualData.get("drakeff@clarusway.commmm"));
        assertEquals(reqBodyAndExpectedDataMap.get("status"),actualData.get("active"));
    }
}
