package Controller;

import java.io.Serializable;

public class Producto implements Serializable{

    private String nombre;
    private int cantidad;
    private int precio;
    private String proveedor;

    public Producto(String nombre,int cantidad,int precio, String proveedor){

        this.nombre=nombre;
        this.cantidad=cantidad;
        this.precio=precio;
        this.proveedor=proveedor;

    }

    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void setPrecio(int precio){
        this.precio=precio;
    }
    public int getPrecio(){
        return precio;
    }
    public void setProveedor(String proveedor){
        this.proveedor=proveedor;
    }
    public String getProveedor(){
        return proveedor;
    }

}
