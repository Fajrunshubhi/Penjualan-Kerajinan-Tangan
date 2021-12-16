package tugasbesar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class awal_Controller implements Initializable {
    
    private Label label;
    @FXML
    private Button btnAwalMasuk;
    @FXML
    private Button btnAwalDaftar;
    @FXML
    private BorderPane mainPane;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void aksiAwalMasuk(ActionEvent event) {
        TugasBesar m = new TugasBesar();
        Pane halaman = m.getPane("login");
        mainPane.setCenter(halaman);
    }

    @FXML
    private void aksiAwalDaftar(ActionEvent event) {
        TugasBesar m = new TugasBesar();
        Pane halaman = m.getPane("daftar");
        mainPane.setCenter(halaman);
    }
    
}
