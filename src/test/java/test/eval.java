package test;

import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;


public class eval {
    @Test
    public void test(){
        float a = (float) 3.4;
        //Scanner scanner = new Scanner(System.in);
        //String expression = scanner.nextLine();
        String expression = "1+2+(33+8)";
        System.out.println(eval(expression));
    }
    public int eval(String ex){
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;
        int len = ex.length();
        for (int i = 0; i < len; i++){
            char c = ex.charAt(i);
            if(Character.isDigit(c)){
                int num = c - '0';
                while (i + 1 < len && Character.isDigit(ex.charAt(i+1))){
                    num = num * 10 + ex.charAt(i + 1) - '0';
                    i++;
                }
                result += num * sign;
            }
            else if(c == '+'){
                sign = 1;
            }
            else if(c== '-'){
                sign = -1;
            }
            //这里的作用到底是什么
            else if ( c == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if ( c == ')'){
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }
}
