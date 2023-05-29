/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolbusqueda;

/**
 *
 * @author Alexis García
 */
public class ArbolBusqueda {

    NodoArbol raiz;

    public ArbolBusqueda() {
        raiz = null;
    }

    
    public void insertarNodo(int dato, String nom) {
        NodoArbol nuevo = new NodoArbol(dato, nom);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            NodoArbol auxiliar = raiz;
            NodoArbol padre;
            while (true) {
                padre = auxiliar;
                if (dato < auxiliar.dato) {
                    auxiliar = auxiliar.izq;
                    if (auxiliar == null) {
                        padre.izq = nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.der;
                    if (auxiliar == null) {
                        padre.der = nuevo;
                        return;
                    }
                }

            }
        }
    }

    public boolean IsVacia() {
        return raiz == null;
    }

    public String toString(int a) {
        String cadena = "";
        switch (a) {
            case 0:
                cadena = PreOrden(raiz, cadena);
                break;
            case 1:
                cadena = EnOrden(raiz, cadena);
                break;

            case 2:
                cadena = PosOrden(raiz, cadena);
                break;
        }
        return cadena;
    }

    public String EnOrden(NodoArbol r, String c) {
        String cadena = "";
        if (r != null) {
            cadena = c + EnOrden(r.izq, c) +r.dato + EnOrden(r.der, c);
        }
        return cadena;
    }

    public String PreOrden(NodoArbol r, String c) {
        String cadena = "";
        if (r != null) {
            cadena = c + r.dato + PreOrden(r.izq, c) + PreOrden(r.der, c);
        }
        return cadena;
    }

    public String PosOrden(NodoArbol r, String c) {
        String cadena = "";
        if (r != null) {
            cadena = c + PosOrden(r.izq, c) + PosOrden(r.der, c) + r.dato;
        }
        return cadena;
    }
   public int factorEquilibrio(NodoArbol x){
        if(x==null){
            return -1;
        }else{
            return x.fe;
        }
    }
   public NodoArbol rotacionIzq(NodoArbol c){
       NodoArbol aux = c.izq;
       c.izq=aux.der;
       aux.der=c;
       c.fe=Math.max(factorEquilibrio(c.izq), factorEquilibrio(c.der))+1;
       aux.fe=Math.max(factorEquilibrio(aux.izq), factorEquilibrio(aux.der))+1;
       return aux;
   }
   public NodoArbol rotacionDer(NodoArbol c){
       NodoArbol aux = c.der;
       c.der=aux.izq;
       aux.izq=c;
       c.fe=Math.max(factorEquilibrio(c.izq), factorEquilibrio(c.der))+1;
       aux.fe=Math.max(factorEquilibrio(aux.izq), factorEquilibrio(aux.der))+1;
       return aux;
   }
   public NodoArbol rotacionDobleIzq(NodoArbol c){
       NodoArbol aux;
       c.izq=rotacionDer(c.izq);
       aux=rotacionIzq(c);
       return aux;
   }
   public NodoArbol rotacionDobleDer(NodoArbol c){
       NodoArbol aux;
       c.der=rotacionIzq(c.der);
       aux=rotacionDer(c);
       return aux;
   }
   public NodoArbol insertarAVL(NodoArbol nuevo, NodoArbol subArbol){
       NodoArbol nuevoPadre=subArbol;
       if(nuevo.dato<subArbol.dato){
           if(subArbol.izq==null){
               subArbol.izq=nuevo;
           }else{
               subArbol.izq=insertarAVL(nuevo, subArbol.izq);
               if((factorEquilibrio(subArbol.izq)-factorEquilibrio(subArbol.der)==2)){
                   if(nuevo.dato<subArbol.izq.dato){
                       nuevoPadre=rotacionIzq(subArbol);
                   }else{
                       nuevoPadre=rotacionDobleIzq(subArbol);
                   }
               }
           }
       }else if(nuevo.dato>subArbol.dato){
           if (subArbol.der==null){
               subArbol.der=nuevo;
           }else{
               subArbol.der=insertarAVL(nuevo, subArbol.der);
                if((factorEquilibrio(subArbol.der)-factorEquilibrio(subArbol.izq)==2)){
                    if(nuevo.dato<subArbol.der.dato){
                        nuevoPadre=rotacionDer(subArbol);
                    }else{
                        nuevoPadre=rotacionDobleDer(subArbol);
                    }
                }
           }
       }else{
           System.out.println("No se pueden repetir nodos");
       }
       if((subArbol.izq==null)&& (subArbol.der!=null)){
           subArbol.fe=subArbol.der.fe+1;
       }else if((subArbol.der==null)&&(subArbol.izq!=null)){
           subArbol.fe=subArbol.izq.fe+1;
       }else{
           subArbol.fe=Math.max(factorEquilibrio(subArbol.izq), factorEquilibrio(subArbol.der))+1;
       }
       return nuevoPadre;
   }
   public void insertarArbolBalanceado(int d){
       NodoArbol nuevo = new NodoArbol(d);
       if (raiz==null){
           raiz=nuevo;
       }else{
           raiz=insertarAVL(nuevo, raiz);
       }
   }
}
