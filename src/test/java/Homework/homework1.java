package Homework;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class homework1 {
     /*
https://jsonplaceholder.typicode.com/todos/2/*Status code is 200
   And "completed" is false
   And "userId" is
   1 And "title" is "quis ut nam facilis et officia qui«
   And header "Via" is "1.1 Vegur«
   And header "Server" is "cloudflare«
   And title is contains "qui«
     */
     @Test
     public  void myHomework() {

         String URL = "https://jsonplaceholder.typicode.com/todos/2";

         Response response = given().accept("application/json").when().get(URL);

         response.then().assertThat().statusCode(200);

         response.then().assertThat().body("completed", equalTo(false));

         Assert.assertTrue(response.asString().contains("\"completed\": false"));

         response.then().assertThat().body("userId", equalTo(1));

         response.then().assertThat().body("title", equalTo("quis ut nam facilis et officia qui"));

         response.then().assertThat().headers("Via", equalTo("1.1 vegur"));

         response.then().assertThat().headers("Server", equalTo("cloudflare"));

         response.then().assertThat().body("title", containsString("qui"));

     }
}
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
 /*

    Given
	   	    https://dummy.restapiexample.com/api/v1/employee/1
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     Response body nin bu şekilde olduğunu doğrular
    {
    "status": "success",
    "data": {
        "id": 1,
        "employee_name": "Tiger Nixon",
        "employee_salary": 320800,
        "employee_age": 61,
        "profile_image": ""
    },
    "message": "Successfully! Record has been fetched."
}

*/
   // 3:
  /*

    Given
	   	     https://swapi.dev/api/vehicles/4
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     Response body nin bu şekilde olduğunu doğrular
   {
    "name": "Sand Crawler",
    "model": "Digger Crawler",
    "manufacturer": "Corellia Mining Corporation",
    "cost_in_credits": "150000",
    "length": "36.8 ",
    "max_atmosphering_speed": "30",
    "crew": "46",
    "passengers": "30",
    "cargo_capacity": "50000",
    "consumables": "2 months",
    "vehicle_class": "wheeled",
    "pilots": [],
    "films": [
        "https://swapi.dev/api/films/1/",
        "https://swapi.dev/api/films/5/"
    ],
    "created": "2014-12-10T15:36:25.724000Z",
    "edited": "2014-12-20T21:30:21.661000Z",
    "url": "https://swapi.dev/api/vehicles/4/"
}


     */