package ListaCompras;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Articulo {
    SimpleStringProperty nombre;
    SimpleIntegerProperty cantidad;
    SimpleFloatProperty precio;
    SimpleFloatProperty total;
    SimpleStringProperty estado = new SimpleStringProperty("Pendiente");

    public Articulo(String nombre, int cantidad, float precio){
        this.nombre = new SimpleStringProperty(nombre);
        this.cantidad = new SimpleIntegerProperty(cantidad);
        this.precio = new SimpleFloatProperty(precio);
        this.total = new SimpleFloatProperty(cantidad*precio);
    }

    public void cambiarEstado(){
        if (this.estado.equals("Pendiente")){
            this.estado = new SimpleStringProperty("Comprado");
        }else{
            this.estado= new SimpleStringProperty("Pendiente");
        }
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


