package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EntradaPanel extends JPanel implements ActionListener {
    private  JLabel  etiquetaPresentacion;
    private  JButton botonPedidos;
    private  JButton botonCliente;
    private  JButton botonPersonal;
    private Ventana ventana;

  public EntradaPanel(Ventana ventana){
    this.ventana=ventana;
        setVisible(true);
    setBackground(new Color(204,204,255));
    setLayout(null);


    etiquetaPresentacion = new JLabel();
    etiquetaPresentacion.setText("EMPRESA HUMAJU");
    add(etiquetaPresentacion);
    etiquetaPresentacion.setBounds(125,5,750,100);
    etiquetaPresentacion.setForeground(new Color(51,51,255));
    etiquetaPresentacion.setFont(new Font("Comic Sans MS", 3, 48));
   
    botonPedidos = new JButton();
    add(botonPedidos);
    botonPedidos.setBounds(160,390,410,40);
    botonPedidos.setText("Pedidos");
    botonPedidos.setForeground(new Color(51,51,255));
    botonPedidos.setFont(new Font("Comic Sans MS",3,18));
    botonPedidos.addActionListener(this);
    
    botonCliente = new JButton();
    add(botonCliente);
    botonCliente.setBounds(160,280,410,40);
    botonCliente.setText("Almacen");
    botonCliente.setForeground(new Color(51,51,255));
    botonCliente.setFont(new Font("Comic Sans MS",3,18));
    botonCliente.addActionListener(this);
    
    botonPersonal = new JButton();
    add(botonPersonal);
    botonPersonal.setBounds(160,160,410,40);
    botonPersonal.setText("Personal");
    botonPersonal.setForeground(new Color(51,51,255));
    botonPersonal.setFont(new Font("Comic Sans MS",3,18));
    botonPersonal.addActionListener(this); /* Para poner los botones en espera de un evento, se le tiene q pasar x parametro
    una clase q implemente de la interfaz actionListener xq de una interfaz no se puede instanciar objetos 
    en vez de crear un objeto oyente pone de oyente a la clase misma*/
    
    }

public void actionPerformed(ActionEvent e) {
    
    if(e.getSource()==botonPersonal){//para saber de donde viene el evento
       
        PersonalPanel nuevoPanel = new PersonalPanel(ventana);

        ventana.cambiarPanel(nuevoPanel);
       
        
    }else if(e.getSource()==botonCliente){

        AlmacenPanel nuevoPanel = new AlmacenPanel(ventana);

        ventana.cambiarPanel(nuevoPanel);
        
    }else{

        PedidoPanel nuevoPanel = new PedidoPanel(ventana);

        ventana.cambiarPanel(nuevoPanel);

    }
}
   
   
}
