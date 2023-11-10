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

    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        activitySelection(start, end);

    }

}
