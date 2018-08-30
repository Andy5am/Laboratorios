package sample;

import ListaCompras.ListaCompras;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class NuevaListaSample {

    //Conexion con grafico
    @FXML
    private TextField nameField;
    @FXML
    private TextField descriptionField;

    private ObservableList<ListaCompras> data;

    //Metodo para actualizar datos de listas
    public void definirData(ObservableList<ListaCompras> data){this.data=data;}

    //metodo para regresar
    public void cerrarVentanaNuevaLista(ActionEvent event){
        try {
            //Se cierra la ventana
            ((Node)event.getSource()).getScene().getWindow().hide();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //Metodo para abrir la ventana de editar lista y actualizar los datos de la tabla de la ventana principal
    public void abrirVentanaEditarLista(ActionEvent event){

        try {
            //Se cargan las ventanas
            FXMLLoader loaderSample = new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent rootSample = loaderSample.load();

            FXMLLoader loaderEditarLista = new FXMLLoader(getClass().getResource("editarListaSample.fxml"));
            Parent rootEditarLista =loaderEditarLista.load();
            Stage stage = new Stage();
            stage.setTitle("Lista:");
            stage.setScene(new Scene(rootEditarLista,600,450));
            //Se ve que haya texto y se crea la lista
            if (nameField.getText()!=null && descriptionField.getText()!=null) {
                ListaCompras nuevaLista = new ListaCompras(nameField.getText(),descriptionField.getText());
                //Se agrega a las lista de nuevas listas
                this.data.add(nuevaLista);
                //se carga el controller de la ventana principal y se actualiza la lista de listas principal
                Controller controller = loaderSample.getController();
                //controller.definirObjetos(this.data);
                //Se carga el controller de la ventana de edicion de listas
                EditarListaSample controllerEditarLista = loaderEditarLista.getController();
                controllerEditarLista.definirListas(this.data);
                controllerEditarLista.definirPantalla(nuevaLista);
                //se cierra la ventana de nueva lista
                ((Node)(event.getSource())).getScene().getWindow().hide();
                //se mustra la ventana de edicion de listas
                stage.show();
            }else {
                System.out.println("Hay algun dato sin escribir");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
