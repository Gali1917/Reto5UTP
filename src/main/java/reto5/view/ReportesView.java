package reto5.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import reto5.controller.ReportesController;
import reto5.model.vo.ComprasVo;
import reto5.model.vo.ListaLideresVo;
import reto5.model.vo.ProyectosVo;

//Clase que contiene las propiedades de la ventana que extiende de JFrame e implementa de ActionListener para escuchar eventos
public class ReportesView extends JFrame implements ActionListener {

    private static ReportesController controller;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JLabel lblTitulo, lblConsulta;
    private JButton boton1, boton2, boton3;
    FondoPanel fondo = new FondoPanel();

    //Constructor donde se va agregando cada item a la ventana
    public ReportesView(){
        controller = new ReportesController();
        this.setContentPane(fondo);
        etiqueta1();
        etiqueta2();
        botonUno();
        botonDos();
        botonTres();
        tabla();
    }

    //Creacion de tabla
    public void tabla(){
        tabla = new JTable(modelo);
        tabla.setPreferredScrollableViewportSize(new Dimension(400, 190));
        tabla.setBackground(new Color(110, 153, 247));
        add(tabla);
        JScrollPane pane = new JScrollPane(tabla);
        add(pane);   
    }

    //Creacion de Botones
    public void botonUno(){
        boton1 = new JButton("Informe 1");
        boton1.setPreferredSize(new Dimension(120, 30));
        boton1.addActionListener(this);
        add(boton1);
    } 
    public void botonDos(){
        boton2 = new JButton("Informe 2");
        boton2.setPreferredSize(new Dimension(120, 30));
        boton2.addActionListener(this);
        add(boton2);
    } 
    public void botonTres(){
        boton3 = new JButton("Informe 3");
        boton3.setPreferredSize(new Dimension(120, 30));
        boton3.addActionListener(this);
        add(boton3);
    } 

    //Creacion de etiquetas para los titulos y texto.
    public void etiqueta1(){
        lblTitulo = new JLabel("Informe Reto 5");
        lblTitulo.setPreferredSize(new Dimension(500, 60));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(0);
        add(lblTitulo);
    }
    public void etiqueta2(){
        lblConsulta = new JLabel("Seleccione la busqueda: ");
        lblConsulta.setPreferredSize(new Dimension(750, 30)); 
        lblConsulta.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblConsulta);
    }

    //Se agregan titulos a la tabla y sus valores correspondientes a la consula SQL
    public void primerInforme() {
        try{
            List<ListaLideresVo> lideres = controller.listarLideres();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id Lider");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Ciudad");

            for(ListaLideresVo lider: lideres){
                Object[] fila = new Object[4];
                fila[0]= lider.getId();
                fila[1]= lider.getNombre();
                fila[2]= lider.getApellido();
                fila[3]= lider.getCiudad();   
                modelo.addRow(fila);                 
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged(); //Actualiza la tabla
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void segundoInforme() {
        try{
            List<ProyectosVo> proyectos = controller.listarProyectos();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id proyecto");
            modelo.addColumn("Constructora");
            modelo.addColumn("Habitaciones");
            modelo.addColumn("Ciudad");

            for(ProyectosVo proyecto: proyectos){
                Object[] fila = new Object[4];
                fila[0]= proyecto.getId();
                fila[1]= proyecto.getConstructora();
                fila[2]= proyecto.getHabitaciones();
                fila[3]= proyecto.getCiudad();   
                modelo.addRow(fila);                 
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
            
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void tercerInforme() {
        try{
            List<ComprasVo> compras = controller.listarCompras();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id Compra");
            modelo.addColumn("Constructora");
            modelo.addColumn("Banco");
       
            for(ComprasVo compra: compras){
                Object[] fila = new Object[3];
                fila[0] = compra.getId();
                fila[1] = compra.getConstructora();
                fila[2] = compra.getBanco();
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Sobrecarga del metodo "actionPerformed" para capturar el evento de los botones y llamar a sus metodos
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton1){
            primerInforme();
            lblConsulta.setText("Informe de lideres");
        }
        if(e.getSource() == boton2){
            segundoInforme();
            lblConsulta.setText("Informe de proyectos");
        }
        if(e.getSource() == boton3){
            tercerInforme();
            lblConsulta.setText("Informe de compras");
        }
    }
    
    //Clase interna para agregar el fondo a la ventana.
    public class FondoPanel extends JPanel{
        private Image imagen;

        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("../resources/images/background3.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
