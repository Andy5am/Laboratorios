package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NuevoArticuloSample {

    @FXML
    TextField nombreField;
    @FXML
    TextField cantidadField;
    @FXML
    TextField precioField;

    public void abrirVentanaEditarLista(ActionEvent event){
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("editarListaSample.fxml"));
            root =loader.load();
            Stage stage = new Stage();
            stage.setTitle("Lista:");
            stage.setScene(new Scene(root,450,450));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
