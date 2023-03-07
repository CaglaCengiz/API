package getRequest;

import BaseURLs.DummyBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get07 extends DummyBaseURL {
     /*
        Given
	   	    https://dummy.restapiexample.com/api/v1/employees
		When
			Kullanıcı GET Methodu ile Request Gönderir
		Then
			 Status Code un "200" olduğunu Assert et
		And
		     employee_age i 55'ten büyük olanları konsola yazdırınız.
		     8 tane olduğunu assert ediniz.
		And
            id si 17 den büyük olanları konsola yazdırınız
            7 tane olduğunu assert ediniz.
        And
            salary si 100.000'den az olanları konsola yazdırınız.
            Doris Wilder'ın bunlardan biri olduğunu assert ediniz.
        And

     */
    @Test
    public  void get07(){
        specification.pathParam("employeesPath","employees");
        Response response=given().
                spec(specification).
                when().
                get("/{employeesPath}");
        response.then().assertThat().statusCode(200);



        JsonPath jsonPath=response.jsonPath();

        List<Integer> employeeAges= jsonPath.getList("data.employee_age");
        System.out.println("employeeAges = " + employeeAges);

        int count=0;
        for (Integer w:employeeAges) {
            if(w>55){
                count++;

            }

        }
        System.out.println("count = " + count);
        assertEquals(8,count);

        List<Integer> idS= jsonPath.getList("data.findAll{(it.id)>17}.id");
        System.out.println("idS = " + idS);
        assertEquals(7,idS.size());

        //       salary si 100.000'den az olanları konsola yazdırınız.
        //       Doris Wilder'ın bunlardan biri olduğunu assert ediniz.
        List<Integer> salaryS=jsonPath.getList("data.findAll{it.employee_salary<100000}.employee_name");
        System.out.println(salaryS);
        assertTrue("Doris Wilder",salaryS.contains("Doris Wilder"));

        //2.way

        List<Integer> employee_salary = jsonPath.getList("data.employee_salary");

        for (Integer w:employee_salary){

            if(w<100000){

                System.out.println(employee_salary);
            }

        }

        assertTrue(salaryS.contains("Doris Wilder"));
    }
}
