package ADA;

import java.util.ArrayList;
import java.util.List;

public class FindTheSafestPathInAGrid {
    public static void main(String[] args) {

    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        List<List<Integer>> thiefts = new ArrayList<>();

        for (int x = 0; x < grid.size(); x++){
            for (int y = 0; y < grid.get(x).size(); y++) {
                System.out.println(x + "," +  y);
                System.out.println("value: " + grid.get(x).get(y));
            }
        }

        return 0;
    }
}
