package Controller;

import java.io.Serializable;

public class Pedido implements Serializable{

    private Producto mercancia;
    private int cantidad;
    
    public Pedido(Producto mercancia,int cantidad){
        this.mercancia=mercancia;
        this.cantidad=cantidad;
    }
    public void setMercancia(Producto mercancia){
        this.mercancia=mercancia;
    }
    public Producto getMercancia(){
        return mercancia;
    }
    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    }
    public int getCantidad(){
        return cantidad;
    }
    public int precioTotal(){
       return mercancia.getPrecio()*cantidad;
    }
}
