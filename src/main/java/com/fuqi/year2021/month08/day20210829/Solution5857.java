package com.fuqi.year2021.month08.day20210829;

/**
 * @author FuQi
 */
public class Solution5857 {
    /**
     * 正序读取的动态规划
     *
     * @param binary
     * @return
     */
    public int numberOfUniqueGoodSubsequences1(String binary) {
        int mod = (int)1e9+7;
        long zero = 0, one = 0, ans = 0;
        boolean hasZero = false;
        for (char ch: binary.toCharArray()){
            if (ch == '0') {
                // 如果新增结尾的字符是0
                zero = ans;
                if (!hasZero) {
                    zero++;
                    hasZero = true;
                }
                zero %= mod;
            } else {
                // 如果新增结尾的字符是1
                one = ans;
                if (!hasZero) {
                    one++;
                }
                one %= mod;
            }
            ans = zero + one;
            ans %= mod;
        }

        return (int) ans;
    }

    /**
     * 倒序遍历进行动态规划
     *
     * @param binary
     * @return
     */
    public int numberOfUniqueGoodSubsequences2(String binary) {
        int n = binary.length();
        int dp0 = 0, dp1 = 0, mod = (int) 1e9 + 7, has0 = 0;
        for(int i = n-1; i >= 0; --i) {
            if(binary.charAt(i) == '0') {
                has0 = 1;
                dp0 = (dp0 + dp1 + 1) % mod;
            } else {
                dp1 = (dp0 + dp1 + 1) % mod;
            }
        }
        return (dp1 + has0) % mod;
    }
}
