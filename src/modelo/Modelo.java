/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.Control;
import huffman.huffmanInterface;
import huffman.huffmanInterface.Model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Andrea
 */
public class Modelo implements Model{
    
    private huffmanInterface.Controller control;
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
        return dicc;
    }
    
    public ArrayList<Nodo> getLista(){
        return lista;
    }

    @Override
    public boolean containsByte(Byte b) {
       return dicc.containsKey(b);
    }

    @Override
    public void addAparicionNodo(Byte b) {
        dicc.replace(b, dicc.get(b), dicc.get(b)+1);
    }

    @Override
    public void createNewNodo(Byte b) {
        dicc.put(b, 1);
    }

    @Override
    public void createList() {
        for (Byte b : dicc.keySet()) {
            lista.add(new Fulla(b, dicc.get(b)));
        }
        Collections.sort(lista);
    }
}
