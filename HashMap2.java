import java.util.*;

public class HashMap2 {
    public static void majorityElement(int nums[], HashMap<Integer, Integer> hm) {

        int num;
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            // if (hm.containsKey(num)) {
            // hm.put(num, hm.get(num) + 1);
            // } else {
            // hm.put(num, 1);
            // }
            hm.put(num, hm.getOrDefault(hm, 0) + 1);
        }
        // Set<Integer> keySet = hm.keySet();
        // for (Integer key : keySet) {
        for (Integer key : hm.keySet()) {
            if (hm.get(key) > nums.length / 3) {
                System.out.println(key);
            }
        }

    }

    public static void validAnagram(String s, String t) {
        if (s.length() != t.length()) {
            System.out.println("False");
            return;
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(hm, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (hm.get(ch) != null) {
                if (hm.get(ch) == 1) {
                    hm.remove(ch);
                } else {
                    hm.put(ch, hm.get(ch) - 1);
                }
            } else {
                System.out.println("False");
                return;
            }
        }
        if (hm.isEmpty()) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static void main(String[] args) {
        // // jun order ma haleko tehi order ma basxa
        // LinkedHashMap<String, Integer> menu = new LinkedHashMap<>();
        // menu.put("Chowmin", 100);
        // menu.put("Chiya", 25);
        // menu.put("MOMO", 120);
        // menu.put("Briyani", 250);
        // System.out.println(menu);
        // // Tree sorted hunxa key
        // TreeMap<String, Integer> tMenu = new TreeMap<>();
        // tMenu.put("Chowmin", 100);
        // tMenu.put("Chiya", 25);
        // tMenu.put("MOMO", 120);
        // tMenu.put("Briyani", 250);
        // System.out.println(tMenu);
        int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        HashMap<Integer, Integer> hm = new HashMap<>();
        majorityElement(arr, hm);
        String s = "race";
        String t = "caret";
        validAnagram(s, t);

    }
}
