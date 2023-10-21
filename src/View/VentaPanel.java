package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import Controller.Producto;
import Controller.Venta;
import Model.GuardarCargarDatos;

public class VentaPanel extends JPanel implements MouseListener, ActionListener{

    private JButton atrasBoton;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JButton registrarBoton;
    private JTable tabla;
    private JTable tabla2;
    private JLabel tituloLabel;
    private ArrayList<Venta> ventas = new ArrayList<>();
    private Ventana ventana;

    public VentaPanel(Ventana ventana){

        this.ventana=ventana;
        ventas = GuardarCargarDatos.CargarLista(ventas, "src/datos/ventas.dat");

        atrasBoton = new JButton();
        tituloLabel = new JLabel();
        registrarBoton = new JButton();
        jScrollPane1 = new JScrollPane();
        jScrollPane2 = new JScrollPane();
        tabla = new JTable();
        tabla2 = new JTable();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(null);

        atrasBoton.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); 
        atrasBoton.setForeground(new java.awt.Color(51, 51, 255));
        atrasBoton.setText("Atras");
        add(atrasBoton);
        atrasBoton.setBounds(380, 380, 370, 80);
        atrasBoton.addActionListener(this);

        tituloLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); 
        tituloLabel.setForeground(new java.awt.Color(51, 51, 255));
        tituloLabel.setText("Ventas");
        add(tituloLabel);
        tituloLabel.setBounds(20, 10, 400, 90);

        registrarBoton.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); 
        registrarBoton.setForeground(new java.awt.Color(51, 51, 255));
        registrarBoton.setText("Registrar venta");
        add(registrarBoton);
        registrarBoton.setBounds(0, 380, 380, 80);
        registrarBoton.addActionListener(this);

        tabla.setModel(new javax.swing.table.DefaultTableModel(new String[]{"Cliente","Importe"},ventas.size()){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        });
        for (int i = 0; i < ventas.size(); i++) {
            tabla.setValueAt(ventas.get(i).getCliente().getNombre(), i, 0);
            tabla.setValueAt(ventas.get(i).calcularImporte(), i, 1);
        }
        tabla.addMouseListener(this);
        jScrollPane1.setViewportView(tabla);
        add(jScrollPane1);
        jScrollPane1.setBounds(20, 110, 345, 260);

        tabla2.setModel(new javax.swing.table.DefaultTableModel(new String[]{"Producto","Cantidad"},ventas.size()){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        });
        jScrollPane2.setViewportView(tabla2);
        add(jScrollPane2);
        jScrollPane2.setBounds(365, 110, 345, 260);
    }

    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==registrarBoton){

            RegistrarVentaPanel nuevoPanel = new RegistrarVentaPanel(ventana);

            ventana.cambiarPanel(nuevoPanel);

        }else{

            AsesorDeVentasPanel nuevoPanel = new AsesorDeVentasPanel(ventana);

            ventana.cambiarPanel(nuevoPanel);

        }
        
    }


    public void mouseReleased(MouseEvent e) {//levantar el mause, proceso de hace un click 
        
        ArrayList<Producto> productos = ventas.get(tabla.rowAtPoint(e.getPoint())).getMercancia();
       
        tabla2.setModel(new javax.swing.table.DefaultTableModel(new String[]{"Producto","Cantidad"},productos.size()){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        });
        
        for (int i = 0; i < productos.size(); i++) {//obtengo de la lista venta la posicion de la fila q toque, y de esa venta la lista de productos
            
            tabla2.setValueAt(productos.get(i).getNombre(), i, 0);
            tabla2.setValueAt(productos.get(i).getCantidad(), i, 1);

        }
        
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }



   
    
    
}
