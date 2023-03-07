package Homework;

import BaseURLs.SwapiApiBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojaDatas.SwapiPojo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Homework7Swap extends SwapiApiBaseURL {
      /*
        Given
            https://swapi.dev/api/starships/3
       When
            Kullanıcı GET Methodu ile Request Gönderir
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrular
         {
    "name": "Star Destroyer",
    "model": "Imperial I-class Star Destroyer",
    "manufacturer": "Kuat Drive Yards",
    "cost_in_credits": "150000000",
    "length": "1,600",
    "max_atmosphering_speed": "975",
    "crew": "47,060",
    "passengers": "n/a",
    "cargo_capacity": "36000000",
    "consumables": "2 years",
    "hyperdrive_rating": "2.0",
    "MGLT": "60",
    "starship_class": "Star Destroyer",
    "pilots": [],
    "films": [
        "https://swapi.dev/api/films/1/",
        "https://swapi.dev/api/films/2/",
        "https://swapi.dev/api/films/3/"
    ],
    "created": "2014-12-10T15:08:19.848000Z",
    "edited": "2014-12-20T21:23:49.870000Z",
    "url": "https://swapi.dev/api/starships/3/"
}
     */

@Test
    public void homework7Swap(){
    // Step 1: SEt URL
    specification.pathParams("endPointPath","starships","idPath","3");


    //Step 2: Set Expected Data

    List<String> pilots = new ArrayList<>();
    List<String> films = new ArrayList<>(List.of("https://swapi.dev/api/films/1/",
            "https://swapi.dev/api/films/2/",
            "https://swapi.dev/api/films/3/"));
    System.out.println("pilots = " + pilots);
    System.out.println("films = " + films);

    SwapiPojo swapiPojosData = new SwapiPojo("Star Destroyer",
            "Imperial I-class Star Destroyer",
            "Kuat Drive Yards",
            "150000000",
            "1,600",
            "975",
            "47,060",
            "n/a",
            "36000000",
            "2 years",
            "2.0",
            "60",
            "Star Destroyer",
            pilots,
            films,
            "2014-12-10T15:08:19.848000Z",
            "2014-12-20T21:23:49.870000Z",
            "https://swapi.dev/api/starships/3/");


    //Step 3: Send a Request
    Response response = given().spec(specification).when().get("/{endPointPath}/{idPath}");

    response.prettyPrint();

    //Step 4: Assertion

    Map<String,Object> actualDataMap = response.as(Hashtable.class);
    response.then().assertThat().statusCode(200);
    assertEquals(swapiPojosData.getName(),actualDataMap.get("name"));
    assertEquals(swapiPojosData.getModel(),actualDataMap.get("model"));
    assertEquals(swapiPojosData.getManufacturer(),actualDataMap.get("manufacturer"));
    assertEquals(swapiPojosData.getCost_in_credits(),actualDataMap.get("cost_in_credits"));
    assertEquals(swapiPojosData.getLength(),actualDataMap.get("length"));
    assertEquals(swapiPojosData.getMax_atmosphering_speed(),actualDataMap.get("max_atmosphering_speed"));
    assertEquals(swapiPojosData.getCrew(),actualDataMap.get("crew"));
    assertEquals(swapiPojosData.getPassengers(),actualDataMap.get("passengers"));
    assertEquals(swapiPojosData.getCargo_capacity(),actualDataMap.get("cargo_capacity"));
    assertEquals(swapiPojosData.getConsumables(),actualDataMap.get("consumables"));
    assertEquals(swapiPojosData.getHyperdrive_rating(),actualDataMap.get("hyperdrive_rating"));
    assertEquals(swapiPojosData.getMGLT(),actualDataMap.get("MGLT"));
    assertEquals(swapiPojosData.getStarship_class(),actualDataMap.get("starship_class"));
    assertEquals(swapiPojosData.getPilots(),actualDataMap.get("pilots"));
    assertEquals(swapiPojosData.getFilms(),actualDataMap.get("films"));
    assertEquals(swapiPojosData.getCreated(),actualDataMap.get("created"));
    assertEquals(swapiPojosData.getEdited(),actualDataMap.get("edited"));
    assertEquals(swapiPojosData.getUrl(),actualDataMap.get("url"));

}



}

