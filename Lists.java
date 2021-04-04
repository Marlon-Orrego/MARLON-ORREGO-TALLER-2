/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import java.util.Stack;

/**
 *
 * @author samaniw
 */
public class Lists {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
     
    //Ejemplo de inserción de datos en lista simple
    
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        DoubleLinkedList<Integer> dll= new DoubleLinkedList<>();
        CircularSingleLinkedList<Integer> csll= new CircularSingleLinkedList<>();
        CircularSingleLinkedList<Integer> csll2= new CircularSingleLinkedList<>();
        CircularDoubleLinkedList<Integer> cdll= new CircularDoubleLinkedList<>();
        
    //IMPLEMENTACION METODOS CON SINGLE LINKED LIST
        System.out.println("\nIMPLEMENTACION METODOS CON DOUBLE LINKED LIST");
        
        sll.add(85);
        sll.add(42);
        sll.add(5231);
        sll.addLast(42);
        sll.addAfter(45, 42);
        sll.addLast(55);
        sll.addAfter(87, 100);
        System.out.println("\nLista Simple: "+sll.showData());
        System.out.println("Cantidad de datos en la lista: "+sll.cantidadDatos());
        
    //IMPLEMENTACION METODOS CON DOUBLE LINKED LIST
        System.out.println("\nIMPLEMENTACION METODOS CON DOUBLE LINKED LIST");

        dll.addOrdered(555);
        dll.addOrdered(77);
        dll.addOrdered(79);
        dll.addOrdered(80);
        dll.addOrdered(5);
        dll.addOrdered(98);
        dll.addOrdered(900);
        dll.addOrdered(55);
        System.out.println("\nLista doble: "+dll.showData());   
        dll.delete(98);
        System.out.println("Lista doble: "+dll.showData());   
        
        
    //IMPLEMENTACION METODOS CON CIRCULAR SIMPLE LINKED LIST
        System.out.println("\nIMPLEMENTACION METODOS CON CIRCULAR SIMPLE LINKED LIST");
        
        csll.add(7);
        csll.add(75);
        csll.add(777);
        csll.add(75258455);
        csll2.add(85);
        csll2.add(5);
        csll2.add(452);
        csll2.add(66);
        csll.deleteFirts();
        csll2.deleteFirts();
        System.out.println("\nLista 1: "+csll.showData());
        System.out.println("Lista 2: "+csll2.showData());
        CircularSingleLinkedList<Integer> csll3=csll.joinLists(csll, csll2);
        System.out.println("La lista con los datos juntos es: "+csll3.showData());
        
    
    //IMPLEMENTACION METODOS CON CIRCULAR DOUBLE LINKED LIST
        System.out.println("\nIMPLEMENTACION METODOS CON CIRCULAR DOUBLE LINKED LIST");
        cdll.add(87);
        cdll.add(8);
        cdll.add(7);
        cdll.add(870);
        cdll.add(855);
        cdll.add(12);
        cdll.add(17);
        cdll.add(9);
       
        System.out.println("\nLista: "+cdll.showData());
        System.out.println("Lista de forma descendiente: "+cdll.showReverse());
        System.out.println("Buscando valor en la lista: "+cdll.search(24));  
        DoubleNode currentNode=cdll.split(870);
        System.out.println("Lista dividida: "+cdll.printSinceNodo(currentNode));
     
       
   
    }
}
