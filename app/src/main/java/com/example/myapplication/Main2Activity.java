package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication.Models.Result;
import com.example.myapplication.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
//30: yeni activitimizi oluşturduk
    //com.example.myappliication -sağ tık- new-Activity-empty activity

    //38: bu activity içerinde değerleri almam gerekiyor postid ve id yi
    String id, postId;

    //52: activity_main2.xml deki view nesneleri oluşturalım
    TextView postITextView, idTextView, nameTextView, bodyTextView, emailTextView;

    //55: listeyi dolduracacğız bize bir list lazım
    List<Result> liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //54: tanimla
        tanimla();
        //42: değerleri al
        al();
        //48: istek at
        istek();
    }

    //39:veryi al
    public void al() {
        //tüm veriyi getir
        Bundle bundle = getIntent().getExtras();
        //40: buradki key leri BilgiAdapterında 37. adımda tanımladık
        id = bundle.getString("id");
        postId = bundle.getString("post_id");

        //41:loglayıp kontrol edelim
        //linearlayouta tıklayınca değerleri alacak
        //Log.i("aldegerler","id = "+ id+","+"post_id= "+postId);
    }

    //53:activity_main2.xml deki viewlları tanımla
    public void tanimla() {
        idTextView = findViewById(R.id.idId2);
        postITextView = findViewById(R.id.idPostId2);
        nameTextView = findViewById(R.id.idIdName2);
        bodyTextView = findViewById(R.id.idBody2);
        emailTextView = findViewById(R.id.idEmail2);
    }

    //57: view lara değerleri atayalım atama fonk
    //bu atama eğer web serviste istek başarılı olursa yapılmalı
    //yani bu fonksiyon, on create içerisinde değil onResponse içerisinden çağğırılmalı
    public void atama(List<Result> list) {
        idTextView.setText("" + list.get(0).getId());
        postITextView.setText("" + list.get(0).getPostId());
        nameTextView.setText(list.get(0).getName());
        bodyTextView.setText(list.get(0).getName());
        emailTextView.setText(list.get(0).getEmail());
    }


    //47: 2. link için yeni bir istek oluşturalım
    public void istek() {
        //56: liste nesnemizi oluşturduk atama gerçekleştirelim
        liste = new ArrayList<>();

        Call<List<Result>> call = ManagerAll.getInstance().managerGetResult(postId, id);
        call.enqueue(new Callback<List<Result>>() {
            @Override
            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                //49:istek gönderilmiiş ml logcatten kontrol edelim:
                //Log.i("başarılı", response.body().get(0).getEmail());
                //57: eğer istek atma başarılıyas listeyi doldur
                if (response.isSuccessful()) {

                    liste = response.body();//liste doldur
                    atama(liste);
                }


            }

            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {

            }
        });
    }

}
