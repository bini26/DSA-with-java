import java.util.*;

public class HashhSet {
    public static void countDistinctElement(int arr[]) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }
        System.out.println(hs.size());
    }

    public static void unionAndIntersection(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        System.out.println("Unoin = " + set.size());

        int count = 0;
        set.clear();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                count++;
                set.remove(arr2[i]);
            }
        }
        System.out.println("Intersection = " + count);

    }

    public static void main(String[] args) {

        // HashSet<String> set = new HashSet<>();
        // set.add(1);
        // set.add(2);
        // set.add(4);
        // set.add(2);
        // System.out.println(set);
        // System.out.println(set.size());
        // // System.out.println(set.contains(2));
        // HashSet<String> name = new HashSet<>();
        // name.add("binod");
        // name.add("ram");
        // name.add("bishal");
        // name.add("puja");
        // name.add("ramesh");
        // Iterator it = name.iterator();
        // while (it.hasNext()) {
        // System.out.print(it.next() + " ");
        // }
        // for (String s : name) {
        // System.out.print(s + " ");
        // }
        // LinkedHashSet<String> lhs = new LinkedHashSet<>();
        // lhs.add("binod");
        // lhs.add("ram");
        // lhs.add("bishal");
        // lhs.add("puja");
        // lhs.add("ramesh");
        // System.out.println(lhs);

        // TreeSet<String> ts = new TreeSet<>();
        // ts.add("binod");
        // ts.add("ram");
        // ts.add("bishal");
        // ts.add("puja");
        // ts.add("ramesh");
        // System.out.println(ts);

        // int arr[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };
        // countDistinctElement(arr);
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };
        unionAndIntersection(arr1, arr2);
    }

}
