/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolbusqueda;


public class Main {

   
    public static void main(String[] args) {
        
java.util.Scanner scanner= new java.util.Scanner(System.in);
ArbolBusqueda arbolito = new ArbolBusqueda();
ArbolBusqueda arbolito2 = new ArbolBusqueda();
System.out.println("Numero de nodos: ");
        int numNodos=scanner.nextInt();
        
        System.out.println("Ingrese los datos separados por una ',' ");
        String cadena = scanner.next();
        
        String[] numerosString = cadena.split(","); // Se separa la cadena en un arreglo de strings usando la coma como separador
    int[] numeros = new int[numNodos]; // Se crea un arreglo de enteros del mismo tamaño que el arreglo de strings
    for(int i = 0; i < numerosString.length; i++) {
        numeros[i] = Integer.parseInt(numerosString[i]); // Se convierte cada string a un número entero y se guarda en el arreglo de enteros
    }
     for (int i=0; i<numeros.length;i++){
         arbolito.insertarNodo(numeros[i], "");
         arbolito2.insertarArbolBalanceado(numeros[i]);
         System.out.println("Procesando....");
     }   
        System.out.println("Preorden: "+arbolito.toString(0));
     System.out.println("Enorden: "+arbolito.toString(1));
     System.out.println("Posorden: "+arbolito.toString(2));
     
        System.out.println("\tBALANCEADO\t\n");
         System.out.println("Preorden: "+arbolito2.toString(0));
     System.out.println("Enorden: "+arbolito2.toString(1));
     System.out.println("Posorden: "+arbolito2.toString(2));
    }
    

}
