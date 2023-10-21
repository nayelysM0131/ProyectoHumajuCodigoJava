package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controller.*;
import Model.GuardarCargarDatos;

public class PersonalPanel extends JPanel implements ActionListener  {
    private JLabel etiquetaContrasenna;
    private JLabel etiquetaNombre;
    private JTextField campoDeTextoContrasenna;
    private JTextField campoDeTextoNombre;
    private JButton botonEntrar;
    private JButton botonRegistrarse;
    private JButton botonAtras;
    private JRadioButton radioAsesor;
    private JRadioButton radioJefe;
    private JRadioButton radioAsistente;
    private Ventana ventana;
    private AsesorDeVentas asesorDeVentas;
    private AsistenteDeLogistica asistenteDeLogistica;
    private JefeDeLogistica jefeDeLogistica;
    private ButtonGroup grupoDeBotones;


    public PersonalPanel(Ventana ventana){
        this.ventana=ventana;
        asesorDeVentas=GuardarCargarDatos.cargarAV(asesorDeVentas,"src/datos/asesorDeVentas.dat");/*se guarda el elemento q devuelve el metodo en la variable q cree, 
        como el metodo es estatico se tiene q llamar, la clase en la q esta punto el nombre del metodo,(los argumentos) saca los datos de esa direccion y los guarda en la variable */
        jefeDeLogistica=GuardarCargarDatos.cargarJL(jefeDeLogistica,"src/datos/jefeDeLogistica.dat");
        asistenteDeLogistica=GuardarCargarDatos.cargarAL(asistenteDeLogistica,"src/datos/asistenteDeLogistica.dat");
        setVisible(true);
        setBackground(new Color(204,204,255));
        setLayout(null);

        etiquetaContrasenna = new JLabel();
        etiquetaContrasenna.setFont(new Font("Comic Sans MS", 3, 48));
        etiquetaContrasenna.setForeground(new Color(51, 51, 255));
        etiquetaContrasenna.setText("  Contraseña");
        add(etiquetaContrasenna);
        etiquetaContrasenna.setBounds(200, 160, 340, 50);

        etiquetaNombre = new JLabel();
        etiquetaNombre.setFont(new Font("Comic Sans MS", 3, 48)); 
        etiquetaNombre.setForeground(new Color(51, 51, 255));
        etiquetaNombre.setText("    Nombre");
        add(etiquetaNombre);
        etiquetaNombre.setBounds(190, 10, 340, 50);

        campoDeTextoContrasenna = new JTextField();
        campoDeTextoContrasenna.setFont(new Font("Tahoma", 0, 24)); 
        add(campoDeTextoContrasenna);
        campoDeTextoContrasenna.setBounds(160, 220, 410, 35);

        campoDeTextoNombre = new JTextField();
        campoDeTextoNombre.setFont(new Font("Tahoma", 0, 24)); 
        add(campoDeTextoNombre);
        campoDeTextoNombre.setBounds(160, 70, 410, 35);

        botonEntrar = new JButton();
        botonEntrar.setFont(new Font("Comic Sans MS", 3, 32)); 
        botonEntrar.setForeground(new Color(51, 51, 255));
        botonEntrar.setText("Entrar");
        add(botonEntrar);
        botonEntrar.setBounds(250, 400, 250, 60);
        botonEntrar.addActionListener(this);

        botonAtras = new JButton();
        botonAtras.setFont(new Font("Comic Sans MS", 3, 32)); 
        botonAtras.setForeground(new Color(51, 51, 255));
        botonAtras.setText("Atras");
        add(botonAtras);
        botonAtras.setBounds(500, 400, 250, 60);
        botonAtras.addActionListener(this);

        botonRegistrarse = new JButton();
        botonRegistrarse.setFont(new Font("Comic Sans MS", 3, 32)); 
        botonRegistrarse.setForeground(new Color(51, 51, 255));
        botonRegistrarse.setText("Registrarse");
        add(botonRegistrarse);
        botonRegistrarse.setBounds(0, 400, 250, 60);
        botonRegistrarse.addActionListener(this);

        
        radioAsesor = new JRadioButton();
        radioAsesor.setText("Asesor de ventas");
        radioAsesor.setBounds(60, 330, 150, 20);
        radioAsesor.setBackground(new Color(204,204,255));
        add(radioAsesor);

        radioJefe = new JRadioButton();
        radioJefe.setText("Jefe de logistica");
        radioJefe.setBounds(290, 330, 150, 20);
        radioJefe.setBackground(new Color(204,204,255));
        add(radioJefe);

        radioAsistente = new JRadioButton();
        radioAsistente.setText("Asistente de logistica");
        radioAsistente.setBounds(540, 330, 250, 20);
        radioAsistente.setBackground(new Color(204,204,255));
        add(radioAsistente);

        grupoDeBotones = new ButtonGroup();
        grupoDeBotones.add(radioAsesor);
        grupoDeBotones.add(radioJefe);
        grupoDeBotones.add(radioAsistente);
        
    }

   
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonRegistrarse){
            
            if( campoDeTextoContrasenna.getText().isEmpty()||campoDeTextoNombre.getText().isEmpty()){ //si el texto del campo esta vacio
                
                JOptionPane.showMessageDialog(null, "LLene todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);

            }else if(!radioAsesor.isSelected()&&!radioAsistente.isSelected()&&!radioJefe.isSelected()){//si se pone || en vez de && se van a tener q seleccionar los 3 para poder acceder, y no es eso lo q queremos
               
                JOptionPane.showMessageDialog(null, "Selecciona el cargo en el que desea registrarse", "Advertencia", JOptionPane.WARNING_MESSAGE);

            }else if((radioAsesor.isSelected()&&!asesorDeVentas.getNombre().isEmpty())||(radioAsistente.isSelected()&&!asistenteDeLogistica.getNombre().isEmpty())||(radioJefe.isSelected()&&!jefeDeLogistica.getNombre().isEmpty())){

                JOptionPane.showMessageDialog(null, "Ya existe ese empleado", "Advertencia", JOptionPane.WARNING_MESSAGE);

            }else if(radioAsesor.isSelected()){

                asesorDeVentas.setNombre(campoDeTextoNombre.getText());
                asesorDeVentas.setCodigo(campoDeTextoContrasenna.getText());
                GuardarCargarDatos.GuardarComponente(asesorDeVentas, "src/datos/asesorDeVentas.dat");//registra al empleado, como el metodo no devuelve nada no se guarda nada en ninguna variable 
                AsesorDeVentasPanel nuevo = new AsesorDeVentasPanel(ventana);
                ventana.cambiarPanel(nuevo);

            }else if(radioAsistente.isSelected()){
                
            asistenteDeLogistica.setNombre(campoDeTextoNombre.getText());
            asistenteDeLogistica.setCodigo(campoDeTextoContrasenna.getText());
            GuardarCargarDatos.GuardarComponente(asistenteDeLogistica, "src/datos/asistenteDeLogistica.dat");//registra al empleado, como el metodo no devuelve nada no se guarda nada en ninguna variable 
            AsistenteDeLogisticaPanel nuevo = new AsistenteDeLogisticaPanel(ventana);
            ventana.cambiarPanel(nuevo);

        }else if(radioJefe.isSelected()){
            jefeDeLogistica.setNombre(campoDeTextoNombre.getText());
            jefeDeLogistica.setCodigo(campoDeTextoContrasenna.getText());
            GuardarCargarDatos.GuardarComponente(jefeDeLogistica, "src/datos/jefeDeLogistica.dat");
            JefeDeLogisticaPanel nuevo = new JefeDeLogisticaPanel(ventana);
            ventana.cambiarPanel(nuevo);
        }

        
        }else if(e.getSource()==botonAtras){

            EntradaPanel nuevo = new EntradaPanel(ventana);
            ventana.cambiarPanel(nuevo);
            
        }else{

            if(campoDeTextoNombre.getText().equals(asesorDeVentas.getNombre())&&campoDeTextoContrasenna.getText().equals(asesorDeVentas.getCodigo())){
                AsesorDeVentasPanel nuevo = new AsesorDeVentasPanel(ventana);
                ventana.cambiarPanel(nuevo);
            }else if(campoDeTextoNombre.getText().equals(asistenteDeLogistica.getNombre())&&campoDeTextoContrasenna.getText().equals(asistenteDeLogistica.getCodigo())){
                AsistenteDeLogisticaPanel nuevo = new AsistenteDeLogisticaPanel(ventana);
                ventana.cambiarPanel(nuevo);
            }else if(campoDeTextoNombre.getText().equals(jefeDeLogistica.getNombre())&&campoDeTextoContrasenna.getText().equals(jefeDeLogistica.getCodigo())){
                JefeDeLogisticaPanel nuevo = new JefeDeLogisticaPanel(ventana);
                ventana.cambiarPanel(nuevo);
            }else{
                JOptionPane.showMessageDialog(null, "Usuario Invalido", "Advertencia", JOptionPane.WARNING_MESSAGE);

            }
            

        }
        
        
    }
    
    }


        

    
    
