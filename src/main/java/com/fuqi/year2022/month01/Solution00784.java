package com.fuqi.year2022.month01;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author FuQi
 * @date 2022/1/15 21:56
 * @description
 */
public class Solution00784 {
    /**
     *
     * @param s 只由数字和字母组成的字符串
     * @return
     */
    public static List<String> letterCasePermutation1(String s) {
        List<String> ans = new ArrayList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char lowerCase = Character.toLowerCase(s.charAt(i));
            char upperCase = Character.toUpperCase(s.charAt(i));
            if (lowerCase == upperCase) {
                // 大小写相等，说明是数字
                if (ans.isEmpty()) {
                    // 第一个字符
                    ans.add(String.valueOf(lowerCase));
                    continue;
                }
                List<String> newAns = ans.stream().map(each -> each = each + lowerCase).collect(Collectors.toList());
                ans.clear();
                ans.addAll(newAns);
                continue;
            }
            if (ans.isEmpty()) {
                ans.add(String.valueOf(lowerCase));
                ans.add(String.valueOf(upperCase));
                continue;
            }
            List<String> ansNew = new ArrayList<>();
            ans.forEach(each -> {
                ansNew.add(each + lowerCase);
                ansNew.add(each + upperCase);
            });
            ans.clear();
            ans.addAll(ansNew);
        }

        return ans;
    }

    public static List<String> letterCasePermutation(String S) {
        int B = 0;
        // 统计字母的数量
        for (char c: S.toCharArray())
            if (Character.isLetter(c))
                B++;

        List<String> ans = new ArrayList();

        for (int bits = 0; bits < 1<<B; bits++) {
            int b = 0;
            StringBuilder word = new StringBuilder();
            for (char letter: S.toCharArray()) {
                if (Character.isLetter(letter)) {
                    if (((bits >> b++) & 1) == 1)
                        word.append(Character.toLowerCase(letter));
                    else
                        word.append(Character.toUpperCase(letter));
                } else {
                    word.append(letter);
                }
            }

            ans.add(word.toString());
        }

        return ans;

    }

    public static void main(String[] args) {
        String s = "a1b2";
//        String s = "12345";
        List<String> res = letterCasePermutation(s);
        System.out.println("res = " + String.join(",", res));

        int b = 5;
        System.out.println(1 << b);
    }
}
