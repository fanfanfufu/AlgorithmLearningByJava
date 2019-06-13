package com.fuqi.month06.day0608;

/**
 * @Description: 正则表达式匹配(动态规划的方式)
 * @Author 傅琦
 * @Date 2019/6/8 15:09
 * @Version V1.0
 */
public class ReMatching {
    public static void main(String[] args){
        String text = "abcdefgh";
        String pattern = "ab.*h";
        boolean result = isMatch(text, pattern);
        System.out.println("the result: " + result);
    }

    private static boolean isMatch(String s, String p){
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        // 从目标字符串的末尾开始匹配
        for (int i = s.length(); i >= 0; i--) {
            // 从模式字符串末尾开始搜索
            for (int j = p.length() - 1; j >= 0; j--) {
                // 匹配当前字符，只有当前的i小于字符串的长度(保证能取出对应位置上的字符串)和(当前字符相等活p中当前字符为.)时为true
                boolean firstMatch = (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
                if (j+1 < p.length() && p.charAt(j+1) == '*'){
                    // 当前pattern的字符不是最后一个字符，并且当前字符的后一位字符是‘*’，结果由以下两种情况之或来确定：
                    // 如果匹配到‘.*’，则从字符串尾部到当前字符串的匹配结果由‘.*’之后的部分的匹配结果决定；
                    // 如果匹配到‘[任意a-z]*’，则由当前字符匹配结果与‘*’之后部分的匹配结果共同决定
                    dp[i][j] = dp[i][j+2] || firstMatch && dp[i+1][j];
                }else {
                    // 如果不满足if中条件，则匹配结果：
                    // 由当前字符的匹配结果，与，两个字符串各回退一步的匹配结果决定
                    dp[i][j] = firstMatch && dp[i+1][j+1];
                }
            }
        }
//        for (boolean[] raw: dp) {
//            for (boolean ele: raw) {
//                System.out.print(ele + " ");
//            }
//            System.out.println();
//        }

        return dp[0][0];
    }
}
