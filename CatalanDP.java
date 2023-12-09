import java.util.*;

public class CatalanDP {

    public static int catalanNumberRecursion(int n) {
        int cat = 0;// Cn
        if (n == 0 || n == 1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            cat += catalanNumberRecursion(i) * catalanNumberRecursion(n - i - 1);
        }
        return cat;
    }

    public static void main(String[] args) {
        System.out.println(catalanNumberRecursion(3));
    }
}
