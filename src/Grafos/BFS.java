package Grafos;

import java.util.*;
import java.util.stream.Collectors;

public class BFS {
    public static void main(String[] args) {
        Node<Integer> n0 = new Node<>(0, false);
        Node<Integer> n1 = new Node<>(1, false);
        Node<Integer> n2 = new Node<>(2, false);
        Node<Integer> n3 = new Node<>(3, false);
        Node<Integer> n4 = new Node<>(4, false);
        Node<Integer> n5 = new Node<>(5, false);
        Node<Integer> n6 = new Node<>(6, false);

        n0.setNeighbours(Arrays.asList(n1, n5, n6));
        n1.setNeighbours(Arrays.asList(n3, n4, n5));
        n4.setNeighbours(Arrays.asList(n2, n6));
        n6.setNeighbours(Arrays.asList(n0));

        breadthFirstSearch(n0);
    }

    public static void breadthFirstSearch(Node<Integer> root){
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node<Integer> current = queue.poll();
            if(!current.isVisited()){
                current.setVisited(true);
                System.out.println(current.getValue());
                queue.addAll(current.getNeighbours());
            }
        }
    }
}
