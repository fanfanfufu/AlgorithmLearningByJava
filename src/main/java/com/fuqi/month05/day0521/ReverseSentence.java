package com.fuqi.month05.day0521;



/**
 * @Description: 翻转字符串
 * “student. a am I” ====> “I am a student.”
 * @Author 傅琦
 * @Date 2019/5/21 18:48
 * @Version V1.0
 */
public class ReverseSentence {
    public static void main(String[] args){
        String str = " ";
        ReverseSentence sentence = new ReverseSentence();
        System.out.println(sentence.reverseSentence(str).length());
    }

    public String reverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }

        String[] strings = str.split(" ");
        String res = "";
        for (int i = strings.length-1; i >= 0 ; i--) {
            if (i == 0){
                res += strings[0];
                return res;
            }
            res = res + strings[i] + " ";
        }
        return res;
    }
}
