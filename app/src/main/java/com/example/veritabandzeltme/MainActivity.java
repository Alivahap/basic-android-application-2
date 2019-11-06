package com.example.veritabandzeltme;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Context context=this;

ListView ls;
    List<Kitap> kitapliste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ls=findViewById(R.id.ListView);


        Kitap ktp= new Kitap("Frans Kafka","Şato");
        sqlite db = new sqlite(context);
        db.eklekitap(ktp);

        kitapliste =new ArrayList<Kitap>();
        kitapliste =db.getirkitap();

      /*  StringBuilder sb = new StringBuilder();
        for (Kitap ktp1 :msr_list){

            String icerik="id = "+ktp1.getId()+"Kitapadı = "+ktp1.getKitapAd()+"yazar="+ktp1.getYazar()+"\n\n";
            sb.append(icerik);

        }ed.setText(sb);
        */
        List<String> array = new ArrayList<>();
      for(int i=0;i<kitapliste.size();i++){

          array.add(i,kitapliste.get(i).getKitapAd());

      }




        ArrayAdapter<String> adoptar=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,android.R.id.text1,array);
ls.setAdapter(adoptar);

    }
}
