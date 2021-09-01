import java.io.*;

class Dequeue {

    int currentOccupancy;
    int max_size;
    int[] arr;
    int front;
    int rear;

    Dequeue() {
        this.max_size = 10;
        this.arr = new int[10];
        this.front = -1;
        this.rear = 10;
        this.currentOccupancy = 0;
    }

    Dequeue(int size) {
        this.max_size = size;
        this.arr = new int[size];
        this.front = -1;
        this.rear = size;
        this.currentOccupancy = 0;
    }

    void insertFront(int value) {
        if (this.currentOccupancy == this.max_size) {
            System.out.println("queue is full");
            return;
        }
        if (this.front == this.max_size - 1) {
            this.front = 0;
        } else {
            this.front++;
        }
        this.arr[this.front] = value;
        this.currentOccupancy++;
    }

    void insertRear(int value) {
        if (this.currentOccupancy == this.max_size) {
            System.out.println("queue is full");
            return;
        }
        if (this.rear == 0) {
            this.rear = this.max_size - 1;
        } else {
            this.rear--;
        }
        this.arr[this.rear] = value;
        this.currentOccupancy++;
    }

    void deleteFront() {
        if (this.currentOccupancy == 0) {
            System.out.println("queue is empty");
            return;
        }
        if (this.front == 0) {
            this.front = this.max_size - 1;
        } else {
            this.front--;
        }
        this.currentOccupancy--;
    }

    void deleteRear() {
        if (this.currentOccupancy == 0) {
            System.out.println("queue is empty");
            return;
        }
        if (this.rear == this.max_size - 1) {
            this.rear = 0;
        } else {
            this.rear++;
        }
        this.currentOccupancy--;
    }

    int getFront() {
        if (this.currentOccupancy == 0) {
            System.out.println("queue is empty");
            return -2342423;
        }
        return this.arr[this.front];
    }

    int getRear() {
        if (this.currentOccupancy == 0) {
            System.out.println("queue is empty");
            return -23423423;
        }
        return this.arr[this.rear];
    }

    boolean isEmpty() {
        return this.currentOccupancy == 0;
    }

    boolean isFull() {
        return this.currentOccupancy == this.max_size;
    }

    void printArray() {
        for (int i = 0; i < this.max_size; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.print("\n");
    }

}

public class DequeueWithArray {

    public static void main(String args[]) {
        Dequeue d = new Dequeue(4);
        d.insertFront(1);
        d.insertRear(3);
        d.insertRear(2);
        d.insertRear(5);
        d.deleteRear();
        d.deleteFront();
        System.out.println(d.getFront());
        System.out.println(d.getRear());
        d.printArray();
    }
}