import java.io.*;

class Stack {
    int top1;
    int top2;
    int max_size = 10;
    int[] arr;
    int currentArrayOccupancy;

    Stack() {
        this.top1 = -1;
        this.top2 = 10;
        this.arr = new int[10];
        this.currentArrayOccupancy = 0;
    }

    Stack(int size) {
        this.top1 = -1;
        this.top2 = size;
        this.arr = new int[size];
        this.currentArrayOccupancy = 0;
    }

    void push1(int value) {
        if (this.currentArrayOccupancy == this.max_size) {
            System.out.println("stack is full");
            return;
        }
        this.top1++;
        this.currentArrayOccupancy++;
        this.arr[this.top1] = value;
    }

    void push2(int value) {
        if (this.currentArrayOccupancy == this.max_size) {
            System.out.println("stack is full");
            return;
        }
        this.top2--;
        this.currentArrayOccupancy++;
        this.arr[this.top2] = value;
    }

    int pop1() {
        if (this.currentArrayOccupancy == 0 || this.top1 == -1) {
            System.out.println("stack is empty");
            return -323443;
        }
        int temp = this.arr[this.top1];
        this.top1--;
        this.currentArrayOccupancy--;
        return temp;
    }
    
    int pop2() {
        if (this.currentArrayOccupancy == 0 || this.top2 == this.max_size) {
            System.out.println("stack is empty");
            return -34353;
        }
        int temp = this.arr[this.top2];
        this.top2++;
        this.currentArrayOccupancy--;
        return temp;
    }
    
    void printStackArray() {
        System.out.print("printing stack array ");
        for (int i = 0; i < this.max_size; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.print("\n");
    }
}

public class TwoStacksWithSingleArray {
    
    public static void main(String args[]) {
        Stack stack = new Stack();
        stack.push1(3);
        stack.push2(4);
         stack.push1(3);
        stack.push2(4);
         stack.push1(3);
        stack.push2(4);
         stack.push1(3);
        stack.push2(4);
        stack.pop1();
        stack.pop2();
         stack.push1(7);
        stack.push2(8);
        stack.printStackArray();
    }
}