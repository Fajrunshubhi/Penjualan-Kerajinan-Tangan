package model;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ModelHalaman {
    
    public void pindahHalaman (ActionEvent event, String tujuan){
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(tujuan));
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
