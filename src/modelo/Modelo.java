/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.Control;
import huffman.huffmanInterface.Model;
import java.util.ArrayList;

/**
 *
 * @author Andrea
 */
public class Modelo implements Model{
    
    private Control control;
    private ArrayList<Nodo> lista;
    
    public Modelo(){
        lista = new ArrayList<>();
    }

    public void setControl(Control control) {
        this.control = control;
    }
    
    public void addNodo(Byte b, int n, Nodo dch, Nodo izq){
        Nodo nodo = new Nodo(b,n,dch,izq);
        lista.add(nodo);
    }

    public ArrayList<Nodo> getLista() {
        return lista;
    }
    
    
    
}
