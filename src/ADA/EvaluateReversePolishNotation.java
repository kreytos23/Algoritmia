package ADA;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
    public static Integer evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(!"+-*/".contains(tokens[i])){
                numbers.push(Integer.parseInt(tokens[i]));;
            }else {
                numbers.push(eval(numbers.pop(),numbers.pop(), tokens[i]));
            }
        }
        return numbers.pop();
    }

    public static Integer eval (Integer int1, Integer int2, String op){
        switch (op){
            case "+":
                return int1 + int2;
            case "-":
                return int1 - int2;
            case "*":
                return int1 * int2;
            case "/":
                return int2 / int1;
        }
        return null;
    }
}
