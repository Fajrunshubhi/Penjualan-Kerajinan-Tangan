package model;

public class UKM{
    String nama;
    String email;
    String noHP;
    String alamat;
    String jeniskelamin;

    public UKM(String nama, String email, String noHP, String alamat, String jeniskelamin) {
        this.nama = nama;
        this.email = email;
        this.noHP = noHP;
        this.alamat = alamat;
        this.jeniskelamin = jeniskelamin;
    }
    public UKM(){
        
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }
 

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getNoHP() {
        return noHP;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }
    

}