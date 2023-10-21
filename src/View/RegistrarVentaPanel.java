package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Guard;
import java.util.ArrayList;

import Controller.Cliente;
import Controller.Producto;
import Controller.Venta;
import Model.GuardarCargarDatos;

public class RegistrarVentaPanel extends JPanel implements ActionListener {
    
    private JButton agregarBoton;
    private JButton atrasBoton;
    private JTextField cantidadCampo;
    private JLabel cantidadLabel;
    private JScrollPane jScrollPane1;
    private JComboBox<String> productoComboBox;
    private JLabel productoLabel;
    private JButton registrarBoton;
    private JTable tabla;
    private JLabel tituloLabel;
    private JComboBox<String> clienteComboBox;
    private JLabel clienteLabel;
    private ArrayList<Producto> mercancia = new ArrayList<>();//para llenar el combobox
    private ArrayList<Cliente> clientes = new ArrayList<>();//para llenar el combobox 
    private Ventana ventana;
    private ArrayList<Venta> ventas = new ArrayList<>();//para guardar las ventas cuando selecciones el boton registar  
    private ArrayList<Producto> carrito = new ArrayList<>();
    int fila = 0;
    private ArrayList<Integer> posiciones = new ArrayList<>();
    private ArrayList<Integer> cantidades = new ArrayList<>();

    public RegistrarVentaPanel(Ventana ventana){

        this.ventana=ventana;
        mercancia = GuardarCargarDatos.CargarLista(mercancia,"src/datos/mercancia.dat");//cargando la mercancia del almacen para llenar la combobox
        clientes = GuardarCargarDatos.CargarLista(clientes,"src/datos/clientes.dat");
        ventas = GuardarCargarDatos.CargarLista(ventas, "src/datos/ventas.dat");

        atrasBoton = new JButton();
        tituloLabel = new JLabel();
        cantidadCampo = new JTextField();
        productoLabel = new JLabel();
        agregarBoton = new JButton();
        cantidadLabel = new JLabel();
        productoComboBox = new JComboBox();
        registrarBoton = new JButton();
        jScrollPane1 = new JScrollPane();
        tabla = new JTable();
        clienteLabel = new JLabel();
        clienteComboBox = new JComboBox();

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
        tituloLabel.setText("Registrar Venta");
        add(tituloLabel);
        tituloLabel.setBounds(20, 10, 400, 90);

        cantidadCampo.setFont(new Font("Comic Sans MS", 1, 14)); 
        cantidadCampo.setForeground(new Color(51, 51, 255));
        add(cantidadCampo);
        cantidadCampo.setBounds(540, 270, 150, 27);

        productoLabel.setFont(new Font("Comic Sans MS", 1, 18)); 
        productoLabel.setForeground(new Color(51, 51, 255));
        productoLabel.setText("Producto : ");
        add(productoLabel);
        productoLabel.setBounds(430, 190, 110, 26);

        agregarBoton.setFont(new Font("Comic Sans MS", 1, 18)); 
        agregarBoton.setForeground(new Color(51, 51, 255));
        agregarBoton.setText("Agregar a la compra");
        add(agregarBoton);
        agregarBoton.setBounds(430, 340, 270, 30);
        agregarBoton.addActionListener(this);

        cantidadLabel.setFont(new Font("Comic Sans MS", 1, 18)); 
        cantidadLabel.setForeground(new Color(51, 51, 255));
        cantidadLabel.setText("Cantidad : ");
        add(cantidadLabel);
        cantidadLabel.setBounds(430, 270, 110, 26);

        productoComboBox.setForeground(new Color(51, 51, 255));
        productoComboBox.setMaximumRowCount(mercancia.size());
        productoComboBox.setModel(new DefaultComboBoxModel<>(new String[] {}));
        for(int i = 0;i<mercancia.size();i++){
            productoComboBox.addItem(mercancia.get(i).getNombre());
        }
        add(productoComboBox);
        productoComboBox.setBounds(540, 190, 150, 30);

        registrarBoton.setFont(new Font("Comic Sans MS", 1, 24)); 
        registrarBoton.setForeground(new Color(51, 51, 255));
        registrarBoton.setText("Registrar");
        add(registrarBoton);
        registrarBoton.setBounds(0, 380, 380, 80);
        registrarBoton.addActionListener(this);

        clienteLabel.setFont(new Font("Comic Sans MS", 1, 18)); 
        clienteLabel.setForeground(new Color(51, 51, 255));
        clienteLabel.setText("Cliente : ");
        add(clienteLabel);
        clienteLabel.setBounds(430, 110, 110, 26);

        clienteComboBox.setForeground(new Color(51, 51, 255));
        clienteComboBox.setMaximumRowCount(clientes.size());
        clienteComboBox.setModel(new DefaultComboBoxModel<>(new String[] {}));
        for(int j = 0;j<clientes.size();j++){
            clienteComboBox.addItem(clientes.get(j).getNombre());
        }
        add(clienteComboBox);
        clienteComboBox.setBounds(540, 110, 150, 30);

        tabla.setModel(new javax.swing.table.DefaultTableModel(new String[]{"Producto","Cantidad"},mercancia.size()){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        });
        jScrollPane1.setViewportView(tabla);
        add(jScrollPane1);
        jScrollPane1.setBounds(20, 110, 370, 260);
        
    }

 
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==agregarBoton){
            if(cantidadCampo.getText().isEmpty() || clientes.size()==0 || mercancia.size()==0){
                JOptionPane.showMessageDialog(null, "LLene todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }else if(Integer.parseInt(cantidadCampo.getText())> mercancia.get(productoComboBox.getSelectedIndex()).getCantidad()){//convierto la cantidad de la cajita a entero y voy al almacen a buscar el producto seleccionado en la cajita , y comparo cantidades
                JOptionPane.showMessageDialog(null, "No disponemos de tal cantidad de ese producto", "Advertencia", JOptionPane.WARNING_MESSAGE);  
            }else{
                Producto producto = mercancia.get(productoComboBox.getSelectedIndex());
                producto.setCantidad(Integer.parseInt(cantidadCampo.getText()));
                tabla.setValueAt(producto.getNombre(), fila , 0);
                tabla.setValueAt(producto.getCantidad(), fila , 1);
                fila++;
                posiciones.add(productoComboBox.getSelectedIndex());//guarda en la lista posiciones la  posicion del producto que se selecciono en la cajita
                cantidades.add(producto.getCantidad());
                mercancia.remove(mercancia.get(productoComboBox.getSelectedIndex()));//para eliminar el producto ya seleccionado de la lista del almacen para q sigan coincidiendo las posiciones d los productos
                /////////productoComboBox.remove(productoComboBox.getSelectedIndex());//para eliminar el producto ya seleccionado de la cajita
                productoComboBox.setModel(new DefaultComboBoxModel<>(new String[] {}));
                for(int i = 0;i<mercancia.size();i++){
                    productoComboBox.addItem(mercancia.get(i).getNombre());
                }
                carrito.add(producto);
                cantidadCampo.setText("");//limpia el campo cantidad cuando agrega el producto
            }
        }else if(e.getSource()==registrarBoton){
            
            if(posiciones.size()!=0){
                Venta venta = new Venta(carrito,clientes.get(clienteComboBox.getSelectedIndex()));
                ventas.add(venta);
                GuardarCargarDatos.GuardarLista(ventas, "src/datos/ventas.dat");
                mercancia=GuardarCargarDatos.CargarLista(mercancia, "src/datos/mercancia.dat");//vuelve a cargar lo q esta en el almacen
                for (int i = 0; i < posiciones.size(); i++) {
                    mercancia.get(posiciones.get(i)).setCantidad(mercancia.get(posiciones.get(i)).getCantidad()-cantidades.get(i));//
                }
                GuardarCargarDatos.GuardarLista(mercancia, "src/datos/mercancia.dat");
    
                VentaPanel nuevoPanel = new VentaPanel(ventana);
                ventana.cambiarPanel(nuevoPanel);    

            }else{
                JOptionPane.showMessageDialog(null, "Agregue algun producto al carrito", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
        }else{

            VentaPanel nuevoPanel = new VentaPanel(ventana);

            ventana.cambiarPanel(nuevoPanel);

        }

        
    }

}
