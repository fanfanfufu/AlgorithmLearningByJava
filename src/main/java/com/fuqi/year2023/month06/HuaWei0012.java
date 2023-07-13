package com.fuqi.year2023.month06;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/23 17:37
 * @description 比赛
 */
public class HuaWei0012 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] firstLine = in.nextLine().split(",");
        int m = Integer.parseInt(firstLine[0]);
        int n = Integer.parseInt(firstLine[1]);
        if (m < 3 || n < 3 || m > 100 || n > 100) {
            System.out.println("-1");
            return;
        }
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] playerScore = in.nextLine().split(",");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(playerScore[j]);
            }
        }
        in.close();

        // 进行排序
        List<String> ans = getTopThree(m, n, matrix);
        System.out.println(String.join(",", ans));
    }

    private static List<String> getTopThree(int m, int n, int[][] matrix) {
        Map<Integer, List<Integer>> players = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int[] scores = new int[m];
            for (int j = 0; j < m; j++) {
                scores[j] = matrix[j][i-1];
            }
            List<Integer> scoreList = Arrays.stream(scores).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            players.put(i, scoreList);
        }

        return players.entrySet().stream()
                .sorted((a,b) -> {
                    int sumA = a.getValue().stream().mapToInt(Integer::intValue).sum();
                    int sumB = b.getValue().stream().mapToInt(Integer::intValue).sum();
                    if (sumA != sumB) {
                        return sumB > sumA ? 1 : -1;
                    }
                    for (int i = 0; i < m; i++) {
                        if (a.getValue().get(i).equals(b.getValue().get(i))) continue;
                        return b.getValue().get(i) - a.getValue().get(i);
                    }

                    return 0;
                })
                .limit(3L)
                .map(entry -> String.valueOf(entry.getKey()))
                .collect(Collectors.toList());
    }
}
