package BaseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class TheMovieDBBaseURL {
    protected RequestSpecification specification;
    @Before
    public  void  setUpBaseURL(){
        specification = new RequestSpecBuilder().
                setBaseUri("https://api.themoviedb.org/3").
                build();
    }
}
