package com.fuqi.year2021.month11.day20211121;

/**
 * @author FuQi
 * @date 2021/11/21 11:45
 * @description
 */
public class Solution05930 {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int ans = 0;
        for(int i=0; i<n-1; i++) {
            for(int j = i+1; j < n; j++) {
                if(colors[i] == colors[j]) {
                    continue;
                }
                ans = Math.max(Math.abs(i-j), ans);
            }
        }
        return ans;
    }
}
