package Trees;

import Grafos.Node;
import Grafos.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;
        t1.right = null;
        invertTree(t1);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current != null){
                if (!(current.right == null && current.left == null)){
                    queue.add(current.right);
                    queue.add(current.left);
                    TreeNode aux = current.right;
                    //System.out.println(current.val);
                    current.right = current.left;
                    current.left = aux;
                }
            }
        }
        return root;
    }

    //Recursividad
    /*
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
     */
}
