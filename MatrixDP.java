import java.util.*;

public class MatrixDP {// This is part of DP on Grid

    public static int mcm(int arr[], int i, int j) {// Matrix chain multiplication
        int ans = Integer.MAX_VALUE;
        if (i == j) {
            return 0;
        }
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcm(arr, i, k);
            int cost2 = mcm(arr, i + 1, j);
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);

        }
        return ans;
    }

    public static int mcmMemoization(int arr[], int i, int j, int dp[][]) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcmMemoization(arr, i, k, dp);
            int cost2 = mcmMemoization(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(ans, cost1 + cost2 + cost3);
        }
        return dp[i][j] = ans;
    }

    public static int mcmTabulation(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        // bottom up
        for (int len = 2; len <= n - 1; len++) {
            for (int i = 1; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k + 1][j];
                    int cost3 = arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
                }
            }
        }

        return dp[1][n - 1];
    }

    public static int minArrayJump(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int steps = arr[i];
            int ans = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + steps && j < n; j++) {
                if (dp[j] != -1) {
                    ans = Math.min(ans, dp[j] + 1);
                }
                if (ans != Integer.MAX_VALUE) {
                    dp[i] = ans;
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length;
        // System.out.println(mcm(arr, 0, n - 1));
        // int dp[][] = new int[n][n];
        // for (int i = 0; i < n; i++) {
        // Arrays.fill(dp[i], -1);
        // }
        // System.out.println(mcmMemoization(arr, 1, n - 1, dp));
        // System.out.println(mcmTabulation(arr));
        System.out.println(minArrayJump(arr));
    }
}
