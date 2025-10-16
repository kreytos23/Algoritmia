package ADA;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class KeysAndRooms {

    public static void main(String[] args) {

    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        final int n = rooms.size();
        Deque<Integer> keys = new ArrayDeque<>();
        int roomsVisited = 0;
        boolean[] visited = new boolean[rooms.size()];

        keys.offerLast(0);
        roomsVisited++;
        visited[0] = true;

        while (!keys.isEmpty() && roomsVisited < n){
            int current = keys.pollFirst();
            for (int currentKey: rooms.get(current)) {
                if (!visited[currentKey]){
                    visited[currentKey] = true;
                    roomsVisited++;
                    if (roomsVisited == n)
                        return true;
                    keys.offerLast(currentKey);
                }
            }
        }
        return false;
    }
}
