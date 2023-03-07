package Homework;

import BaseURLs.BookerBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Homework2 extends BookerBaseURL {
     /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
             Kullanıcı GET Methodu ile Request Gönderir
         And
            Kullanıcı firstname olarak Sarah i aratır
        Then
            Status Code un "200" olduğunu Assert et
		And
            Response body de "bookingid" olduğunu verify eder.

*/

    @Test
    public void test01(){
        specification.pathParam("bookıngPath","booking");
        Response response=given().when().spec(specification).get("/{bookıngPath}");

        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        String responsebody=response.asString();
        System.out.println("responsebody = " + responsebody);
        assertTrue(responsebody.contains("bookingid"));
        response.then().assertThat().statusCode(200);
        assertFalse(responsebody.contains("Sarah"));

/* @Test
    public void getHomework02(){
 specification.pathParam("bookingPath","booking");
​
 specification.queryParam("firstname","Jim");
​
 Response response = given().spec(specification).when().get("/{bookingPath}");
​
 response.prettyPrint();
​
 response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
​
 JsonPath jsonPath = response.jsonPath();
​
 try {
     jsonPath.getInt("[0].bookingid");
     Assert.assertTrue(true);
​
 }catch (NullPointerException e){
​
     Assert.fail("Bookingid bulunamadı");
​
*/

    }
}


