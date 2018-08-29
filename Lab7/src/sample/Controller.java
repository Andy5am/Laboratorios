package sample;

import ListaCompras.ListaCompras;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    TableView<ListaCompras> ListasComprasTabla;
    @FXML
    TableColumn nombreCol;
    @FXML
    TableColumn fechaCol;
    @FXML
    TableColumn pendienteCol;
    @FXML
    TableColumn estimadoCol;

    public void abrirVentanaNuevaLista(ActionEvent event){
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("nuevaListaSample.fxml"));
            root =loader.load();
            Stage stage = new Stage();
            stage.setTitle("Crear una nueva lista");
            stage.setScene(new Scene(root,450,450));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void abrirVentanaEditarLista(ActionEvent event){
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("editarListaSample.fxml"));
            root =loader.load();
            Stage stage = new Stage();
            stage.setTitle("Lista");
            stage.setScene(new Scene(root,600,450));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
