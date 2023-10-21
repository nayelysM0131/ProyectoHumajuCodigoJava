package View;

import javax.swing.*;

import Controller.Producto;
import Model.GuardarCargarDatos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistrtarProductoPanel extends JPanel implements ActionListener {

    private JButton atrasBoton;
    private JTextField cantidadCampo;
    private JLabel cantidadLabel;
    private JTextField nombreCampo;
    private JLabel nombreLabel;
    private JTextField precioCampo;
    private JLabel precioLabel;
    private JTextField proveedorCampo;
    private JLabel proveedorLabel;
    private JButton registrarBoton;
    private JLabel tituloLabel;
    private Ventana ventana;
    private ArrayList<Producto> mercancia = new ArrayList<>();


    public RegistrtarProductoPanel(Ventana ventana){

        atrasBoton = new JButton();
        tituloLabel = new JLabel();
        nombreCampo = new JTextField();
        nombreLabel = new JLabel();
        cantidadCampo = new JTextField();
        cantidadLabel = new JLabel();
        registrarBoton = new JButton();
        precioCampo = new JTextField();
        precioLabel = new JLabel();
        proveedorCampo = new JTextField();
        proveedorLabel = new JLabel();
        this.ventana= ventana;
        mercancia = GuardarCargarDatos.CargarLista(mercancia, "src/datos/mercancia.dat");

        setBackground(new Color(204, 204, 255));
        setLayout(null);

        atrasBoton.setFont(new Font("Comic Sans MS", 1, 24)); 
        atrasBoton.setForeground(new Color(51, 51, 255));
        atrasBoton.setText("Atras");
        atrasBoton.setActionCommand("Atras");
        add(atrasBoton);
        atrasBoton.setBounds(380, 380, 370, 80);
        atrasBoton.addActionListener(this);

        tituloLabel.setFont(new Font("Comic Sans MS", 1, 48)); 
        tituloLabel.setForeground(new Color(51, 51, 255));
        tituloLabel.setText("Registrar Producto");
        add(tituloLabel);
        tituloLabel.setBounds(20, 10, 600, 90);

        nombreCampo.setFont(new Font("Comic Sans MS", 1, 14)); 
        nombreCampo.setForeground(new Color(51, 51, 255));
        add(nombreCampo);
        nombreCampo.setBounds(340, 130, 150, 27);

        nombreLabel.setFont(new Font("Comic Sans MS", 1, 18)); 
        nombreLabel.setForeground(new Color(51, 51, 255));
        nombreLabel.setText("Nombre : ");
        add(nombreLabel);
        nombreLabel.setBounds(240, 130, 92, 26);

        cantidadCampo.setFont(new Font("Comic Sans MS", 1, 14)); 
        cantidadCampo.setForeground(new Color(51, 51, 255));
        add(cantidadCampo);
        cantidadCampo.setBounds(340, 200, 150, 27);

        cantidadLabel.setFont(new Font("Comic Sans MS", 1, 18)); 
        cantidadLabel.setForeground(new Color(51, 51, 255));
        cantidadLabel.setText("Cantidad : ");
        add(cantidadLabel);
        cantidadLabel.setBounds(230, 200, 110, 26);

        registrarBoton.setFont(new Font("Comic Sans MS", 1, 24)); 
        registrarBoton.setForeground(new Color(51, 51, 255));
        registrarBoton.setText("Registrar");
        add(registrarBoton);
        registrarBoton.setBounds(0, 380, 380, 80);
        registrarBoton.addActionListener(this);

        precioCampo.setFont(new Font("Comic Sans MS", 1, 14)); 
        precioCampo.setForeground(new Color(51, 51, 255));
        add(precioCampo);
        precioCampo.setBounds(340, 270, 150, 27);

        precioLabel.setFont(new Font("Comic Sans MS", 1, 18)); 
        precioLabel.setForeground(new Color(51, 51, 255));
        precioLabel.setText("Precio De Venta : ");
        add(precioLabel);
        precioLabel.setBounds(160, 270, 180, 26);

        proveedorCampo.setFont(new Font("Comic Sans MS", 1, 14)); 
        proveedorCampo.setForeground(new Color(51, 51, 255));
        add(proveedorCampo);
        proveedorCampo.setBounds(340, 330, 150, 27);

        proveedorLabel.setFont(new Font("Comic Sans MS", 1, 18)); 
        proveedorLabel.setForeground(new Color(51, 51, 255));
        proveedorLabel.setText("Proveedor : ");
        add(proveedorLabel);
        proveedorLabel.setBounds(213, 330, 180, 26);


    }


 
    public void actionPerformed(ActionEvent e) {
        

if(e.getSource()==registrarBoton){

    boolean existe = false;
        if(mercancia.size()!=0){
            for (int i = 0; i < mercancia.size(); i++) {
                if(mercancia.get(i).getNombre().equals(nombreCampo.getText())){
                    existe=true;
                }
            }
        }

    if(nombreCampo.getText().isEmpty()||cantidadCampo.getText().isEmpty()||precioCampo.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "LLene todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }else if(existe==true){
        JOptionPane.showMessageDialog(null, "El producto ya ha sido registrado antes", "Advertencia", JOptionPane.WARNING_MESSAGE);
        nombreCampo.setText("");
        cantidadCampo.setText("");
        precioCampo.setText("");
        proveedorCampo.setText("");
    }else{

        int precio = Integer.parseInt(precioCampo.getText());//convierte un String a entero, todo lo que se escribe en un campo de texto es String
        int cantidad = Integer.parseInt(cantidadCampo.getText());// por tanto hay q convertirlo a entero

        Producto producto = new Producto(nombreCampo.getText(), cantidad , precio,proveedorCampo.getText());

        mercancia.add(producto);
        GuardarCargarDatos.GuardarLista(mercancia, "src/datos/mercancia.dat");

        JOptionPane.showMessageDialog(null, "El producto ha sido registrado con exito", "Advertencia", JOptionPane.WARNING_MESSAGE);

        nombreCampo.setText("");
        cantidadCampo.setText("");
        precioCampo.setText("");
        proveedorCampo.setText("");
    }

}else{

    AsistenteDeLogisticaPanel nuevoPanel = new AsistenteDeLogisticaPanel(ventana);

    ventana.cambiarPanel(nuevoPanel);

}

    }
    
}
