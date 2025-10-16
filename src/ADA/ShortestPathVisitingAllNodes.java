package ADA;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPathVisitingAllNodes {

    public static void main(String[] args) {

    }
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        // Caso trivial: un solo nodo => ya está visitado
        if (n == 1) return 0;

        // target = todos los nodos visitados: 111...1 (n bits)
        int target = (1 << n) - 1;

        // visited[u][mask] = ya procesamos el estado "estoy en u con 'mask' visitado"
        boolean[][] visited = new boolean[n][1 << n];

        // Cola para BFS. Cada elemento: {node, mask}
        Queue<int[]> q = new ArrayDeque<>();

        // 1) Multi-source init: empezamos desde TODOS los nodos
        for (int i = 0; i < n; i++) {
            int m = 1 << i;          // solo el bit i encendido
            q.offer(new int[]{i, m});
            visited[i][m] = true;
        }

        int steps = 0; // longitud del camino (número de aristas)

        // 2) BFS por capas
        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                int[] cur = q.poll();
                int u = cur[0];
                int mask = cur[1];

                // 3) Expandir a vecinos
                for (int v : graph[u]) {
                    int nextMask = mask | (1 << v); // encendemos bit de v

                    // Si con este paso ya visitamos todos, ¡listo!
                    if (nextMask == target) {
                        return steps + 1; // +1 por la arista (u -> v) recién usada
                    }

                    // Si el estado (v, nextMask) no ha sido visto, encolar
                    if (!visited[v][nextMask]) {
                        visited[v][nextMask] = true;
                        q.offer(new int[]{v, nextMask});
                    }
                }
            }

            // 4) Siguiente capa (aumenta longitud del camino en 1)
            steps++;
        }

        // Teóricamente no llegamos aquí si el grafo es conexo (como garantiza el enunciado)
        return -1;
    }

    public int prenderBit(int i){
        return i | 1 << i;
    }
}
