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

    public static int catalanNumberMemoization(int n, int dp[]) {
        int cat = 0;
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        for (int i = 0; i < n; i++) {
            cat += catalanNumberMemoization(i, dp) * catalanNumberMemoization(n - i - 1, dp);

        }
        return dp[n] = cat;

    }

    public static int catalanNumberTebulation(int n) {// O(n^2)
        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static int countBST(int n) {

        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                int left = dp[j];// left subtree
                int right = dp[i - j - 1];// right subtree
                dp[i] += left * right;
            }
        }
        return dp[n];
    }

    public static int mountainRanges(int n) {

        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                int inside = dp[j];// ranges laying inside
                int outside = dp[i - j - 1];// ranges laying outside
                dp[i] += inside * outside;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        // System.out.println(catalanNumberMemoization(n, dp));
        System.out.println(catalanNumberTebulation(n));
    }
}
