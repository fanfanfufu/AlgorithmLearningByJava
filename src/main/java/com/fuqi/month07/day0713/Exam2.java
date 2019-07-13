package com.fuqi.month07.day0713;

/**
 * @Description: 删去字符串中的元音: a,e,i,o,u
 * @Author: 傅琦
 * @DateTime: 2019/7/13 22:30
 * @Version: V1.0
 */
public class Exam2 {
    public String removeVowels(String S) {
        return S.replaceAll("[aeiou]", "");
    }

    public static void main(String[] args) {
        Exam2 exam2 = new Exam2();
        String res = exam2.removeVowels("aeiou");
        // 输入：leetcodeisacommunityforcoders
        // ltcdscmmntyfrcdrs
        // ltcdscmmntyfrcdrs
        System.out.println("res = " + res);
    }
}
