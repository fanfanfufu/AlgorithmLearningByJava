package com.fuqi.day0609;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/6/9 11:02
 * @Version: V1.0
 */
public class OccurrencesAfterBigram {
    public static void main(String[] args){
        String s = "we will we will rock you";
        String first = "we";
        String second = "will";
        String[] result = findOcurrences(s, first, second);
        System.out.print("[");
        for (String str: result) {
            System.out.print(str + ", ");
        }
        System.out.print("]");
    }

    private static String[] findOcurrences(String text, String first, String second) {
        if (text == null || "".equals(text.trim())){
            return new String[0];
        }
        text = text.trim();
        String[] texts = text.split(" ");
        List<String> stringList = new ArrayList<>(10);

        for (int i = 0; i < texts.length-1; i++) {
            if (i < texts.length-2 && first.equals(texts[i]) && second.equals(texts[i+1])){
                stringList.add(texts[i+2]);
            }
        }
        String[] res = new String[stringList.size()];
        for (int i = 0; i < stringList.size(); i++) {
            res[i] = stringList.get(i);
        }
        return res;
    }
}
