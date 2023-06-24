package com.fuqi.year2023.month06;

import java.util.*;

public class Solution062402 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int startIndex = Integer.parseInt(in.nextLine());
        int wordLength = Integer.parseInt(in.nextLine());
        if (wordLength <= 0 || wordLength > 20 || startIndex > wordLength || startIndex < 0) {
            System.out.println();
            return;
        }
        Map<Character, List<String>> wordMap = new HashMap<>();
        String startWord = null;
        for (int i = 0; i < wordLength; i++) {
            String word = in.nextLine();
            if (i == startIndex) {
                startWord = word;
                continue;
            }
            char c = word.charAt(0);
            wordMap.computeIfAbsent(c, key -> new ArrayList<>()).add(word);
        }
        in.close();
        // 对每个相同首字母的字符串列表进行排序，优先按照长度降序排列
        // 相同长度的，再根据字典序升序排列
        for (List<String> wordList : wordMap.values()) {
            if (wordList.size() == 0) continue;
            wordList.sort((wordA, wordB) -> {
                if (wordA.length() != wordB.length()) {
                    return wordB.length() - wordA.length();
                }

                return wordA.compareTo(wordB);
            });
        }
        System.out.println(getJoinedWord(startWord, wordMap));
    }

    public static String getJoinedWord(String startWord, Map<Character, List<String>> wordMap) {
        StringBuilder ans = new StringBuilder(startWord);
        while (true) {
            char curChar = ans.charAt(ans.length() - 1);
            if (!wordMap.containsKey(curChar)) {
                break;
            }
            List<String> wordList = wordMap.getOrDefault(curChar, new ArrayList<>());
            if (wordList.size() == 0) break;
            // 取出第一个字符串
            String removed = wordList.remove(0);
            ans.append(removed);
        }

        return ans.toString();
    }
}
