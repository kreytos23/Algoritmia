package ADA;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fib(3));
    }

    public static int fib(int n) {
        if (n <= 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static int fibMemo(int n, HashMap<Integer, Integer> mem) {
        if (n <= 1) {
            return n;
        }

        if (mem.containsKey(n)){
            return mem.get(n);
        } else{
            int res = fibMemo(n - 1, mem) + fibMemo(n - 2, mem);
            mem.put(n,res);
            return res;
        }
    }
}
