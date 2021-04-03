/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

/**
 *
 * @author samaniw
 */
public class CircularSingleLinkedList<T extends Number & Comparable> implements ILists<T> {

    private Node<T> head;
    private Node<T> tail;

    public CircularSingleLinkedList() {
        head = tail = null;
    }

    
    
    @Override
    public void add(T d) {
        Node<T> newNode = new Node<>(d);
        if(isEmpty()){
            head = tail = newNode;
        }else{
            //1. Modificar el siguiente del nuevo nodo
            //para que apunte a la cabeza actual
            newNode.setNextNode(head);
            //2. Actualiza la cabeza para que sea el nuevo nodo
            head = newNode;
            //3. Cambiar el siguente de la cola, para que apunte a la
            //nueva cabeza
            tail.setNextNode(head);
        }
        


    }

    @Override
    public void addLast(T d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addAfter(T a, T b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addOrdered(T d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteFirts() {
        Node<T> nodeCabezaAux = head;
        if (isEmpty()) {
            System.out.println("Lista sin datos");
        } else{
            if (head.getNextNode()==head.getPreviousNode()){
                head=null;
               
            }else{ 
            while(nodeCabezaAux.getNextNode()!=head){
                nodeCabezaAux=nodeCabezaAux.getNextNode();
            }
            nodeCabezaAux.setNextNode(head.getNextNode());
            head.getNextNode().setPreviousNode(nodeCabezaAux);
            head=head.getNextNode();
            }  
        }
    }

    @Override
    public void deleteLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(T d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String showData() {
         if (isEmpty()) {
            return "Lista vacia";
        } else {
            String info = "";
            for (Node<T> i = head; i != tail; i = i.getNextNode()) {
               
                info = info + i.getData() + " - ";
            }
            return info+= tail.getData();
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean search(T d) {
        if(isEmpty()){
            return false;
        }else{
            return searchR(d,head);
        }
    }
    
    private boolean searchR(T d, Node currentNode) {
        //casos base de la recursividad.
        if(currentNode==tail && !currentNode.getData().equals(d)){
            return false;
        }else if(currentNode.getData().equals(d)){
            return true;
        }else{
            return searchR(d, currentNode.getNextNode());
        }
    }

    public CircularSingleLinkedList joinLists(CircularSingleLinkedList ListA,CircularSingleLinkedList ListB){
    
        Node nodecurrentA=ListA.head;
        Node nodecurrentB=ListB.head;
        int d;
        CircularSingleLinkedList<Integer> newcsll= new CircularSingleLinkedList<>();

        while(nodecurrentA.getNextNode()!=ListA.head){
            d=(int) nodecurrentA.getData();
            newcsll.add(d);
            nodecurrentA=nodecurrentA.getNextNode();
        }
            d=(int) nodecurrentA.getData();
            newcsll.add(d);
            
        while(nodecurrentB.getNextNode()!=ListB.head){
            d=(int) nodecurrentB.getData();
            newcsll.add(d);
            nodecurrentB=nodecurrentB.getNextNode();
        }
            d=(int) nodecurrentB.getData();
            newcsll.add(d);

        return newcsll;
    }
}
