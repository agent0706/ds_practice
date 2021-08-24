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
        for(int i = 1; i < values.length; i++) {
            tempNode.nextNode = new Node(values[i]);
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
            System.out.print(tempNode.getValue() + "\n");
            tempNode = tempNode.nextNode;
        }
        System.out.print("\n");
    }
}

public class DetectingLoopInLinkedList {

    LinkedList.Node isReachable(LinkedList.Node currentNode, LinkedList.Node loopNode) {
        LinkedList.Node tempNode = loopNode;
        while(true) {
            if (tempNode.nextNode == loopNode) {
                return null;
            }
            if (tempNode.nextNode == currentNode) {
                return tempNode;
            }
            tempNode = tempNode.nextNode;
        }
    }

    void removeLoop(LinkedList.Node headNode, LinkedList.Node loopNode) {
        LinkedList.Node tempNode = headNode;
        while(tempNode != null) {
            LinkedList.Node nodeTOBeSeverd = isReachable(tempNode, loopNode);
            if (nodeTOBeSeverd != null) {
                nodeTOBeSeverd.nextNode = null;
                return;
            }
            tempNode = tempNode.nextNode;
        }
    }

    void detectAndRemoveLoop(LinkedList ll) {
        // detecting loop node can be any of the loop nodes
        LinkedList.Node fastPointer = ll.headNode;
        LinkedList.Node slowPointer = ll.headNode;
        while(fastPointer != null || slowPointer != null || fastPointer.nextNode != null) {
            fastPointer = fastPointer.nextNode.nextNode;
            slowPointer = slowPointer.nextNode;
            if (fastPointer == slowPointer) {
                removeLoop(ll.headNode, fastPointer);
                return;
            }
        }
    }
    
    public static void main(String args[]) {
        DetectingLoopInLinkedList detectingLoopInLinkedListInstance = new DetectingLoopInLinkedList();
        LinkedList ll = new LinkedList();
        ll.initList(new int[] {1, 3, 6});
        ll.headNode.nextNode.nextNode.nextNode = ll.headNode.nextNode;
        //ll.printList();
        detectingLoopInLinkedListInstance.detectAndRemoveLoop(ll);
        ll.printList();
    }
}