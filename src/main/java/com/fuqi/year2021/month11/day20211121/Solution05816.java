package com.fuqi.year2021.month11.day20211121;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FuQi
 * @date 2021/11/21 11:14
 * @description
 */
public class Solution05816 {

}

class RangeFreqQuery{
    private int[] element;
    private int size;

    private Map<Integer, Integer> numCount = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        this.element = arr;
        this.size = arr.length;
        for (int num : arr) {
            Integer count = numCount.getOrDefault(num, 0) + 1;
            numCount.put(num, count);
        }
    }

    public int query(int left, int right, int value) {
        right++;
        if (left == 0 && right == this.size) {
            return this.numCount.getOrDefault(value, 0);
        }
        int ans = 0;
        for (int i = left; i < right; i++) {
            ans = (this.element[i] == value) ? (ans+1) : ans;
        }
        return ans;
    }
}
