package ADA;

import java.util.List;

public class LongestCommonSubsequence {
    public static void main(String[] args) {

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int [][] dp = new int[text1.length() + 1][text2.length() + 1];

        // Paso 1 : Casos Base

        for (int i = 0; i < text1.length(); i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < text2.length(); j++) {
            dp[0][j] = 0;
        }

        // Paso 2: Tabulacion

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }


    public int longestCommonSubsequenceRecursive(int i, int j, String text1, String text2, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] = 1 + longestCommonSubsequenceRecursive(i - 1, j - 1, text1, text2, dp);
        } else{
            return dp[i][j] = Math.max(
                    longestCommonSubsequenceRecursive(i - 1, j, text1, text2, dp),
                    longestCommonSubsequenceRecursive(i, j - 1, text1, text2, dp));
        }
    }
}
