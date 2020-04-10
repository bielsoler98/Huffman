/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.Control;
import huffman.huffmanInterface.View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JToolBar;

/**
 *
 * @author Andrea
 */
public class Vista extends JFrame implements View{
    
    private static final int SIZE_X = 800; 
    private static final int SIZE_Y = 600; 
    private JProgressBar barraProg;
    private JToolBar barraTools;
    private Control control;
        
     public Vista() {
        initVista();
        initToolBar();
        initProgressBar();
        pack();
    }
    
    //Inicializa la ventana
    private void initVista(){
        setTitle("Seleccion de archivos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setPreferredSize(new Dimension(SIZE_X, SIZE_Y));
        setVisible(true);
    }
    
    //Añade la barra de progreso
    private void initProgressBar(){
        barraProg = new JProgressBar();
        barraProg.setValue(0);
        add(barraProg, BorderLayout.SOUTH);
    }
    
    //Cambia el valor de la barra de progreso
    public void progreso(int prog) {
        barraProg.setValue(prog);
    }
     
    //Pone a 0 el valor de la barra de progreso
    public void resetBar(){
        barraProg.setValue(0);
    } 
    
    //Añade los botones 
    private void initToolBar(){
        barraTools = new JToolBar();
        add(barraTools, BorderLayout.PAGE_START);
        barraTools.setFloatable(false);
        JButton select = new JButton("Seleccionar archivo");
        select.addActionListener((ActionEvent) -> {
          control.selectFile();
        });
        barraTools.add(select);
        barraTools.addSeparator();
    }

    public void setControl(Control control) {
        this.control = control;
    }
    
    
    
}
