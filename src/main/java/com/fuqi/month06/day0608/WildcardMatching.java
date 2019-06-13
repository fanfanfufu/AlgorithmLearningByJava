package com.fuqi.month06.day0608;

/**
 * @Description: 通配符匹配(动态规划的方式做)
 * @Author 傅琦
 * @Date 2019/6/8 20:48
 * @Version V1.0
 */
public class WildcardMatching {
    private static boolean isMatch(String s, String p){
        if (s == null || p == null){
            return true;
        }

        //Time Complexity: O(n*m)
        //Space Complexity: O(n*m)
        int n = s.length();
        int m = p.length();

        boolean[][] dp =new boolean[n+1][m+1];

        // For empty string and empty pattern
        dp[0][0] = true;

        //Fill Row 0, if there is a * in pattern just copy the [j-1]th computed value
        // 填充第一行，如果有*存在，则*这一列的结果与前一位的结果一致
        // 改行的结果实际上等价于用空字符串""匹配字符串p的结果
        for(int j=1; j<=m;j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args){
        String text = "adceb";
        String pattern = "*a*b";
        boolean res = isMatch(text, pattern);
        System.out.println(res);
    }
}
