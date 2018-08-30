package sample;

import ListaCompras.ListaCompras;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    // Se conectan los elementos graficos
    @FXML
    private TableView<ListaCompras> ListasComprasTabla;
    @FXML
    private TableColumn nombreCol;
    @FXML
    private TableColumn fechaCol;
    @FXML
    private TableColumn pendienteCol;
    @FXML
    private TableColumn estimadoCol;

    private ObservableList<ListaCompras> data = FXCollections.observableArrayList();

    public void initialize(){
        nombreCol.setCellValueFactory(
                new PropertyValueFactory<ListaCompras,String>("nombre")
        );
        fechaCol.setCellValueFactory(
                new PropertyValueFactory<ListaCompras,String>("fecha")
        );
        pendienteCol.setCellValueFactory(
                new PropertyValueFactory<ListaCompras,String>("pendiente")
        );
        estimadoCol.setCellValueFactory(
                new PropertyValueFactory<ListaCompras,String>("estimado")
        );
        ListasComprasTabla.setItems(data);
    }
    //Metodo para actualizar la tabla
    public void definirObjetos(ObservableList<ListaCompras> lista){
        this.data=lista;
    }
    //Metodo para abrir la vetana de agregar lista
    public void abrirVentanaNuevaLista(ActionEvent event){
        Parent root;
        try {
            //Carga ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("nuevaListaSample.fxml"));
            root =loader.load();
            Stage stage = new Stage();
            stage.setTitle("Crear una nueva lista");
            stage.setScene(new Scene(root,450,450));
            //Conexion con controller de nueva lista
            NuevaListaSample controllerNuevaLista = loader.getController();
            //Se actualiza los datos de listas
            controllerNuevaLista.definirData(this.data);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //Metodo para abrir la vetana de editar lista
    public void abrirVentanaEditarLista(ActionEvent event){
        Parent root;
        try {
            //Se carga la ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("editarListaSample.fxml"));
            root =loader.load();
            Stage stage = new Stage();
            stage.setTitle("Lista");
            stage.setScene(new Scene(root,600,450));
            //Se define la selecciono de lista y lo que se hara con ella
            ListaCompras listaSeleccionada = ListasComprasTabla.getSelectionModel().getSelectedItem();
            EditarListaSample controllerEditarLista = loader.getController();
            controllerEditarLista.definirPantalla(listaSeleccionada);
            //Se muestra la ventana
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //Metodo para eliminar lista
    public void eliminarLista(){
        //se define la lista seleccionada y se elimina
        ListaCompras listaSeleccionada = ListasComprasTabla.getSelectionModel().getSelectedItem();
        ListasComprasTabla.getItems().remove(listaSeleccionada);
    }
}
