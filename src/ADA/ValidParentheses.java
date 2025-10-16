package ADA;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        Map<Character, Character> parenthesis = new HashMap<>();
        parenthesis.put('(', ')');
        parenthesis.put('[', ']');
        parenthesis.put('{', '}');

        Stack<Character> stackChar = new Stack<>();

        if (s.length() < 2)
                return false;

        for (int i = 0; i < s.length(); i++) {
            if (parenthesis.containsKey(s.charAt(i))){
                stackChar.push(s.charAt(i));
            }else{
                if (stackChar.isEmpty()){
                    return false;
                }
                if (parenthesis.get(stackChar.pop()) != s.charAt(i)){
                    return false;
                }
            }
        }

        return stackChar.isEmpty();
    }
}
