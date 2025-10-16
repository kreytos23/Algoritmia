package ArraysAndStrings;

public class Largest3SameDigitNumberInString {
    public static void main(String[] args) {
        String str1= "2300019";
        String res = largestGoodInteger(str1);
        System.out.println(res);
    }

    public static String largestGoodInteger(String num) {
        int begin = 999;
        for (int i = 0; i < 10; i++) {
            String beginStr = begin == 0 ? "000" : String.valueOf(begin);
            if (num.contains(beginStr)) {
                if (begin == 0)
                    return "000";
                return String.valueOf(begin);
            } else {
                begin -= 111;
            }
        }
        return "";
    }
}
