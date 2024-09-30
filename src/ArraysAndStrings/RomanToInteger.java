package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String romanNumber = "MCMXIV";
        System.out.println(romanToInt(romanNumber));
    }

    public static int romanToInt(String s) {
        Map<String, Integer> romanValues = new HashMap<>(){{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
        }};

        int lengthOfString = s.length();
        int currentSum = 0;
        for (int i = 0; i < lengthOfString; i++) {
            if(i + 1 < lengthOfString && romanValues.get(String.valueOf(s.charAt(i))) < romanValues.get(String.valueOf(s.charAt(i+1)))){
                currentSum -= romanValues.get(String.valueOf(s.charAt(i)));
            }else{
                currentSum += romanValues.get(String.valueOf(s.charAt(i)));
            }
        }
        return currentSum;
    }
}
