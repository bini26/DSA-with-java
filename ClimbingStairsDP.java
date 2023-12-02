import java.util.*;

public class ClimbingStairsDP {

    public static int recursion(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        // if (n == 1 || n == 2 || n == 3) {
        // return n;
        // }
        return recursion(n - 1) + recursion(n - 2);
    }

    public static int memoization(int n, int dp[]) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = memoization(n - 1, dp) + memoization(n - 2, dp);
        return dp[n];
    }

    public static int tabulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

    public static void main(String[] args) {
        int n = 4;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(tabulation(n));
    }
}
