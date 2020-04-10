/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Andrea
 */
public class Nodo {
    
    private byte bits;
    private int aparicion;
    private Nodo drch;
    private Nodo izq;
    
    public Nodo(byte b, int n, Nodo drch, Nodo izq){
        this.bits=b;
        this.aparicion=n;
        this.drch=drch;
        this.izq=izq;
    }

    public byte getBits() {
        return bits;
    }

    public void setBits(byte bits) {
        this.bits = bits;
    }

    public int getAparicion() {
        return aparicion;
    }

    public void setAparicion(int aparicion) {
        this.aparicion = aparicion;
    }

    public Nodo getDrch() {
        return drch;
    }

    public void setDrch(Nodo drch) {
        this.drch = drch;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }
    
    
}
