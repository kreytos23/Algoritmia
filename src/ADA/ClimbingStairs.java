package ADA;

import java.util.HashMap;

public class ClimbingStairs {

    public int climbStairs(int n) {
        return climbStairsFib(n, new HashMap<>());
    }
    public int climbStairsFib(int n, HashMap<Integer, Integer> mem) {
        if (n < 2){
            return n;
        }

        if (mem.containsKey(n)){
            return mem.get(n);
        } else{
            int res = climbStairsFib(n - 1, mem) + climbStairsFib(n - 2, mem);
            mem.put(n,res);
            return res;
        }
    }
}
