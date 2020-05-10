package com.ahmadabuhasan.dicoding;

public class PatunaActivity {
    private String nama, nomor, harga, ket, foto;

    public PatunaActivity() {

    }

    public PatunaActivity(String nama, String nomor, String harga, String ket, String foto) {
        this.nama = nama;
        this.nomor = nomor;
        this.harga = harga;
        this.ket = ket;
        this.foto = foto;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    //

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    //

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    //

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    //

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

}
