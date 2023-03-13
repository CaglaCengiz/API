package testData;

import java.util.HashMap;

public class JsonPlaceHolderTestData {
    public static HashMap<String, Object> expectedData;


    public HashMap setUpDataTodos() {

        /*
         {
    "userId": 1,
    "id": 2,
    "title": "quis ut nam facilis et officia qui",
    "completed": false
}
         */
        expectedData = new HashMap<>();

        expectedData.put("StatusCode", 200);
        expectedData.put("Server", "cloudflare");
        expectedData.put("userId", 1);
        expectedData.put("id", 2);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("completed", false);

        return expectedData;

    }

    public class JsonPlaceHolderTestDat {
        public HashMap<String, Object> setUpExpectedData() {    //GET14 İCİN HAZIRLANDI
            /*
            {                           "userId": 10,
                                        "id": 198,
                                        "title": "quis eius est sint explicabo",
                                        "completed": true
                                      }
             */
            HashMap<String, Object> setUpExpectedDataMap = new HashMap<>();
            setUpExpectedDataMap.put(" userId", 10);
            setUpExpectedDataMap.put("id", 198);
            setUpExpectedDataMap.put("title", "quis eius est sint explicabo");
            setUpExpectedDataMap.put("completed", true);
            return setUpExpectedDataMap;
        }}
        public HashMap<String,Object> setUpForPutReq(){ //put01 için

        /*
         {
                 "userId": 01,
                 "title": "CW FSQA API Tutorial",
                 "completed": true
               }
         */
            expectedData = new HashMap<>();

            expectedData.put("userId",01);
            expectedData.put("title","CW FSQA API Tutorial");
            expectedData.put("completed",true);

            return expectedData;


        }
    }
