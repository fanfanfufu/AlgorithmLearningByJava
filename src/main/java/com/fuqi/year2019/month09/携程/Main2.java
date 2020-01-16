package com.fuqi.year2019.month09.携程;

import java.util.*;

public class Main2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/

    static String resolve(String expr) {
        if (expr.trim().length() == 0) { return ""; }

        Deque<Character> stack = new LinkedList<>();
        Deque<Character> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') {
                if (queue.isEmpty()) {
                    stack.push(expr.charAt(i));
                } else {
                    queue.clear();
                }
            } else if (expr.charAt(i) == ')' && !stack.isEmpty()) {
                char ch = stack.pop();
                if (ch == '(') {
                    while (!queue.isEmpty()) {
                        stringBuilder.append(queue.poll());
                    }
                    stringBuilder.reverse();
                } else {
                    queue.clear();
                }
            } else {
                queue.offer(expr.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}

