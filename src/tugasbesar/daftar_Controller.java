package tugasbesar;

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

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;


public class daftar_Controller implements Initializable {
    
    @FXML
    private TextField tfUsername;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField tfEmail;
    @FXML
    private Button btnDaftar;
    @FXML
    private Label lbPeringatan;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    @FXML
    private void aksiDaftar(ActionEvent event) {
        TugasBesar tb = new TugasBesar();
        
        if(tfEmail.getText().isEmpty() || tfUsername.getText().isEmpty() || tfPassword.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("message");
            alert.setHeaderText("Tolong isikan data!");
            alert.showAndWait();
        }
        else {
            daftar df = new daftar (tfEmail.getText(), tfUsername.getText(), tfPassword.getText());
            XStream xstream = new XStream (new StaxDriver());
            String xml = xstream.toXML(df);
            FileOutputStream f = null;
        
            try {
                f = new FileOutputStream("Daftar.xml");
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
            alert.setHeaderText("Daftar Berhasil, silahkan masuk!");
            alert.showAndWait();    
            tb.pindahHalaman(event, "login.fxml");
            
        }
        
    }    
    
}
