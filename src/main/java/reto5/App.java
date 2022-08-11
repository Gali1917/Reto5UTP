package reto5;

import reto5.view.ReportesView;
import java.awt.*;
import javax.swing.JFrame;
public class App{

    //Funcion principal donde dibujara la ventana
    public static void main( String[] args )
    {
        ReportesView reportesView = new ReportesView();
        reportesView.setLayout(new FlowLayout(1, 90, 30));
        reportesView.setSize(800, 600);
        reportesView.setVisible(true);
        reportesView.setResizable(false);
        reportesView.setTitle("Ejercicio Reto 5");
        reportesView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reportesView.setLocationRelativeTo(null); 
    }
}

