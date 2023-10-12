package com.fuqi.year2023.month10;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/10/11 22:00
 * @description
 */
public class Solution02512 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<String, Integer> wordScoreMap = new HashMap<>();
        for (String pos : positive_feedback) wordScoreMap.put(pos, 3);
        for (String neg : negative_feedback) wordScoreMap.put(neg, -1);
        int n = student_id.length;
        int[][] studentScores = new int[n][2];
        for (int i = 0; i < n; i++) {
            int score = 0;
            for (String word : report[i].split(" ")) {
                score += wordScoreMap.getOrDefault(word, 0);
            }
            // 这里对score取负号的原因是Java的Arrays.sort()方法不支持int类型的降序排列
            // 因此需要取负号，然后按score升序排列
            studentScores[i] = new int[]{-score, student_id[i]};
        }
        Arrays.sort(studentScores, (a, b) -> {
            if (a[0] == b[0]) {
                // 得分相同的按照学生的学号升序排列
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        return Arrays.stream(studentScores).limit(k).map(student -> student[1]).collect(Collectors.toList());
    }
}
