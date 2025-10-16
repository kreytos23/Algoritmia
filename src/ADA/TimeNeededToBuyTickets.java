package ADA;

import java.util.PriorityQueue;
import java.util.Queue;

public class TimeNeededToBuyTickets {
    public static void main(String[] args) {

    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        int time = 0;
        int pos = 0;

        for (int i = 0; i < tickets.length; i++) {
            queue.add(tickets[i]);
        }

        while (true){
            if(k != pos && !queue.isEmpty()){
                time++;
                if (queue.peek() - 1 != 0) {
                    queue.add(queue.poll() -1);
                }else {
                    k--;
                }
            }
        }

    }
}
