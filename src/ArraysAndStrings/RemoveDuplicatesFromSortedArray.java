package ArraysAndStrings;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        int isRepeated = 0;

        for (int i = 1; i < nums.length; i++) {
            int before = nums[i - 1];
            if (before == nums[i]){
                isRepeated++;
            }else if(before != nums[i]){
                isRepeated = 0;
            }
            if(isRepeated == 2){
                //nums = Arrays.copyOf()
            }
        }

        return 0;
    }
}
