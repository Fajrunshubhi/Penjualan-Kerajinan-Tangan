package tugasbesar;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.daftar;

public class login_Controller implements Initializable {

    @FXML
    private TextField tfUsername;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private Button btnMasuk;
    @FXML
    private Label lbPeringatan;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    @FXML
    private void aksiMasuk(ActionEvent event) throws IOException {
        daftar df = new daftar();
        TugasBesar tb = new TugasBesar();
        
        XStream xstream = new XStream(new StaxDriver());
        FileInputStream f = null;
        try{
            f = new FileInputStream("daftar.xml");
            
            int isi;
            char c;
            String xml = "";
            
            // membaca satu persatu perkarakter
            while ((isi = f.read()) != -1){
                c = (char) isi;
                xml = xml + c;
            }
            // proses deserialisasi Sstring xml ke objek kelas, lalau di downcasting
            df = (daftar) xstream.fromXML(xml);
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
        String user = df.tampiluser();
        String pw =  df.tampilpw();
        
        
        if (tfUsername.getText().equals(user)&& tfPassword.getText().equals(pw)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("message");
            alert.setHeaderText("Login Berhasil!");
            alert.showAndWait();  
            tb.pindahHalaman(event, "userMenu.fxml");
        }
        else if (tfUsername.getText().isEmpty() && tfPassword.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("message");
            alert.setHeaderText("Tolong isikan data!");
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("message");
            alert.setHeaderText("Tolong isikan data yang sesuai!");
            alert.showAndWait();
        }
    }
    
}
