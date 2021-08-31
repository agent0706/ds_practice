import java.io.*;

class StackLinkedList {

    Node topNode;

    StackLinkedList() {
        this.topNode = null;
    }

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

    void push(int value) {
        if (this.topNode == null) {
            this.topNode = new Node(value);
            return;
        }
        Node tempNode = new Node(value);
        tempNode.nextNode = this.topNode;
        this.topNode = tempNode;
    }

    int pop() {
        if (this.topNode == null) {
            System.out.println("stack is empty");
            return -4334535;
        }
        int poppedValue = this.topNode.getValue();
        this.topNode = this.topNode.nextNode;
        return poppedValue;
    }

    int peek() {
         if (this.topNode == null) {
            System.out.println("stack is empty");
            return -4334535;
        }
        return this.topNode.getValue();
    }

    boolean isEmpty() {
        if (this.topNode == null) {
            return true;
        }
        return false;
    }
}

public class StackWithLinkedList {

    public static void main(String args[]) {
        StackLinkedList stack = new StackLinkedList();
        System.out.print(stack.peek() + "\n");
        stack.push(1);
        stack.push(2);
        stack.push(5);
        System.out.print(stack.peek() + "\n");
        System.out.print(stack.pop() + "\n");
        System.out.print(stack.peek() + "\n");
        System.out.print(stack.isEmpty() + "\n");
    }
}