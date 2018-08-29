package ListaCompras;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;

public class ListaCompras {
    SimpleStringProperty nombre;
    SimpleDateFormat fecha;
    SimpleStringProperty descripcion;
    SimpleListProperty<Articulo> articulos = new SimpleListProperty();

    public ListaCompras(String nombre,String descripcion){
        this.nombre= new SimpleStringProperty(nombre);
        this.descripcion= new SimpleStringProperty(descripcion);
        this.fecha = new SimpleDateFormat();
    }

    public void añadirArticuolo(Articulo articulo){
        for(int i=0; i <articulos.size(); i++){
            if (articulos.get(i).equals(articulo)){
                this.articulos.add(articulo);
            }
        }
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
