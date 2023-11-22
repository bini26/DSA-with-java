import java.util.*;

public class HashMap2 {
    public static void main(String[] args) {
        // jun order ma haleko tehi order ma basxa
        LinkedHashMap<String, Integer> menu = new LinkedHashMap<>();
        menu.put("Chowmin", 100);
        menu.put("Chiya", 25);
        menu.put("MOMO", 120);
        menu.put("Briyani", 250);
        System.out.println(menu);
        // Tree sorted hunxa key
        TreeMap<String, Integer> tMenu = new TreeMap<>();
        tMenu.put("Chowmin", 100);
        tMenu.put("Chiya", 25);
        tMenu.put("MOMO", 120);
        tMenu.put("Briyani", 250);
        System.out.println(tMenu);
    }
}
