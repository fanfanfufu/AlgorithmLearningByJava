package com.fuqi.year2023.month09;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/9/16 23:00
 * @description
 */
public class Solution06988 {
    /**
     * 暴力解法
     *
     * @param coordinates
     * @param k
     * @return
     */
    public int countPairs(List<List<Integer>> coordinates, int k) {
        int ans = 0;
        int n = coordinates.size();
        for (int i = 0; i < n; i++) {
            List<Integer> cur = coordinates.get(i);
            for (int j = i + 1; j < n; j++) {
                List<Integer> next = coordinates.get(j);
                if ((cur.get(0) ^ next.get(0)) + (cur.get(1) ^ next.get(1)) == k) ans++;
            }
        }

        return ans;
    }

    /**
     * 类似两数之和
     *
     * @param coordinates
     * @param k
     * @return
     */
    public int countPairs2(List<List<Integer>> coordinates, int k) {
        int cnt = 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (List<Integer> coordinate : coordinates) {
            int x = coordinate.get(0);
            int y = coordinate.get(1);
            for (int i = 0; i <= k; i++) {
                Map<Integer, Integer> map1 = map.get(x ^ i);
                if (map1 == null) {
                    continue;
                }
                cnt += map1.getOrDefault(y ^ (k - i), 0);
            }
            Map<Integer, Integer> map1 = map.computeIfAbsent(x, key -> new HashMap<>());
            map1.put(y, map1.getOrDefault(y, 0) + 1);
        }
        return cnt;
    }


    public static void main(String[] args) {
        String adId = "-6727717";
        System.out.println(Arrays.toString(adId.getBytes(StandardCharsets.UTF_8)));
        int adIdInt = Integer.parseInt(adId);
        System.out.println("int value binary: " + Integer.toBinaryString(adIdInt));
        byte[] intToBytes = intToBytes(adIdInt);
        System.out.println(Arrays.toString(intToBytes));
    }

    /**
     * 高位在左，低位在右
     *
     * @param value
     * @return
     */
    public static byte[] intToBytes(int value) {
        byte[] src = new byte[4];
        src[0] = (byte) ((value>>24) & 0xFF);
        src[1] = (byte) ((value>>16)& 0xFF);
        src[2] = (byte) ((value>>8)&0xFF);
        src[3] = (byte) (value & 0xFF);
        return src;
    }

}
