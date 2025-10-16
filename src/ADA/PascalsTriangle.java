package ADA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(List.of(1)));

        List<Integer> prev = ans.get(0);

        for (int i = 1; i < numRows; i++){
                List<Integer> newRow = new ArrayList<>(i + 1);
                newRow.add(0,1);

                for (int j = 1; j < prev.size() ; j++){
                    newRow.add(j, prev.get(j - 1) + prev.get(j));
                }

                newRow.add(1);
                ans.add(newRow);
                prev = newRow;
        }

        return ans;
    }
}
