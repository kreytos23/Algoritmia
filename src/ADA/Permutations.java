package ADA;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();   // Acumula todas las permutaciones
        List<Integer> path = new ArrayList<>();        // Camino actual (perm. parcial)
        boolean[] used = new boolean[nums.length];     // Marca si ya tomé nums[i]

        // Llamada inicial: nivel 0, sin elementos en el path todavía.
        backtrack(nums, used, path, ans);
        return ans;
    }

    /**
     * Backtracking:
     * - En cada nivel, recorremos TODOS los elementos posibles.
     * - Si nums[i] ya fue usado en el path actual, lo saltamos.
     * - Si no está usado, lo elegimos, avanzamos (nivel + 1), y luego deshacemos (backtrack).
     */
    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> ans) {
        // Caso base: si el path ya tiene longitud n, formamos una permutación completa.
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path)); // ¡Clonar! No referenciar el mismo path.
            return;
        }

        // Paso recursivo: probar cada número aún no tomado.
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;           // Si ya está en el path, no lo vuelvas a usar.

            // 1) Elegir nums[i]
            used[i] = true;                  // Marcar como usado
            path.add(nums[i]);               // Agregar al camino actual

            // 2) Recurrir al siguiente nivel
            backtrack(nums, used, path, ans);

            // 3) Backtrack: deshacer la elección para explorar otra permutación
            path.remove(path.size() - 1);    // Quitar el último agregado
            used[i] = false;                 // Marcar como disponible de nuevo
        }
    }
}
