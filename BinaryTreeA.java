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
        System.out.println(sumNode(root));
    }
}
