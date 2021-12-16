package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class DataBarangProperty {
    private SimpleStringProperty kode;
    private SimpleStringProperty nama;
    private SimpleIntegerProperty stok;
    private SimpleIntegerProperty harga;
    
    public DataBarangProperty(String kode, String nama, int stok, int harga){
        this.kode = new SimpleStringProperty(kode);
        this.nama = new SimpleStringProperty(nama);
        this.stok = new SimpleIntegerProperty(stok);
        this.harga = new SimpleIntegerProperty(harga);
    }
    public DataBarangProperty(){
        this("","",0,0);
    }
    
    public StringProperty getKodeProperty(){
        return kode;
    }
    public String getKode() {
        return this.kode.get();
    }

    public void setKode(String kode) {
        this.kode.set(kode);
    }
    
    
    public StringProperty getNamaProperty(){
        return nama;
    }
    public String getNama() {
        return this.nama.get();
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }
    
    public IntegerProperty getStokProperty(){
        return stok;
    }
    public int getStok() {
        return this.stok.get();
    }

    public void setStok(int stok) {
        this.stok.set(stok);
    }
    
    
    public IntegerProperty getHargaProperty(){
        return harga;
    }
    public int getHarga() {
        return this.harga.get();
    }

    public void setHarga(int harga) {
        this.harga.set(harga);
    }
    
    
    
    
    
    
    
    
    
    
}
