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
public class CircularDoubleLinkedList<T extends Number & Comparable> implements ILists<T> {

    private DoubleNode<T> head;

    public CircularDoubleLinkedList() {
        head = null;
    }

    @Override
    public void add(T d) {
        if (isEmpty()) {
            DoubleNode<T> newNode = new DoubleNode<>(d);
            head = newNode;
            newNode.setNextNode(newNode);
            newNode.setPreviousNode(newNode);
        }else{
            DoubleNode<T> newNode = new DoubleNode<>(head.getPreviousNode(),d,head);
            newNode.getPreviousNode().setNextNode(newNode);
            head.setPreviousNode(newNode);
            head = newNode;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            return showDataRecursive(head);
        }
    }

    private String showDataRecursive(DoubleNode currentNode) {
        if (currentNode == head.getPreviousNode()) {
            return currentNode.getData().toString();
        } else {
            return currentNode.getData() + " - " + showDataRecursive(currentNode.getNextNode());
        }

    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean search(T d) {
        boolean checkFounded = false;
        
        if(isEmpty()){
            return false;
        }else{
            DoubleNode<T> currentNode=head.getPreviousNode();
            do{
                if (currentNode.getData()==d){
                    checkFounded=true;
                }
                currentNode=currentNode.getPreviousNode();
            }while(currentNode!=head.getPreviousNode() && checkFounded!=true);
        }
        
        return checkFounded;
    }
    
    public void reverse(){
      int c=0,t=1;
      DoubleNode<T> newNode = head;  
      DoubleNode<T> currentNode = head;
      DoubleNode<T> Temp = head;

      DoubleNode<T> newNode2 = head.getNextNode();
      
      if (isEmpty()) {
            System.out.println("Lista vacía");
        } else {
          
         while(newNode.getNextNode()!=head){
             newNode=newNode.getNextNode();
             c++;
             System.out.println("ciclo 1 bien");
         }
         int temp=0;
         
         do{
             currentNode=head;
             DoubleNode<T> nextNodeCurrent = currentNode.getNextNode();
             
             while(currentNode.getNextNode()!=head){
                 
                 if((int) currentNode.getData() > (int) currentNode.getNextNode().getData()){
                     
                     temp=(int) currentNode.getData();
                     temp=(int) currentNode.getData();
                     
                     Temp=currentNode;
                     currentNode.setData(currentNode.getNextNode().getData());
                     currentNode.getNextNode().setData(Temp.getData());
                     
                     currentNode=currentNode.getNextNode();
                     
                 }else{
                     
                     currentNode=currentNode.getNextNode();
                 }
             }

         }while(currentNode.getNextNode()!=null);
      
      }
        
      
   
    }
    public void split(T d){
        
        DoubleNode currentNode=head;
        DoubleNode auxNode2=head;
        DoubleNode auxNode3=head;

        
        while(auxNode3.getNextNode().getData()!=head){
            auxNode3=auxNode3.getNextNode();
        }
        
        while(currentNode.getNextNode().getData()!=head){
             if(currentNode.getData()==d){
                 
                 //El siguiente del nodo del dato sera la cabeza 
                 currentNode.setNextNode(head);
                 //El nodo previo del nodo siguiente donde esta el dato es la cola en este caso auxnode3
                 currentNode.getNextNode().setPreviousNode(auxNode3);
                 //El nodo siguiente de la cola sera el siguiente del nodo siguiente donde esta el dato
                 auxNode3.setNextNode(currentNode.getNextNode());
                 //El previo de la cabeza sera el nodo del dato
                 head.setPreviousNode(currentNode);
             }
             
             
        }
       
                
        
    
    }
}
