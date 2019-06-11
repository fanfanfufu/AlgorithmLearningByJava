package com.fuqi.day0524;

/**
 * @Description: 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配。
 * @Author 傅琦
 * @Date 2019/5/24 21:17
 * @Version V1.0
 */
public class SimulateMatch {
    public boolean match(char[] str, char[] pattern)
    {
        if (str == null && pattern == null){
            return true;
        }else if(str != null && pattern == null){
            return false;
        }

        int strIndex = 0, patternIndex = 0;
        return matchCore(str, pattern, strIndex, patternIndex);
    }

    private static boolean matchCore(char[] str, char[] pattern, int strIndex, int patternIndex){
        // 有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length){ return true; }

        // pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length){ return false; }

        // 模式当前位是*，且字符串当前位跟模式前一位匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex+1] == '*'){
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                    || (strIndex != str.length && pattern[patternIndex] == '.')){
                return matchCore(str, pattern, strIndex, patternIndex+2)
                        || matchCore(str, pattern, strIndex+1, patternIndex+2)
                        || matchCore(str, pattern, strIndex+1, patternIndex);
            }else {
                return matchCore(str, pattern, strIndex, patternIndex+2);
            }
        }

        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                || (strIndex != str.length && pattern[patternIndex] == '.')){
            return matchCore(str, pattern, strIndex+1, patternIndex+1);
        }

        return false;
    }
}
