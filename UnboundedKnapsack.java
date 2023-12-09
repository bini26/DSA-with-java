import java.util.*;

public class UnboundedKnapsack {

    public static int coinChange(int coins[], int sum) {
        int n = coins.length;
        int dp[][] = new int[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[n][sum];
    }

    public static int rodCutting(int length[], int price[], int totRod) {
        int n = length.length;
        int dp[][] = new int[n + 1][totRod + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < totRod + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < totRod + 1; j++) {

                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);

                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][totRod];

    }

    public static int lcsMemo(String str1, String str2, int n, int m, int dp[][]) {// longest Common Subsequesnce
                                                                                   // Memoization
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {// same
            return dp[n][m] = lcsMemo(str1, str2, n - 1, m - 1, dp) + 1;

        } else {
            int ans1 = lcsMemo(str1, str2, n - 1, m, dp);
            int ans2 = lcsMemo(str1, str2, n, m - 1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }

    }

    public static int lcsTabulation(String str1, String str2, int n, int m) {// longest Common Subsequence using
                                                                             // Tabulation
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }

            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {// same char in last
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {// last is not same
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {

        int coins[] = { 1, 2, 3 };
        int sum = 4;
        // System.out.println(coinChange(coins, sum));

        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int totRod = 8;
        // System.out.println(rodCutting(length, price, totRod));

        String str1 = "abcde";
        String str2 = "aghtdvs";
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = -1;

            }
        }
        // System.out.println(lcsMemo(str1, str2, n, m, dp));
        System.out.println(lcsTabulation(str1, str2, n, m));
    }

}