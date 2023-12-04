public class KnapsackDP {
    public static int knapsackRecursion(int wt[], int val[], int W, int idx) {
        if (W == 0 || idx == 0) {
            return 0;
        }
        if (wt[idx - 1] <= W) {// valid
            // include
            int ans1 = val[idx - 1] + knapsackRecursion(wt, val, W - wt[idx - 1], idx - 1);

            // exclude
            int ans2 = knapsackRecursion(wt, val, W, idx - 1);
            return Math.max(ans1, ans2);
        } else {// not valid
            return knapsackRecursion(wt, val, W, idx - 1);
        }
    }

    public static int knapsackMemoization(int wt[], int val[], int W, int idx, int dp[][]) {

        if (W == 0 || idx == 0) {
            return 0;
        }
        if (dp[idx][W] != -1) {
            return dp[idx][W];
        }
        if (wt[idx - 1] <= W) {// valid
            // include
            int ans1 = val[idx - 1] + knapsackMemoization(wt, val, W - wt[idx - 1], idx - 1, dp);

            // exclude
            int ans2 = knapsackMemoization(wt, val, W, idx - 1, dp);
            dp[idx][W] = Math.max(ans1, ans2);
            return dp[idx][W];
        } else {// not valid
            dp[idx][W] = knapsackMemoization(wt, val, W, idx - 1, dp);
            return dp[idx][W];
        }

    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int dp[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        // System.out.println(knapsackRecursion(wt, val, W, val.length));
        System.out.println(knapsackMemoization(wt, val, W, val.length, dp));
    }
}
