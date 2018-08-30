package ListaCompras;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.SimpleDateFormat;

public class ListaCompras {
    //atributos
    SimpleStringProperty nombre;
    SimpleDateFormat fecha;
    SimpleStringProperty descripcion;
    ObservableList<Articulo> articulos = FXCollections.observableArrayList();

    public ListaCompras(String nombre,String descripcion){
        this.nombre= new SimpleStringProperty(nombre);
        this.descripcion= new SimpleStringProperty(descripcion);
        this.fecha = new SimpleDateFormat();
    }


    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public SimpleStringProperty descripcionProperty() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    @Override
    public String toString() {
        return "Nombre:"+nombre+
                "\nDescripcion:"+this.descripcion+
                "\nArticulos:"+this.articulos;
    }
}
