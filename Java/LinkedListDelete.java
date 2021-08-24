import java.io.*;

public class LinkedListDelete {

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

    void initList(int[] values) {
        if (this.headNode != null) {
            System.out.println("Linked list is already initialised");
            return;
        } else {
            this.headNode = new Node(values[0]);
        }
        Node tempNode = this.headNode;
        for (int i = 1; i< values.length; i++) {
            Node newNode = new Node(values[i]);
            tempNode.nextNode = newNode;
            tempNode = tempNode.nextNode;
        }
    }

    void addNode(int value) {
        if (this.headNode == null) {
            this.headNode = new Node(value);
            return;
        }
        Node tempNode = this.headNode;
        while(tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = new Node(value);
    }

    void printList() {
        Node tempNode = this.headNode;
        while(tempNode != null) {
            System.out.println(tempNode.value);
            tempNode = tempNode.nextNode;
        }
    }

    void deleteNodeRecursive(int value, Node currentNode, Node prevNode) {
        if (currentNode == null) {
            System.out.println("No node to delete");
            return;
        }

        if (currentNode.getValue() == value) {
            prevNode.nextNode = currentNode.nextNode;
        } else {
            deleteNodeRecursive(value, currentNode.nextNode, currentNode);
        }
    }

    public static void main(String args[]) {
        LinkedListDelete ll = new LinkedListDelete();
        // ll.initList(new int[] {1, 4,6,7,3});
        ll.addNode(5);
        ll.addNode(1);
        ll.addNode(8);
        ll.deleteNodeRecursive(1, ll.headNode, null);
        ll.printList();
    }
}