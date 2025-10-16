package ArraysAndStrings;

public class PowerOfFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
    }

    public static boolean isPowerOfFour(int n) {
        if ( n <= 0) return false;
        return ((Math.log10(n) / Math.log10(4)) % 1 == 0);

        /*
        if(n<=0) return false;
        if((n&(n-1)) == 0 && Integer.bitCount(n-1)%2==0) return true;
        return false;
         */
    }
}

