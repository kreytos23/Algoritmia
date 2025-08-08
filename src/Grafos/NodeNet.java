package Grafos;

import java.util.ArrayList;
import java.util.List;

public class NodeNet {

    int id;
    List<NodeNet> neighbours;
    boolean isInfluenced;
    int influencedCount;

    NodeNet(int id){
        this.id = id;
        this.neighbours = new ArrayList<>();
        this.isInfluenced = false;
        this.influencedCount = 0;
    }

    void addNeighbour (NodeNet neighbour){
        neighbours.add(neighbour);
    }
}
