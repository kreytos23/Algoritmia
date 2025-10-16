package ADA;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        int n = nums.length;
        if (k > n) k = n;

        int[] res = new int[n - k + 1];
        int ri = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(n,
                (a, b) -> (a[0] != b[0]) ? Integer.compare(b[0], a[0]) : Integer.compare(b[1], a[1]));

        for (int i = 0; i < k; i++) {
            pq.add(new int[]{nums[i], i});
        }

        res[ri++] = pq.peek()[0];

        for (int i = k; i < n; i++) {

            pq.add(new int[]{nums[i], i});

            int left = i - k + 1;

            while (!pq.isEmpty() && pq.peek()[1] < left) {
                pq.poll();
            }
            res[ri++] = pq.peek()[0];
        }

        return res;
    }
}
