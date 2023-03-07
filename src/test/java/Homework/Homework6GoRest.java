package Homework;

import BaseURLs.GoRestCoBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import pojaDatas.GoRestCoApiPojo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Homework6GoRest extends GoRestCoBaseURL {

    /*
        Given
            https://gorest.co.in/public/v2/users/697102
       When
            Kullanıcı GET Methodu ile Request Gönderir
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrular
      {
"id": 480339,
"name": "Bhupen Deshpande PhD",
"email": "bhupen_phd_deshpande@prosacco.biz",
"gender": "male",
"status": "active"
}
*/
    //1. step set url
    @Test
            public  void homework06(){
        //Step 1:
        specification.pathParams("Users","users","pathId","713683");

        //2. step set expected data

    GoRestCoApiPojo expectedData= new GoRestCoApiPojo(713683,"Chandni Sinha","chandni_sinha@ohara-sporer.name","male","active");

        System.out.println("expectedData = " + expectedData);

        //3.step send a request

    Response response =given().spec(specification).when().get("/{Users}/{pathId}");

        response.prettyPrint();

        //4.step Assertion
        //pojo classları -->expected daat ,request bady ,actual data
        /*
        GoRestCoApiPojo actualDataPojo = response.as(GoRestCoApiPojo.class);
        System.out.println("Actual Data: " + actualDataPojo);
        assertEquals(goRestCoApiPojo.getEmail(),actualDataPojo.getEmail());
        assertEquals(goRestCoApiPojo.getGender(),actualDataPojo.getGender());
        assertEquals(goRestCoApiPojo.getName(),actualDataPojo.getName());
        assertEquals(goRestCoApiPojo.getId(),actualDataPojo.getId());
        assertEquals(goRestCoApiPojo.getStatus(),actualDataPojo.getStatus());

         */

    Map<String,Object> actualData=response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
		 response.then().assertThat().statusCode(200);
        Assert.assertEquals(expectedData.getId(),actualData.get("id"));
        Assert.assertEquals(expectedData.getName(),actualData.get("name"));
        Assert.assertEquals(expectedData.getEmail(),actualData.get("email"));
        Assert.assertEquals(expectedData.getGender(),actualData.get("gender"));
        Assert.assertEquals(expectedData.getStatus(),actualData.get("status"));


}
}
