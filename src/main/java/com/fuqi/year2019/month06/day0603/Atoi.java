package com.fuqi.year2019.month06.day0603;

/**
 * @Description: 字符串里的数据转成整形
 * @Author 傅琦
 * @Date 2019/6/3 10:11
 * @Version V1.0
 */
public class Atoi {
    public static void main(String[] args){
        int result = myAtoi("+0 123");
        System.out.println(result);
    }

    private static int myAtoi(String str){
        if (str == null || "".equals(str.trim())){ return 0; }
        str = str.trim();
        if ("+".equals(str) || "-".equals(str)){ return 0; }
        long res = 0L;
        int symbol = 1;
        if (str.charAt(0) == '+'){
        }else if (str.charAt(0) == '-'){
            symbol = -1;
        }else if ('0' <= str.charAt(0) && str.charAt(0) <= '9'){
            String temp = Character.toString(str.charAt(0));
            res = res * 10 + Integer.parseInt(temp);
        }else {
            return 0;
        }

        for (int i = 1; i < str.length(); i++) {
            if ('0' <= str.charAt(i) && str.charAt(i) <= '9'){
                String temp = Character.toString(str.charAt(i));
                res = res * 10 + Integer.parseInt(temp);
                if (res > Integer.MAX_VALUE){
                    return symbol == 1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
                }
            }else {
                break;
            }
        }

        if (symbol == 1){
            return (int) res;
        }else {
            res = res * symbol;
            return (int) res;
        }
    }
}
