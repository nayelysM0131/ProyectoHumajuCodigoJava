package View;

import javax.swing.*;

import Controller.*;
import Model.GuardarCargarDatos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarPanel extends JPanel implements ActionListener{

    private JButton editarBoton;
    private JButton atrasBoton;
    private JLabel nombreLabel;
    private JLabel codigoLabel;
    private JTextField nombreCampo;
    private JTextField codigoCampo;
    private Ventana ventana;
    private String cargo;
    AsesorDeVentas asesor;
    JefeDeLogistica jefe;
    AsistenteDeLogistica asistente;

    public EditarPanel(Ventana ventana , String cargo){

        this.ventana=ventana;
        this.cargo=cargo;

        editarBoton = new JButton();
        atrasBoton = new JButton();
        nombreLabel = new JLabel();
        codigoLabel = new JLabel();
        nombreCampo = new JTextField();
        codigoCampo = new JTextField();

        setBackground(new Color(204,204,255));
        setLayout(null);

        codigoLabel = new JLabel();
        codigoLabel.setFont(new Font("Comic Sans MS", 3, 48));
        codigoLabel.setForeground(new Color(51, 51, 255));
        codigoLabel.setText("  Contraseña");
        add(codigoLabel);
        codigoLabel.setBounds(200, 160, 340, 50);

        nombreLabel = new JLabel();
        nombreLabel.setFont(new Font("Comic Sans MS", 3, 48)); 
        nombreLabel.setForeground(new Color(51, 51, 255));
        nombreLabel.setText("    Nombre");
        add(nombreLabel);
        nombreLabel.setBounds(190, 10, 340, 50);

        codigoCampo = new JTextField();
        codigoCampo.setFont(new Font("Tahoma", 0, 24)); 
        add(codigoCampo);
        codigoCampo.setBounds(160, 220, 410, 35);

        nombreCampo = new JTextField();
        nombreCampo.setFont(new Font("Tahoma", 0, 24)); 
        add(nombreCampo);
        nombreCampo.setBounds(160, 70, 410, 35);

        editarBoton = new JButton();
        editarBoton.setFont(new Font("Comic Sans MS", 3, 32)); 
        editarBoton.setForeground(new Color(51, 51, 255));
        editarBoton.setText("Editar");
        add(editarBoton);
        editarBoton.setBounds(0, 400, 375, 60);
        editarBoton.addActionListener(this);

        atrasBoton = new JButton();
        atrasBoton.setFont(new Font("Comic Sans MS", 3, 32)); 
        atrasBoton.setForeground(new Color(51, 51, 255));
        atrasBoton.setText("Atras");
        add(atrasBoton);
        atrasBoton.setBounds(375, 400, 375, 60);
        atrasBoton.addActionListener(this);


    }

    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==editarBoton){

            if( codigoCampo.getText().isEmpty()||nombreCampo.getText().isEmpty()){ //si el texto del campo esta vacio
                
                JOptionPane.showMessageDialog(null, "LLene todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);

            }else{

            if(cargo.equals("Asesor")){

                asesor = GuardarCargarDatos.cargarAV(asesor, "src/datos/asesorDeVentas.dat");
                asesor.setNombre(nombreCampo.getText());
                asesor.setCodigo(codigoCampo.getText());
                GuardarCargarDatos.GuardarComponente(asesor,"src/datos/asesorDeVentas.dat");

                AsesorDeVentasPanel nuevoPanel = new AsesorDeVentasPanel(ventana);
                ventana.cambiarPanel(nuevoPanel);

            }else if(cargo.equals("Jefe")){

                jefe = GuardarCargarDatos.cargarJL(jefe, "src/datos/jefeDeLogistica.dat");
                jefe.setNombre(nombreCampo.getText());
                jefe.setCodigo(codigoCampo.getText());
                GuardarCargarDatos.GuardarComponente(jefe,"src/datos/jefeDeLogistica.dat");

                JefeDeLogisticaPanel nuevoPanel = new JefeDeLogisticaPanel(ventana);
                ventana.cambiarPanel(nuevoPanel);

            }else{

                asistente = GuardarCargarDatos.cargarAL(asistente, "src/datos/asistenteDeLogistica.dat");
                asistente.setNombre(nombreCampo.getText());
                asistente.setCodigo(codigoCampo.getText());
                GuardarCargarDatos.GuardarComponente(asistente,"src/datos/asistenteDeLogistica.dat");

                AsistenteDeLogisticaPanel nuevoPanel = new AsistenteDeLogisticaPanel(ventana);
                ventana.cambiarPanel(nuevoPanel);
                
            }
        }

        }else{

            if(cargo.equals("Asesor")){

                AsesorDeVentasPanel nuevoPanel = new AsesorDeVentasPanel(ventana);
                ventana.cambiarPanel(nuevoPanel);

            }else if(cargo.equals("Jefe")){

                JefeDeLogisticaPanel nuevoPanel = new JefeDeLogisticaPanel(ventana);
                ventana.cambiarPanel(nuevoPanel);

            }else{

                AsistenteDeLogisticaPanel nuevoPanel = new AsistenteDeLogisticaPanel(ventana);
                ventana.cambiarPanel(nuevoPanel);

            }

        }
        
    }

    
}
