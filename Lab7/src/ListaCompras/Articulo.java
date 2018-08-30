package ListaCompras;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Articulo {
    SimpleStringProperty nombre;
    SimpleIntegerProperty cantidad;
    SimpleDoubleProperty precio;
    SimpleDoubleProperty total;
    SimpleStringProperty estado;

    public Articulo(String nombre, int cantidad, double precio){
        this.nombre = new SimpleStringProperty(nombre);
        this.cantidad = new SimpleIntegerProperty(cantidad);
        this.precio = new SimpleDoubleProperty(precio);
        this.total = new SimpleDoubleProperty(cantidad*precio);
        this.estado = new SimpleStringProperty("Pendiente");
    }

    public void cambiarAPendiente(){
        this.estado = new SimpleStringProperty("Pendiente");
    }
    public void cambiarAComprado(){
        this.estado = new SimpleStringProperty("Comprado");
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

    public int getCantidad() {
        return cantidad.get();
    }

    public SimpleIntegerProperty cantidadProperty() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad.set(cantidad);
    }

    public double getPrecio() {
        return precio.get();
    }

    public SimpleDoubleProperty precioProperty() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio.set(precio);
    }

    public double getTotal() {
        return total.get();
    }

    public SimpleDoubleProperty totalProperty() {
        return total;
    }

    public void setTotal(double total) {
        this.total.set(total);
    }

    public String getEstado() {
        return estado.get();
    }

    public SimpleStringProperty estadoProperty() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado.set(estado);
    }

    @Override
    public String toString() {
        return "Nombre:"+nombre+
                "\nCantidad:"+cantidad+
                "\nPrecio:"+precio+
                "\nTotal:"+total+
                "\nEstado:"+estado;
    }
}


