package getRequest;

import BaseURLs.JsonPlaceHolderBaseURL;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import testData.JsonPlaceHolderTestData;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get14 extends JsonPlaceHolderBaseURL {
      /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

  {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  } */

    @Test
    public void get14() {

        //Step 1: Set URL
        //https://jsonplaceholder.typicode.com/todos/198
        specification.pathParams("todosPath", "todos",
                "idPath", "198");
        //Step 2: Set Expected Data

        String expectedData = "{\n" +
                "    \"userId\": 10,\n" +
                "    \"id\": 198,\n" +
                "    \"title\": \"quis eius est sint explicabo\",\n" +
                "    \"completed\": true\n" +
                "}";


        System.out.println("ExpectedDataString: " + expectedData);

        HashMap<String, Object> expectedDataMap = JsonToJava.convertJsonToJavaObject(expectedData, HashMap.class);
        System.out.println("EXPECTED DATA MAP: " + expectedDataMap);

        //HOMEWORK:   expected data yı JSONPLACEHOLDERTESTDATA classın da bir tane metot create ediniz.
        JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();
        // HashMap<String,Object> reqBodyAndExpectedDataMap=JsonPlaceHolderTestData.expectedData;
        //  System.out.println("reqBodyAndExpectedDataMap = " + reqBodyAndExpectedDataMap);


        //Step 3: Send a request
        Response response = given().
                spec(specification).
                when().
                get("/{todosPath}/{idPath}");

        System.out.println("RESPONSE: ");
        response.prettyPrint();

        // Step 4: Assertion

        //Response

        //HashMap<String,Object> actualDataMap =  response.as(HashMap.class);   // ---> NOme Problemooo
        //  JsonPath jsonPath = response.jsonPath(); /// ----> NOme Problemooo

        //  response.then().assertThat().body(""); /// ---> Nome Problemo
        HashMap<String, Object> actualDataMapJSONToJAVA = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);

        System.out.println("actualDataMapJSONToJAVA: " + actualDataMapJSONToJAVA);

        /*
        ASSERTION HOMEWORK
         */
        //   Assert.assertEquals(reqBodyAndExpectedDataMap.get("UserId"),actualDataMapJSONToJAVA.get("UserId"));
        //   Assert.assertEquals(reqBodyAndExpectedDataMap.get("id"),actualDataMapJSONToJAVA.get("id"));
        //   Assert.assertEquals(reqBodyAndExpectedDataMap.get("completed"),actualDataMapJSONToJAVA.get("completed"));
        //   Assert.assertEquals(reqBodyAndExpectedDataMap.get("title"),actualDataMapJSONToJAVA.get("title"));
//
        for (String key : actualDataMapJSONToJAVA.keySet()) {

            assertEquals(jsonPlaceHolderTestData.setUpDataTodos().get(key), actualDataMapJSONToJAVA.get(key));
        }
    }
}