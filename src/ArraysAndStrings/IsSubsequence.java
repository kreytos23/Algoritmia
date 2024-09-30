package ArraysAndStrings;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while(i < s.length() ){
            if(j < t.length() && s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            } else if (j < t.length() && s.charAt(i) != t.charAt(j)) {
                j++;
            } else if (j == t.length()) {
                return false;
            }
        }
        return true;
    }
}
 /*
 while(i < s.length() ){
            if(j < t.length() && s.charAt(i) == t.charAt(j)){
                i++;
            }
            if (j == t.length()) {
                return false;
            }
            j++;
        }
  */