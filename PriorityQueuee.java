import java.util.PriorityQueue;

public class PriorityQueuee {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }

    }

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(4);
        pq.add(7);
        pq.add(3);
        pq.add(9);
        pq.add(2);

        while (!pq.isEmpty()) {
            System.out.print(pq.peek() + "   ");
            pq.remove();
        }

    }
}
