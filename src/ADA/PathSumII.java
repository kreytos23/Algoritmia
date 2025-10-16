package ADA;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
    }

    public List<List<Integer>> pathSum(TreeNodeBin root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(root, targetSum, path, ans);
        return ans;

    }

    public void backtrack (TreeNodeBin node, int remainSum, List<Integer> path, List<List<Integer>> src){
        if (node == null)
            return;

        path.add(node.val);
        remainSum -= node.val;

        if (node.right == null && node.left == null && remainSum == 0){
            src.add(new ArrayList<>(path));
        } else{
            backtrack(node.right, remainSum, path, src);
            backtrack(node.left, remainSum, path, src);
        }

        path.remove(path.size() - 1);
    }
}

class TreeNodeBin {
    int val;
    TreeNodeBin left;
    TreeNodeBin right;

    TreeNodeBin() {
    }

    TreeNodeBin(int val) {
        this.val = val;
    }

    TreeNodeBin(int val, TreeNodeBin left, TreeNodeBin right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
