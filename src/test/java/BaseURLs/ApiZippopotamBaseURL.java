package BaseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class ApiZippopotamBaseURL {

        protected RequestSpecification specification;
        @Before
        public  void  setUpBaseURL(){
            specification = new RequestSpecBuilder().
                    setBaseUri("http://api.zippopotam.us").
                    build();
        }

    }
