package tugasbesar;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import model.UKM;

public class profil_Controller implements Initializable {
    UKM ukm = new UKM();
    
    @FXML
    private Label lbEmail;
    @FXML
    private Label lbHandphone;
    @FXML
    private Label lbNama;
    @FXML
    private Button btnKembali;
    @FXML
    private Button btnEdit;
    private TextFlow tfAlamat;
    @FXML
    private TextArea taAlamat;
    @FXML
    private Label lbKelamin;
    @FXML
    private Button btnLoad;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        profilUKM();
    }    

    @FXML
    private void aksiEdit(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("formEditProfil.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Craft.It");
        stage.setScene(scene);
        stage.show();
    }
    

    @FXML
    private void aksiKembali(ActionEvent event) {
        TugasBesar tb = new TugasBesar ();
        tb.pindahHalaman(event, "userMenu.fxml");
    }

    @FXML
    private void aksiLoad(ActionEvent event) {
        UKM ukm = new UKM();
        TugasBesar tb = new TugasBesar();
        
        XStream xstream = new XStream(new StaxDriver());
        FileInputStream f = null;
        try{
            f = new FileInputStream("profil_ukm.xml");
            
            int isi;
            char c;
            String xml = "";
            
            // membaca satu persatu perkarakter
            while ((isi = f.read()) != -1){
                c = (char) isi;
                xml = xml + c;
            }
            // proses deserialisasi Sstring xml ke objek kelas, lalau di downcasting
            ukm = (UKM) xstream.fromXML(xml);
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
        finally{
            if(f!=null) {
                try{
                    f.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        String user = ukm.getNama();
        String eml = ukm.getEmail();
        String nohp = ukm.getNoHP();
        String almt = ukm.getAlamat();
        String jnsklmin = ukm.getJeniskelamin();
        lbNama.setText(user);
        lbEmail.setText(eml);
        lbHandphone.setText(nohp);
        taAlamat.setText(almt);
        lbKelamin.setText(jnsklmin);
    }
    
    public void profilUKM(){
        UKM ukm = new UKM();
        TugasBesar tb = new TugasBesar();
        
        XStream xstream = new XStream(new StaxDriver());
        FileInputStream f = null;
        try{
            f = new FileInputStream("profil_ukm.xml");
            
            int isi;
            char c;
            String xml = "";
            
            // membaca satu persatu perkarakter
            while ((isi = f.read()) != -1){
                c = (char) isi;
                xml = xml + c;
            }
            // proses deserialisasi Sstring xml ke objek kelas, lalau di downcasting
            ukm = (UKM) xstream.fromXML(xml);
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
        finally{
            if(f!=null) {
                try{
                    f.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        String user = ukm.getNama();
        String eml = ukm.getEmail();
        String nohp = ukm.getNoHP();
        String almt = ukm.getAlamat();
        String jnsklmin = ukm.getJeniskelamin();
        lbNama.setText(user);
        lbEmail.setText(eml);
        lbHandphone.setText(nohp);
        taAlamat.setText(almt);
        lbKelamin.setText(jnsklmin);
    }
    
    
}
