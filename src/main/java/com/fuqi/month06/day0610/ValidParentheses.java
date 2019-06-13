package com.fuqi.month06.day0610;

import java.util.Stack;

/**
 * @Description:
 * @Author 傅琦
 * @Date 2019/6/11 15:23
 * @Version V1.0
 */
public class ValidParentheses {
    private static boolean isValid(String s) {
        if (s == null || "".equals(s.trim())){
            return true;
        }

        if (s.length() % 2 == 1){
            return false;
        }

        Stack<Character> characters = new Stack<>();
        characters.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!characters.isEmpty() && characters.peek() == '(' && s.charAt(i) == ')'){ characters.pop(); }
            else if (!characters.isEmpty() && characters.peek() == '[' && s.charAt(i) == ']'){ characters.pop(); }
            else if (!characters.isEmpty() && characters.peek() == '{' && s.charAt(i) == '}'){ characters.pop(); }
            else {
                characters.push(s.charAt(i));
            }

            if (characters.size() > (s.length() / 2)){
                return false;
            }
        }

        return characters.isEmpty();
    }

    public static void main(String[] args){
        String s = "([)]";
        boolean res = isValid(s);
        System.out.print(res);
    }
}
