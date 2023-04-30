package com.fuqi.year2023.month04;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/4/30 11:32
 * @description
 */
public class Solution06343 {
    private static final long mul = 1_000_01;

    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        // 放置到达每个点的路径成本的
        Map<Long, Long> pos = new HashMap<>();
        pos.put(serialize(start), 0L);

        TreeSet<Long> queue = new TreeSet<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                Long v1 = pos.getOrDefault(o1, Long.MAX_VALUE), v2 = pos.getOrDefault(o2, Long.MAX_VALUE);
                if (v1.compareTo(v2) != 0) {
                    return v1.compareTo(v2);
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        queue.add(serialize(start));
        while (!queue.isEmpty()) {
            long key = queue.first(), cost = pos.get(key);
            queue.remove(key);

            int[] p = deserialize(key);
            for (int[] r : specialRoads) {
                long k1 = serialize(r[0], r[1]), k2 = serialize(r[2], r[3]);
                if (p[0] != r[0] || p[1] != r[1]) {
                    int c = Math.abs(p[0] - r[0]) + Math.abs(p[1] - r[1]);
                    long curCost = c + cost;
                    if (!pos.containsKey(k1) || pos.get(k1) > curCost) {
                        queue.remove(k1);
                        pos.put(k1, curCost);
                        queue.add(k1);
                    }
                } else {
                    int c = r[4];
                    long curCost = c + cost;
                    if (!pos.containsKey(k2) || pos.get(k2) > curCost) {
                        queue.remove(k2);
                        pos.put(k2, curCost);
                        queue.add(k2);
                    }
                }

                if (p[0] != r[2] || p[1] != r[3]) {
                    int c = Math.abs(p[0] - r[2]) + Math.abs(p[1] - r[3]);
                    long curCost = c + cost;
                    if (!pos.containsKey(k2) || pos.get(k2) > curCost) {
                        queue.remove(k2);
                        pos.put(k2, curCost);
                        queue.add(k2);
                    }
                }
            }
        }

        long res = Math.abs(target[0] - start[0]) + Math.abs(target[1] - start[1]);
        for (int[] r : specialRoads) {
            long k1 = serialize(r[0], r[1]), k2 = serialize(r[2], r[3]);
            if (pos.containsKey(k1)) {
                res = Math.min(res, pos.get(k1) + Math.abs(target[0] - r[0]) + Math.abs(target[1] - r[1]));
            }
            if (pos.containsKey(k2)) {
                res = Math.min(res, pos.get(k2) + Math.abs(target[0] - r[2]) + Math.abs(target[1] - r[3]));
            }
        }
        return (int) res;
    }

    private long serialize(int[] p) {
        return p[0] * mul + p[1];
    }

    private long serialize(int p1, int p2) {
        return p1 * mul + p2;
    }

    private int[] deserialize(long key) {
        int l1 = (int)(key / mul), l2 = (int)(key % mul);
        return new int[]{l1, l2};
    }
}
