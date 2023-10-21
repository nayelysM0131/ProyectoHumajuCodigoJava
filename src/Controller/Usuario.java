package Controller;

import java.io.Serializable;

public class Usuario implements Serializable{

    private String nombre;
    private String ci;

    public Usuario(String nombre,String ci){
        this.nombre=nombre;
        this.ci=ci;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void setCi(String ci){
        this.ci=ci;
    }
    public String getCi(){
        return ci;
    }
    
}
