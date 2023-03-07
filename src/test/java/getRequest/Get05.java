package getRequest;

import BaseURLs.TheMovieDBBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Get05 extends TheMovieDBBaseURL {
    /*
        Given
            https://api.themoviedb.org/3/movie/popular

            apı_key = 4c841d9ec32b7f8c0069cf3fec36774f
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
		And
		    id lerin içerisnde
		    646389
            536554
            640146 olduğunu assert ediniz.

     */
    @Test
    public  void  get05(){
           /*
        1) Set URL
        2) Expecta Data   ---> Map, List, Arr
        3) Send REquest
        4) Assertion
         */
        //Step 1: Set URL:

        /*
         https://api.themoviedb.org/3/movie/popular

            api_key = 4c841d9ec32b7f8c0069cf3fec36774f    ---> query params
         */
        specification.pathParams("moviePath","movie",
                "popularPath","popular")
                .queryParam("apı_key", "4c841d9ec32b7f8c0069cf3fec36774f");

        //Step 2: Set Expected Data(ignored)

        //Step 3:Send a Request

        Response response =given().spec(specification).
                when().
                get("/{moviePath}/{popularPath}");// get methodun içine calısacagım endpoitleri sytanx ine
        //uygun bır sekide yazmalıyım

        response.prettyPrint();

        //Step 4: Assertion

      /*  Then
        Status Code un "200" olduğunu Assert et
                And
        Content Type ın "application/json" olduğunu assert et
        And
        id lerin içerisnde
        646389
        536554
        640146 olduğunu assert ediniz.

                */
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("results.id", Matchers.hasItems(646389 ,536554 ,640146));
    }
}
