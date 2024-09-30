package Varios;

import java.util.HashMap;

public class cesars {

    public static int palindromo (String s){
        if(s.equals(new StringBuilder(s).reverse().toString())){
            return -1;
        }

        if (s.isBlank()){
            return -1;
        }
        StringBuilder original = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            StringBuilder reverseModified = new StringBuilder((original.substring(0, i) + (original.substring(i + 1)))).reverse();
            StringBuilder normalModifies = new StringBuilder((original.substring(0, i) + (original.substring(i + 1))));

            System.out.println("Normal " + normalModifies);
            System.out.println("Reverse " + reverseModified);

            if (normalModifies.toString().equals(reverseModified.toString())){
                return i;
            }
        }

        int[] answers = new int[2];
        return -1;
    }

    public int[] twoSum(int[] nums, int target) {
        /*int[] answers = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    answers[0] = i;
                    answers[1] = j;
                    return answers;
                }
            }
        }
        return null;
        */
        //(Number, Index)
        HashMap<Integer, Integer> numbers = new HashMap<>();
        int lengthArray = nums.length;

        for (int i = 0; i < lengthArray; i++) {
            int diff = target - nums[i];

            if (numbers.containsKey(diff)) {
                return new int[]{i, numbers.get(diff)};
            } else {
                numbers.put(diff, i);
            }
        }
        return null;
    }
    //cababac
    //cbaaabc
    //bcaaacb
    public static void main(String[] args) {
        System.out.println(palindromo("acasohubobuhoshaca"));
    }
}
