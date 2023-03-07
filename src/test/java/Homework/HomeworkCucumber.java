package Homework;

public class HomeworkCucumber {


    /*
    Cucumber ile Testdataları File dan

    !!---https://dev.bitpace.com/bitpace-merchant-rest-api#getDepositAddressUsingPOST--!!!

    Given
        https://api-sandbox.bitpace.com/api/v1/auth/token adresine POST metodu  ile request atılıp token alınmalı.

       Kullanılacak Request Body:
            {
    "merchant_code":"20625123425",
    "password":"a1a82a55-8355-46f1-9a95-3cd9adce495b"
}


    Token alındıktan sonra aşğaıdaki işlemlere geçebiliriz.
        https://api-sandbox.bitpace.com/api/v1/customer/deposit/address

        **Alınan Token Headers ta Bearer Auth. olarak gçnderilecektir.**

    When
       Kullanıcı POST metodu ile request atar

       Kullanılacak Request Body:
        {
    "cryptocurrency": "BTC",
    "customer": {
        "reference_id": "20625123425",
        "first_name":"",
        "last_name":"",
        "email":"fryteceducation@gmail.com"
    }
}
    Then
        Kullanıcı "Deposit Adress Creat" edildiğini verify eder.
        Expected message "Response Approved" içermeli

     */
}
