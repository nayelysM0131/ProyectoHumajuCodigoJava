package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Controller.Producto;
import Controller.Pedido;
import Model.GuardarCargarDatos;

public class RegistrarPedidoPanel extends JPanel implements ActionListener{

    private JButton atrasBoton;
    private JTextField cantidadCampo;
    private JLabel cantidadLabel;
    private JComboBox<String> productoComboBox;
    private JLabel productoLabel;
    private JButton registrarBoton;
    private JLabel tituloLabel;
    private Ventana ventana;
    private ArrayList<Producto> mercancia = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    
    public RegistrarPedidoPanel(Ventana ventana){

        this.ventana=ventana;
        mercancia=GuardarCargarDatos.CargarLista(mercancia, "src/datos/mercancia.dat");//cargamos la lista
        pedidos=GuardarCargarDatos.CargarLista(pedidos, "src/datos/pedidos.dat");
        atrasBoton = new JButton();
        tituloLabel = new JLabel();
        cantidadCampo = new JTextField();
        productoLabel = new JLabel();
        registrarBoton = new JButton();
        productoComboBox = new JComboBox();
        cantidadLabel = new JLabel();

        setBackground(new Color(204, 204, 255));
        setLayout(null);

        atrasBoton.setFont(new Font("Comic Sans MS", 1, 24)); 
        atrasBoton.setForeground(new Color(51, 51, 255));
        atrasBoton.setText("Atras");
        add(atrasBoton);
        atrasBoton.setBounds(380, 380, 370, 80);
        atrasBoton.addActionListener(this);

        tituloLabel.setFont(new Font("Comic Sans MS", 1, 48)); 
        tituloLabel.setForeground(new Color(51, 51, 255));
        tituloLabel.setText("Registrar Pedido");
        add(tituloLabel);
        tituloLabel.setBounds(20, 10, 400, 90);

        cantidadCampo.setFont(new Font("Comic Sans MS", 1, 14)); 
        cantidadCampo.setForeground(new Color(51, 51, 255));
        add(cantidadCampo);
        cantidadCampo.setBounds(340, 290, 150, 27);

        productoLabel.setFont(new Font("Comic Sans MS", 1, 18)); 
        productoLabel.setForeground(new Color(51, 51, 255));
        productoLabel.setText("Producto : ");
        add(productoLabel);
        productoLabel.setBounds(230, 170, 110, 26);

        registrarBoton.setFont(new Font("Comic Sans MS", 1, 24)); 
        registrarBoton.setForeground(new Color(51, 51, 255));
        registrarBoton.setText("Registrar");
        add(registrarBoton);
        registrarBoton.setBounds(0, 380, 380, 80);
        registrarBoton.addActionListener(this);

        productoComboBox.setForeground(new Color(51, 51, 255));
        add(productoComboBox);
        productoComboBox.setBounds(340, 170, 150, 30);
        productoComboBox.setMaximumRowCount(mercancia.size());
        productoComboBox.setModel(new DefaultComboBoxModel<>(new String[] {}));//el tipo d dato con el q se va a llenar el menu desplegable
        for(int j = 0;j<mercancia.size();j++){
            productoComboBox.addItem(mercancia.get(j).getNombre());//va recorriendo la lista y llenando el menu con los nombres de los productos
        }

        cantidadLabel.setFont(new Font("Comic Sans MS", 1, 18)); 
        cantidadLabel.setForeground(new Color(51, 51, 255));
        cantidadLabel.setText("Cantidad : ");
        add(cantidadLabel);
        cantidadLabel.setBounds(230, 290, 110, 26);


    }

   
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==registrarBoton){
            if(cantidadCampo.getText().isEmpty() || mercancia.size()==0){

                JOptionPane.showMessageDialog(null, "LLene todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);


            }else{

                mercancia.get(productoComboBox.getSelectedIndex()).setCantidad(mercancia.get(productoComboBox.getSelectedIndex()).getCantidad()+Integer.parseInt(cantidadCampo.getText())); //establece una nueva cantidad, primero obtienes la cantidad actual y le sumas la q se escribe en el campo, convirtiendo el string a entero
                GuardarCargarDatos.GuardarLista(mercancia, "src/datos/mercancia.dat");

                Pedido pedido = new Pedido(mercancia.get(productoComboBox.getSelectedIndex()), Integer.parseInt(cantidadCampo.getText()));// creas un pedido con la mercancia q seleccionaste y la cantidad que pediste
                pedidos.add(pedido);//agregar el pedido a la lista d pedidos
                GuardarCargarDatos.GuardarLista(pedidos, "src/datos/pedidos.dat");// guarda la lista de pedidos

                JOptionPane.showMessageDialog(null, "Pedido registrado con exito", "Info", JOptionPane.WARNING_MESSAGE);

                JefeDeLogisticaPanel nuevoPanel =  new JefeDeLogisticaPanel(ventana);
                ventana.cambiarPanel(nuevoPanel);

            }
        }else{

            JefeDeLogisticaPanel nuevoPanel =  new JefeDeLogisticaPanel(ventana);
            ventana.cambiarPanel(nuevoPanel);

        }
        
    }
    
}
