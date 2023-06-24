package com.fuqi.year2022.month02;

import java.util.*;

/**
 * @author FuQi
 * @date 2022/2/17 22:22
 * @description
 */
public class Solution00017 {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());

        return combinations;
    }

    private void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        int letterCount = letters.length();
        for (int i = 0; i < letterCount; i++) {
            combination.append(letters.charAt(i));
            backtrack(combinations, phoneMap, digits, index+1, combination);
            combination.deleteCharAt(index);
        }
    }

    private String[] alphaMap = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * BFS的实现
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinationsBfs(String digits) {
        Deque<String> path = new LinkedList<>();
        int n = digits.length();

        for (int i = 0; i < n; i++) {
            int number = digits.charAt(i) - '2';
            String alphaStr = alphaMap[number];
            int curLen = path.size();
            if (curLen == 0) {
                for (char alpha : alphaStr.toCharArray()) {
                    path.offerLast(String.valueOf(alpha));
                }
                continue;
            }
            for (int j = 0; j < curLen; j++) {
                String cur = path.pollFirst();
                for (char alpha : alphaStr.toCharArray()) {
                    path.offerLast(cur + alpha);
                }
            }
        }

        return new ArrayList<>(path);
    }

    public List<String> letterCombinationsDfs(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ans;
        Deque<String> path = new LinkedList<>();
        int len = digits.length();
        int index = 0;

        dfs(ans, digits, index, len, path);

        return ans;
    }

    private void dfs(List<String> ans, String digits, int index, int len, Deque<String> path) {
        if (index == len) {
            ans.add(String.join("", path));
            return;
        }
        int number = digits.charAt(index) - '2';
        for (char alpha : alphaMap[number].toCharArray()) {
            path.offerLast(String.valueOf(alpha));
            dfs(ans, digits, index+1, len, path);
            path.pollLast();
        }
    }
}
