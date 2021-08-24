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
        if (values.length == 0) {
            return;
        }
        if (this.headNode != null) {
            System.out.println("linked list is already initialised");
            return;
        }
        this.headNode = new Node(values[0]);
        Node tempNode = this.headNode;
        for (int i=1; i<values.length; i++) {
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
            System.out.print(tempNode.value + " ");
            tempNode = tempNode.nextNode;
        }
         System.out.print("\n");
    }
}

public class MergeSortedLinkedList {

    LinkedList copyList(LinkedList list) {
        LinkedList newList = new LinkedList();
        LinkedList.Node tempNode = list.headNode;
        while(tempNode != null) {
            newList.addNode(tempNode.getValue());
            tempNode = tempNode.nextNode;
        }
        return newList;
    }

    LinkedList getMergedLinkedList(LinkedList l1, LinkedList l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 != null && l2 == null) {
            return this.copyList(l1);
        }
        if (l1 == null && l2 != null) {
            return this.copyList(l2);
        }
        LinkedList newList = new LinkedList();
        LinkedList.Node t1 = l1.headNode;
        LinkedList.Node t2 = l2.headNode;
        while(t1 != null && t2 != null) {
            if (t1.getValue() < t2.getValue()) {
                newList.addNode(t1.getValue());
                t1 = t1.nextNode;
            } else if (t1.getValue() > t2.getValue()) {
                newList.addNode(t2.getValue());
                t2 = t2.nextNode;
            } else {
                newList.addNode(t1.getValue());
                t1 = t1.nextNode;
                t2 = t2.nextNode;
            }
        }
        if (t1 != null) {
            while(t1 != null) {
                newList.addNode(t1.getValue());
                t1 = t1.nextNode;
            }
        }
        if (t2 != null) {
            while(t2 != null) {
                newList.addNode(t2.getValue());
                t2 = t2.nextNode;
            }
        }
        return newList;
    }
    
    public static void main(String args[]) {
        MergeSortedLinkedList mergeSortedLinkedListInstance = new MergeSortedLinkedList();
        LinkedList ll1 = new LinkedList();
        ll1.initList(new int[] {1, 4, 6,9});
        ll1.printList();
        LinkedList ll2 = new LinkedList();
        ll2.initList(new int[] {3,5,8});
        ll2.printList();
        LinkedList mergedLinkedList = mergeSortedLinkedListInstance.getMergedLinkedList(ll1, ll2);
        mergedLinkedList.printList();
    }
}

