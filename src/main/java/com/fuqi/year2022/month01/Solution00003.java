package com.fuqi.year2022.month01;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author FuQi
 * @date 2022/1/20 23:02
 * @description
 */
public class Solution00003 {
    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Deque<Character> window = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!window.contains(s.charAt(i))) {
                // 当前字符不在窗口中时，添加进去
                window.offer(s.charAt(i));
                continue;
            }
            // 若当前字符存在窗口中，此时比较一次窗口长度与ans，去最大的
            ans = Math.max(ans, window.size());
            // 将窗口队列中重复元素以及重复元素之前的元素都移除出队列
            while (window.contains(s.charAt(i))) {
                window.poll();
            }
            // 再添加当前元素
            window.offer(s.charAt(i));
        }
        // 最后再比较一次
        ans = Math.max(ans, window.size());

        return ans;
    }

    /**
     * 优化，一次遍历即可
     * 使用HashMap，记录元素的索引
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int ans = 0;
        HashMap<Character, Integer> indexMap = new HashMap<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (indexMap.containsKey(ch)) {
                j = Math.max(indexMap.get(ch)+1, j);
            }
            // 更新最大长度
            ans = Math.max(ans, (i-j+1));
            indexMap.put(ch, i);
        }

        return ans;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring2("abcdefd");
    }
}
