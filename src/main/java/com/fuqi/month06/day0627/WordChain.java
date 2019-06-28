package com.fuqi.month06.day0627;

import javafx.util.Pair;

import java.util.*;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/6/27 10:18
 * @Version V1.0
 */
public class WordChain {
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        // Since all words are of same length.
        int L = beginWord.length();

        // 创建一个用于记录，只修改一个字符后的单词作为key，对应的有多少个完整的单词为value
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // 存储元素示例：h*t->[hit, hot]
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        ArrayList<String> transformations =
                                allComboDict.getOrDefault(newWord, new ArrayList<String>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        // 创建一个用于BFS的队列
        Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
        Q.add(new Pair(beginWord, 1));

        // 访问过的元素做上标记，避免重复访问
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }

    private int L;
    private HashMap<String, ArrayList<String>> allComboDict;

    WordChain() {
        this.L = 0;

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        this.allComboDict = new HashMap<String, ArrayList<String>>();
    }

    private int visitWordNode(
            Queue<Pair<String, Integer>> Q,
            HashMap<String, Integer> visited,
            HashMap<String, Integer> othersVisited) {
        Pair<String, Integer> node = Q.remove();
        String word = node.getKey();
        int level = node.getValue();

        for (int i = 0; i < this.L; i++) {

            // Intermediate words for current word
            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

            // Next states are all the words which share the same intermediate state.
            for (String adjacentWord : this.allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                // If at any point if we find what we are looking for
                // i.e. the end word - we can return with the answer.
                if (othersVisited.containsKey(adjacentWord)) {
                    return level + othersVisited.get(adjacentWord);
                }

                if (!visited.containsKey(adjacentWord)) {

                    // Save the level as the value of the dictionary, to save number of hops.
                    visited.put(adjacentWord, level + 1);
                    Q.add(new Pair(adjacentWord, level + 1));
                }
            }
        }
        return -1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        // Since all words are of same length.
        this.L = beginWord.length();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // Key is the generic word
                        // Value is a list of words which have the same intermediate generic word.
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        ArrayList<String> transformations =
                                this.allComboDict.getOrDefault(newWord, new ArrayList<String>());
                        transformations.add(word);
                        this.allComboDict.put(newWord, transformations);
                    }
                });

        // Queues for birdirectional BFS
        // BFS starting from beginWord
        Queue<Pair<String, Integer>> Q_begin = new LinkedList<Pair<String, Integer>>();
        // BFS starting from endWord
        Queue<Pair<String, Integer>> Q_end = new LinkedList<Pair<String, Integer>>();
        Q_begin.add(new Pair(beginWord, 1));
        Q_end.add(new Pair(endWord, 1));

        // Visited to make sure we don't repeat processing same word.
        HashMap<String, Integer> visitedBegin = new HashMap<String, Integer>();
        HashMap<String, Integer> visitedEnd = new HashMap<String, Integer>();
        visitedBegin.put(beginWord, 1);
        visitedEnd.put(endWord, 1);

        while (!Q_begin.isEmpty() && !Q_end.isEmpty()) {

            // One hop from begin word
            int ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
            if (ans > -1) {
                return ans;
            }

            // One hop from end word
            ans = visitWordNode(Q_end, visitedEnd, visitedBegin);
            if (ans > -1) {
                return ans;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        WordChain chain = new WordChain();
        String start = "hit";
        String end = "cog";
        String[] list0 = {"hot","dot","dog","lot","log","cog"};
        List<String> list = new ArrayList<>(list0.length);
        for (String s: list0) {
            list.add(s);
        }
        int res = chain.ladderLength1(start, end, list);
        System.out.println("res = " + res);
    }
}
