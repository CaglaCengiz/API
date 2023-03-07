package getRequest;

import BaseURLs.ApiZippopotamBaseURL;
import org.junit.Test;
import pojaDatas.ZippoPotamPlaces;

import io.restassured.response.Response;
import pojaDatas.ZippoPotamPojos;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get11 extends ApiZippopotamBaseURL {
    /*


        Given
            http://api.zippopotam.us/TR/34010
       When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
 		And
 		    Response body nin bu şekilde olduğunu doğrular

            {
    "post code": "34010",
    "country": "Turkey",
    "country abbreviation": "TR",
    "places": [
        {
            "place name": "Maltepe Mah.",
            "longitude": "32.3609",
            "state": "İstanbul",
            "state abbreviation": "34",
            "latitude": "40.1589"
        }
    ]
}

     */
    @Test
    public void  get11(){
        specification.pathParams("countryPath","TR","postCodePath","34010");

       /* {
            "post code": "34010",
                "country": "Turkey",
                "country abbreviation": "TR",
                "places": [
            {
                "place name": "Maltepe Mah.",
                    "longitude": "32.3609",
                    "state": "İstanbul",
                    "state abbreviation": "34",
                    "latitude": "40.1589"
            }*/

        ZippoPotamPlaces zippoPotamPlaces = new ZippoPotamPlaces("Maltepe Mah.","32.3609","İstanbul","34","40.1589");
        ZippoPotamPojos zippoPotamPojos = new ZippoPotamPojos("34010","Turkey","TR",zippoPotamPlaces);

        System.out.println("Expected Data: " + zippoPotamPojos);
        //Step 3: Send a Request

        Response response = given().
                spec(specification).
                when().
                get("/{countryPath}/{postCodePath}");
/*
        System.out.println("RESPONSE: ");
        response.prettyPrint();

 */
  //Step 4: Assertion with GSON
        Map<String,Object> actualDataMap = response.as(HashMap.class);
        System.out.println("Actual Data: " + actualDataMap);

        // get("Key")

        assertEquals(zippoPotamPojos.getCountry(),actualDataMap.get("country"));
        assertEquals(zippoPotamPojos.getPostCode(),actualDataMap.get("post code"));
        assertEquals(zippoPotamPojos.getCountryAbbreviation(),actualDataMap.get("country abbreviation"));
        assertEquals(zippoPotamPojos.getZippoPotamPlaces().getPlaceName(),(((Map)((List)actualDataMap.get("places")).get(0))).get("place name"));

        assertEquals(zippoPotamPojos.getZippoPotamPlaces().getLatitude(),(((Map)((List)actualDataMap.get("places")).get(0)).get("latitude")));
        assertEquals(zippoPotamPojos.getZippoPotamPlaces().getLongitude(),(((Map)((List)actualDataMap.get("places")).get(0)).get("longitude")));

        /*
       burada sırayla gittik yani assert için bize expected ve actual datalar lazım önce expected-->
       sippopotampojostan zoppopotamplacese oradan get ile placesname aldık sonra acutal data--> getirmemiz gerekti
       onu da actual datadan sırayla responsu okuyorak gittik -
       önce places!  actual datadan places e gittik orada ilk bizi list karşıloyr
       (hep responsu okuyoruz) o yüzden cast to list yaptık sonra listin içinde bizi map karşılıyor bize çıktı
       map olması gerektiği için bu kez hepsini cast to map yaptık

         */
    }


    }

