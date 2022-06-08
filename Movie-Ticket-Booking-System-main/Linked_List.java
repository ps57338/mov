package com.company;

class Node <T>{
    public Node<T> link;
    private T data;

    Node(T data){
        this.link = null;
        this.data = data;
    }



    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data+"" ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Node))
            return false;
        Node other = (Node) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (link == null) {
            if (other.link != null)
                return false;
        } else if (!link.equals(other.link))
            return false;
        return true;
    }

}

public class Linked_List <T>{
    Node<T> root = null;
    int size = 0;

    public int size() {
        return size;
    }

    public void add(T data){
        this.size++;
        Node<T> curr = root;
        Node<T> temp = new Node<T>(data);

        if(root==null){
            this.root = temp;
            return;
        }

        else{
            while(curr.link!=null){
                curr = curr.link;
            }
            curr.link = temp;

        }

    }


    public T getNode(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("Index not available.");
        }
        // If index=0 , return head
        if (index == 0) {
            return this.root.getData();
        }
        // If index= size, return last node
        if (index == this.size - 1) {
            return getLastNode(this.root).getData();
        }
        int pointer = 0;
        Node<T> pointerNode = this.root;
        while (pointer <= index) {
            if (pointer == index) {
                return pointerNode.getData();
            } else {
                pointerNode = pointerNode.link;
                pointer++;
            }
        }
        return null;
    }
    private Node<T> getLastNode(Node<T> node) {

        Node<T> lastNode = node;
        if (lastNode.link != null) {
            return getLastNode(lastNode.link);
        } else {
            return lastNode;
        }
    }

    boolean remove(T key){
        Node<T> prev = new Node<>(null);

        // Dummy node pointing to head node
        prev.link = root;

        // Next node that points ahead of current node
        Node<T> next = root.link;

        // Temporary node for traversal
        Node<T> temp = root;

        // Boolean value that checks whether value to be
        // deleted exists or not
        boolean exists = false;

        // If head node needs to be deleted
        if (root.getData() == key) {
            root = root.link;

            // Node to be deleted exists
            exists = true;
        }

        // Iterating over LinkedList
        while (temp.link != null) {

            // We convert value to be compared into Strings
            // and then compare using
            // String1.equals(String2) method

            // Comparing value of key and current node
            if (String.valueOf(temp.getData()).equals(
                    String.valueOf(key))) {

                // If node to be deleted is found previous
                // node now points to next node skipping the
                // current node
                prev.link = next;
                // node to be deleted exists
                exists = true;

                // As soon as we find the node to be deleted
                // we exit the loop
                break;
            }

            // Previous node now points to current node
            prev = temp;

            // Current node now points to next node
            temp = temp.link;

            // Next node points the node ahead of current
            // node
            next = temp.link;
        }

        // Comparing the last node with the given key value
        if (exists == false
                && String.valueOf(temp.getData()).equals(
                String.valueOf(key))) {

            // If found , last node is skipped over
            prev.link = null;

            // Node to be deleted exists
            exists = true;
        }

        // If node to be deleted exists
        if (exists) {

            // Length of LinkedList reduced
            this.size--;
        }

        // If node to be deleted does not exist
        return exists;
    }



    @Override
    public String toString() {
        String represent = "";
        Node<T> nextNode = this.root;
        while (nextNode != null) {
            represent = represent + nextNode.toString();
            nextNode = nextNode.link;
            if (nextNode != null) {
                represent = represent + ",";
            }
        }
        represent = represent + "";
        return represent;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Linked_List))
            return false;
        Linked_List other = (Linked_List) obj;
        if (root == null) {
            if (other.root != null)
                return false;
        } else if (!root.equals(other.root))
            return false;
        if (size != other.size)
            return false;
        return true;
    }

}
