import java.io.*;

public class ReverseLinkedList {

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
            System.out.println("Linked list is not empty");
            return;
        }
        this.headNode = new Node(values[0]);
        Node tempNode = this.headNode;
        for (int i = 1; i < values.length; i++ ) {
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

    void reverseLinkedListRecursive(Node currentNode, Node prevNode) {
        if (currentNode == null) {
            return;
        }
        reverseLinkedListRecursive(currentNode.nextNode, currentNode);
        if (currentNode.nextNode == null) {
            this.headNode = currentNode;
        }
        currentNode.nextNode = prevNode;
    }

    Node reverseRecursive(Node headNode) {
        if (headNode == null) {
            return null;
        }
        if (headNode.nextNode == null) {
            return headNode;
        }
        Node tempNode = reverseRecursive(headNode.nextNode);
        headNode.nextNode.nextNode = headNode;
        headNode.nextNode = null;
        return tempNode;
    }

    void reverseLinkedListIterative() {
        Node currentNode = this.headNode;
        Node prevNode = null;
        Node nextNode = null;

        while(currentNode.nextNode != null) {
            nextNode = currentNode.nextNode;
            currentNode.nextNode = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        currentNode.nextNode = prevNode;
         this.headNode = currentNode;
    }

    public static void main(String args[]) {
        ReverseLinkedList ll = new ReverseLinkedList();
        ll.initList(new int[] {1, 5, 3, 8});
        ll.printList();
        System.out.println("reversed linked list");
        // ll.reverseLinkedListRecursive(ll.headNode, null);
        ll.headNode = ll.reverseRecursive(ll.headNode);
        ll.printList();
    }
}