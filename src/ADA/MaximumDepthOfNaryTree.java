package ADA;

import java.util.Arrays;
import java.util.List;

public class MaximumDepthOfNaryTree {
    public static void main(String[] args) {
        Node n8 = new Node(8);
        Node n7 = new Node(7, Arrays.asList(n8));
        Node n6 = new Node(6);
        Node n5 = new Node(5);
        Node n4 = new Node(4, Arrays.asList(n7));
        Node n3 = new Node(3, Arrays.asList(n5, n6));
        Node n2 = new Node(2);
        Node root = new Node(1, Arrays.asList(n2, n3, n4));

        System.out.println(maxDepth(root));
    }
    public static int maxDepth(Node root) {
        if (root == null) return 0;

        if (root.children == null || root.children.isEmpty()) return 1;

        int maxChildDepth = 0;

        for (Node child : root.children) {
            if (child == null) continue;

            int childDepth = maxDepth(child);

            if (childDepth > maxChildDepth) {
                maxChildDepth = childDepth;
            }
        }
        return maxChildDepth + 1;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
