package com.fuqi.month05.day0521;

/**
 * @Description:
 * @Author 傅琦
 * @Date 2019/5/21 16:28
 * @Version V1.0
 */
public class LeftRotateString {

    public static void main(String[] args){
        LeftRotateString leftRotateString = new LeftRotateString();
        String res = leftRotateString.leftRotateString("abcdefg", 7);
        System.out.println(res);
    }

    public String leftRotateString(String str,int n) {
        int len = str.length();
        if(n>len){
            return "";
        }

        String[] strs = new String[len];

        for(int i = 0; i < len; i++){
            Character ch = str.charAt(i);
            String s = Character.toString(ch);
            strs[i] = s;
        }

        String str1 = "";
        for (int i = 0; i < n; i++){
            str1 += strs[i];
        }

        String str2 = "";
        for(int i = n; i < strs.length; i++){
            str2 += strs[i];
        }

        return str2 + str1;
    }
}
