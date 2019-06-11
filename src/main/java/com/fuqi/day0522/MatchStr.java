package com.fuqi.day0522;

/**
 * @Description: 正则匹配字符串
 * @Author 傅琦
 * @Date 2019/5/22 16:22
 * @Version V1.0
 */
public class MatchStr {

    public boolean match(char[] str, char[] pattern){
        if ((str == null && pattern != null) || (str != null && pattern == null)){
            return false;
        }else if ((str.length == 0 && pattern.length != 0) || (str.length != 0 && pattern.length == 0)){
            return false;
        }

        if ((str == null && pattern == null) || (str.length == 0 && pattern.length == 0)){
            return true;
        }

        int len = str.length > pattern.length ? str.length: pattern.length;
        return false;
    }
}
