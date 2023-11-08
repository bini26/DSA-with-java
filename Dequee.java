import java.util.*;
import java.util.LinkedList;

public class Dequee {

    static class Stack {
        Deque<Integer> deque = new LinkedList<>();

        // push
        public void push(int data) {
            deque.addLast(data);
        }

        public int pop() {
            if (deque.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return deque.removeLast();
        }

        public int peek() {
            if (deque.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return deque.getLast();

        }
    }

    public static class Queue {
        Deque<Integer> deque = new LinkedList<>();

        public void add(int data) {
            deque.addLast(data);
        }

        public int remove() {
            if (deque.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return deque.removeFirst();

        }

        public int peek() {
            if (deque.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return deque.getFirst();
        }

    }

    public static void main(String args[]) {
        // Deque<Integer> deque = new LinkedList<>();
        // deque.addFirst(2);
        // deque.addFirst(1);
        // deque.addLast(3);
        // deque.addLast(4);
        // deque.removeFirst();
        // deque.removeLast();
        // System.out.println(deque.getFirst());
        // System.out.println(deque.getLast());
    }

}
