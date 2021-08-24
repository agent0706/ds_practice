import java.io.*;

class LinkedList {

    Node headNode;

    static class Node {
        int value;
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
            System.out.println("linked list is not empty");
            return;
        }
        if (this.headNode == null) {
            this.headNode = new Node(values[0]);
        }
        Node tempNode = this.headNode;
        for (int i = 1; i < values.length; i++) {
            tempNode.nextNode = new Node(values[i]);
            tempNode = tempNode.nextNode;
        }
    }

    void printList() {
        Node tempNode = this.headNode;
        System.out.println("printing linked list");
        while(tempNode != null) {
            System.out.print(tempNode.getValue() + " ");
            tempNode = tempNode.nextNode;
        }
        System.out.print("\n");
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
}

public class RotatingLinkedList {

    void rotateLinkedList(LinkedList ll, int pivot) {
        if (ll.headNode == null) {
            return;
        }
        int count = 1;
        LinkedList.Node tempNode = ll.headNode;
        while(count < pivot && tempNode != null) {
            tempNode = tempNode.nextNode;
            count++;
        }
        if (tempNode == null || tempNode.nextNode == null) {
            return;
        }
        LinkedList.Node pivotNode = tempNode.nextNode;
        tempNode.nextNode = null;
        tempNode = pivotNode;
        while(tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = ll.headNode;
        ll.headNode = pivotNode;
    }

    public static void main(String args[]) {
        RotatingLinkedList roatingLinkedListInstance = new RotatingLinkedList();
        LinkedList ll = new LinkedList();
        ll.initList(new int[] {1,3,5,6,7,2});
        System.out.println("before rotating");
        ll.printList();
        roatingLinkedListInstance.rotateLinkedList(ll, 2);
        System.out.println("after rotating");
        ll.printList();
    }
}