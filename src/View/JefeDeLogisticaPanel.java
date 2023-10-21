package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JefeDeLogisticaPanel extends JPanel implements ActionListener {
    private JLabel etiquetaHumaju;
    private JLabel etiquetaEmpleo;
    private JButton atrasBoton;
    private JButton botonEditar;
    private JButton botonPedido;
    Ventana ventana;

    public JefeDeLogisticaPanel(Ventana ventana){
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
        etiquetaEmpleo.setBounds(0,360,750,40);
        etiquetaEmpleo.setFont(new Font("Comic Sans MS", 3, 24));
        etiquetaEmpleo.setForeground(new Color(51,51,255));
        etiquetaEmpleo.setText("Jefe De Logística");
        add(etiquetaEmpleo);

        botonPedido = new JButton();
        botonPedido.setBounds(50,200,640,80);
        botonPedido.setFont(new Font("Comic Sans MS", 3, 24));
        botonPedido.setForeground(new Color(51,51,255));
        botonPedido.setText("Registrar Pedidos");
        add(botonPedido);
        botonPedido.addActionListener(this);

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
        if(e.getSource()== botonPedido){
        RegistrarPedidoPanel nuevoPanel = new RegistrarPedidoPanel(ventana);

        ventana.cambiarPanel(nuevoPanel);

        }else if(e.getSource()==botonEditar){
            
            EditarPanel nuevoPanel = new EditarPanel(ventana, "Jefe");
            ventana.cambiarPanel(nuevoPanel);
        
        }else{

            EntradaPanel nuevoPanel = new EntradaPanel(ventana);

            ventana.cambiarPanel(nuevoPanel);

        }
    }

}
