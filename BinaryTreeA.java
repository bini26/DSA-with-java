import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.*;

public class BinaryTreeA {
    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int height = Math.max(leftHeight, rightHeight) + 1;
        return height;
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftcount = countNodes(root.left);
        int rightcount = countNodes(root.right);
        int count = leftcount + rightcount + 1;
        return count;
    }

    public static int sumNode(Node root) {
        if (root == null) {
            return 0;
        }
        int leftsum = sumNode(root.left);
        int rightsum = sumNode(root.right);
        int sum = leftsum + rightsum + root.data;
        return sum;

    }

    public static int diameter2(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDiameter = diameter2(root.left);
        int rightDiameter = diameter2(root.right);
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int selfdiameter = leftHeight + rightHeight + 1;
        int diameter = Math.max(Math.max(leftDiameter, rightDiameter), selfdiameter);
        return diameter;
    }

    static class Info {
        int diameter;
        int height;

        public Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public static Info diameter(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);
        int finalDiameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter),
                leftInfo.height + rightInfo.height + 1);
        int finalHeight = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(finalDiameter, finalHeight);

    }

    public static boolean isIdentical(Node node, Node subNode) {
        if (node == null && subNode == null) {
            return true;
        } else if (node == null || subNode == null || node.data != subNode.data) {
            return false;
        }
        if (!isIdentical(node.left, subNode.left)) {
            return false;
        }
        if (!isIdentical(node.right, subNode.right)) {
            return false;
        }
        return true;

    }

    public static boolean isSubTree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }
        boolean leftAns = isSubTree(root.left, subRoot);
        boolean rightAns = isSubTree(root.right, subRoot);

        return leftAns || rightAns;

    }

    public static class topInfo {
        Node node;
        int hd;

        public topInfo(Node node, int hd) {
            this.node = node;
            this.hd = hd;

        }
    }

    public static void topView(Node root) {
        // Level Order treversal
        Queue<topInfo> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0;
        int max = 0;
        q.add(new topInfo(root, 0));
        q.add(null);
        while (!q.isEmpty()) {
            topInfo curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);

                }
                if (curr.node.left != null) {
                    q.add(new topInfo(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null) {
                    q.add(new topInfo(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + "  ");
        }
        System.out.println();
    }

    public static void klevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + "  ");
            return;
        }
        klevel(root.left, level + 1, k);
        klevel(root.right, level + 1, k);
        System.out.println();
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.data == n) {
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);
        if (foundLeft || foundRight) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root, n1, path1);
        getPath(root, n2, path2);
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }

        }
        Node lca = path1.get(i - 1);
        return lca;

    }

    public static Node lca2(Node root, int n1, int n2) {

        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);
        if (rightLca == null) {
            return leftLca;
        }
        if (leftLca == null) {
            return rightLca;
        }
        return root;
    }

    public static void main(String[] args) {
        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         * 
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        /*
         * 2
         * / \
         * 4 5
         */
        // Node subRoot = new Node(2);
        // subRoot.left = new Node(4);
        // subRoot.right = new Node(5);

        // System.out.println(isSubTree(root, subRoot));
        // topView(root);
        // k=2
        // klevel(root,1,k);
        int n1 = 4, n2 = 7;
        System.out.println(lca2(root, n1, n2).data);

    }
}
