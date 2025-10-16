package ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class WaysToExpressAnIntegerAsSumofPowers {
    // Módulo requerido
    private static final int MOD = 1_000_000_007;
    public static void main(String[] args) {

    }

    /**
     * Cuenta el número de combinaciones de bases distintas b1, b2, ... tales que
     * b1^x + b2^x + ... = n, sin importar el orden (cada base se usa a lo más una vez).
     * Se devuelve el conteo módulo 1e9+7.
     */
    public static int countRepresentations(int n, int x) {
        // 1) Precalcular todas las potencias b^x <= n
        List<Integer> powers = generatePowersUpTo(n, x);

        // 2) DP de suma de subconjuntos (cada potencia se puede elegir 0/1 veces).
        //    dp[s] = número de maneras de formar suma s con las potencias vistas hasta ahora.
        int[] dp = new int[n + 1];
        dp[0] = 1; // hay 1 forma de formar suma 0: elegir nada

        // Recorremos cada potencia y actualizamos de n hacia abajo
        for (int p : powers) {
            for (int s = n; s >= p; s--) {
                // Agregamos las formas que llegan a (s - p) y le sumamos p
                dp[s] += dp[s - p];
                if (dp[s] >= MOD) dp[s] -= MOD; // mantener módulo
            }
        }

        return dp[n];
    }

    /**
     * Genera la lista de potencias b^x (con b >= 1) tales que b^x <= n.
     * Se usa potencia entera para evitar errores de punto flotante.
     */
    private static List<Integer> generatePowersUpTo(int n, int x) {
        List<Integer> list = new ArrayList<>();
        int b = 1;
        while (true) {
            long pow = intPow(b, x);
            if (pow > n) break;     // si ya nos pasamos, detenemos
            list.add((int) pow);     // b^x es válido
            b++;                     // siguiente base
        }
        return list;
    }

    /**
     * Potencia entera segura: calcula base^exp usando exponenciación rápida.
     * Devuelve long para evitar overflow intermedio (aunque aquí los valores son pequeños).
     */
    private static long intPow(int base, int exp) {
        long result = 1;
        long cur = base;
        int e = exp;
        while (e > 0) {
            if ((e & 1) == 1) result *= cur;
            cur *= cur;
            e >>= 1;
        }
        return result;
    }
}
