package ADA;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TakeGiftsFromTheRichestPile {
    public static void main(String[] args) {
        int [] num = {25,64,9,4,100};
        System.out.println(pickGifts(num, 4));
    }

    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(Arrays.stream(gifts).boxed().collect(Collectors.toList()));

        for (int i = 0; i < k; i++) {
            pq.add((int) Math.sqrt(pq.poll()));
        }

        return pq.stream().mapToLong(Integer::longValue).sum();
    }

    /*
     public static long pickGifts(int[] gifts, int k) {

        // Max-heap: mayor sale primero. Preasignamos capacidad para evitar resize.
        PriorityQueue<Integer> pq = new PriorityQueue<>(gifts.length, Comparator.reverseOrder());

        long sum = 0L; // llevar la suma en tiempo real para evitar un segundo recorrido

        // Cargar sin streams para evitar boxing/listas intermedias
        for (int g : gifts) {
            pq.add(g);
            sum += g; // sumamos todo una vez
        }

        // k operaciones: sacar el mayor, reemplazar por floor(sqrt(mayor)), actualizar suma
        while (k-- > 0 && !pq.isEmpty()) {
            int top = pq.poll();            // mayor actual
            if (top <= 1) break;            // sqrt(1)=1, sqrt(0)=0 → no cambia la suma; podemos cortar
            int reduced = (int) Math.sqrt(top);

            sum += (long) reduced - top;    // actualizar suma en O(1)
            pq.add(reduced);                // reinsertar
        }

        // sum ya es la respuesta, sin drenar la cola
        return sum;
     }
     */
}
