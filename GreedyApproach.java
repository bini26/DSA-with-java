import java.util.*;

public class GreedyApproach {

    public static void activitySelection(int start[], int end[]) {// O(n)
        // if end time is not in sorting ording then we have to sort first
        int activity[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activity[i][0] = i;
            activity[i][1] = start[i];
            activity[i][2] = end[i];
        }
        // using lamda function ->
        Arrays.sort(activity, Comparator.comparingDouble(o -> o[2]));
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        // lst activity
        maxAct = 1;
        ans.add(activity[0][0]);
        int lastEnd = activity[0][2];
        for (int i = 1; i < end.length; i++) {
            if (activity[i][1] >= lastEnd) {
                maxAct++;
                ans.add(activity[i][0]);
                lastEnd = activity[i][2];
            }

        }

        /*
         * //if given array / activity is sorted
         * int maxAct = 0;
         * ArrayList<Integer> ans = new ArrayList<>();
         * // lst activity
         * maxAct = 1;
         * ans.add(0);
         * int lastEnd = end[0];
         * for (int i = 1; i < end.length; i++) {
         * if (start[i] >= lastEnd) {
         * maxAct++;
         * ans.add(i);
         * lastEnd = end[i];
         * }
         * 
         * }
         */
        System.out.println("Maximum Activity done: " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + "  ");
        }
        System.out.println();
    }

    public static void fractionalKnapsack(int val[], int weight[], int w) {
        double ratio[][] = new double[val.length][2];
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }
        // ascending order sorting
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        int capacity = w;
        int finalVal = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                finalVal += val[idx];
                capacity -= weight[idx];

            } else {
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("So the maximum value we can store in KnapSack is : " + finalVal);
    }

    public static void minAbsoluteDifferencePairs(int A[], int B[]) {// O(n)logn
        Arrays.sort(A);
        Arrays.sort(B);
        int minDiff = 0;
        for (int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }
        System.out.println("Minimum absolute difference is :" + minDiff);
    }

    public static void MaxLengthChainOfPairs(int pairs[][]) {
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int chainLength = 1;
        int chainEnd = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > chainEnd) {
                chainLength++;
                chainEnd = pairs[i][1];
            }
        }
        System.out.println("Max length chain of pair :" + chainLength);
    }

    public static void indianCoins(Integer coins[], int amount) {
        Arrays.sort(coins, Comparator.reverseOrder());
        int countOfCoins = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    countOfCoins++;
                    ans.add(coins[i]);
                    amount -= coins[i];

                }

            }
        }
        System.out.println("Total minimum coins used :" + countOfCoins);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " + ");
        }

    }

    public static class Job {
        int deadline;
        int profit;
        int id;// 0(A),1(B),2(C)

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void jobSequencingproblem(int jobInfo[][]) {
        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);// descending order sorting

        ArrayList<Integer> sequence = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job currJob = jobs.get(i);
            if (currJob.deadline > time) {
                sequence.add(currJob.id);
                time++;
            }
        }
        System.out.println("Maximum job : " + sequence.size());
        for (int i = 0; i < sequence.size(); i++) {
            System.out.print(sequence.get(i) + "  ");
        }
        System.out.println();

    }

    public static void chocolaProblem() {
        int n = 4, m = 5;
        Integer costHorz[] = { 4, 1, 2 };// n-1
        Integer costVer[] = { 2, 1, 3, 1, 4 };// m-1
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHorz, Collections.reverseOrder());
        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;
        while (h < costHorz.length && v < costVer.length) {
            if (costVer[v] <= costHorz[h]) {// horizontal cut
                cost += (costHorz[h] * vp);
                hp++;
                h++;

            } else {
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }
        while (h < costHorz.length) {
            cost += (costHorz[h] * vp);
            hp++;
            h++;
        }
        while (v < costVer.length) {
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }
        System.out.println("Minimum cost of cuts : " + cost);

    }

    public static void main(String[] args) {
        // int start[] = { 1, 3, 0, 5, 8, 5 };
        // int end[] = { 2, 4, 6, 7, 9, 9 };

        // activitySelection(start, end);
        // int val[] = { 60, 100, 120 };
        // int weight[] = { 10, 20, 30 };
        // int w = 50;
        // fractionalKnapsack(val, weight, w);
        // int A[] = { 4, 1, 8, 7 };
        // int B[] = { 2, 3, 6, 5 };
        // minAbsoluteDifferencePairs(A, B);
        // int pair[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        // MaxLengthChainOfPairs(pair);
        // Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        // indianCoins(coins, 590);
        // int job[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        // jobSequencingproblem(job);
        chocolaProblem();
    }

}
