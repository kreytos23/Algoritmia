package ADA;

import java.util.*;

public class NetworkDelayTime {
    private static final int INF = 1_000_000_000;
    public static void main(String[] args) {

    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // 1) Construir grafo: graph[u] = lista de pares (v, w)
        List<int[]>[] graph = new ArrayList[n + 1]; // índices 1..n
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : times) {
            int u = e[0], v = e[1], w = e[2];
            graph[u].add(new int[]{v, w});
        }

        // 2) Dijkstra desde k -> obtener las distancias mínimas a todos
        int[] dist = dijkstra(graph, n, k);

        // 3) Tomar el máximo de dist[1..n]; si hay INF, retornar -1
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) return -1;  // algún nodo no recibió la señal
            ans = Math.max(ans, dist[i]);   // el último en enterarse
        }
        return ans;
    }

    /**
     * Dijkstra clásico usando una PriorityQueue (min-heap).
     * @param graph Lista de adyacencia donde graph[u] contiene int[]{v, w}
     * @param n     Número de nodos (1..n)
     * @param src   Nodo origen
     * @return      Arreglo dist[] con la distancia mínima desde src a cada nodo
     */
    private static int[] dijkstra(List<int[]>[] graph, int n, int src) {
        // Distancias iniciales: INF excepto el origen
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        // seen[u] evita procesar el mismo nodo más de una vez (opcional pero eficiente)
        boolean[] seen = new boolean[n + 1];

        // Min-heap por primera coordenada (distancia). Cada entrada es int[]{d, u}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0], u = top[1];

            // Si ya lo fijamos (eliminado del heap como mínimo una vez), lo saltamos
            if (seen[u]) continue;
            seen[u] = true;

            // Si la distancia sacada es mayor que la conocida, no hace falta expandir
            if (d > dist[u]) continue;

            // Relajar aristas u -> (v, w)
            for (int[] edge : graph[u]) {
                int v = edge[0], w = edge[1];
                int nd = d + w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new int[]{nd, v});
                }
            }
        }
        return dist;
        // Complejidad: O((n + m) log n), m = número de aristas.
    }
}
