package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Controller.Pedido;
import Model.GuardarCargarDatos;

public class PedidoPanel extends JPanel implements ActionListener{

    private JButton atrasBoton;
    private JScrollPane jScrollPane1;
    private JTable tabla;
    private JLabel tituloLabel;
    private Ventana ventana;
    private ArrayList<Pedido> pedido = new ArrayList<>();

    public PedidoPanel( Ventana ventana){
        this.ventana=ventana;
        pedido = GuardarCargarDatos.CargarLista(pedido, "src/datos/pedidos.dat");
        atrasBoton = new JButton();
        tituloLabel = new JLabel();
        jScrollPane1 = new JScrollPane();
        tabla = new JTable();

        setBackground(new Color(204, 204, 255));
        setLayout(null);

        atrasBoton.setFont(new Font("Comic Sans MS", 1, 24)); 
        atrasBoton.setForeground(new Color(51, 51, 255));
        atrasBoton.setText("Atras");
        add(atrasBoton);
        atrasBoton.setBounds(0, 380, 750, 80);
        atrasBoton.addActionListener(this);

        tituloLabel.setFont(new Font("Comic Sans MS", 1, 48)); 
        tituloLabel.setForeground(new Color(51, 51, 255));
        tituloLabel.setText("Pedidos");
        add(tituloLabel);
        tituloLabel.setBounds(20, 10, 400, 90);

        tabla.setModel(new javax.swing.table.DefaultTableModel(new String[]{"Producto","Proveedor","Precio","Cantidad"},pedido.size()){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        });
        for(int i = 0;i<pedido.size();i++){
            tabla.setValueAt(pedido.get(i).getMercancia().getNombre(), i, 0);
            tabla.setValueAt(pedido.get(i).precioTotal(),i,2);
            tabla.setValueAt(pedido.get(i).getCantidad(), i, 3);
            tabla.setValueAt(pedido.get(i).getMercancia().getProveedor(), i, 1);
        }

        jScrollPane1.setViewportView(tabla);//coloca la tabla dentro del scroll
        add(jScrollPane1);
        jScrollPane1.setBounds(60, 100, 620, 250);

    }

   
    public void actionPerformed(ActionEvent e) {
       
        EntradaPanel nuevo = new EntradaPanel(ventana);
        ventana.cambiarPanel(nuevo);
        
    }

    
}
