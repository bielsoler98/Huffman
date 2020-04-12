/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import huffman.huffmanInterface;
import modelo.Modelo;
import vista.Vista;
import huffman.huffmanInterface.Controller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Fulla;
import modelo.Nodo;

/**
 *
 * @author Andrea
 */
public class Control implements Controller{
    
    private huffmanInterface.View vista;
    private huffmanInterface.Model modelo;
    
    public Control(Vista vista, Modelo modelo){
        this.vista=vista;
        this.modelo=modelo;
    }
    
    
    private void readFile(File file){
        try {
            for(byte b : Files.readAllBytes(file.toPath())){
                addToDicc(b);
            }
        } catch (IOException ex) {
            vista.ioexception(ex.toString());
        }
    }
    
    private void addToDicc(Byte b){
        if(modelo.containsByte(b)){
            modelo.addAparicionNodo(b);
        }else{
            modelo.createNewNodo(b);
        }
    }
    
    private void showDicc(){
        HashMap<Byte,Integer> dicc = modelo.getDicc();
        for (Byte i : dicc.keySet()) {
          System.out.println("Byte: "+i+" Aparic: "+dicc.get(i));
        }
    }
    
    private void showLista(){
        ArrayList<Nodo> lista = modelo.getLista();
        for(int i=0; i<lista.size(); i++){
            System.out.println("Byte: "+((Fulla)lista.get(i)).getId()+
                    " Aparc: "+lista.get(i).getAparicion());
        }
    }

    private void createList() {
        modelo.createList();
    }

    @Override
    public void selectFilePressed() {
        readFile(vista.getSelectFile());
        createList();
        showDicc();
        System.out.println("--------------------");
        showLista();
    }
}
