package Grafos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SocialNetwork {

    public static int influencedNodes(int n, ArrayList<ArrayList<Integer>> edges, int k, ArrayList<Integer> initial){
        NodeNet[] nodes = new NodeNet[n];
        int totalInfluenced = 0;
        for (int i = 0; i < n; i++) {
            nodes[i] = new NodeNet(i);
        }

        for (ArrayList<Integer> edge: edges){
            int u = edge.get(0);
            int v = edge.get(1);
            nodes[u].addNeighbour(nodes[v]);
        }

        Queue<NodeNet> queue = new LinkedList<>();

        for (int id : initial) {
            NodeNet start = nodes[id];
            if (!start.isInfluenced){
                start.isInfluenced = true;
                queue.add(start);
                totalInfluenced++;
            }
        }

        while (!queue.isEmpty()) {
            NodeNet current = queue.poll();
            for (NodeNet neighbour : current.neighbours) {
                   if(!neighbour.isInfluenced){
                       neighbour.influencedCount++;
                       if (neighbour.influencedCount >= k){
                           neighbour.isInfluenced = true;
                           queue.add(neighbour);
                           totalInfluenced++;
                       }
                   }
            }
        }
        return totalInfluenced;
    }
}
