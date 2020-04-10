/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.Control;
import huffman.huffmanInterface.Model;

/**
 *
 * @author Andrea
 */
public class Modelo implements Model{
    
    private Control control;
    private static Arbol arbol;
    
    public Modelo(){
        
    }

    public void setControl(Control control) {
        this.control = control;
    }
    
    
}
