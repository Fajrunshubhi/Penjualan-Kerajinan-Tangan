package tugasbesar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.ModelHalaman;


public class userMenu_Controller implements Initializable {
    ModelHalaman m = new ModelHalaman();

    @FXML
    private Button btnDataBarang;
    @FXML
    private Button btnProfil;
    @FXML
    private Button btnKeluar;
    @FXML
    private BorderPane mainPaneUser;
    @FXML
    private Button btnJenisBarang;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }        

    @FXML
    private void aksiProfil(ActionEvent event) throws IOException {
//        Stage stage = new Stage();
//        Parent root = FXMLLoader.load(getClass().getResource("profil.fxml"));
//        Scene scene = new Scene(root);
//        stage.setTitle("Craft.It");
//        stage.setScene(scene);
//        stage.show();
        TugasBesar tb = new TugasBesar();
        Pane halaman = tb.getPane("profil");
        mainPaneUser.setCenter(halaman);   
    }

    @FXML
    private void aksiKeluar(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("message");
        alert.setHeaderText("Berhasil Keluar");
        alert.showAndWait();
        TugasBesar tb = new TugasBesar ();
        tb.pindahHalaman(event, "awal.fxml");
        
    }

    @FXML
    private void aksiJenisBarang(ActionEvent event) {
        TugasBesar tb = new TugasBesar();
        Pane halaman = tb.getPane("formBeranda");
        mainPaneUser.setCenter(halaman);
    }

    @FXML
    private void aksiData(ActionEvent event) throws IOException {
        TugasBesar tb = new TugasBesar();
        tb.pindahHalaman(event, "formInputBarang.fxml");
    }
}
