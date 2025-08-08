package Grafos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PiedraPapelTijera {
    public static void main(String[] args) {
//
// ——————————
    }
    public static int joKenPoCardGame(List<String> deck) {
        int size = deck.size();
        int[] scores = new int[size + 2];
        scores[size] = 0;
        scores[size + 1] = 0;

        for (int i = size - 2; i >= 0; i--) {
            String joaoCarta1 = deck.get(i);
            int j = i + 1; 
            int opcion1;

            if (j == size - 1) {
                opcion1 = compareCards(joaoCarta1, deck.get(j)) + scores[j + 1];
            } else {
                int casoA = compareCards(joaoCarta1, deck.get(j)) + scores[j + 1];
                int casoB = compareCards(joaoCarta1, deck.get(j + 1)) + scores[j + 2];
                opcion1 = Math.min(casoA, casoB);
            }

            int opcion2 = Integer.MIN_VALUE;
            if (i <= size - 3) {
                String joaoCarta2 = deck.get(i + 1);
                int k = i + 2; 
                if (k == size - 1) {
                    opcion2 = compareCards(joaoCarta2, deck.get(k)) + scores[k + 1];
                } else {
                    int casoC = compareCards(joaoCarta2, deck.get(k)) + scores[k + 1];
                    int casoD = compareCards(joaoCarta2, deck.get(k + 1)) + scores[k + 2];
                    opcion2 = Math.min(casoC, casoD);
                }
            }
            scores[i] = Math.max(opcion1, opcion2);
        }
        return scores[0];
    }
    private static int compareCards(String a, String b) {
        if (a.equals(b)) {
            return 0;
        }
        if ((a.equals("stone") && b.equals("scissor")) ||
                (a.equals("scissor") && b.equals("paper")) ||
                (a.equals("paper") && b.equals("stone"))) {
            return +1;
        }
        return -1;
    }

}
