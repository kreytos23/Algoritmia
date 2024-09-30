package Varios;

import java.util.ArrayList;
import java.util.List;

public class FLipper {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();

        int size = arr.size() - 1;
        int middle = arr.size() / 2;
        int temp = 0;

        for (int i = 0; i < middle; i++) {
            for (int j = 0; j < middle; j++) {
                temp +=
                  Math.max(arr.get(i).get(j) , Math.max(arr.get(i).get(size - j), Math.max(arr.get(size - i).get(size - j) , arr.get(size - i).get(j))))
                ;
            }
        }
    }
}
