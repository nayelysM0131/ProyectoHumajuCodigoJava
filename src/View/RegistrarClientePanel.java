package View;

import javax.swing.*;

import Controller.Cliente;
import Model.GuardarCargarDatos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistrarClientePanel extends JPanel implements ActionListener{
    
    private JButton atrasBoton;
    private JTextField ciCampo;
    private JLabel ciLabel;
    private JTextField nombreCampo;
    private JLabel nombreLabel;
    private JButton registrarBoton;
    private JLabel tituloLabel;
    private Ventana ventana;
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public RegistrarClientePanel(Ventana ventana){

        this.ventana=ventana;
        setLayout(null);
        setBackground(new Color(204,204,255));

        atrasBoton = new JButton();
        tituloLabel = new JLabel();
        nombreCampo = new JTextField();
        nombreLabel = new JLabel();
        ciCampo = new JTextField();
        ciLabel = new JLabel();
        registrarBoton = new JButton();
        clientes = GuardarCargarDatos.CargarLista(clientes, "src/datos/clientes.dat");

        atrasBoton.setFont(new Font("Comic Sans MS", 1, 24)); 
        atrasBoton.setForeground(new Color(51, 51, 255));
        atrasBoton.setText("Atras");
        atrasBoton.setActionCommand("Atras");
        add(atrasBoton);
        atrasBoton.setBounds(380, 380, 370, 80);
        atrasBoton.addActionListener(this);

        tituloLabel.setFont(new Font("Comic Sans MS", 1, 48)); 
        tituloLabel.setForeground(new Color(51, 51, 255));
        tituloLabel.setText("Registrar Cliente");
        add(tituloLabel);
        tituloLabel.setBounds(20, 10, 400, 90);

        nombreCampo.setFont(new Font("Comic Sans MS", 1, 14)); 
        nombreCampo.setForeground(new Color(51, 51, 255));
        add(nombreCampo);
        nombreCampo.setBounds(180, 240, 150, 27);

        nombreLabel.setFont(new Font("Comic Sans MS", 1, 18)); 
        nombreLabel.setForeground(new Color(51, 51, 255));
        nombreLabel.setText("Nombre : ");
        add(nombreLabel);
        nombreLabel.setBounds(80, 240, 92, 26);

        ciCampo.setFont(new Font("Comic Sans MS", 1, 14)); 
        ciCampo.setForeground(new Color(51, 51, 255));
        add(ciCampo);
        ciCampo.setBounds(500, 240, 150, 27);

        ciLabel.setFont(new Font("Comic Sans MS", 1, 18)); 
        ciLabel.setForeground(new Color(51, 51, 255));
        ciLabel.setText("Carnet Id : ");
        add(ciLabel);
        ciLabel.setBounds(382, 240, 110, 26);

        registrarBoton.setFont(new Font("Comic Sans MS", 1, 24)); 
        registrarBoton.setForeground(new Color(51, 51, 255));
        registrarBoton.setText("Registrar");
        add(registrarBoton);
        registrarBoton.setBounds(0, 380, 380, 80);
        registrarBoton.addActionListener(this);

    }

    
    public void actionPerformed(ActionEvent e) {

        boolean existe = false;
        if(clientes.size()!=0){
        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getCi().equals(ciCampo.getText())){
                existe=true;
            }
        }
        }   
       
        if(e.getSource()==registrarBoton){

            if(nombreCampo.getText().isEmpty()||ciCampo.getText().isEmpty()){

                JOptionPane.showMessageDialog(null, "LLene todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);

            }else if(existe==true){

                JOptionPane.showMessageDialog(null, "El cliente ya esta en el sistema", "Advertencia", JOptionPane.WARNING_MESSAGE);

            }else{

                Cliente nuevoCliente = new Cliente(nombreCampo.getText(), ciCampo.getText());
                clientes.add(nuevoCliente);
                GuardarCargarDatos.GuardarLista(clientes, "src/datos/clientes.dat");

                JOptionPane.showMessageDialog(null, "Cliente registrado con exito", "Advertencia", JOptionPane.WARNING_MESSAGE);

                AsesorDeVentasPanel nuevoPanel = new AsesorDeVentasPanel(ventana);
                ventana.cambiarPanel(nuevoPanel);

            }

        }else{

            AsesorDeVentasPanel nuevoPanel = new AsesorDeVentasPanel(ventana);

            ventana.cambiarPanel(nuevoPanel);

        }
        
    }

}
