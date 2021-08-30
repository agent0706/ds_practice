import java.io.*;

class LinkedList {
    Node headNode;

    static class Node {
        int value;
        Node nextNode;
        Node prevNode;

        Node(int value) {
            this.value = value;
            this.nextNode = null;
            this.prevNode = null;
        }

        int getValue() {
            return this.value;
        }

        void setValue(int value) {
            this.value = value;
        }
    }

    void insertNodeAtBeginning(int value) {
        if (this.headNode == null) {
            this.headNode = new Node(value);
            return;
        }
        Node tempNode = new Node(value);
        tempNode.nextNode = this.headNode;
        this.headNode.prevNode = tempNode;
        this.headNode = tempNode;
    }

    void insertNodeAtTheEnd(int value) {
        if (this.headNode == null) {
            this.headNode = new Node(value);
            return;
        }
        Node tempNode = this.headNode;
        while(tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = new Node(value);
        tempNode.nextNode.prevNode = tempNode;
    }
     
    void printList() {
        Node tempNode = this.headNode;
        System.out.println("Printing list");
        while(tempNode != null) {
            System.out.print(tempNode.getValue() + " ");
            tempNode = tempNode.nextNode;
        }
        System.out.println("\n");
    }

    void printListReverse() {
        Node tempNode = this.headNode;
        System.out.println("Printing list");
        while(tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        while(tempNode != null) {
            System.out.print(tempNode.getValue() + " ");
            tempNode = tempNode.prevNode;
        }
        System.out.println("\n");
    }

    void deleteNode(int value) {
        if (this.headNode.getValue() == value) {
            Node tempNode = this.headNode.nextNode;
            if (tempNode != null) {
                tempNode.prevNode = null;
            }
            this.headNode = tempNode;
        }
        Node tempNode = this.headNode;
        while(tempNode.nextNode != null && tempNode.getValue() != value) {
            tempNode = tempNode.nextNode;
        }
        Node prevNode = tempNode.prevNode;
        Node nextNode = tempNode.nextNode;
        if (nextNode != null) {
            nextNode.prevNode = prevNode;
        }
        prevNode.nextNode = nextNode;
    }
}

public class DoublyLinkedList {
    
    public static void main(String args[]) {
        DoublyLinkedList doublyLinkedListInstance = new DoublyLinkedList();
        LinkedList ll = new LinkedList();
        ll.insertNodeAtBeginning(1);
        ll.insertNodeAtBeginning(3);
        ll.insertNodeAtBeginning(2);
        ll.insertNodeAtBeginning(7);
        ll.insertNodeAtTheEnd(9);
        ll.deleteNode(3);
        ll.printList();
        ll.printListReverse();
    }
}