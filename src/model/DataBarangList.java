package model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataBarangList {
    private ObservableList<DataBarangProperty> list;
    private String DataBarangFile;
    
    public DataBarangList(){
        list = FXCollections.observableArrayList();
        DataBarangFile = "DataBarang.xml";
    }
    
    // ambil data dari observable list 
    public ObservableList<DataBarangProperty> get(){
        return this.list;
    }

    // akses file xml, untuk input data baru variable biasa
    public void setFromArray(DataBarang[] array){
        list = FXCollections.observableArrayList();
        
        for(DataBarang s : array){
            list.add(new DataBarangProperty(s.getKode(),s.getNama(),s.getStok(),s.getHarga()));
        }
    }
    
    public void setData(String kode, String nama,int stok, int harga){
        list.add(new DataBarangProperty(kode, nama, stok, harga));
    }
    
    
    //  xstream masukin array lalu diubah jadi property lalu dimasukan ke tabel;
    public void loadXMLFile(){

        try {
            XStream xstream = new XStream(new StaxDriver());
            FileInputStream in = new FileInputStream(DataBarangFile);

            String s = "";
            int i = in.read();

                while(i != -1){
                    s += (char) i;
                    i = in.read();
                }
            DataBarang[] array = (DataBarang[]) xstream.fromXML(s);
            this.setFromArray(array);
        }
        catch(Exception e){
               e.printStackTrace();
        }   
    }
    
    // untuk dapat data dalam bentuk array
    public DataBarang[] getArray(){
       
        DataBarangProperty dbp = new DataBarangProperty();
        
        DataBarang[] array = new DataBarang[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            String kode = list.get(i).getKode();
            String nama = list.get(i).getNama();
            int stok = list.get(i).getStok();
            int harga = list.get(i).getHarga();
            array[i] = new DataBarang(kode, nama, stok, harga);         
        }
        System.out.println(array);
        return array;
    }
    
    
    
    public void saveXMLFile(){
      DataBarang[] array = this.getArray();
      System.out.println(Arrays.toString(array));
      XStream xstream = new XStream(new StaxDriver());

      try{
          FileOutputStream output = new FileOutputStream(DataBarangFile);
          String xml = xstream.toXML(array);
          byte[] bytes = xml.getBytes("UTF-8");
          output.write(bytes);
          output.close();
          
      }catch(Exception e){
          e.printStackTrace(); 
      }   
        System.out.println("berhasil disimpan");
    
    }
}
