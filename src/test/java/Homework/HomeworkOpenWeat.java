package Homework;

public class HomeworkOpenWeat {
    //https://openweathermap.org/api
    /*
    Given
            1) "http://api.openweathermap.org/data/3.0/triggers?appid=c73a117fa646e4723bf40f2abfba56f1"
    And
           2) {
   "time_period":{
      "start":{
         "expression":"after",
         "amount":132000000
      },
      "end":{
         "expression":"after",
         "amount":432000000
      }
   },
   "conditions":[
      {
         "name":"temp",
         "expression":"$gt",
         "amount":299
      }
   ],
   "area":[
      {
         "type":"Point",
         "coordinates":[
            53,
            37
         ]
      }
   ]
}
    When
        Kullanıcı POST metodu ile request atar
    Then
        Kullanıcı status code un 201 olduğunu verify eder
    And
        Response Body nin aşağıdaki gibi olduğunu verify eder
      {
    "__v": 0,
    "_id": "630b8e79486da9000b22afcf",
    "alerts": {},
    "area": [
        {
            "type": "Point",
            "_id": "630b8e79486da9000b22afd0",
            "coordinates": [
                53,
                37
            ]
        }
    ],
    "conditions": [
        {
            "name": "temp",
            "expression": "$gt",
            "amount": 299,
            "_id": "630b8e79486da9000b22afd1"
        }
    ],
    "time_period": {
        "end": {
            "expression": "after",
            "amount": 432000000
        },
        "start": {
            "expression": "after",
            "amount": 132000000
        }
    }
}
     */
}
