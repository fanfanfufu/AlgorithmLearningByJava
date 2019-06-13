package com.fuqi.month06.day0613;

/**
 * @Description: 整数转成罗马数字
 * @Author 傅琦
 * @Date 2019/6/13 10:48
 * @Version V1.0
 */
public class IntegerToRoman {

    private String intToRoman(int num){
        String[] numerals = new String[] {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0){
            if (num - values[i] > -1){
                sb.append(numerals[i]);
                num -= values[i];
            }else {
                i++;
            }
        }
        return sb.toString();
    }
}
