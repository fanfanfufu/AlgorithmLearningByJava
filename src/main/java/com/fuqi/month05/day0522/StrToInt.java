package com.fuqi.month05.day0522;

/**
 * @Description: 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * @Author 傅琦
 * @Date 2019/5/22 11:27
 * @Version V1.0
 */
public class StrToInt {

    public static void main(String[] args){
        StrToInt toInt = new StrToInt();
        int res = toInt.strToInt("-123");
        System.out.println(res);
    }

    public int strToInt(String str) {
        if(str == null || str.trim().equals("")){
            return 0;
        }

        // 符号位: 0表示+，1表示-
        int symbol = 1;
        int start = 0;
        char[] chars = str.toCharArray();

        if (chars[0] == '-'){
            symbol = -1;
            start = 1;
        }else if(chars[0] == '+'){
            start = 1;
        }

        int result = 0;
        for (int i = start; i < chars.length; i++){
            // 遇到非法字符则返回0
            if (chars[i] > '9' || chars[i] < '0'){
                return 0;
            }

            result = result * 10 + (int) (chars[i] - '0');

            // 溢出判断
            if ((symbol == 0 && result > Integer.MAX_VALUE) || (symbol == 1 && result < Integer.MIN_VALUE)){
                return 0;
            }
        }

        return result * symbol;
    }
}
