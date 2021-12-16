package model;

public class Pengguna {
    String nama;
    String alamat;
    String noHP;
    String email;

    public Pengguna(String nama, String alamat, String noHP, String email) {
        this.nama = nama;
        this.alamat = alamat;
        this.noHP = noHP;
        this.email = email;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoHP() {
        return noHP;
    }

    public String getEmail() {
        return email;
    }
    
    
}
