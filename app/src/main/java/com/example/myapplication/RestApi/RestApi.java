package com.example.myapplication.RestApi;

import com.example.myapplication.Models.Bilgi;
import com.example.myapplication.Models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {
    //2: json datasının url inni son parçasını GEt ile al
    //getir metodu oluştur. liste oluşturalım listenin tipi Bilgi classı olsun
    //url : http://jsonplaceholder.typicode.com/comments
    @GET("/comments")
    Call<List<Bilgi>> getir();

    //44: 2. link için yeni bir get anatotaion oluşturalım
    //url: https://jsonplaceholder.typicode.com/comments?postId=1&id=1
    @GET("/comments")
    //45: @Query anatotionunu oluşturalım ve içerisine url deki
    //parametreleri sırayla yaz
    Call<List<Result>> getirResult(@Query("postId") String postid, @Query("id") String id);

}
