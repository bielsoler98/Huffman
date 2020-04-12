/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author biels
 */
public class Fulla extends Nodo{
    
    private byte id;
    
    public Fulla(byte id, int repeats) {
        super(repeats, null, null);
        this.id = id;
    }

    public byte getId() {
        return id;
    }
    
}
