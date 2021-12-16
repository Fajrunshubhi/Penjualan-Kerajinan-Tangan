package tugasbesar;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class TugasBesar extends Application {
    private static Stage stg;
    private Pane halaman;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        stg = stage;
        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("userMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Craft.It");
        stage.setScene(scene);
        stage.show();
    }
    
    // pindah stage 
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
            System.out.println(e.getMessage());
        }
    }
    
    
    public Pane getPane (String fileName){
        
        try{
            URL fileHalaman = TugasBesar.class.getResource(fileName + ".fxml");
            if(fileHalaman == null){
                throw new java.io.FileNotFoundException("Halaman tidak ditemukan");
            }
            halaman = new FXMLLoader().load(fileHalaman);
        }
        catch (IOException e){
            System.out.println(e);
        }
        return halaman;
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
