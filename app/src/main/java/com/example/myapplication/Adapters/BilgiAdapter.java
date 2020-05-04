package com.example.myapplication.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.Main2Activity;
import com.example.myapplication.Models.Bilgi;
import com.example.myapplication.R;

import java.util.List;

import androidx.appcompat.widget.LinearLayoutCompat;

//adapter daima BaseAdapter dan kalıtım alır
public class BilgiAdapter extends BaseAdapter {
    //15:adapter değişkenlerimizi tanımlayalım
    List<Bilgi>bilgiList;
    Context context;
    //32: activity değişkenmizi oluşturalım
    Activity activity;

    //16: değişkenlere ait constructorımızı belirleyelim
    //sağ tıkgenerate-constructor
    //33: aşağıdaki Context context yazan alandan sonra activity mizi ekleyeliö
    //çümkü activitiyi en başta tanımlayıp constructor tanımladan olşturmadık
    public BilgiAdapter(List<Bilgi> bilgiList, Context context, Activity activity) {
        this.bilgiList = bilgiList;
        this.context = context;
        //34:activity de ekle
        this.activity=activity;


    }

    //17: listenin size dönsün
    @Override
    public int getCount() {
        return bilgiList.size();
    }

    //18: lisetenin positionu dönsün
    @Override
    public Object getItem(int position) {
        return bilgiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //19:cconvertView dönsün
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //20: hangi layouttaki View kullanılacak onu belirleyelim
        //layout isimli layoutumuzdaki Viewler kullnaılacak
        convertView = LayoutInflater.from(context).inflate(R.layout.layout,parent,false);

        //21: layouttaki view ları tanımlayalım
        TextView postId, id, name, email, body;
        //29: layoutu tanımlayalım
        //LinearLayout hata veriyor
        //kütüphaneyi yukarıya ekle
        //import android.widget.LinearLayout;
        LinearLayout layoutList;
        layoutList=convertView.findViewById(R.id.idLayout);

        postId=convertView.findViewById(R.id.idPostId);
        id=convertView.findViewById(R.id.idId);
        name=convertView.findViewById(R.id.idName);
        email=convertView.findViewById(R.id.idEmail);
        body=convertView.findViewById(R.id.idBody);

        //22: şimdi bu view ların set işlemini yapalım:
        //buradaki postid ve id integer geliyor. stringe çevirmek içn string ifadeyle birleştir
        postId.setText(""+bilgiList.get(position).getPostId());
        id.setText(""+bilgiList.get(position).getId());
        name.setText(bilgiList.get(position).getName());
        email.setText(bilgiList.get(position).getEmail());
        body.setText(bilgiList.get(position).getBody());
        //37: intent te verileri put etmek için post ve id yi al
        final String post = ""+bilgiList.get(position).getPostId();
        final String idm=""+bilgiList.get(position).getId();

        //35:layouta tıklanınca nereye gideceğini belirtelim
        layoutList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(activity, Main2Activity.class);
                //37: devam
                intent.putExtra("post_id",post);
                intent.putExtra("id",idm);

                activity.startActivity(intent);

            }
        });
        return convertView;
    }
}
