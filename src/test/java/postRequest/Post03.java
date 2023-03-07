package postRequest;

import BaseURLs.DummyBaseURL;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojaDatas.DummyRestApiExPojo;
import pojaDatas.DummyRestApiPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03 extends DummyBaseURL {
     /*

    Given
        http://dummy.restapiexample.com/api/v1/create
    And
        Request Body olarak aşağıdaki pattern de body gönderiniz
      {
  "name": "Drake F.",
  "salary": "40000",
  "age": "27"
}
    When
        Kullanıcı POST Methodu ile Request Gönderir
    Then
        Status Code un "200" olduğunu Assert et
    And
           Response Body nin aşağıdaki şekilde olduğunu doğrulayınız
           {
    "status": "success",
    "data": {
        "name": "Drake F.",
        "salary": "40000",
        "age": "27",
        "id": 4545
    },
    "message": "Successfully! Record has been added."
}

   */
    @Test
    public void post03(){
        //Step1: Set URL
        //http://dummy.restapiexample.com/api/v1/create

        specification.pathParam("createPath","create");


        //Set Expected and Req. Body

        /*
            {
  "name": "Drake F.",
  "salary": "40000",
  "age": "27"
}
         */
        DummyRestApiPojo dummyRestApiPojo = new DummyRestApiPojo("Drake F.","40000","28");

        /*
         {
    "status": "success",
    "data": {
        "name": "Drake F.",
        "salary": "40000",
        "age": "27",

    },
    "message": "Successfully! Record has been added."
}
         */

        DummyRestApiExPojo dummyResTApiExPojo = new DummyRestApiExPojo("success",dummyRestApiPojo,"Successfully! Record has been added.");



        //Step 3: Send a request

        //Basic Auth.  ---> kullanılacak.
        // Dokumanda suth istemiyor fakat biz örnek olsun diye nasıl kukllanıalcğaını öğrenmek amaçlı olarak basic auth. ile işlem yapacağız.

        // ---> Beare token     Header da vermiştik.
        Response response = given().
                spec(specification).
                contentType(ContentType.JSON).
                auth().
                basic("admin","password123").
                body(dummyRestApiPojo).
                when().
                post("/{createPath}");


        System.out.println("Response:  ");
        response.prettyPrint();


        //Step 4: Assertion İşlemi:

        DummyRestApiExPojo actualData = response.as(DummyRestApiExPojo.class);//pojo
        System.out.println("Actual Data: " + actualData);

        assertEquals(dummyResTApiExPojo.getStatus(),actualData.getStatus());
        assertEquals(dummyResTApiExPojo.getMessage(),actualData.getMessage());
        assertEquals(dummyResTApiExPojo.getData().getAge(),actualData.getData().getAge());
        assertEquals(dummyResTApiExPojo.getData().getName(),actualData.getData().getName());
        assertEquals(dummyResTApiExPojo.getData().getSalary(),actualData.getData().getSalary());

    }
}
