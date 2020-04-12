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
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;
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
    
    private void huffmanAvid(){
        while(modelo.getLista().size()>1){
            Nodo uno = modelo.getLista().get(1);
            Nodo zero = modelo.getLista().get(0);
            Nodo n = new Nodo(zero.getAparicion() + uno.getAparicion(), zero, uno);
            modelo.getLista().remove(1);
            modelo.getLista().remove(0);
            modelo.getLista().add(n);
            Collections.sort(modelo.getLista());
        }
    }

    private void newCodification(){
        int originaSize = 0;
        int comprSize = 0;
        Stack<Nodo> nodes = new Stack<>(); 
        Stack<String> codif = new Stack<>(); 
        nodes.push(modelo.getLista().get(0));
        codif.push("");
        while (!nodes.isEmpty()) { 
            Nodo current = nodes.pop();
            String currentCode = codif.pop();
            if(current instanceof Fulla){
                int numBytesCompr = current.getAparicion()*currentCode.length();
                int numBytesNoCompr = current.getAparicion()*8;
                originaSize += numBytesNoCompr;
                comprSize += numBytesCompr;
                int guany = numBytesNoCompr - numBytesCompr;
                System.out.println("Byte: " + ((Fulla) current).getId() +
                        " Codif: " + currentCode + 
                        " Bytes Compr: " + numBytesCompr + 
                        " Bytes no Compr: "+ numBytesNoCompr +
                        " Guany: "+ guany);
            }
            if (current.getNodeOne() != null) {
                nodes.push(current.getNodeOne());
                codif.push(currentCode+"1");
            }
            if (current.getNodeZero() != null) {
                nodes.push(current.getNodeZero());
                codif.push(currentCode+"0");
            } 
        }
        int guany = originaSize - comprSize;
        System.out.println("Tamany Original: " + originaSize+ " Tamany compres: " + comprSize + " Guany: "+ guany);
    }
    
    @Override
    public void selectFilePressed() {
        readFile(vista.getSelectFile());
        createList();
        showDicc();
        System.out.println("--------------------");
        showLista();
        huffmanAvid();
        System.out.println("--------------------");
        newCodification();
        System.out.println("--------------------");
    }
}
