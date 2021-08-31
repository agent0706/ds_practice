import java.io.*;
import java.lang.Math;

class Queue {
    int start;
    int rear;
    int max_size = 10;
    int currentSize;
    int[] arr = new int[max_size];

    Queue() {
        this.rear = -1;
        this.start = -1;
        this.currentSize = 0;
    }

    Queue(int size) {
        this.max_size = size;
        this.start = -1;
        this.rear = -1;
        this.currentSize = 0;
    }

    boolean isFull() {
        return this.currentSize == this.max_size;
    }

    boolean isEmpty() {
        return this.currentSize <= 0;
    }

    int getSize() {
        return this.currentSize;
    }

    void enqueue(int value) {
        if(this.isFull()) {
            System.out.println("queue is full");
            return;
        }
        this.rear = (this.rear + 1) % this.max_size;
        if (this.start == -1) {
            this.start = 0;
        }
        this.arr[this.rear] = value;
        this.currentSize++;
    }

    int dequeue() {
        if (this.isEmpty()) {
            System.out.println("queue is empty");
            return -3242342;
        }
        int temp = this.arr[this.start];
        this.start = (this.start + 1) % this.max_size;
        this.currentSize--;
        return temp;
    }

    int getStart() {
        if (this.isEmpty()) {
            System.out.println("queue is empty");
            return -43345;
        }
        return this.arr[this.start];
    }

    int getRear() {
        if (this.isEmpty()) {
            System.out.println("queue is empty");
            return -4353453;
        }
        return this.arr[this.rear];
    }
} 

public class QueueWithArray {

    public static void main(String args[]) {
        Queue q = new Queue();
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
        System.out.println(q.getRear());
        q.enqueue(9);
        System.out.println(q.getStart());
        System.out.println(q.getRear());
    }
}