import java.io.*;

class QueueLinkedList {
    
    Node startNode;
    Node endNode;
    int currentSize;

    QueueLinkedList() {
        this.startNode = null;
        this.endNode = null;
        this.currentSize = 0;
    }

    static class Node {
        int value;
        Node nextNode;

        Node(int value) {
            this.value = value;
            this.nextNode = null;
        }

        int getValue() {
            return this.value;
        }

        void setValue(int value) {
            this.value = value;
        }
    }

    void enqueue(int value) {
        if(this.startNode == null) {
            this.startNode = new Node(value);
            this.currentSize++;
            this.endNode = this.startNode;
            return;
        }
        Node tempNode = this.startNode;
        while(tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = new Node(value);
        this.endNode = tempNode.nextNode;
        this.currentSize++;
    }

    int dequeue() {
        if (this.endNode == null) {
            System.out.println("queue is empty");
            return -4334345;
        }
        int tempValue = this.startNode.getValue();
        this.startNode = this.startNode.nextNode;
        if (this.startNode == null) {
            this.endNode = null;
        }
        return tempValue;
    }

    int getStart() {
        if (this.startNode == null) {
            System.out.println("queue is empty");
            return -4345345;
        }
        return this.startNode.getValue();
    }

    int getEnd() {
        if (this.endNode == null) {
            System.out.println("queue is empty");
            return -3224234;
        }
        return this.endNode.getValue();
    }

}

public class QueueWithLinkedList {

    public static void main(String args[]) {
        QueueLinkedList q = new QueueLinkedList();
        q.enqueue(1);
        q.enqueue(3);
        q.enqueue(2);
        q.enqueue(7);
        q.enqueue(5);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.getStart());
        System.out.println(q.getEnd());
        q.enqueue(9);
        System.out.println(q.getStart());
        System.out.println(q.getEnd());
    }
}