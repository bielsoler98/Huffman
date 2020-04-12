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
public class Nodo implements Comparable<Nodo> {
    
    private int aparicion;
    private Nodo nodeZero;
    private Nodo nodeOne;
    
    public Nodo(int n, Nodo drch, Nodo izq){
        this.aparicion=n;
        this.nodeZero=drch;
        this.nodeOne=izq;
    }

    public Nodo getNodeZero() {
        return nodeZero;
    }

    public Nodo getNodeOne() {
        return nodeOne;
    }

    public int getAparicion() {
        return aparicion;
    }
  
    @Override
    public int compareTo(Nodo o) {
       return this.aparicion-o.aparicion;
    }
        
}