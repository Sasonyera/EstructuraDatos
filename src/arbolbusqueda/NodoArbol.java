/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolbusqueda;

/**
 *
 * @author Alexis García
 */
public class NodoArbol {
    int dato,fe;
    String nombre;
    NodoArbol izq,der;
    public NodoArbol(int d,String n){
        this.dato=d;
        this.fe=0;
        this.nombre=n;
        this.der=null;
        this.izq=null;
        
    }
   public NodoArbol(int d){
        this.dato=d;
        this.fe=0;
        this.der=null;
        this.izq=null;
        
    }
}
