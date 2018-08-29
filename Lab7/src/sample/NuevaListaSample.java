package sample;

import ListaCompras.ListaCompras;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;


public class NuevaListaSample {


    @FXML
    TextField nameField;
    @FXML
    TextField descriptionField;
    public void abrirVentanaNuevaLista(ActionEvent event){
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            root =loader.load();
            Stage stage = new Stage();
            stage.setTitle("Control de listas de compra");
            stage.setScene(new Scene(root,450,450));
            Controller controller = loader.getController();
            ObservableList<ListaCompras>data =FXCollections.observableArrayList(
                new ListaCompras(nameField.getText(),descriptionField.getText()));
            controller.nombreCol.setCellValueFactory(
                    new PropertyValueFactory<ListaCompras,String>("nombre")
            );
            controller.estimadoCol.setCellValueFactory(
                    new PropertyValueFactory<ListaCompras,String>("descripcion")
            );
            controller.ListasComprasTabla.setItems(data);
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
            stage.setTitle("Lista:");
            stage.setScene(new Scene(root,600,450));
            EditarListaSample controllerEditarLista = loader.getController();
            ObservableList<ListaCompras>data= FXCollections.observableArrayList(
                new ListaCompras(nameField.getText(),descriptionField.getText()));
            controllerEditarLista.nombreLista.setText(String.valueOf(new PropertyValueFactory<ListaCompras,String>("nombre")));
            controllerEditarLista.descripcionLista.setText(String.valueOf(new PropertyValueFactory<ListaCompras,String>("descripcion")));
            controllerEditarLista.nombreLista.setText(String.valueOf(data.get(0).getNombre()));
            controllerEditarLista.descripcionLista.setText(String.valueOf(data.get(0).getDescripcion()));

            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
