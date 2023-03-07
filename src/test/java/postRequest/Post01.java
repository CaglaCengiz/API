package postRequest;

import BaseURLs.GoRestCoBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import testData.GoRestApiTestData;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.junit.Assert.assertEquals;

public class Post01 extends GoRestCoBaseURL {
    /*
    Given
        https://gorest.co.in/public/v2/users
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "422" olduğunu Assert et

   */
    //422: Anlamsal hata içeren istekleri sunucunun işleyemediği anlamına gelen durum kodudur.
    //d22162f73a409e33eedc4b33cd0fc1a41aa3833a376eb705e2c0967e4baa9281
    @Test
    public void post01(){

        //Set URL
        //https://gorest.co.in/public/v2/users
        specification.pathParam("usersPath","users");
        //Set Expected Data
        GoRestApiTestData goRestApiTestData = new GoRestApiTestData();
        System.out.println("Expected Test Data: " + goRestApiTestData.statusCodeForPostInvalid());
     //Send a Request
        Response response = given().
                spec(specification).
                when().
                header("Authorization","Bearer d22162f73a409e33eedc4b33cd0fc1a41aa3833a376eb705e2c0967e4baa9281").//dokumandan aldım
                post("/{usersPath}");

        System.out.println("Response: ");
        response.prettyPrint();

        //Assertion
        //  assertEquals(goRestApiTestData.statusCodeForPostInvalid(),response.getStatusCode());
        response.then().assertThat().statusCode(422);
    }
}
