package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ClosesToK {
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println(findClosestElements(arr1, 4, 3));
    }
 // Input: arr = [1,2,3,4,5], k = 4, x = 3
 //
 //Output: [1,2,3,4]
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;

        if (k >= n) {
            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        }

        int left = 0; //0
        int right = n - k; // 1

        while (left < right) {
            int mid = (left + right) >>> 1; //0

            int distLeft = x - arr[mid]; //2
            int distRight = arr[mid + k] - x; //1

            if (distLeft > distRight) {
                left = mid + 1; //1
            } else {
                right = mid;
            }
        }

        // 'left' es el inicio óptimo de la ventana.
        List<Integer> ans = new ArrayList<>(k);
        for (int i = left; i < left + k; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

}


