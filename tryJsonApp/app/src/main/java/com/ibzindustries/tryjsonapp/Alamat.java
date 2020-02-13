package com.ibzindustries.tryjsonapp;

public class Alamat {
    private String namaAlamat, alamatLengkap, namaKota;

    public Alamat(String namaAlamat, String alamatLengkap, String namaKota) {
        this.namaAlamat = namaAlamat;
        this.alamatLengkap = alamatLengkap;
        this.namaKota = namaKota;
    }

    public String getNamaAlamat() {
        return namaAlamat;
    }

    public String getAlamatLengkap() {
        return alamatLengkap;
    }

    public String getNamaKota() {
        return namaKota;
    }

}
