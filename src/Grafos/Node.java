package Grafos;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Node<T> {
    private final T value;
    private boolean isVisited;
    private List<Node<T>> neighbours = new LinkedList<>();

    public Node(T value, boolean isVisited) {
        this.value = value;
        this.isVisited = isVisited;
    }

    public T getValue() {
        return value;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public List<Node<T>> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Node<T>> neighbours) {
        this.neighbours = neighbours;
    }
}
