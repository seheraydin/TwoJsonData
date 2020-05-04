package com.example.myapplication.RestApi;

import com.example.myapplication.Models.Bilgi;
import com.example.myapplication.Models.Result;

import java.util.List;

import retrofit2.Call;

//BaseManager dan kalıtılmalı
public class ManagerAll extends BaseManager{
    //6: Main activity de bu class aktif kullanılacak o yüzden bu classın
    //kendisinin döndürülmesi gerekiyor
    //bu sebeple instance yapalım
    private static ManagerAll ourInstance=new ManagerAll();
    //7:bu sınıfın kendisini döndürecek olan metot
    public static synchronized ManagerAll getInstance()
    {
        return ourInstance;
    }
    //8: yanıt döndüren bir fonk yazalım .. retrofite ait call olmalı
    public Call<List<Bilgi>> getirCall()
    {
        Call<List<Bilgi>> x = getRestApi().getir();
        return x;
    }
    //46: yanıt döndüren bir fonk yazalım .. retrofite ait call olmalı
    public Call<List<Result>> managerGetResult(String post, String id)
    {
        Call<List<Result>> x = getRestApi().getirResult(post,id);
        return x;
    }
}
