import java.io.*;

public class LinkedList {

    Node headNode;
    
    static class Node {
        private int value;
        Node nextNode;

        Node(int value) {
            this.value = value;
            this.nextNode = null;
        }

        void setValue(int value) {
            this.value = value;
        }

        int getValue() {
            return this.value;
        }
    }

    void addNode(int value) {
        Node newNode = new Node(value);
        Node tempNode = this.headNode;
        while(tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = newNode;
    }

    void deleteNode(int value) {
        Node tempNode = this.headNode;
        if (this.headNode == null) {
            System.out.println("linked list is empty");
            return;
        }
        if (tempNode.getValue() == value) {
            this.headNode = tempNode.nextNode;
        } else {
            Node prevNode = tempNode;
            boolean isMatched = false;
            while(tempNode.nextNode != null) {
                prevNode = tempNode;
                tempNode = tempNode.nextNode;
                if (tempNode.getValue() == value) {
                    isMatched = true;
                    break;
                }
            }
            if (isMatched) {
                prevNode.nextNode = tempNode.nextNode;
            }
        }
    }

    void printList() {
        Node tempNode = this.headNode;
        while(tempNode != null) {
            System.out.println(tempNode.getValue());
            tempNode = tempNode.nextNode;
        }
    }

    void initList(int[] values) {
        if (values.length > 0) {
            this.headNode = new Node(values[0]);
            for(int i = 1; i < values.length; i++) {
                this.addNode(values[i]);
            }
        } else {
            System.out.println("An empty array of values is given");
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.initList(new int[]{1, 4, 7, 5});
        ll.deleteNode(4);
        ll.printList();
    }
}