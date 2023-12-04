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

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;

        System.out.println(knapsackRecursion(wt, val, W, val.length));
    }
}
