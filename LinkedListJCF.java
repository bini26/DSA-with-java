import java.util.LinkedList;

public class LinkedListJCF {
    public static void main(String args[]) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        System.out.println(ll);
        ll.removeFirst();
    }

}
