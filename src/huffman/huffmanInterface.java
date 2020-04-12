/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import modelo.Nodo;

/**
 *
 * @author Andrea
 */
public interface huffmanInterface {
    
    interface View{
        File getSelectFile();
        void ioexception(String s);
    }
    
    interface Model{
        HashMap<Byte,Integer> getDicc();
        ArrayList<Nodo> getLista();
        boolean containsByte(Byte b);
        void addAparicionNodo(Byte b);
        void createNewNodo(Byte b);
        void createList();
    }
    
    interface Controller{
        void selectFilePressed();
    }
}
