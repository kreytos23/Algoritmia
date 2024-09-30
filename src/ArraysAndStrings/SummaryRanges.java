package ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0)
            return ranges;

        int start;
        int i = 0;
        while (i < nums.length){
            start = nums[i];
            while (i < nums.length - 1 && nums[i+1] == nums[i] + 1){
                i++;
            }
            if (start == nums[i]){
                ranges.add(String.valueOf(start));
            }else {
                ranges.add(start + "->" + nums[i]);
            }
            i++;
        }
        return ranges;
    }
}
