package com.fuqi.year2024.month08;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/8/1 22:21
 * @description
 */
public class LCP00040 {
    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int n = cards.length;
        int sum = 0;
        for (int i = n-cnt; i < n; i++) sum += cards[i];
        if (sum % 2 == 0) return sum;

        int x=cards[n-cnt];
        int ans = replacedSum(cards, cnt, sum, x);
        for (int i = n-cnt+1; i < n; i++) {
            ans = Math.max(ans, replacedSum(cards, cnt, sum, cards[i]));
            break;
        }

        return ans;
    }

    private int replacedSum(int[] cards, int cnt, int s, int x) {
        for (int i = cards.length - cnt - 1; i >= 0; i--) {
            if (cards[i] % 2 != x % 2) { // 找到一个最大的奇偶性和 x 不同的数
                return s - x + cards[i]; // 用 cards[i] 替换 s
            }
        }
        return 0;
    }
}
