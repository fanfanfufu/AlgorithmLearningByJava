package com.fuqi.year2020.month05.day20;

import java.util.Arrays;

/**
 * @Description: 每个元音包含偶数次的最长子字符串
 * @Author 傅琦
 * @date 2020/5/20 10:07
 * @Version V1.0
 */
public class LeetCode1371 {
    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        LeetCode1371 leetCode1371 = new LeetCode1371();
        System.out.println(leetCode1371.findTheLongestSubstring(s));
    }

    public int findTheLongestSubstring(String s){
        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a'){
                status ^= 1;
            }else if (ch == 'e'){
                status ^= (1 << 1);
            }else if (ch == 'i'){
                status ^= (1 << 2);
            }else if (ch == 'o'){
                status ^= (1 << 3);
            }else if (ch == 'u'){
                status ^= (1 << 4);
            }
            if (pos[status] >= 0){
                ans = Math.max(ans, i+1 - pos[status]);
            }else {
                pos[status] = i+1;
            }
        }

        return ans;
    }
}
