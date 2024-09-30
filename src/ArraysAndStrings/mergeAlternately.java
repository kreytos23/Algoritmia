package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class mergeAlternately {
    public static void main(String[] args) {

    }
    public static String mergeAlternately(String word1, String word2) {
        int min = 0;
        boolean eq = false;
        StringBuilder sb = new StringBuilder();
        if(word1.length() < word2.length()){
            min = word1.length();
        }else if (word1.length() > word2.length()){
            min = word2.length();
        } else{
            min = word1.length();
            eq = true;
        }
        for (int i = 0; i < min ; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if(min == word1.length() && !eq){
            sb.append(word2.substring(min));
        }else if(min == word2.length() && !eq){
            sb.append(word1.substring(min));
        }
        return sb.toString();
    }
}
