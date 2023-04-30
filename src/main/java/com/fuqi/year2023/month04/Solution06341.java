package com.fuqi.year2023.month04;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/4/30 11:16
 * @description
 */
public class Solution06341 {
    public int isWinner(int[] player1, int[] player2) {
        int n = player1.length;
        int score1 = player1[0];
        int score2 = player2[0];
        if (n == 1) return compare(score1, score2);
        score1 += player1[1];
        score2 += player2[1];
        if (player1[0] == 10) {
            score1 += player1[1];
        }
        if (player2[0] == 10) {
            score2 += player2[1];
        }
        if (n == 2) return compare(score1, score2);

        for (int i = 2; i < n; i++) {
            score1 += player1[i];
            score2 += player2[i];
            if (player1[i-2] == 10 || player1[i-1] == 10) {
                score1 += player1[i];
            }
            if (player2[i-2] == 10 || player2[i-1] == 10) {
                score2 += player2[i];
            }
        }

        return compare(score1, score2);
    }

    private int compare(int score1, int score2) {
        if (score1 == score2) return 0;

        return score1 > score2 ? 1 : 2;
    }
}
