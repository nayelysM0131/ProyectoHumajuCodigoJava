package View;

import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.Producto;
import Model.GuardarCargarDatos;

public class AlmacenPanel extends JPanel implements ActionListener {

    private JButton atrasBoton;
    private JScrollPane jScrollPane1;
    private JTable tabla;
    private JLabel tituloLabel;
    private Ventana ventana;
    private ArrayList<Producto> mercancia = new ArrayList<>();

    public AlmacenPanel( Ventana ventana){
        this.ventana=ventana;
        mercancia = GuardarCargarDatos.CargarLista(mercancia, "src/datos/mercancia.dat");
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
        tituloLabel.setText("Almacen");
        add(tituloLabel);
        tituloLabel.setBounds(20, 10, 400, 90);

        tabla.setModel(new javax.swing.table.DefaultTableModel(new String[]{"Producto","Proveedor","Precio De Venta","Cantidad"},mercancia.size()){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        });
        for(int i = 0;i<mercancia.size();i++){
            tabla.setValueAt(mercancia.get(i).getNombre(), i, 0);
            tabla.setValueAt(mercancia.get(i).getPrecio(),i,2);
            tabla.setValueAt(mercancia.get(i).getCantidad(), i, 3);
            tabla.setValueAt(mercancia.get(i).getProveedor(), i, 1);
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
