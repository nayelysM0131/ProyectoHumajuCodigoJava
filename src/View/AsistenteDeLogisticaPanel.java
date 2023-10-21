package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AsistenteDeLogisticaPanel extends JPanel implements ActionListener{
    private JLabel etiquetaHumaju;
    private JLabel etiquetaEmpleo;
    private JButton botonProducto;
    private JButton botonEditar;
    private JButton atrasBoton;
    private Ventana ventana;

    public AsistenteDeLogisticaPanel(Ventana ventana){
        this.ventana=ventana;
        setVisible(true);
        setBackground(new Color(204,204,255));
        setLayout(null);

        etiquetaHumaju = new JLabel();
        etiquetaHumaju.setBounds(0,30,750,90);
        etiquetaHumaju.setFont(new Font("Comic Sans MS", 3, 48));
        etiquetaHumaju.setForeground(new Color(51,51,255));
        etiquetaHumaju.setText("H U M A J U");
        add(etiquetaHumaju);

        etiquetaEmpleo = new JLabel();
        etiquetaEmpleo.setBounds(0,360,750,40);
        etiquetaEmpleo.setFont(new Font("Comic Sans MS", 3, 24));
        etiquetaEmpleo.setForeground(new Color(51,51,255));
        etiquetaEmpleo.setText("Asistente De Logística");
        add(etiquetaEmpleo);

        botonProducto = new JButton();
        botonProducto.setBounds(50,200,640,80);
        botonProducto.setFont(new Font("Comic Sans MS", 3, 24));
        botonProducto.setForeground(new Color(51,51,255));
        botonProducto.setText("Registrar Productos");
        add(botonProducto);
        botonProducto.addActionListener(this);

        botonEditar = new JButton();
        botonEditar.setBounds(50,280,640,20);
        botonEditar.setFont(new Font("Comic Sans MS", 3, 14));
        botonEditar.setForeground(new Color(51,51,255));
        botonEditar.setText("editar datos del usuario");
        add(botonEditar);
        botonEditar.addActionListener(this);

        atrasBoton = new JButton();
        atrasBoton.setFont(new Font("Comic Sans MS", 1, 24)); 
        atrasBoton.setForeground(new Color(51, 51, 255));
        atrasBoton.setText("Cerrar Sesion");
        add(atrasBoton);
        atrasBoton.setBounds(0, 400, 750, 60);
        atrasBoton.addActionListener(this);

    }

  
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==botonProducto){

            RegistrtarProductoPanel nuevoPanel = new RegistrtarProductoPanel(ventana);

            ventana.cambiarPanel(nuevoPanel);

        }else if(e.getSource()==botonEditar){
            
            EditarPanel nuevoPanel = new EditarPanel(ventana, "Asistente");
            ventana.cambiarPanel(nuevoPanel);
        
        }else{

            EntradaPanel nuevoPanel = new EntradaPanel(ventana);

            ventana.cambiarPanel(nuevoPanel);
        } 
    }
    

}
