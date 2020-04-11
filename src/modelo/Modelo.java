/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.Control;
import huffman.huffmanInterface.Model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Andrea
 */
public class Modelo implements Model{
    
    private Control control;
    private ArrayList<Nodo> lista;
    private HashMap<Byte,Integer> dicc;
    
    public Modelo(){
        lista = new ArrayList<>();
        dicc= new HashMap<>();
    }

    public void setControl(Control control) {
        this.control = control;
    }

    public HashMap<Byte,Integer> getDicc() {
        return this.dicc;
    }
    
    public ArrayList<Nodo> getLista(){
        return this.lista;
    }

    public boolean containsByte(Byte b) {
       if(dicc.containsKey(b)) return true;
       return false;
    }

    public void addAparicionNodo(Byte b) {
        dicc.replace(b, dicc.get(b).intValue(), dicc.get(b).intValue()+1);
    }

    public void createNewNodo(Byte b) {
        dicc.put(b, 1);
    }

    public void createList() {
        for (Byte b : this.dicc.keySet()) {
            this.lista.add(new Nodo(b,this.dicc.get(b),null,null));
        }
        Collections.sort(this.lista);
    }
    
    
    
   
    
    
    
    
}
