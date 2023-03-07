package getRequest;

import BaseURLs.GoRestCoBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojaDatas.GoRestCoApiPojo;
import utilities.JsonToJava;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get12 extends GoRestCoBaseURL {
      /*
        Given
            https://gorest.co.in/public/v2/users/702440
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

   {
"id": 724790,
"name": "Dr. Lalita Rana",
"email": "rana_dr_lalita@block.org",
"gender": "male",
"status": "active"
}

     */

    @Test
    public void get12(){

        //Step 1: Set URL
        //https://gorest.co.in/public/v2/users/702440
        specification.pathParams("usersPath","users",
                "idPath","724790");
        //Step 2: Set Expected Data

        String expectedData = "{{\n" +
                "\"id\": 724790,\n" +
                "\"name\": \"Dr. Lalita Rana\",\n" +
                "\"email\": \"rana_dr_lalita@block.org\",\n" +
                "\"gender\": \"male\",\n" +
                "\"status\": \"active\"\n" +
                "}}";

        //Object Mapper
       /*
       Object Mapper ı kullanaiblmek için
       maven projelerinde pom.xml
       dependcy eklemem gerekiyor.  --->> maven repo

        */

        System.out.println("Expected Data:\n " + expectedData);

        GoRestCoApiPojo goRestCoApiPojo = JsonToJava.convertJsonToJavaObject(expectedData, GoRestCoApiPojo.class);
        System.out.println("goRestCoApiPojo: " + goRestCoApiPojo);


        HashMap<String,Object> expectedDataMap = JsonToJava.convertJsonToJavaObject(expectedData, HashMap.class);
        System.out.println("expectedDataMap: " + expectedDataMap );
        //Step 3:
        Response response = given().spec(specification).when().get("/{usersPath}/{idPath}");
        System.out.println("RESPONSE: ");
        response.prettyPrint();

        //Step 4:

        Map<String , Object> actualDataMap = JsonToJava.convertJsonToJavaObject(response.toString(),HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);

        assertEquals(expectedDataMap.get("gender"),actualDataMap.get("gender"));
        assertEquals(expectedDataMap.get("name"),actualDataMap.get("name"));
        assertEquals(expectedDataMap.get("id"),actualDataMap.get("id"));
        assertEquals(expectedDataMap.get("email"),actualDataMap.get("email"));
        assertEquals(expectedDataMap.get("status"),actualDataMap.get("status"));
    }
}
