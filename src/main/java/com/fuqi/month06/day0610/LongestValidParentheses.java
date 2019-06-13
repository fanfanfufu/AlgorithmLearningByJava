package com.fuqi.month06.day0610;

/**
 * @Description:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 *
 * Input: "((())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "(())"
 *
 * @Author 傅琦
 * @Date 2019/6/11 10:00
 * @Version V1.0
 */
public class LongestValidParentheses {
    private static int longestValidParentheses(String s) {
        if (s == null || "".equals(s.trim())){
            return 0;
        }
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                // else if这一判断语句是判断当前的右括号，对称到其内部成对的括号左侧的位置上是否有左括号
                // 若有左括号，则进入判断体；没有则跳出
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // 进入这里，说明当前位置的右括号处，有与其对称的做括号
                    // 那么当前的最大长度就是，两个括号内的长度 + 左括号左边的成对括号长度
                    // (若左括号左边就有相邻的成对括号，则取dp[i - dp[i - 1] - 2]的值来相加，保证能找到最长的字串)
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public static void main(String[] args){
        int res = longestValidParentheses("()((()))");
        System.out.print(res);
    }
}
