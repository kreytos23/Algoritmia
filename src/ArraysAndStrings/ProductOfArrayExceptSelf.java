package ArraysAndStrings;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int [] ans = productExceptSelf(nums);
        Arrays.stream(ans).forEach(System.out::println);
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length], right = new int[nums.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        int currentProduct;
        for (int i = 0; i < nums.length - 1; i++) {
            currentProduct = left[i] * nums[i];
            left[i+1] = currentProduct;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            currentProduct = right[i] * nums[i];
            right[i-1] = currentProduct;
        }
        for (int i = 0; i < nums.length; i++) {
            left[i] = left[i] * right[i];
        }
        return left;
    }
}
