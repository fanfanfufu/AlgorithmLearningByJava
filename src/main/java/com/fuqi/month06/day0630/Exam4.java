package com.fuqi.month06.day0630;

import java.util.Stack;

/**
 * @Description:
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 *
 * 有效的表达式需遵循以下约定：
 *
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 *
 *
 * 输入：expression = "!(f)"
 * 输出：true
 *
 * 输入：expression = "|(f,t)"
 * 输出：true
 *
 * 输入：expression = "&(t,f)"
 * 输出：false
 *
 * 输入：expression = "|(&(t,f,t),!(t))"
 * 输出：false
 *
 * @Author: 傅琦
 * @DateTime: 2019/6/30 10:29
 * @Version: V1.0
 */
public class Exam4 {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> symbols = new Stack<>();
        Stack<Character> elements = new Stack<>();
        for (Character ch : expression.toCharArray()) {
            if (ch == '!' || ch == '&' || ch == '|'){
                symbols.push(ch);
            } else if (ch == '(' || ch == 't' || ch == 'f'){
                elements.push(ch);
            }else if (ch == ')'){
                char symbol = symbols.pop();
                StringBuilder poped = new StringBuilder();
                while (!elements.isEmpty() && elements.peek() != '('){
                    poped.append(elements.pop());
                }
                boolean val = eval(symbol, poped.toString());
                // 如果elements非空，则删除掉其中的'('
                if (!elements.isEmpty()){ elements.pop(); }
                // 再将前一个括号的计算结果转成对应的字符放入elements中
                if (val){
                    elements.push('t');
                }else {
                    elements.push('f');
                }
            }
        }

        return elements.pop() == 't';
    }

    private boolean eval(char symbol, String poped){
        int count = 0;
        for (char ch : poped.toCharArray()) {
            if (ch == 't'){
                count++;
            }

            if (symbol == '&' && ch == 'f'){
                return false;
            } else if (symbol == '!' && ch == 't') {
                return false;
            }else if (symbol == '!' && ch == 'f'){
                return true;
            }
        }

        return count > 0;
    }

    public static void main(String[] args) {
        Exam4 exam4 = new Exam4();
        String input = "!(&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))))";
        boolean res = exam4.parseBoolExpr(input);
        System.out.println("res = " + res);
    }
}
