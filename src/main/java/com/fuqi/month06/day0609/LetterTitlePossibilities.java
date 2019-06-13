package com.fuqi.month06.day0609;

import java.util.Arrays;

/**
 * @Description: DFS全排列问题
 *
 * Input: "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 *
 * Input: "AAABBC"
 * Output: 188
 *
 * @Team: 电子科技大学自动化研究所
 * @Author: 傅琦
 * @DateTime: 2019/6/9 17:38
 * @Version: V1.0
 */
public class LetterTitlePossibilities {

    int count;
    public int numTilePossibilities(String tiles) {
        count = 0;
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[chars.length];
        dfs(chars, 0, visited);
        return count;
    }

    private void dfs(char[] chars, int length, boolean[] visited){
        if(length == chars.length) {return;}

        for(int i = 0; i < chars.length; i++){
            if(visited[i]) {continue;}
            // 最妙的一行代码
            if(i - 1 >= 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {continue;}
            count ++;
            visited[i] = true;
            dfs(chars, length + 1, visited);
            visited[i] = false;
        }
    }

    public static void main(String[] args){
        LetterTitlePossibilities titlePossibilities = new LetterTitlePossibilities();
        int res = titlePossibilities.numTilePossibilities("AAABBC");
        System.out.println(res);
    }
}
