package com.fuqi.month06.day0621;

/**
 * @Description: 输入两个字符串word1，word2，求将word1修改成word2所需要经历的最小步骤数。
 * 每次只能操作一个字符，操作方式只有三种：
 * 1. 插入单个字符
 * 2. 删除单个字符
 * 3. 替换单个字符
 *
 * 示例1：
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 * 示例2：
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 * @Author 傅琦
 * @date 2019/6/21 10:40
 * @Version V1.0
 */
public class 字符换最小编辑距离 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 其中有一个是空字符串
        if (n * m == 0) {
            return n + m;
        }

        // 记录历史步数
        int [][] dp = new int[n + 1][m + 1];

        // 初始化第一列
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        // 初始化第一行
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    // 如果word1当前字符与word2当前字符相同，可以不用修改，则修改次数与前面的相同
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    // 若不同，则需要取出前面的最小的操作次数，然后+1
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        字符换最小编辑距离 distance = new 字符换最小编辑距离();
        String word1 = "intention";
        String word2 = "execution";
        int res = distance.minDistance(word1, word2);
        System.out.println("res = " + res);
    }
}
