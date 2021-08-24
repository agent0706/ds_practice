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
            System.out.print("Linked list is not empty");
            return;
        }
        if (this.headNode == null) {
            this.headNode = new Node(values[0]);
        }
        Node tempNode = this.headNode;
        for (int i = 1; i < values.length; i++ ) {
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
        System.out.print("Printing linked list " + "\n");
        while(tempNode != null) {
            System.out.print(tempNode.getValue() + " ");
            tempNode = tempNode.nextNode;
        }
        System.out.print("\n");
    }
}

public class ReverseLinkedListInGroups {

    LinkedList.Node reverseLinkedListInGroups(int step, LinkedList.Node headNode) {
        if (headNode == null) {
            return null;
        }
        LinkedList.Node currentNode = headNode;
        LinkedList.Node nextNode = null;
        LinkedList.Node prevNode = null;
        int count = 0;
        while(count < step && currentNode != null) {
            nextNode = currentNode.nextNode;
            currentNode.nextNode = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            count++;
        }
        headNode.nextNode = this.reverseLinkedListInGroups(step, currentNode);
        return prevNode;
    }

    public static void main(String args[]) {
        ReverseLinkedListInGroups reverseLinkedListInGroupsInstance = new ReverseLinkedListInGroups();
        LinkedList ll = new LinkedList();
        ll.initList(new int[] {1, 5, 6, 3, 8, 7});
        System.out.println("before reversing the list");
        ll.printList();
        ll.headNode = reverseLinkedListInGroupsInstance.reverseLinkedListInGroups(3, ll.headNode);
        System.out.println("after reversing the list");
        ll.printList();
    }
}