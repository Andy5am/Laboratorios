package ListaCompras;

import ListaCompras.Articulo;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Date;

public class ListaCompras {
    //atributos
    SimpleStringProperty nombre;
    java.util.Date fecha= new Date();
    SimpleStringProperty descripcion;
    ObservableList<Articulo> articulos = FXCollections.observableArrayList();
    SimpleIntegerProperty pendiente;
    SimpleDoubleProperty estimado;

    public ListaCompras(String nombre,String descripcion){
        this.nombre= new SimpleStringProperty(nombre);
        this.descripcion= new SimpleStringProperty(descripcion);
        this.setPendiente(this.articulos);
    }

    public void añadirArticulo(ObservableList<Articulo> articulos){
        for (int i =this.articulos.size();i<articulos.size();i++)
        articulos.forEach(articulo -> this.articulos.add(articulo));
    }


    public ObservableList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ObservableList<Articulo> articulos) {
        this.articulos = articulos;
    }

    public int getPendiente() {
        return pendiente.get();
    }

    public SimpleIntegerProperty pendienteProperty() {
        return pendiente;
    }

    public void setPendiente(ObservableList<Articulo> articulos) {
        SimpleIntegerProperty numPendientes= new SimpleIntegerProperty(0);
        int numero = 0;
        for (int i = 0;i<articulos.size();i++){
            if (this.articulos.get(i).getEstado()=="Pendiente"){
                numero++;
                numPendientes= new SimpleIntegerProperty(numero);
            }
        }
        this.pendiente=numPendientes;
    }

    public double getEstimado() {
        return estimado.get();
    }

    public SimpleDoubleProperty estimadoProperty() {
        return estimado;
    }

    public void setEstimado(double estimado) {
        this.estimado.set(estimado);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
                "\nFecha:"+fecha+
                "\nArticulos:"+this.articulos;
    }
}
