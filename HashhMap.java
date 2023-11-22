import java.util.LinkedList;
import java.util.ArrayList;

public class HashhMap {
    static class HashMapCode<K, V> {// k,v generic hunxa
        private class Node {

            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;// n
        private LinkedList<Node> buckets[];// N

        @SuppressWarnings("unchecked")
        public HashMapCode() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;

        }

        private int searchInLinkedList(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N * 2];
            N = 2 * N;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLinkedList(key, bi);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lambda = n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLinkedList(key, bi);

            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLinkedList(key, bi);

            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLinkedList(key, bi);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    // public static void main(String[] args) {
    // // create
    // HashMap<String, Integer> hm = new HashMap<>();

    // // insert
    // hm.put("Nepal", 5);
    // hm.put("China", 150);
    // hm.put("USA", 130);
    // hm.put("India", 200);
    // // System.out.println(hm);

    // // Get
    // // System.out.println(hm.get("Nepal"));
    // // // contains key
    // // System.out.println(hm.containsKey("India"));
    // // // remove
    // // hm.remove("China");
    // // System.out.println(hm);

    // // Iterate
    // Set<String> keys = hm.keySet();
    // System.out.println(keys);
    // for (String k : keys) {
    // System.out.println("Key => " + k + ", Value=> " + hm.get(k));

    // }
    // }
    public static void main(String[] args) {
        HashMapCode<String, Integer> hm = new HashMapCode<>();
        hm.put("Nepal", 50);
        hm.put("China", 200);
        hm.put("India", 250);

        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key);
        }

    }

}
