package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.myapplication.Adapters.BilgiAdapter;
import com.example.myapplication.Models.Bilgi;
import com.example.myapplication.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //26:main activity deki View ı oluşturalım
    ListView listView;

    //23:adapter sınıfına ait adp değişkeninimizi oluşturalım
    BilgiAdapter adp;

    //11: Bilgi claasıı tipinde list oluştur
    List<Bilgi>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //28: tanimla fonk
        tanimla();
        //11: istek metodu
        istek();
    }
    //27: main activity de listview ı tanımlayalım
    public void tanimla()
    {
        listView = findViewById(R.id.idLstView);
    }

    //9: web servera istek fonksiyonu
    public void istek()
    {
        //12:listemixi tanımllayalım
        list = new ArrayList<>();

        //9: not:ManagerAll instance aracılığı ile nesnesini oluşturmadan burada ManagerAll sınıfının
        //metoduna ulaştık
        Call<List<Bilgi>> call = ManagerAll.getInstance().getirCall();
        call.enqueue(new Callback<List<Bilgi>>() {
            @Override
            public void onResponse(Call<List<Bilgi>> call, Response<List<Bilgi>> response) {

                if(response.isSuccessful())
                {
                    //10:loglayalım kontrol edwlim sonuç dönüyor mu
                    //örneğin 0. elemanın emailini getirelim
                    //Log.i("sonuc",response.body().get(0).getEmail());

                    //13:eğer web servise bağlanırsak listeyi doldur
                    list=response.body();

                    //24:adp nesnesini oluşturalım
                    //36:adapterın constructoru değiştiği için yeni bir acctivity girmek gerek
                    //MainActivity.this
                    adp =new BilgiAdapter(list,getApplicationContext(),MainActivity.this);

                    //28:listView ımaza adapter verelim
                    listView.setAdapter(adp);
                }

            }

            @Override
            public void onFailure(Call<List<Bilgi>> call, Throwable t) {

            }
        });
    }
}
