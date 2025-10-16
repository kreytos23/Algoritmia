package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class reorderedPowerOf2 {
    public static void main(String[] args) {
        System.out.println();
        System.out.println(permutacionesSinCeroInicial(1).stream().anyMatch(n -> n > 0 && ((n & (n - 1)) == 0)));
        System.out.println(permutacionesSinCeroInicial(6).stream().anyMatch(n -> n > 0 && ((n & (n - 1)) == 0)));
        System.out.println(permutacionesSinCeroInicial(345).stream().anyMatch(n -> n > 0 && ((n & (n - 1)) == 0)));
        System.out.println(permutacionesSinCeroInicial(64).stream().anyMatch(n -> n > 0 && ((n & (n - 1)) == 0)));

    }

    public static List<Integer> permutacionesSinCeroInicial(int numero) {
        // Convertir número a lista de dígitos
        List<Integer> digitos = new ArrayList<>();
        if (numero == 0) {
            digitos.add(0);
        } else {
            while (numero > 0) {
                digitos.add(numero % 10);
                numero /= 10;
            }
            Collections.reverse(digitos); // mantener el orden original
        }

        // Ordenamos para poder evitar duplicados
        Collections.sort(digitos);

        boolean[] usado = new boolean[digitos.size()];
        List<Integer> resultado = new ArrayList<>();
        List<Integer> actual = new ArrayList<>();

        backtrack(digitos, usado, actual, resultado);
        return resultado;
    }

    private static void backtrack(List<Integer> digitos, boolean[] usado,
                                  List<Integer> actual, List<Integer> resultado) {
        if (actual.size() == digitos.size()) {
            // Convertir la lista de dígitos a número entero
            int valor = 0;
            for (int d : actual) {
                valor = valor * 10 + d;
            }
            resultado.add(valor);
            return;
        }

        for (int i = 0; i < digitos.size(); i++) {
            if (usado[i]) continue;

            // Evitar duplicados (solo tomamos el primero de cada grupo igual)
            if (i > 0 && Objects.equals(digitos.get(i), digitos.get(i - 1)) && !usado[i - 1]) continue;

            // Evitar que el primer dígito sea cero
            if (actual.isEmpty() && digitos.get(i) == 0) continue;

            usado[i] = true;
            actual.add(digitos.get(i));

            backtrack(digitos, usado, actual, resultado);

            actual.remove(actual.size() - 1);
            usado[i] = false;
        }
    }

    /*
    public boolean reorderedPowerOf2(int n) {
        String target = countDigits(n);

        for (int i = 0; i < 31; i++) { // 2^30 < 10^9
            int power = 1 << i;
            if (target.equals(countDigits(power))) {
                return true;
            }
        }
        return false;
    }

    private String countDigits(int num) {
        int[] count = new int[10];
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int c : count) {
            sb.append(c);
        }
        return sb.toString();
    }
     */
}

