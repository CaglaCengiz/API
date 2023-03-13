package putRequest;

import BaseURLs.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.JsonPlaceHolderTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class team2 extends JsonPlaceHolderBaseURL {
     /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "userId": 01,
                 "title": "CW FSQA API Tutorial",
                 "completed": true
               }
        When
	 		Kullanıcı Put Reques ile request gönderir
	    Then
	   	   Status code is 200
	   	  Response body nin aşağıdaki gibi olduğunu verify eder.
	   	    {
                 "userId": 01,
                 "title": "CW FSQA API Tutorial",
                 "completed": true
               }
     */
    @Test
    public void put03(){
        //Step1
        specification.pathParams("todosPath","todos","idPath","198");

        //Step2

        JsonPlaceHolderTestData jsonPlaceHolderTestData=new JsonPlaceHolderTestData();
        Map<String,Object> expectedRequest  = jsonPlaceHolderTestData.setUpForPutReq();

        System.out.println("expectedRequest = " + expectedRequest);

        //Step3

        Response response=given().spec(specification).
                contentType(ContentType.JSON).
                body(expectedRequest).
                when().put("/{todosPath}/{idPath}");
        response.prettyPrint();

//Step4
        Map<String,Object>actualData=response.as(Map.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedRequest.get("title"),actualData.get("title"));
        assertEquals(expectedRequest.get("userId"),actualData.get("userId"));
        assertEquals(expectedRequest.get("completed"),actualData.get("completed"));
    }

}
