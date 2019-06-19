package com.fuqi.month06.day0619;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description:
 *
 * 输入一行字符串，输出其字符组成回文字符串的最小个数，
 * 例如输入“abbaaba”可以组成回文“abababa”输出个数1，
 * 例如输入“abc”可以组成回文“a”“b”“c”，输出个数3。
 *
 * @Author 傅琦
 * @Date 2019/6/19 19:26
 * @Version V1.0
 */
public class Exam2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char[] chars = input.toCharArray();
        HashMap<String, Integer> map = new HashMap<>();

        for (char ch: chars) {
            String temp = Character.toString(ch);
            if (map.containsKey(temp)){
                map.put(temp, map.get(temp)+1);
            }else {
                map.put(temp, 1);
            }
        }

        int res = 0;
        for (String key: map.keySet()) {
            if (map.get(key) % 2 == 1){
                res += 1;
            }
        }

        if (res == 0){
            System.out.println(1);
        }else {
            System.out.println(res);
        }
    }
}
