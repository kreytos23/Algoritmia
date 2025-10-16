package ADA;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        int index = 0;
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        backtraking(1, n, k, ans, path);
        return ans;

    }
    public static void backtraking(int start, int n, int k, List<List<Integer>> ans, List<Integer> path){
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        int need = k - path.size();

        for (int i = start; i <= n - need + 1; i++) {
            // Elegir i
            path.add(i);

            // Siguiente elección deberá ser mayor a i (para no repetir/mezclar orden)
            backtraking(i + 1, n, k, ans, path);

            // Backtrack: deshacer la elección de i
            path.remove(path.size() - 1);
        }
    }
}
