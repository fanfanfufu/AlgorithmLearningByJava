package com.fuqi.year2023.month06;

import com.fuqi.year2022.month11.Solution00402;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/24 22:37
 * @description 构造最长的新字符串
 */
public class Solution06895 {
    public int longestString(int x, int y, int z) {
        int ans1 = dfs(x - 1, y, z, "AA", 2);
        int ans2 = dfs(x, y - 1, z, "BB", 2);
        int ans3 = dfs(x, y, z - 1, "AB", 2);

        return Math.max(ans1, Math.max(ans2, ans3));
    }

    private int dfs(int x, int y, int z, String lastTwo, int ans) {
        if ("AA".equals(lastTwo) && y <= 0) {
            return ans;
        }
        // 最后两个字符如果是BB或者是AB时，终止条件都一样
        if (x <= 0 && z <= 0) return ans;
        int ansA = 0, ansB = 0;
        if ("AA".equals(lastTwo)) {
            ansA = dfs(x, y - 1, z, "BB", ans + 2);
        } else {
            int temp1 = 0, temp2 = 0;
            if (x > 0) {
                temp1 = dfs(x - 1, y, z, "AA", ans + 2);
            }
            if (z > 0) {
                temp2 = dfs(x, y, z - 1, "AB", ans + 2);
            }
            ansB = Math.max(temp1, temp2);
        }

        return Math.max(ansA, ansB);
    }

    public int longestString2(int x, int y, int z) {
        int min = Math.min(x, Math.min(y, z));
        int ans = min * 6;
        x -= min;
        y -= min;
        z -= min;
        // 必然有一个为0
        if (z == 0) {
            min = Math.min(x, y);
            ans += (4 * min);
            if (x > min || y > min) {
                ans += 2;
            }
            return ans;
        }
        // z > 0
        ans += (2 * z);
        if (x > 0 || y > 0) {
            ans += 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        int x = 2, y = 5, z = 1;
//        int x = 5, y = 8, z = 33;
        Solution06895 solution06895 = new Solution06895();
        System.out.println(solution06895.longestString(x, y, z));
        System.out.println(solution06895.longestString2(x, y, z));
    }


}
