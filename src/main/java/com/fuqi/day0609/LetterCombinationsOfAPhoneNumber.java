package com.fuqi.day0609;

import java.util.*;

/**
 * @Description:
 * @Author 傅琦
 * @Date 2019/6/10 16:16
 * @Version V1.0
 */
public class LetterCombinationsOfAPhoneNumber {
    private static List<String> letterCombinations(String digits) {
        Map<Character, String[]> map = new HashMap<>(16);
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "x"});

        char[] chars = digits.toCharArray();
        List<String> res = new ArrayList<>();
        for (char ch: chars) {
            List<String> temp = new ArrayList<>();
            if (res.isEmpty()){
                List<String> list = new ArrayList<>(Arrays.asList(map.get(ch)));
                res.addAll(list);
            }else {
                for (String s1: res) {
                    for (String s2: map.get(ch)) {
                        temp.add(s1+s2);
                    }
                }
                res.clear();
                res.addAll(temp);
            }
        }

        return res;
    }

    public static void main(String[] args){
        List<String> res = letterCombinations("293");
        System.out.println(res);
    }
}
