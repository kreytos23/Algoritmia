package ArraysAndStrings;

public class PowerOfThree {
    public static void main(String[] args) {

    }

    public static boolean isPowerOfThree(int n) {
        if ( n <= 0) return false;

        return ((Math.log10(n) / Math.log10(3)) % 1 == 0);
    }
}
