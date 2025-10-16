package ADA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {
    public static void main(String[] args) {

    }

    public List<List<Integer>> recursionSubset(int[] nums) {
        // Lista que contendrá todos los subconjuntos resultado.
        List<List<Integer>> ans = new ArrayList<>();
        // Lista temporal que representa el subconjunto que estamos construyendo.
        List<Integer> path = new ArrayList<>();
        // Llamada al DFS recursivo empezando en el índice 0.
        subsets(0, nums, path, ans);
        return ans;
    }

    public void subsets(int i, int[] nums, List<Integer> path, List<List<Integer>> ans) {
        // Caso base: si ya decidimos para todos los índices, guardamos una COPIA del path.
        if (i == nums.length) {
            ans.add(new ArrayList<>(path)); // ¡copia, no referencia!
            return;
        }

        // 1) Rama "INCLUIR" nums[i]: agregamos el elemento actual al path.
        path.add(nums[i]);
        // Avanzamos al siguiente índice con el elemento incluido.
        subsets(i + 1, nums, path, ans);
        // Backtrack: deshacemos la inclusión para no contaminar otras ramas.
        path.remove(path.size() - 1);

        // 2) Rama "EXCLUIR" nums[i]: NO modificamos path; simplemente avanzamos.
        subsets(i + 1, nums, path, ans);
    }
}
