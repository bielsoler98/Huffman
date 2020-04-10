/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import control.Control;
import modelo.Modelo;
import vista.Vista;

/**
 *
 * @author biels
 */
public class Huffman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Control control = null;
        Modelo model = new Modelo();
        Vista vista = new Vista();
        control = new Control(vista, model);
        vista.setControl(control);
        model.setControl(control);
    }
    
}
