package model;

public class DataBarang {
    private String kode;
    private String nama;
    private int harga;
    private int stok;

    public DataBarang(String kode, String nama, int stok, int harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }
    public DataBarang(){}

    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }
    
    
}
