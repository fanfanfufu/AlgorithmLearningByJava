package com.fuqi.dynamicplanning;

/**
 * @Description: 通配符匹配(dp)
 * @Author: 傅琦
 * @DateTime: 2019/6/8 23:47
 * @Version: V1.0
 */
public class WildcardMatching {
    public static void main(String[] args){
        String s = "aa";
        String p = "a";
        boolean res = isMatch(s, p);
        System.out.println("result: " + res);
    }

    private static boolean isMatch(String s, String p) {

        //Time Complexity: O(n*m)
        //Space Complexity: O(n*m)
        int n = s.length();
        int m = p.length();

        boolean[][] dp =new boolean[n+1][m+1];

        // For empty string and empty pattern
        dp[0][0] = true;

        //Fill Row 0, if there is a * in pattern just copy the [j-1]th computed value
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
}
