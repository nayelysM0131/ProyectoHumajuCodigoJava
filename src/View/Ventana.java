package View;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{
   
    JPanel panel = new JPanel();

    public Ventana(){
        setSize(750, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("HUMAJU");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
       
        panel = new EntradaPanel(this);// creando un objeto de la clase panel entrada
        add(panel);
        
       
    }

    public void cambiarPanel(JPanel nuevoPanel){

        remove(panel);//removemos el panel q esta en ese momento
        panel=nuevoPanel;//al panel se le asigna los componentes del nuevo panel
        add(panel);//y sed le agrega el nuevo panel
        setSize(750,501);
        setSize(750,500);

    }
    
 }

    

