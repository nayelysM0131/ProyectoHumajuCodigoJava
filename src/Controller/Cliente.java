package Controller;

import java.io.Serializable;

public class Cliente extends Usuario implements Serializable{

    public Cliente(String nombre, String carnetId){
        super(nombre,carnetId);
    }
    
}
