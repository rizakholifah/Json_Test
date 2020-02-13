package com.ibzindustries.tryjsonapp;

import java.util.ArrayList;

public class Person {
    private String nama, umur, gender;
    private ArrayList<Alamat> alamats;

    public Person(String nama, String umur, String gender, ArrayList<Alamat> alamats) {
        this.nama = nama;
        this.umur = umur;
        this.gender = gender;
        this.alamats = alamats;
    }

    public String getNama() {
        return nama;
    }

    public String getUmur() {
        return umur;
    }

    public String getGender() {
        return gender;
    }

    public ArrayList<Alamat> getAlamats() {
        return alamats;
    }
}
