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
public class SingleLinkedList<T extends Number & Comparable> implements ILists<T> {

    private Node<T> head;
    private Node<T> tail;
    

    public SingleLinkedList() {
        head = null;
    }
    int cont=0;

    @Override
    public void add(T d) {
        //1. Crear un nuevo nodo
        Node<T> newNode = new Node<>(d);
        //2. Modificar el siguiente del nuevo nodo(cabeza)
        newNode.setNextNode(head);
        //3. Cambiar la cabeza de la lista(nuevo nodo)
        head = newNode;
        cont++;
    }
  
    
    @Override
    public void addLast(T d) {
        
        Node<T> newNode = new Node<>(d);
        Node<T> currentNode=head;
        Node<T> currentNode2=head;

        boolean checked=false;
        
        while((currentNode2!=null)&&(checked==false) ){    
            if((int)currentNode2.getData()==(int)d){
                System.out.println("EL DATO YA SE ENCUENTRA EN LA LISTA ");
                checked=true;
            }
           
            currentNode2=currentNode2.getNextNode();
            
        }
           
        if (checked==false){
            while(currentNode.getNextNode()!=null){
                    currentNode=currentNode.getNextNode();
        }
            currentNode.setNextNode(newNode);
            cont++;
        
        }
    }

    @Override
    public void addAfter(T a, T b) {
        
        boolean checked=false;
        //1. Crear un nuevo nodo
        Node<T> newNode = new Node<>(a);
        //2.Recorrer Lista hasta encontrar el nodo con el dato
        for (Node<T> i = head; i != null; i = i.getNextNode()) {
            if (i.getData()==b){
            
            //3. El siguiente del nuevo nodo va a ser el siguiente del nodo del valor referenciado
            newNode.setNextNode(i.getNextNode());
            //4. El siguiente del nodo referenciado serà el nuevo nodo
            i.setNextNode(newNode);
            cont++;
            checked=true;
            }
            }
        
        if (checked==false){
            System.out.println("NO SE ENCUENTRA EL DATO");
        }
    }

    @Override
    public void deleteFirts() {
        if (isEmpty()) {
            System.out.println("Lista vacía");
        } else {
            //cambiar cabeza
            //la nueva cabeza será el siguiente de la cabeza actual
            head = head.getNextNode();
            cont--;
        }
    }

    @Override
    public void deleteLast() {

        if (isEmpty()) {
            System.out.println("Lista vacía");
        }else {
            if (head!=null){
                Node<T> currentNode=head;
                
                while(currentNode.getNextNode()!=null){
                    currentNode=currentNode.getNextNode();
                }
                
                Node<T> currentNode2=head;
                while(currentNode2.getNextNode()!=currentNode){
                    currentNode2=currentNode2.getNextNode();
                }
                currentNode=currentNode2;
                currentNode.setNextNode(null);
                cont--;
                
            }else{
               head=tail=null;
                }
    }
    
    
    }

    @Override
    public boolean delete(T d) {
        boolean checkDeleted = false;
        //1. Validar si el dato a borrar esta en la cabeza
        if (head.getData() == d) {
            deleteFirts();
            checkDeleted = true;            
        } else {
            //2. Recorrer toda la estructura
            Node<T> currentNode = head;
            while (currentNode.getNextNode() != null) {
                //3. Verificar si el dato se encuentra en el siguiente nodo
                if (currentNode.getNextNode().getData() == d) {
                    //4.Cambiar el siguiene del actual para que se ubique dos pasos adelante
                    currentNode.setNextNode(currentNode.getNextNode().getNextNode());
                    checkDeleted = true;                   
                } //5. Avanzar un nodo
                else if (currentNode.getNextNode() != null) {
                    currentNode = currentNode.getNextNode();
                }
                //System.out.println("");
                
            }cont--;
        }
        return checkDeleted;

    }

    @Override
    public String showData() {
        if (isEmpty()) {
            return "Lista vacia";
        } else {
            String info = "";
            for (Node<T> i = head; i != null; i = i.getNextNode()) {
                info = info + i.getData() + " - ";
            }

            //forma tradicional de recorrer lista con Mientras
            /*Node<T> currentNode = head;
            while (currentNode!=null) {
                info = info + currentNode.getData();
                currentNode = currentNode.getNextNode();
            }*/
            return info;
        }

    }

    @Override
    public boolean isEmpty() {
        return head == null;/*
        if (head == null) {
            return true;
        } else {
            return false;
        }*/

    }

    @Override
    public boolean search(T d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addOrdered(T d) {
        //Crear un nodo para el nuevo dato.
        Node<T> newNode = new Node<>(d);
        /*Si la lista esta vacía, o el valor del primer elemento de la lista 
            es mayor que el nuevo, insertar el nuevo nodo en la primera posición 
            de la lista y modificar la cabecera respectivamente.*/
        if (isEmpty() || newNode.getData().compareTo(head.getData()) == -1) {
            add(d);
        } /*
        Si no se cumple el caso anterior, buscar el lugar adecuado 
        para la inserción: recorrer la lista conservando el nodo actual. 
        Inicializar nodo actual con el valor de primera posición, 
        y avanzar mientras el siguiente nodo no sea nulo y el dato que 
        contiene la siguiente posición sea menor o igual que el dato a insertar.
         */ else {
            Node<T> currentNode = head;
            while (currentNode.getNextNode() != null
                    && currentNode.getNextNode().getData().compareTo(d) < 0) {
                //avanzar
                currentNode = currentNode.getNextNode();
            }
            /*
            Con esto se seña al nodo adecuado, a continuación insertar el 
            nuevo nodo a continuación de él
             */
            newNode.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(newNode);
        }

    }
    
    public int cantidadDatos(){
        return cont;
    }
}
   