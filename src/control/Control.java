/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.FileNotFoundException;
import modelo.Modelo;
import vista.Vista;
import huffman.huffmanInterface.Controller;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import modelo.Nodo;

/**
 *
 * @author Andrea
 */
public class Control implements Controller{
    
    private Vista vista;
    private Modelo modelo;
    
    public Control(Vista vista, Modelo modelo){
        this.vista=vista;
        this.modelo=modelo;
    }
    
    public String selectFile(){
        return vista.showSelectFile();
    }
    
    public void readFile(String file){
        RandomAccessFile entrada=null;
        try {
            entrada = new RandomAccessFile(file,"r");
            int cont =1;
            while (entrada.length() >= cont) {
                addToDicc(entrada.readByte());
                cont++;
            }
        } catch (FileNotFoundException e) {
            vista.notFileFound(e.getMessage());
        } catch (NullPointerException e) {
            vista.notFileSelect();
        } catch (IOException e) {
            vista.ioexception(e.toString());
        } finally {
            try{
               entrada.close();
            }catch(IOException e){
                vista.ioexception(e.toString());
            }   
        }
    }
    
    private void addToDicc(Byte b){
        if(modelo.containsByte(b)){
            modelo.addAparicionNodo(b);
        }else{
            modelo.createNewNodo(b);
        }
    }
    
    public void showDicc(){
        HashMap<Byte,Integer> dicc = modelo.getDicc();
        for (Byte i : dicc.keySet()) {
          System.out.println("Byte: "+i+" Aparic: "+dicc.get(i).intValue());
        }
    }
    
    public void showLista(){
        ArrayList<Nodo> lista = modelo.getLista();
        for(int i=0; i<lista.size(); i++){
            System.out.println("Byte: "+lista.get(i).getBytes()+
                    " Aparc: "+lista.get(i).getAparicion());
        }
    }

    public void createList() {
        modelo.createList();
    }
}
