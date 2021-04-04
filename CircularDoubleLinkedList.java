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
            }while(currentNode!=head.getPreviousNode()&& checkFounded!=true);
            
            if((int)currentNode.getNextNode().getData()==(int)d){
                checkFounded=true;
            }
        }
        
        return checkFounded;
    }
    
    public String showReverse(){
        DoubleNode<T> currentNode=head;
        String cadena="";
        boolean aux=false;
        if (isEmpty()) {
            return "Lista vacia";
        }else if(currentNode==head.getPreviousNode()){
            cadena=currentNode.getData().toString();
        } 
        
        else {
            
            while(currentNode.getNextNode()!=head && aux==false){
                currentNode=currentNode.getNextNode();
                
            }
           
            
            while(currentNode!=head){
                
                cadena=cadena+" "+currentNode.getData().toString();
                currentNode=currentNode.getPreviousNode();
               
                }
                cadena=cadena+" "+currentNode.getData().toString();
        }
        
        return cadena; 
      
   
    }
    public DoubleNode split(T d){
        
        DoubleNode currentNode=head;
        DoubleNode auxNode2=head;
        DoubleNode auxNode3=head;
        CircularDoubleLinkedList<Integer> newCdll= new CircularDoubleLinkedList<>();

        
        while(auxNode3.getNextNode()!=head){
            auxNode3=auxNode3.getNextNode();
            
        }
        
        while(currentNode.getNextNode()!=head){
            
             if((int)currentNode.getData()==(int)d){
                auxNode2=currentNode.getNextNode();
                auxNode2.setPreviousNode(auxNode3);
                auxNode3.setNextNode(auxNode2);
                currentNode.setNextNode(head);
                head.setPreviousNode(currentNode);
                
                return auxNode2;
             }
             currentNode=currentNode.getNextNode();
        }
       return auxNode2;
    }
    
    public String printSinceNodo(DoubleNode currentNode){
        String cadena="";
        currentNode=head;
        boolean checked=false;
        
        do{
            cadena=cadena+" "+currentNode.getData().toString();
            currentNode=currentNode.getNextNode();
            
        }while(currentNode!=head && checked==false);
            
     
        return cadena;
    
    }
}
