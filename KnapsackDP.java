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

    public static int knapsackTabulation(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {

                int v = val[i - 1];
                int w = wt[i - 1];
                if (w <= j) {// valid
                    int incProfit = v + dp[i - 1][j - w];// include profit
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {// invalid
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        return dp[n][W];
    }

    public static boolean targetSumTabulation(int num[], int target) {
        int n = num.length;
        boolean dp[][] = new boolean[n + 1][target + 1];
        for (int i = 0; i < n + 1; i++) {// i = items and j=targetsum
            dp[i][0] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                int v = num[i - 1];
                // include
                if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;
                } else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][target];
    }

    public static int UnboundedKnapsack(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < W + 1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) {// valid
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {// invalid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    // Minimum Partitioning
    public static int minimumPartitioning(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int w = sum / 2;
        int dp[][] = new int[n + 1][w + 1];

        // bottom up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int sum1 = dp[n][w];
        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);
    }

    // Minimum Partitioning
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
        // System.out.println(knapsackMemoization(wt, val, W, val.length, dp));
        // System.out.println(knapsackTabulation(val, wt, W));
        int number[] = { 4, 2, 7, 1, 3 };
        int targetSum = 10;
        // System.out.println(targetSumTabulation(number, targetSum));
        // System.out.println(UnboundedKnapsack(val, wt, W));
        int arr[] = { 1, 11, 6, 5 };
        System.out.println(minimumPartitioning(arr));
    }
}
