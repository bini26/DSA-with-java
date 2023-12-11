public class SegmentTree {

    static int tree[];

    public static void initialize(int n) {
        tree = new int[4 * n];
    }

    public static int buildST(int arr[], int sti, int start, int end) {
        if (start == end) {
            tree[sti] = arr[start];
            return arr[start];
        }
        int mid = (start + end) / 2;
        buildST(arr, 2 * sti + 1, start, mid);// left subtree - 2*i+1
        buildST(arr, 2 * sti + 2, mid + 1, end);// right subtree - 2*i +2
        tree[sti] = tree[2 * sti + 1] + tree[2 * sti + 2];
        return tree[sti];
    }

    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
        if (qj <= si || qi >= sj) {
            return 0;
        } else if (si >= qi && sj <= qj) {
            return tree[i];
        } else {
            int mid = (si + sj) / 2;
            int left = getSumUtil(2 * i + 1, si, mid, qi, qj);
            int right = getSumUtil(2 * i + 2, mid + 1, sj, qi, qj);
            return left + right;
        }
    }

    public static int getSum(int arr[], int qi, int qj) {
        int n = arr.length;
        return getSumUtil(0, 0, n - 1, qi, qj);
    }

    public static void updateUtil(int i, int si, int sj, int idx, int diff) {
        if (idx > sj || idx < si) {
            return;
        }
        tree[i] += diff;
        if (si != sj) {
            int mid = (si + sj) / 2;
            updateUtil(2 * i + 1, si, mid, idx, diff);
            updateUtil(2 * i + 2, mid + 1, sj, idx, diff);
        }
    }

    public static void update(int arr[], int idx, int val) {
        int n = arr.length;
        int diff = val - arr[idx];
        arr[idx] = val;

        updateUtil(0, 0, n - 1, idx, diff);
    }

    public static int getMax(int arr[], int qi, int qj) {
        int n = arr.length;
        return getMaxUtil(0, 0, n - 1, qi, qj);
    }

    public static int getMaxUtil(int i, int si, int sj, int qi, int qj) {
        if (si > qj || sj < qi) {
            return Integer.MIN_VALUE;
        } else if (si >= qi && sj <= qj) {
            return tree[i];
        } else {
            int mid = (si + sj) / 2;
            int leftAns = getMaxUtil(2 * i + 1, si, mid, qi, qj);
            int rightAns = getMaxUtil(2 * i + 2, mid + 1, sj, qi, qj);
            return Math.max(leftAns, rightAns);
        }
    }

    public static void updateMax(int arr[], int idx, int newVal) {
        arr[idx] = newVal;
        int n = arr.length;
        updateMaxUtil(0, 0, n - 1, idx, newVal);
    }

    public static void updateMaxUtil(int i, int si, int sj, int idx, int newVal) {
        if (idx < si || idx > sj) {
            return;
        }
        tree[i] = Math.max(tree[i], newVal);
        if (si != sj) {
            int mid = (si + sj) / 2;
            updateMaxUtil(2 * i + 1, si, mid, idx, newVal);
            updateMaxUtil(2 * i + 2, mid + 1, sj, idx, newVal);
        }

    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;
        initialize(n);
        buildST(arr, 0, 0, n - 1);
        // System.out.println(getSum(arr, 2, 5));
        // update(arr, 2, 2);
        // System.out.println(getSum(arr, 2, 5));
        int max = getMax(arr, 2, 5);
        System.out.println(max);
        updateMax(arr, 2, 12);
        max = getMax(arr, 2, 5);
        System.out.println(max);
    }
}
