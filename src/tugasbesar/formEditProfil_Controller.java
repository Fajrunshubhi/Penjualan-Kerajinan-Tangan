package tugasbesar;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.UKM;
import model.daftar;

public class formEditProfil_Controller implements Initializable {

    @FXML
    private TextField tfNama;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfHandphone;
    @FXML
    private TextArea tfAlamat;
    @FXML
    private Button btnSimpan;
    @FXML
    private Button btnHapus;
    @FXML
    private ToggleGroup pilihKelamin;
    @FXML
    private RadioButton radioBtn1;
    @FXML
    private RadioButton radioBtn2;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void aksiSimpan(ActionEvent event) {
        TugasBesar tb = new TugasBesar();
        String kelamin = null;
        
        if (this.pilihKelamin.getSelectedToggle().equals(this.radioBtn1)){
            kelamin = "Laki-Laki";
        }
        else if (this.pilihKelamin.getSelectedToggle().equals(this.radioBtn1)){
            kelamin = "Perempuan";
        }
        
        if(tfEmail.getText().isEmpty() || tfNama.getText().isEmpty() || tfHandphone.getText().isEmpty() || tfAlamat.getText().isEmpty() || pilihKelamin.getToggles().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("message");
            alert.setHeaderText("Tolong isikan data!");
            alert.showAndWait();
        }
        else {
            UKM ukm = new UKM (tfNama.getText(), tfEmail.getText(), tfHandphone.getText(),tfAlamat.getText(),kelamin);
            XStream xstream = new XStream (new StaxDriver());
            String xml = xstream.toXML(ukm);
            FileOutputStream f = null;
        
            try {
                f = new FileOutputStream("profil_ukm.xml");
                byte[] byteKu = xml.getBytes("UTF-8");
                f.write(byteKu);
                f.close();
            }
            catch(IOException e){
                System.out.println("Perhatian " + e.getMessage());
            }
            finally{
                if(f != null){
                    try{
                        f.close();
                    }
                    catch (IOException e){
                        System.out.println(e);
                    }
                }
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("message");
            alert.setHeaderText("Data berhasil disimpan!");
            alert.showAndWait();    
        }
        
    }

    @FXML
    private void aksiHapus(ActionEvent event) {
        tfNama.setText("");
        tfEmail.setText("");
        tfHandphone.setText("");
        tfAlamat.setText("");
    }

    @FXML
    private void aksiKelamin(ActionEvent event) {
        String rbString = event.getSource().toString();
        int panjang = rbString.length();
    }
    
}
