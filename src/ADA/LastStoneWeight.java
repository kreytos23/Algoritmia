package ADA;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {

    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
        for (int i: stones) {
            pq.add(i);
        }

        while (pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();

            if (x < y){
                pq.add(y-x);
            } else if (x > y){
                pq.add(x - y);
            }
        }

        if (pq.isEmpty()){
            return 0;
        }else {
            return pq.poll();
        }
    }
}
