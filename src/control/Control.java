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
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
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
    
    public void selectFile() throw new IOException{
        //File f = new File(vista.showSelectFile());
        //Scanner entrada = null;
        RandomAccessFile entrada=null;
        try {
            entrada = new RandomAccessFile(vista.showSelectFile(),"r");
            //entrada = new Scanner(f);
            while (entrada.length()!=0) {
                modelo.addNodo(entrada.readByte(),0, null, null);
            }
        } catch (FileNotFoundException e) {
            vista.notFileFound(e.getMessage());
        } catch (NullPointerException e) {
            vista.notFileSelect();
        } catch (IOException e) {
            vista.showError(e.getMessage());
        } finally {
               entrada.close();
        }
    }
    
    public void showLista(){
        ArrayList<Nodo> lista = modelo.getLista();
        for(int i=0; i<lista.size(); i++){
            System.out.println(lista.get(i).getBits());
        }
    }
}
