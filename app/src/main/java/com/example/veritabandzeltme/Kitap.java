package com.example.veritabandzeltme;

public class Kitap {
    int id;
    String yazar;
    String kitapAd;

    public Kitap() {
    }

    public Kitap(String yazar, String kitapAd) {
        this.yazar = yazar;
        this.kitapAd = kitapAd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public String getKitapAd() {
        return kitapAd;
    }

    public void setKitapAd(String kitapAd) {
        this.kitapAd = kitapAd;
    }
}
