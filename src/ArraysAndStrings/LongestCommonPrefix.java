package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1){
            return strs[0];
        }
        int minimumLen = strs[0].length();
        for (String current: strs) {
            if (current.length() < minimumLen){
                minimumLen = current.length();
            }
        }
        int i = 0;
        while (i < minimumLen){
            for (String current : strs) {
                if(current.charAt(i) != strs[0].charAt(i)){
                    return strs[0].substring(0, i);
                }
            }
            i++;
        }
        return strs[0].substring(0, i);
    }

    /*public static String longestCommonPrefix(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        System.out.println(new ArrayList<>(Arrays.asList(v)));
        String first = v[0];
        String last = v[v.length-1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }*/
}
