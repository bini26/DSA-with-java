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

    public static int longestCommonSubstring(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = 0;
        }
        // bottomup code
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;

    }

    public static int lis(int arr1[]) {// longest increasing subsequence
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        int arr2[] = new int[set.size()];// sortes unique element
        int i = 0;
        for (int num : set) {
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2);// ascending order sorting

        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n + 1][m + 1];
        // initialization
        for (int j = 0; j < n + 1; j++) {
            dp[j][0] = 0;
        }
        for (int k = 0; k < n + 1; k++) {
            dp[0][k] = 0;
        }

        for (int j = 1; j < n + 1; j++) {
            for (int k = 1; k < m + 1; k++) {
                if (arr1[j - 1] == arr2[k - 1]) {
                    dp[j][k] = dp[j - 1][k - 1] + 1;
                } else {
                    int ans1 = dp[j - 1][k];
                    int ans2 = dp[j][k - 1];
                    dp[j][k] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static int editDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {// initialize
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {// bottomup
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {// same wala case
                    dp[i][j] = dp[i - 1][j - 1];
                } else {// diffrent wala case
                    int add = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int replace = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(add, Math.min(delete, replace));
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

        String str1 = "intention";
        String str2 = "execution";
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = -1;

            }
        }
        // System.out.println(lcsMemo(str1, str2, n, m, dp));
        // System.out.println(lcsTabulation(str1, str2, n, m));
        // System.out.println(longestCommonSubstring(str1, str2));
        int arr[] = { 50, 3, 10, 7, 40, 80 };
        // System.out.println(lis(arr));
        System.out.println(editDistance(str1, str2));

    }

}