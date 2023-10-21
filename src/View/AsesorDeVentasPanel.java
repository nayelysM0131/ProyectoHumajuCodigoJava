package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AsesorDeVentasPanel extends JPanel implements ActionListener{

    private JLabel etiquetaHumaju;
    private JLabel etiquetaEmpleo;
    private JButton botonVenta;
    private JButton botonCliente;
    private JButton botonEditar;
    private JButton atrasBoton;
    private Ventana ventana;

    
    public AsesorDeVentasPanel(Ventana ventana){
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

        etiquetaEmpleo= new JLabel();
        etiquetaEmpleo.setBounds(0,370,750,30);
        etiquetaEmpleo.setFont(new Font("Comic Sans MS", 3, 24));
        etiquetaEmpleo.setForeground(new Color(51,51,255));
        etiquetaEmpleo.setText("Asesor De Ventas");
        add(etiquetaEmpleo);

        botonVenta = new JButton();
        botonVenta.setBounds(50,200,320,70);
        botonVenta.setFont(new Font("Comic Sans MS", 3, 24));
        botonVenta.setForeground(new Color(51,51,255));
        botonVenta.setText("Ventas");
        add(botonVenta);
        botonVenta.addActionListener(this);

        botonEditar = new JButton();
        botonEditar.setBounds(50,270,640,20);
        botonEditar.setFont(new Font("Comic Sans MS", 3, 14));
        botonEditar.setForeground(new Color(51,51,255));
        botonEditar.setText("editar datos del usuario");
        add(botonEditar);
        botonEditar.addActionListener(this);

        botonCliente = new JButton();
        botonCliente.setBounds(370,200,320,70);
        botonCliente.setFont(new Font("Comic Sans MS", 3, 24));
        botonCliente.setForeground(new Color(51,51,255));
        botonCliente.setText("Registrar Clientes");
        add(botonCliente);
        botonCliente.addActionListener(this);

        atrasBoton = new JButton();
        atrasBoton.setFont(new Font("Comic Sans MS", 1, 24)); 
        atrasBoton.setForeground(new Color(51, 51, 255));
        atrasBoton.setText("Cerrar Sesion");
        add(atrasBoton);
        atrasBoton.setBounds(0,400, 750, 60);
        atrasBoton.addActionListener(this);


    }


   
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==botonCliente){

            RegistrarClientePanel nuevoPanel = new RegistrarClientePanel(ventana);

            ventana.cambiarPanel(nuevoPanel);

        }else if(e.getSource()==botonVenta){

            VentaPanel nuevoPanel = new VentaPanel(ventana);

            ventana.cambiarPanel(nuevoPanel);

        }else if(e.getSource()==botonEditar){
            
            EditarPanel nuevoPanel = new EditarPanel(ventana, "Asesor");
            ventana.cambiarPanel(nuevoPanel);
        
        }else{

            EntradaPanel nuevoPanel = new EntradaPanel(ventana);
            ventana.cambiarPanel(nuevoPanel);

        }
        
    }

}
