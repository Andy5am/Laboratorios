package sample;

import ListaCompras.Articulo;
import ListaCompras.ListaCompras;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class EditarListaSample {

    @FXML
    private Label nombreLista;
    @FXML
    private Label descripcionLista;
    @FXML
    private TableView<Articulo> articulosTabla;
    @FXML
    private TableColumn articuloCol;
    @FXML
    private TableColumn cantidadCol;
    @FXML
    private TableColumn unitarioCol;
    @FXML
    private TableColumn totalCol;
    @FXML
    private TableColumn estadoCol;
    @FXML
    private Label pendiente;

    ObservableList<Articulo> articulos = FXCollections.observableArrayList();
    ObservableList<ListaCompras> listas = FXCollections.observableArrayList();
    public ListaCompras listaActual;
    public void initialize(){

        articuloCol.setCellValueFactory(
                new PropertyValueFactory<Articulo, String>("nombre")
        );
        cantidadCol.setCellValueFactory(
                new PropertyValueFactory<Articulo, String>("cantidad")
        );
        unitarioCol.setCellValueFactory(
                new PropertyValueFactory<Articulo, String>("precio")
        );
        totalCol.setCellValueFactory(
                new PropertyValueFactory<Articulo, String>("total")
        );
        estadoCol.setCellValueFactory(
                new PropertyValueFactory<Articulo, String>("estado")
        );
        articulosTabla.setItems(articulos);

    }

    public void definirDatos(ObservableList<Articulo> datos){
        this.articulos=datos;
    }
    public void definirListas(ObservableList<ListaCompras> datos){
        this.listas=datos;
    }
    public void anadirArticulos(Articulo articulo){
        this.articulos.add(articulo);
    }
    public void abrirVentanaControlListas(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent root = loader.load();

            Controller controller = loader.getController();
            System.out.println(listas);
            System.out.println(articulos);
            this.articulos.removeAll();
            System.out.println(articulos);
            listaActual.añadirArticulo(articulos);
            this.definirListas(listas);
            controller.definirObjetos(listas);

            ((Node)event.getSource()).getScene().getWindow().hide();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void definirPantalla(ListaCompras nuevaLista){
        this.nombreLista.setText(nuevaLista.getNombre());
        this.descripcionLista.setText(nuevaLista.getDescripcion());
        this.listaActual = nuevaLista;
    }


    public void abrirVentanaNuevoArticulo(ActionEvent event){
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("nuevoArticuloSample.fxml"));
            root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Crear nuevo articulo");
            stage.setScene(new Scene(root,600,450));
            NuevoArticuloSample controllerNuevoArticulo = loader.getController();
            controllerNuevoArticulo.actualizarArticulos(articulos);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void marcarPendiente(ActionEvent event){
        Articulo articuloSeleccionado = articulosTabla.getSelectionModel().getSelectedItem();
        if (articuloSeleccionado!=null) {
            articuloSeleccionado.cambiarAPendiente();
            articulosTabla.refresh();
        }else{
            System.out.println("No hay articulo seleccionado");
        }
    }
    public void marcarComprado(ActionEvent event){
        Articulo articuloSeleccionado = articulosTabla.getSelectionModel().getSelectedItem();
        if (articuloSeleccionado!=null) {
            articuloSeleccionado.cambiarAComprado();
            articulosTabla.refresh();
        }else {
            System.out.println("No hay articulo seleccionado");
        }
    }

}
