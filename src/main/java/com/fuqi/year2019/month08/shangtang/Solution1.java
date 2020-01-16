package com.fuqi.year2019.month08.shangtang;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/19 19:44
 * @Version V1.0
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] input = s.split(" ");
        for (String str : input) {
            System.out.print(str + " ");
        }

        System.out.println(helper(input));
    }

    private static int helper(String[] symbols) {
        Deque<Integer> numbers = new LinkedList<>();
        for (String string : symbols) {
            if ("+".equals(string)){
                int right = numbers.pop();
                int left = numbers.pop();
                int res = left + right;
                numbers.push(res);
            }else if ("-".equals(string)){
                int right = numbers.pop();
                int left = numbers.pop();
                int res = left - right;
                numbers.push(res);
            }else if ("*".equals(string)){
                int right = numbers.pop();
                int left = numbers.pop();
                int res = left * right;
                numbers.push(res);
            }else if ("/".equals(string)){
                int right = numbers.pop();
                int left = numbers.pop();
                int res = left / right;
                numbers.push(res);
            }else {
                numbers.push(Integer.parseInt(string));
            }
        }
        return numbers.pop();
    }
}
