package Controller;

import java.io.Serializable;

public class Empleado implements Serializable{
    
    protected String codigo;
    protected String nombre;

    public Empleado(String nombre, String codigo){
        this.nombre=nombre;
        this.codigo=codigo;
    }
    public void setCodigo(String codigo){
        this.codigo=codigo;
    }
    public String getCodigo(){
        return codigo;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return nombre;
    }
    
}
