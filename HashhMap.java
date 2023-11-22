import java.util.*;

public class HashhMap {
    public static void main(String[] args) {
        // create
        HashMap<String, Integer> hm = new HashMap<>();

        // insert
        hm.put("Nepal", 5);
        hm.put("China", 150);
        hm.put("USA", 130);
        hm.put("India", 200);
        // System.out.println(hm);

        // Get
        // System.out.println(hm.get("Nepal"));
        // // contains key
        // System.out.println(hm.containsKey("India"));
        // // remove
        // hm.remove("China");
        // System.out.println(hm);

        // Iterate
        Set<String> keys = hm.keySet();
        System.out.println(keys);
        for (String k : keys) {
            System.out.println("Key => " + k + ", Value=> " + hm.get(k));

        }
    }

}
