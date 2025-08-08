package Grafos;

public class Bombs {
    public static int detonation(int[][] bombs) {
        int maxChain = 1;
        for (int i = 0; i < bombs.length -1 ; i++) {
          int [] current = bombs[i];
            for (int j = 0; j < bombs.length -1 ; j++) {
                if (j == i) continue;
                int[] neigbour = bombs[j];
                if (distanceManhathan(current, neigbour) <= current[2]){
                    maxChain++;
                    break;
                }
            }
        }
        return 0;
    }

    public static int distanceManhathan(int[] x1, int[] x2){
        return Math.abs(x1[0] - x2[0]) + Math.abs(x1[1] - x2[1]);
    }
}
