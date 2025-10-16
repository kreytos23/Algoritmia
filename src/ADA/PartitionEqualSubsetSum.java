package ADA;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {

    }

    public boolean canPartition(int[] nums) {

        int target = 0;

        for (int num : nums) {
            target += num;
        }

        if ((target & 1) == 1)
            return false;

        target = target >> 1;

        int n = nums.length;

        // dp[i][s] = true si puedo formar la suma s usando los primeros i elementos
        boolean[][] dp = new boolean[n + 1][target + 1];

        // 1️⃣ Base: con 0 elementos, solo la suma 0 es posible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // 2️⃣ Rellenar la tabla
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1]; // elemento actual (porque dp tiene 1-based i)
            for (int s = 1; s <= target; s++) {
                // Caso 1: no uso este número → heredo valor anterior
                dp[i][s] = dp[i - 1][s];

                // Caso 2: uso este número si no me paso del target
                if (s >= num) {
                    dp[i][s] = dp[i][s] || dp[i - 1][s - num];
                }
            }
        }

        // 3️⃣ La respuesta final está en dp[n][target]
        return dp[n][target];
    }

}
