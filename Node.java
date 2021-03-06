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
public class Node<V> {   
    private V data;
    private Node<V> nextNode;
    private Node<V> previousNode;

    public Node(V data) {
        this.data = data;
        this.nextNode = null;
    }
    
    public Node(V data, Node nextNode){
        setData(data);
        setNextNode(nextNode);   
    }

    /**
     * @return the data
     */
    public V getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(V data) {
        this.data = data;
    }

    /**
     * @return the nextNode
     */
    public Node<V> getNextNode() {
        return nextNode;
    }

    /**
     * @param nextNode the nextNode to set
     */
    public void setNextNode(Node<V> nextNode) {
        this.nextNode = nextNode;
    }
    
    public Node<V> getPreviousNode() {
        return previousNode;
    }

    /**
     * @param nextNode the nextNode to set
     */
    public void setPreviousNode(Node<V> previousNode) {
        this.previousNode = previousNode;
    }
}
