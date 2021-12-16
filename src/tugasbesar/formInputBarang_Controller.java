package tugasbesar;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DataBarang;
import model.DataBarangList;
import model.DataBarangProperty;
import model.ModelHalaman;


public class formInputBarang_Controller implements Initializable {
    ModelHalaman m = new ModelHalaman();
    DataBarangList dbl;
    

    @FXML
    private TextField tfStok;
    @FXML
    private TextField tfHarga;
    @FXML
    private TextField tfCari;
    @FXML
    private Button btnMenuAwal;
    @FXML
    private Button btnSimpan;
    @FXML
    private Button btnHapus;
    @FXML
    private Button btnEdit;
    @FXML
    private TextField tfKode;
    @FXML
    private TextField tfNama;
    @FXML
    private TableView<DataBarangProperty> TableView;
    @FXML
    private TableColumn<DataBarangProperty, String> colomKode;
    @FXML
    private TableColumn<DataBarangProperty, String> colomNama;
    @FXML
    private TableColumn<DataBarangProperty, Integer> colomStok;
    @FXML
    private TableColumn<DataBarangProperty, Integer> colomHarga;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        colomKode.setCellValueFactory(new PropertyValueFactory<DataBarang, String>("kode"));
//        colomNama.setCellValueFactory(new PropertyValueFactory<DataBarang, String>("nama"));
//        colomStok.setCellValueFactory(new PropertyValueFactory<DataBarang, Integer>("stok"));
//        colomHarga.setCellValueFactory(new PropertyValueFactory<DataBarang, Integer>("harga"));
    }   
    
    @FXML
    private void aksiMenuAwal(ActionEvent event) {
        TugasBesar tb = new TugasBesar ();
        tb.pindahHalaman(event, "userMenu.fxml");
    }
    
    
    
    @FXML
    private void aksiSimpan(ActionEvent event) {
        if (!tfKode.getText().equals("") && !tfNama.getText().equals("") && !tfStok.getText().equals("") && !tfHarga.getText().equals("")){
            //data.add(new DataBarang(tfKode.getText(), tfNama.getText(), Integer.parseInt(tfStok.getText()),Integer.parseInt(tfHarga.getText())));
            
            DataBarangProperty dbp =  new DataBarangProperty();
            dbp.setKode(tfKode.getText());
            dbp.setNama(tfNama.getText());
            dbp.setStok(Integer.parseInt(tfStok.getText()));
             
            // masukin value ke datastoklist
            
            TableView.getItems().add(dbp);
            dbl.saveXMLFile();
            System.out.println("Data baru telah disimpan"); 
            
            tfKode.clear();
            tfNama.clear();
            tfStok.clear();
            tfHarga.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("perhatian");
            alert.setHeaderText("data berhasil dimasukan");
            alert.showAndWait();
        } 
    }

    @FXML
    private void aksiHapus(ActionEvent event) {
        int selectedIndex = TableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
           TableView.getItems().remove(selectedIndex);
           
        } else {
            // Jika gak ada yang dipilih
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Tidak ada pilihan");
            alert.setHeaderText("Belum ada order yang dipilih");
            alert.setContentText("Pilih order pada tabel");
            alert.showAndWait();
        }
        dbl.saveXMLFile();
    }

    @FXML
    private void aksiEdit(ActionEvent event) {
    }
    
}
