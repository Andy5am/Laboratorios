package sample;

import ListaCompras.ListaCompras;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class EditarListaSample {

    @FXML
    Label nombreLista;
    @FXML
    Label descripcionLista;

    public void abrirVentanaControlListas(ActionEvent event){
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            root =loader.load();
            Stage stage = new Stage();
            stage.setTitle("Crear una nueva lista");
            stage.setScene(new Scene(root,450,450));

            Controller controller = loader.getController();
            ObservableList<ListaCompras> data = FXCollections.observableArrayList(
                    new ListaCompras(nombreLista.getText(),descripcionLista.getText())
            );
            controller.nombreCol.setCellValueFactory(
                    new PropertyValueFactory<ListaCompras,String>("nombre")
            );
            controller.ListasComprasTabla.setItems(data);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
