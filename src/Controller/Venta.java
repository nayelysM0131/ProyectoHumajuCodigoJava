package Controller;

import java.io.Serializable;
import java.util.ArrayList;

import Model.FinanzasInterface;

public class Venta implements Serializable,FinanzasInterface{

    private ArrayList<Producto> mercancia;
    private Cliente cliente;

    public Venta(ArrayList<Producto> mercancia,Cliente cliente){
        this.mercancia=mercancia;
        this.cliente=cliente;
    }

    public void setMercancia(ArrayList<Producto> mercancia){
        this.mercancia=mercancia;
    }
    public ArrayList<Producto> getMercancia(){
        return mercancia;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente=cliente;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public int calcularImporte(){//no se le pasa nada porque el metodo trabaja con la lista de productos que es atributo de su misma clase

        int importe = 0;

        for (int i = 0; i < mercancia.size(); i++) {
            
            importe = importe + (mercancia.get(i).getPrecio()*mercancia.get(i).getCantidad());

        }

        return importe;

    }
    
}
