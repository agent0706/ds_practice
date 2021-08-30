import java.io.*;

 class Stack {
    static final int max_size = 1000;
    int[] arr = new int[max_size];
    int top;
    
    Stack() {
        this.top = -1;
    }

    int pop() {
        if (this.top < 0) {
            System.out.println("Stack is empty");
            return -3242342;
        }
        int temp = this.arr[this.top];
        this.top--;
        return temp;
    }

    void push(int value) {
        if (this.top == this.max_size - 1) {
            System.out.println("stack overflow error");
            return;
        }
        this.top++;
        this.arr[this.top] = value;
    }

    int peek() {
        if (this.top < 0) {
            System.out.println("stack is empty");
            return -324224;
        }
        return this.arr[this.top];
    }

    boolean isEmpty() {
        if (this.top < 0) {
            return true;
        }
        return false;
    }

}

public class StackWithArray {
    
    public static void main(String args[]) {
        Stack stack = new Stack();
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