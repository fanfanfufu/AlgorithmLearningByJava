package com.fuqi.day0522;

/**
 * @Description: 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 *
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * @Author 傅琦
 * @Date 2019/5/22 17:19
 * @Version V1.0
 */
public class IsNumeric {
    /**
     * 偷鸡做法，不可取
     * @param str
     * @return
     */
    public boolean isNumeric1(char[] str){
        if(str == null || str.length == 0){
            return false;
        }

        String string = "";
        for(int i = 0; i < str.length; i++){
            String s = Character.toString(str[i]);
            string += s;
        }

        try{
            Double number = Double.parseDouble(string);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    /**
     * 各种情况枚举
     * @param str
     * @return
     */
    public boolean isNumeric2(char[] str){
        if(str == null || str.length == 0){
            return false;
        }

        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'E' || str[i] == 'e'){
                // 如果e是最后一位，则返回false
                if (i == str.length-1){
                    return false;
                }
                // 如果前面已经出现过小数点或者e了
                if (hasE || decimal){
                    return false;
                }
                hasE = true;
            }else if(str[i] == '+' || str[i] == '-'){
                // 第一次出现+-符号，要么是在字符串开头，要么就是在e或者E之后
                if ((i!=0) && (str[i-1] != 'e') && (str[i-1] != 'E') && (!sign)){
                    return false;
                }
                // 不是第一次出现+-符号，就必须跟在E或者e后面
                if (sign && (str[i-1] != 'e') && (str[i-1] != 'E')){
                    return false;
                }
                sign = true;
            }else if (str[i] == '.'){
                // 如果小数点出现在e后面或者第二次出现
                if (hasE || decimal){
                    return false;
                }
                decimal = true;
            }else if (str[i] < '0' || str[i] > '9'){
                // 其他非法字符，直接返回false
                return false;
            }
        }
        return true;
    }

    public boolean isNumeric3(char[] str){
        if(str == null || str.length == 0){
            return false;
        }

        String string = String.valueOf(str);
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }
}
