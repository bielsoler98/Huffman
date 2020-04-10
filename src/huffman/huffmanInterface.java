/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.util.ArrayList;
import modelo.Nodo;

/**
 *
 * @author Andrea
 */
public interface huffmanInterface {
    
    interface View{
        String showSelectFile();
        void notFileFound(String s);
        void notFileSelect();
        void showError(String s);
        void showError2(String s);
    }
    
    interface Model{
        void addNodo(Byte b, int n, Nodo dch, Nodo izq);
        ArrayList<Nodo> getLista();
    }
    
    interface Controller{
        void selectFile();
        void showLista();
    }
}
