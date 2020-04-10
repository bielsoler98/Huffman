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
    
    private char caracter;
    private int aparicion;
    private Nodo drch;
    private Nodo izq;
    
    public Nodo(char c, int n, Nodo drch, Nodo izq){
        this.caracter=c;
        this.aparicion=n;
        this.drch=drch;
        this.izq=izq;
    }
}
