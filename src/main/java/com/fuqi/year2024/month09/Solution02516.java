package com.fuqi.year2024.month09;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/9/27 23:11
 * @description
 */
public class Solution02516 {
    public int takeCharacters(String s, int k) {
        int[] cnt = new int[3];
        int len = s.length();
        int ans = len;
        for (int i = 0; i < len; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        if (cnt[0] >= k && cnt[1] >= k && cnt[2] >= k) {
            ans = Math.min(ans, len);
        } else {
            return -1;
        }

        int l = 0;
        for (int r = 0; r < len; r++) {
            cnt[s.charAt(r) - 'a']--;
            while (l < r && (cnt[0] < k || cnt[1] < k || cnt[2] < k)) {
                cnt[s.charAt(l) - 'a']++;
                l++;
            }
            if (cnt[0] >= k && cnt[1] >= k && cnt[2] >= k) {
                ans = Math.min(ans, len - (r - l + 1));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution02516 solution02516 = new Solution02516();
        System.out.println(solution02516.takeCharacters("aabaaaacaabc", 2));
    }
}
