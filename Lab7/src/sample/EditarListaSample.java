package sample;

import ListaCompras.Articulo;
import ListaCompras.ListaCompras;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditarListaSample {

    @FXML
    private Label nombreLista;
    @FXML
    private Label descripcionLista;
    @FXML
    private TableView articulosTabla;
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

    ObservableList<Articulo> articulos;
    public void Initialize(){
        articuloCol.setCellValueFactory(
                new PropertyValueFactory<Articulo,String>("nombre")
        );
        cantidadCol.setCellValueFactory(
                new PropertyValueFactory<Articulo,String>("cantidad")
        );
        unitarioCol.setCellValueFactory(
                new PropertyValueFactory<Articulo,String>("precio")
        );
        totalCol.setCellValueFactory(
                new PropertyValueFactory<Articulo,String>("total")
        );
        estadoCol.setCellValueFactory(
                new PropertyValueFactory<Articulo,String>("estado")
        );
        articulosTabla.setItems(articulos);
    }

    public void definirDatos(ObservableList<Articulo> datos){
        this.articulos=datos;
    }

    public void abrirVentanaControlListas(ActionEvent event){
        Parent root;
        try {
            ((Node)event.getSource()).getScene().getWindow().hide();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void definirPantalla(ListaCompras nuevaLista){
        this.nombreLista.setText(nuevaLista.getNombre());
        this.descripcionLista.setText(nuevaLista.getDescripcion());
    }

}
