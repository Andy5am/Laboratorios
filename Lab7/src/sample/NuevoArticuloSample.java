package sample;

import ListaCompras.Articulo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class NuevoArticuloSample {

    @FXML
    private TextField nombreField;
    @FXML
    private TextField cantidadField;
    @FXML
    private TextField precioField;

    private ObservableList<Articulo> data;

    public void actualizarArticulos(ObservableList<Articulo> datos){
        this.data=datos;
    }

    public void cerrarVentana(ActionEvent event){
        Parent root;
        try {
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void crearArticulo(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("editarListaSample.fxml"));
            Parent root = loader.load();

            String nombreArt = nombreField.getText();
            Integer cantidadArt = Integer.parseInt(cantidadField.getText());
            Double precioArt =Double.parseDouble(precioField.getText());

            if ((nombreArt!=null) &&  (cantidadArt!=null) && (precioArt!=null)){

                Articulo nuevoArticulo = new Articulo(nombreArt,cantidadArt,precioArt);
                this.data.add(nuevoArticulo);

                EditarListaSample controllerEditarLista = loader.getController();

                controllerEditarLista.definirDatos(this.data);


                ((Node)event.getSource()).getScene().getWindow().hide();

            }else{
                System.out.println("Hay algun dato sin escribir");
            }


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
