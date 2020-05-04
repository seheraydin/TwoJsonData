package com.example.myapplication.RestApi;

public class BaseManager {
    //5: bu class url leri yönetecek yani url in son kısmının bulunduğu
    //RestApi interface döndürecek
    //protected: bir alt sınıf bu sınıftaki metoda erişsin
    protected RestApi getRestApi()
    {
        //aşağıdaki kod url imizin ana kısmını nesnemize alır.
        RestApiClient restApiClient=new RestApiClient(BaseUrl.url);

        //aşağıdaki kod getRestApi() metodu bize Bilgi interface classınıı döndürüyor
        return restApiClient.getRestApi();
    }
}
