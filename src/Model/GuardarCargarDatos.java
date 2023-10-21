package Model;
//////////////////
import java.io.*;
import java.util.ArrayList;

import Controller.AsesorDeVentas;
import Controller.AsistenteDeLogistica;
import Controller.JefeDeLogistica;

public class GuardarCargarDatos {  
   
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static <E> void Guardar (ArrayList<E> objetos,String direccion) throws FileNotFoundException,IOException{
        
        File ruta = new File(direccion);
        FileOutputStream guardarArchivo = new FileOutputStream(ruta);//CREA UN FLUJO DE SALIDA D UN ARCHIVO
        ObjectOutputStream guardarDato = new ObjectOutputStream(guardarArchivo);//CREA UN FLUJO DE SALIDA D UN OBJETO
        int cantidad = objetos.size();//GUARDA LA CANTIDAD DE ELEMENTOS QUE TIENE LA LISTA
        guardarDato.writeInt(cantidad);//GUARDA UN ENTERO EN LA DIRECCION 
    
    for(int i=0;i<cantidad;i++){//Mientras q la posicion en la q t encuentras parada sea menor q la longitudde arreglo
        guardarDato.writeObject(objetos.get(i));//guarda el elemento 

        
    }
    guardarDato.close();//cierra el flujo(tunel)
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static <E> ArrayList<E> Cargar(String direccion) throws ClassNotFoundException,IOException {
        File ruta = new File(direccion);
        FileInputStream cargarArchivo = new FileInputStream(ruta);
        ObjectInputStream cargarDato = new ObjectInputStream(cargarArchivo);

        

        ArrayList<E> objetos = new ArrayList<E>();
        
        int cantidad = cargarDato.readInt();//lee el entero y lo guarda en la variable q se creo

        for(int i = 0;i<cantidad;i++){
            E elemento = (E)cargarDato.readObject();//el metodo recupera un elemento, lo convierto en generico y se guarda en la variable 
            objetos.add(elemento);//se agrega el elemento a la lista
        }
       
       cargarDato.close();
        return objetos;

    }
    ////////////////////////////////////////////////////////////////////////////////
    public static <E> ArrayList<E> CargarLista(ArrayList<E> objetos,String direccion){
        try{
            objetos = GuardarCargarDatos.Cargar(direccion);//guardar la lista q devuelve el metodo en la lista objetos
        }catch(IOException g2){//si ocurre un error de entrada o salida, la lista se crea vacia
            objetos = new ArrayList<>();
            System.out.println(g2.getMessage());
        }catch(ClassNotFoundException g3){//error d clase no encontrada
            objetos = new ArrayList<>();
            System.out.println(g3.getMessage());
        }
        return objetos;
    }
    /////////////////////////////////////////////////////////////////////////////////////
   
    public static <E> void GuardarLista(ArrayList<E> objetos,String direccion){
        try{
            GuardarCargarDatos.Guardar(objetos, direccion);//intenta guardar la lista en la direccion q quieres
        }catch(IOException g){
            System.out.println(g.getMessage());
        }    
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////

public static <E> void GuardarElemento (E elemento,String direccion) throws FileNotFoundException,IOException{
        
    File ruta = new File(direccion);
    FileOutputStream guardarArchivo = new FileOutputStream(ruta);//CREA UN FLUJO DE SALIDA D UN ARCHIVO
    ObjectOutputStream guardarDato = new ObjectOutputStream(guardarArchivo);//CREA UN FLUJO DE SALIDA D UN OBJETO
    guardarDato.writeObject(elemento);//guarda el elemento
    guardarDato.close();//cierra el flujo(tunel)
 
}
///////////////////////////////////////////////////////////////////////////////////////////////////////
public static <E> E CargarElemento(String direccion) throws ClassNotFoundException,IOException {
    File ruta = new File(direccion);
    FileInputStream cargarArchivo = new FileInputStream(ruta);
    ObjectInputStream cargarDato = new ObjectInputStream(cargarArchivo);
    E elemento = (E)cargarDato.readObject();//lee el eLemento y lo guarda en la variable q se creo
    cargarDato.close();
    return elemento;
}
////////////////////////////////////////////////////////////////////////////////////////////

public static AsesorDeVentas cargarAV( AsesorDeVentas elemento,String direccion){
    try{
      elemento = GuardarCargarDatos.CargarElemento(direccion);//el elemento q devuelve el metodo lo guarda en la variable
    }catch(IOException g2){//si ocurre un error de entrada o salida, el objeto se crea vacio
        elemento = new AsesorDeVentas("", "");
        System.out.println(g2.getMessage());
    }catch(ClassNotFoundException g3){//error d clase no encontrada
      elemento = new AsesorDeVentas("", "");
        System.out.println(g3.getMessage());
    }
    return elemento;
}
///////////////////////////////////////////////////////////////////////////////////////////////////////
public static AsistenteDeLogistica cargarAL( AsistenteDeLogistica elemento,String direccion){
    try{
      elemento = GuardarCargarDatos.CargarElemento(direccion);
    }catch(IOException g2){//si ocurre un error de entrada o salida, el objeto se crea vacio
        elemento = new AsistenteDeLogistica("", "");
        System.out.println(g2.getMessage());
    }catch(ClassNotFoundException g3){//error d clase no encontrada
      elemento = new AsistenteDeLogistica("", "");
        System.out.println(g3.getMessage());
    }
    return elemento;
}
//////////////////////////////////////////////////////////////////////////////////////////////////////
public static JefeDeLogistica cargarJL( JefeDeLogistica elemento,String direccion){
    try{
      elemento = GuardarCargarDatos.CargarElemento(direccion);
    }catch(IOException g2){//si ocurre un error de entrada o salida, el objeto se crea vacio
        elemento = new JefeDeLogistica("", "");
        System.out.println(g2.getMessage());
    }catch(ClassNotFoundException g3){//error d clase no encontrada
      elemento = new JefeDeLogistica("", "");
        System.out.println(g3.getMessage());
    }
    return elemento;
}
//////////////////////////////////////////////////////////////////////////////////////////////////////
public static <E> void GuardarComponente(E elemento,String direccion){
    try{
        GuardarCargarDatos.GuardarElemento(elemento, direccion);//intenta guardar el elemento en la direccion q quieres
    }catch(IOException g){
        System.out.println(g.getMessage());
    }    
}
}