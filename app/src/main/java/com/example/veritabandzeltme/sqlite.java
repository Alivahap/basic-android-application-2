package com.example.veritabandzeltme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class sqlite extends SQLiteOpenHelper {
    static final int Database_Version=1;
    static final String Database_Name="VeriTabanıİsmi";
    static final String Table_book="KitapTablosu";

    public sqlite( Context context) {
        super(context, Database_Name, null, Database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Create_Table="CREATE TABLE "+Table_book+"(id INTEGER PRIMARY KEY AUTOINCREMENT,KitapAdı TEXT, Yazar TEXT)";
        db.execSQL(Create_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE İF EXİSTS "+Table_book);
    }

    public void eklekitap(Kitap ktp) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("KitapAdı",ktp.getKitapAd());
        cv.put("Yazar",ktp.getYazar());
        db.insert(Table_book,null,cv);

    }
    public List<Kitap> getirkitap() {
        List<Kitap> listele = new ArrayList<>();
        SQLiteDatabase db =this.getReadableDatabase();
        String sql="select * from " +Table_book;
        Cursor c =db.rawQuery(sql,null);
        int sıranoid=c.getColumnIndex("id") ;
        int sıranokitap=c.getColumnIndex("KitapAdı") ;
        int sıranoyazar=c.getColumnIndex("Yazar") ;

        try {
            while (c.moveToNext()){
                Kitap mstr=new Kitap();
                mstr.setId(c.getInt(sıranoid));
                mstr.setKitapAd(c.getString(sıranokitap));
                mstr.setYazar(c.getString(sıranoyazar));
                listele.add(mstr);
            }



        }finally {

            c.close();
            db.close();
        }


        return listele;
    }





}
