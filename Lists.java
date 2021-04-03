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
        
        
      

        
        dll.addOrdered(555);
        dll.addOrdered(100000000);
        dll.addOrdered(8);
        dll.addOrdered(77);
        dll.addOrdered(7);
        dll.addOrdered(7352);
        dll.addOrdered(721547);
        
        System.out.println(dll.showData());   
        dll.deleteLast();
        System.out.println(dll.showData());

        
        /*        
        csll.add(7);
        csll.add(75);
        csll.add(777);
        csll.add(75258455);
        csll2.add(85);
        csll2.add(5);
        csll2.add(452);
        csll2.add(66);

        System.out.println(csll.showData());
        System.out.println(csll2.showData());
        csll.joinLists(csll, csll2);
        
        csll2.deleteFirts();
        System.out.println(csll2.showData());
        CircularSingleLinkedList<Integer> csll3=csll.joinLists(csll, csll2);
        System.out.println("La lista con los datos juntos es: "+csll3.showData());
        
        cdll.add(87);
        cdll.add(8);
        cdll.add(7);
        cdll.add(870);
        cdll.add(8700);
        cdll.add(8447);
        System.out.println(cdll.showData());
        System.out.println(cdll.search(24));    
        */

    }
//Ejemplo de genérico
//https://docs.oracle.com/javase/tutorial/java/generics/types.html

    public static class Box<E> {

        private E[] object;

        public void Experiment() {
            System.out.println("Experiment 1");
        }

        public void Experiment(int x) {
            System.out.println("Experiment " + x);
        }

        public void Experiment(int x, int y) {
            System.out.println("Experiment " + x + y);
        }

        public void set(E[] object) {
            this.object = object;
        }

        public Object get() {
            return object;
        }
    }

    //Verificar si una expresión esta balanceada
    public static boolean checkParentheses(String exp) {

        LinkedStack<String> checkBalance = new LinkedStack<>();
        char[] arrayExp = exp.toCharArray();
        for (int i = 0; i < arrayExp.length; i++) {
            if (arrayExp[i] == '(') {
                checkBalance.push("(");
            } else if (arrayExp[i] == ')') {
                if (checkBalance.empty()) {
                    return false;
                } else {
                    checkBalance.pop();
                }
            }
        }
        return checkBalance.empty();
    }

    //convertir de decimal a binario
    public static String toBinary(int n) {
        LinkedStack<Integer> residue = new LinkedStack<>();
        String binary ="";
        while (n>0) {            
            residue.push(n % 2);
            n /= 2;
        }
        while (!residue.empty()) {            
            binary+=residue.pop();
        }
        return binary;
    }

}
