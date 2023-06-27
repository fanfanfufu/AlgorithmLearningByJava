package com.fuqi.year2023.month06;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/27 23:45
 * @description 字符串连接删减字母
 */
public class Solution02746 {
    public int minimizeConcatenatedLength(String[] words) {
        int n = words.length;
        int[][][] dp = new int[n][26][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                Arrays.fill(dp[i][j], 100000);
            }
        }

        String s = words[0];
        dp[0][s.charAt(0) - 'a'][s.charAt(s.length()-1) - 'a'] = s.length();
        for (int i = 1; i < n; i++) {
            s = words[i];
            int len = s.length();
            int left = s.charAt(0) - 'a';
            int right = s.charAt(len - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    if (k == left) {
                        // 当前字符串拼接到末尾，并且当前的左边字符与前面字符串末尾的字符相同
                        dp[i][j][right] = Math.min(dp[i][j][right], dp[i-1][j][k] + len - 1);
                    } else {
                        dp[i][j][right] = Math.min(dp[i][j][right], dp[i-1][j][k] + len);
                    }
                    if (right == j) {
                        dp[i][left][k] = Math.min(dp[i][left][k], dp[i-1][j][k] + len - 1);
                    } else {
                        dp[i][left][k] = Math.min(dp[i][left][k], dp[i-1][j][k] + len);
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                ans = Math.min(ans, dp[n-1][i][j]);
            }
        }
        return ans;
    }
}
