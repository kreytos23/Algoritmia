package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int [][] result = merge(intervals);
        System.out.println(Arrays.deepToString(result));
    }
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> intervalsMerged = new ArrayList<>();
        int[] arrAux = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (current[0] <= arrAux[1]) {
                arrAux[1] = Math.max(current[1], arrAux[1]);
            } else {
                intervalsMerged.add(arrAux);
                arrAux = current;
            }
        }
        intervalsMerged.add(arrAux);
        return intervalsMerged.toArray(new int[intervalsMerged.size()][]);
    }
}
